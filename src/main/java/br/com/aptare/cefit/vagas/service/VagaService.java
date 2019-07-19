package br.com.aptare.cefit.vagas.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.trabalhador.entity.TrabalhadorCbo;
import br.com.aptare.cefit.trabalhador.entity.TrabalhadorRejeicao;
import br.com.aptare.cefit.trabalhador.service.TrabalhadorRejeicaoService;
import br.com.aptare.cefit.trabalhador.service.TrabalhadorService;
import br.com.aptare.cefit.vagas.entity.Encaminhamento;
import br.com.aptare.cefit.vagas.entity.Vaga;
import br.com.aptare.cefit.vagas.entity.VagaDia;
import br.com.aptare.cefit.vagas.entity.VagaLog;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class VagaService extends AptareService<Vaga>
{
    private static VagaService instancia;

    private final int DIAS_VINCULO = 3;

    public static final int SITUACAO_ABERTA = 1;
    public static final int SITUACAO_EM_ANDAMENTO = 2;
    public static final int SITUACAO_FINALIZADA = 5;

    public static VagaService getInstancia()
    {
        if (instancia == null)
        {
            instancia = new VagaService();
        }
        return instancia;
    }

    private VagaService()
    {
        adicionarFiltro("tipoVaga", CatalogoRestricoes.UM_DOS, "filtro.tipoVagaIN");
        adicionarFiltro("listaEncaminhamento.flagAtivo", CatalogoRestricoes.DIFERENTE_OU_NULO, "filtro.flagAtivoDiferenteEncaminhamento");
    }

    @Override
    protected void validarInserir(Session session, Vaga entity) throws AptareException
    {
        // Regras para cadastro de vagas do tipo nominal ou freguesia
        if(entity.getTipoDescricaoVaga().equals("N") || entity.getTipoDescricaoVaga().equals("F"))
        {
            Trabalhador trabalhador = new Trabalhador();
            trabalhador.setCodigo(entity.getCodigoTrabalhador());
            trabalhador = TrabalhadorService.getInstancia().get(session, trabalhador, new String[] {"listaTrabalhadorCbo"}, null);

            if(trabalhador != null
                    && trabalhador.getListaTrabalhadorCbo() != null
                    && trabalhador.getListaTrabalhadorCbo().size() > 0)
            {
                boolean flagControle = false;

                for (TrabalhadorCbo objCbo : trabalhador.getListaTrabalhadorCbo())
                {
                    if(objCbo.getCodigoCbo().intValue() == entity.getCodigoCbo().intValue())
                    {
                        flagControle = true;
                    }
                }

                if(!flagControle)
                {
                    throw new AptareException("O Trabalhador não pertence a ocupação solicitada na vaga.");
                }
            }

//         if(trabalhador.getCodigoCbo().intValue() != entity.getCodigoCbo())
//         {
//            throw new AptareException("O Trabalhador não pertence a ocupação solicitada na vaga.");
//         }


            // Regra do bloqueio
            TrabalhadorRejeicao rejeicao = new TrabalhadorRejeicao();
            rejeicao.setCodigoEmpregador(entity.getCodigoEmpregador());
            rejeicao.setCodigoTrabalhador(entity.getCodigoTrabalhador());
            rejeicao.setFlagAtivo("S");

            List<TrabalhadorRejeicao> listaRejeicao = TrabalhadorRejeicaoService.getInstancia().pesquisar(session, rejeicao, null, null);

            if(listaRejeicao != null
                    && listaRejeicao.size() > 0)
            {
                throw new AptareException("Não foi possivel cadastrar o serviço pois existe um bloqueio entre o trabalhador e o empregador selecionado.");
            }

            // Vinculo empregaticio
            // Verificando se a lista de dias passados pelo cliente existe vinculo
            if(entity.getListaVagaDia().size() > 1)
            {
                for (VagaDia vagaDia : entity.getListaVagaDia())
                {
                    if(this.existeVinculo(vagaDia.getData(), entity.getListaVagaDia()))
                    {
                        throw new AptareException("Esta vaga não pode ser solicitada pois as datas informadas geram um vínculo empregatício para o trabalhador selecionado. "
                                + "O empregador só pode atender no máximo 2 vezes por semana na em uma mesma residência.");
                    }
                }
            }

            Encaminhamento encaminhamento = new Encaminhamento();
            encaminhamento.setFlagAtivo("S");
            encaminhamento.setCodigoTrabalhador(entity.getCodigoTrabalhador());
            encaminhamento.setVaga(new Vaga());
            encaminhamento.getVaga().setTipoVaga("I");
            encaminhamento.setFiltroMap(new HashMap<String, Object>());
            encaminhamento.getFiltroMap().put("situacaoVagaIN", new Integer[] {SITUACAO_ABERTA, SITUACAO_EM_ANDAMENTO, SITUACAO_FINALIZADA});

            List<Encaminhamento> listaEncaminhamento = EncaminhamentoService.getInstancia().pesquisar(session, encaminhamento, new String[] {"vaga.listaVagaDia*"}, null);

            if(listaEncaminhamento != null
                    && listaEncaminhamento.size() > 0)
            {
                for (Encaminhamento obj : listaEncaminhamento)
                {
                    for (VagaDia objVagaDia : obj.getVaga().getListaVagaDia())
                    {
                        for (VagaDia entVagaDia : entity.getListaVagaDia())
                        {
                            if(objVagaDia.getData().equals(entVagaDia.getData()))
                            {
                                //
                                int horaReferenciaInicial = Integer.parseInt(objVagaDia.getHorarioEntrada());
                                int horaReferenciaFinal = Integer.parseInt(objVagaDia.getHorarioSaida());

                                int horaParametroInicial = Integer.parseInt(entVagaDia.getHorarioEntrada());
                                int horaParametroFinal = Integer.parseInt(entVagaDia.getHorarioEntrada());

                                if(horaParametroInicial <= horaReferenciaInicial && horaParametroFinal >= horaReferenciaFinal)
                                {
                                    throw new AptareException("Já existe um encaminhamento não realizado para o trabalhador "
                                            + "no dia " + new SimpleDateFormat("dd/MM/yyyy").format(objVagaDia.getData()) + " no horário: "
                                            + "" + horaReferenciaInicial + " às " + horaReferenciaFinal);
                                }

                                if((horaParametroInicial <= horaReferenciaInicial) || (horaParametroInicial > horaReferenciaFinal))
                                {
                                    if((horaParametroFinal <= horaReferenciaInicial) || (horaParametroFinal > horaReferenciaFinal))
                                    {
                                        throw new AptareException("Já existe um encaminhamento não realizado para o trabalhador "
                                                + "no dia " + new SimpleDateFormat("dd/MM/yyyy").format(objVagaDia.getData()) + " no horário: "
                                                + "" + horaReferenciaInicial + " às " + horaReferenciaFinal);
                                    }
                                }

                            }
                        }
                    }
                }
            }

            List<VagaDia> listaComparacao = new ArrayList<VagaDia>();
            listaComparacao.addAll(entity.getListaVagaDia());

            if(listaEncaminhamento != null
                    && listaEncaminhamento.size() > 0)
            {
                for (Encaminhamento obj : listaEncaminhamento)
                {
                    if(obj.getVaga().getCodigoEmpregador().intValue() == entity.getCodigoEmpregador().intValue()
                            && obj.getVaga().getCodigoEndereco().intValue() == entity.getCodigoEndereco().intValue())
                    {
                        listaComparacao.addAll(obj.getVaga().getListaVagaDia());
                    }
                }
            }

            if (listaComparacao.size() > 1)
            {
                for (VagaDia vagaDia : listaComparacao)
                {
                    if (this.existeVinculo(vagaDia.getData(), new HashSet<VagaDia>(listaComparacao)))
                    {
                        throw new AptareException(
                                "Esta vaga não pode ser solicitada pois as datas informadas geram um vínculo empregatício para o trabalhador selecionado. "
                                        + "O empregador só pode atender no máximo 2 vezes por semana na em uma mesma residência.");
                    }
                }
            }
        }
    }

    @Override
    public Vaga inserir(Session session, Vaga entity) throws AptareException
    {
        this.validarInserir(session, entity);

        if(entity.getTipoDescricaoVaga().equals("N") || entity.getTipoDescricaoVaga().equals("F"))
        {
            entity.setSituacao(VagaService.SITUACAO_EM_ANDAMENTO);
        }
        else
        {
            entity.setSituacao(VagaService.SITUACAO_ABERTA);
        }

        // Vaga
        session.save(entity);

        // Vaga Dia
        if(entity.getListaVagaDia() != null
                && entity.getListaVagaDia().size() > 0)
        {
            List<VagaDia> listaVagaDia = new ArrayList<VagaDia>(entity.getListaVagaDia());

            for (VagaDia vagaDia : listaVagaDia)
            {
                vagaDia.setCodigoVaga(entity.getCodigo());
                VagaDiaService.getInstancia().inserir(session, vagaDia);
            }
        }

        // Encaminhamento
        if(entity.getTipoDescricaoVaga().equals("N") || entity.getTipoDescricaoVaga().equals("F"))
        {
            Encaminhamento encaminhamento = new Encaminhamento();
            encaminhamento.setCodigoVaga(entity.getCodigo());
            encaminhamento.setCodigoTrabalhador(entity.getCodigoTrabalhador());
            encaminhamento.setAuditoria(new Auditoria());
            encaminhamento.getAuditoria().setCodigoUsuarioInclusao(entity.getAuditoria().getCodigoUsuarioInclusao());
            encaminhamento.getAuditoria().setDataInclusao(new Date());
            encaminhamento.setFlagAtivo("S");

            EncaminhamentoService.getInstancia().inserir(session, encaminhamento);
        }

        return entity;
    }

    @Override
    public Vaga alterar(Session session, Vaga entity) throws AptareException
    {
        this.validarAlterar(session, entity);

        //entity.setEmpregador(null);

        if(entity.getCodigoEmpregador() == null
                && entity.getEmpregador() != null
                && entity.getEmpregador().getCodigo() != null)
        {
            entity.setCodigoEmpregador(entity.getEmpregador().getCodigo());
            entity.setEmpregador(null);
        }

        // Vaga
        session.merge(entity);
        session.flush();

        // Atualizar Dias
        VagaDiaService.getInstancia().atualizarListaVagaDia(session, new ArrayList<VagaDia>(entity.getListaVagaDia()), entity.getCodigo());


        return entity;
    }

    public Vaga alterarSituacaoVaga(Vaga entity) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            Vaga retorno = this.alterarSituacaoVaga(session, entity);
            tx.commit();
            return retorno;
        }
        catch (Exception ae)
        {
            throw TratamentoPadraoErro.getInstancia().catchHBEdicaoSession(ae, tx);
        }
        finally
        {
            session.close();
        }
    }

    public Vaga alterarSituacaoVaga(Session session, Vaga entity) throws AptareException
    {
        // Get vaga somente com o codigo
        Vaga vaga = new Vaga();
        vaga.setCodigo(entity.getCodigo());

        vaga = this.get(session, vaga, null, null);

        // Inserindo Log de Acao
        VagaLog vagaLog = new VagaLog();
        vagaLog.setSituacaoAnterior(vaga.getSituacao().longValue());
        vagaLog.setSituacaoNova(entity.getSituacao().longValue());
        vagaLog.setDataOperacao(new Date());
        vagaLog.setCodigoUsuarioOperacao(entity.getAuditoria().getCodigoUsuarioAlteracao());
        VagaLogService.getInstancia().inserir(session, vagaLog);

        // Alterndo Acao
        vaga.setSituacao(entity.getSituacao());
        vaga.setFlagRealizada(entity.getFlagRealizada());
        vaga.setValorPago(entity.getValorPago());
        vaga.getAuditoria().setDataAlteracao(new Date());
        vaga.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

        session.merge(vaga);

        return vaga;
    }

    private boolean existeVinculo(Date data, Set<VagaDia> listaVagaDia)
    {
        boolean retorno = false;

        GregorianCalendar gcInicio = new GregorianCalendar();
        gcInicio.setTime(data);
        gcInicio.set(Calendar.DAY_OF_WEEK, 1);

        Date dataInicioSemana = gcInicio.getTime();

        GregorianCalendar gcFim = new GregorianCalendar();
        gcFim.setTime(data);
        gcFim.set(Calendar.DAY_OF_WEEK, 7);

        Date dataFimSemana = gcFim.getTime();

        int count = 0;

        for (VagaDia vagaDia : listaVagaDia)
        {
            if( (vagaDia.getData().equals(dataInicioSemana) || vagaDia.getData().after(dataInicioSemana))
                    && (vagaDia.getData().equals(dataFimSemana) || vagaDia.getData().before(dataFimSemana)) )
            {
                count++;
            }
        }

        if(count >= DIAS_VINCULO)
        {
            retorno = true;
        }


        return retorno;
    }

}
