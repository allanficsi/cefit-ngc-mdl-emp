package br.com.aptare.cefit.trabalhador.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.aptare.cefit.trabalhador.entity.*;
import org.apache.commons.collections4.bag.TransformedBag;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cadastroUnico.entidade.CadastroUnico;
import br.com.aptare.cadastroUnico.servico.CadastroUnicoService;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Usuario;
import br.com.aptare.seguranca.servico.UsuarioService;

public class TrabalhadorService extends AptareService<Trabalhador>
{
   private static TrabalhadorService instancia;
   
   public static int JOIN_CADASTRO_UNICO = 1;
   
   
   public static int SITUACAO_PENDENTE = 1;
   public static int SITUACAO_ATIVA = 2;
   public static int SITUACAO_INATIVA = 3;

   //SITUAÇÃO DE INGRESSO NO PROGRAMA
   public static int PENDENTE_DE_AVALIACAO=1;
   public static int PENDENTE_DE_VALIDACAO=2;
   public static int ENCAMINHADO_PARA_A_AVALIACAO=3;
   public static int ENCAMINHADO_PARA_A_CAPACITACAO=4;
   public static int ENCAMINHADO_PARA_A_ENTREVISTA_OCUPACIONAL=5;
   public static int RESTRICAO_POR_AVALIACAO=6;
   public static int RESTRICAO_POR_CAPACITACAO=7;
   public static int RESTRICAO_POR_ENTREVISTA_OCUPACIONAL=8;
   public static int APROVADO=9;
   public static int EXCLUIDO=10;

   public static TrabalhadorService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new TrabalhadorService();
      }
      return instancia;
   }

   private TrabalhadorService()
   {
      adicionarFiltro("cadastroUnico.nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "cadastroUnico.nome");
   }

    @Override
   public Trabalhador inserir(Session session, Trabalhador entity) throws AptareException
   {
      this.validarInserir(session, entity);
      
      // INSERINDO CADASTRO UNICO
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      
      if(cadastroUnico.getCodigo() != null)
      {
         cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      }
      else 
      {
         cadastroUnico = CadastroUnicoService.getInstancia().inserir(session, cadastroUnico);
      }
      
      session.flush();
      
      //INSERINDO TRABALHADOR
      entity.setCodigoCadastroUnico(cadastroUnico.getCodigo());
      session.save(entity);
      
      //INSERINDO CBO
      if(entity.getListaTrabalhadorCbo() != null
            && entity.getListaTrabalhadorCbo().size() > 0)
      {
         for (TrabalhadorCbo trabalhadorCbo : entity.getListaTrabalhadorCbo())
         {
            trabalhadorCbo.setCodigoTrabalhador(entity.getCodigo());
            TrabalhadorCboService.getInstancia().inserir(session, trabalhadorCbo);
         }
      }
      
      //INSERINDO DEFICIENCIA
      if(entity.getListaTrabalhadorDeficiencia() != null
            && entity.getListaTrabalhadorDeficiencia().size() > 0)
      {
         for (TrabalhadorDeficiencia trabalhadorDeficiencia : entity.getListaTrabalhadorDeficiencia())
         {
            trabalhadorDeficiencia.setCodigoTrabalhador(entity.getCodigo());
            TrabalhadorDeficienciaService.getInstancia().inserir(session, trabalhadorDeficiencia);
         }
      }

       //INSERINDO AGENDA
       if(entity.getListaTrabalhadorAgenda() != null
               && entity.getListaTrabalhadorAgenda().size() > 0)
       {
           List<TrabalhadorAgenda> listaAgenda = new ArrayList<TrabalhadorAgenda>(entity.getListaTrabalhadorAgenda());

           for (TrabalhadorAgenda agenda : listaAgenda)
           {
               TrabalhadorAgenda objInserirAgenda = new TrabalhadorAgenda();
               objInserirAgenda.setCodigoTrabalhador(entity.getCodigo());
               objInserirAgenda.setNrHor1(agenda.getNrHor1());
               objInserirAgenda.setNrHor2(agenda.getNrHor2());
               objInserirAgenda.setNrHor3(agenda.getNrHor3());
               objInserirAgenda.setNrHor4(agenda.getNrHor4());
               objInserirAgenda.setFlagSel(agenda.getFlagSel());
               objInserirAgenda.setNrDia(agenda.getNrDia());

               TrabalhadorAgendaService.getInstancia().inserir(session, objInserirAgenda);
           }
       }
         
      return entity;
   }
   
   @Override
   protected void validarInserir(Session session, Trabalhador entity) throws AptareException
   {
      if(entity.getCodigoCadastroUnico() != null) 
      {
         Trabalhador trabalhador = new Trabalhador();
         trabalhador.setCodigoCadastroUnico(entity.getCodigoCadastroUnico());
         
         trabalhador = this.get(session, trabalhador, null, null);
         
         if(trabalhador != null)
         {
            throw new AptareException("Este trabalhador já existe em nossa base de dados.");
         }
      }
   }
   
   @Override
   @SuppressWarnings({ "rawtypes", "unchecked" })
   public Trabalhador alterar(Session session, Trabalhador entity) throws AptareException
   {
      this.validarAlterar(session, entity);
      
      CadastroUnico cadastroUnico = entity.getCadastroUnico();
      cadastroUnico = CadastroUnicoService.getInstancia().alterar(session, cadastroUnico);
      session.flush();
      
      session.update(entity);
      
      // ALTERANDO CBO
      TrabalhadorCboService.getInstancia().atualizarListaCbo(session, new ArrayList(entity.getListaTrabalhadorCbo()), entity.getCodigo());
      
      session.flush();
      
      // ALTERANDO DEFICIENCIA
      TrabalhadorDeficienciaService.getInstancia().atualizarListaDeficiencia(session, new ArrayList(entity.getListaTrabalhadorDeficiencia()), entity.getCodigo());

       // ALTERANDO AGENDA
       TrabalhadorAgendaService.getInstancia().atualizarAgenda(session, new ArrayList(entity.getListaTrabalhadorAgenda()), entity.getCodigo());

      return entity;
   }
   
   @Override
   protected void validarAlterar(Session session, Trabalhador entity) throws AptareException
   {
      CadastroUnico cadastroUnico = new CadastroUnico();
      cadastroUnico.setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      cadastroUnico.setTipoPessoa("F");
      
      cadastroUnico = CadastroUnicoService.getInstancia().get(cadastroUnico, null, null);
      
      if(cadastroUnico != null
            && cadastroUnico.getCodigo().intValue() != entity.getCodigoCadastroUnico().intValue())
      {
         throw new AptareException("Este CPF já existe em nossa base de dados.");
      }
   }
   
   public Trabalhador ativarInativar(Trabalhador entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       try
       {
           Trabalhador retorno = this.ativarInativar(session, entity);
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

   public Trabalhador ativarInativar(Session session, Trabalhador trabalhador) throws AptareException
   {
       session.update(trabalhador);
       return trabalhador;
   }
   
   public void cadastrarUsuario(Usuario entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       try
       {
           this.cadastrarUsuario(session, entity);
           tx.commit();
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

   private void cadastrarUsuario(Session session, Usuario entity) throws Exception
   {
      // validar
      Usuario bancoUsuario = new Usuario();
      bancoUsuario.setCadastroUnico(new CadastroUnico());
      bancoUsuario.getCadastroUnico().setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      
      bancoUsuario = UsuarioService.getInstancia().get(session, bancoUsuario, null, null);
      
      Trabalhador bancoTrabalhador = new Trabalhador();
      bancoTrabalhador.setCadastroUnico(new CadastroUnico());
      bancoTrabalhador.getCadastroUnico().setCpfCnpj(entity.getCadastroUnico().getCpfCnpj());
      
      bancoTrabalhador = super.get(session, bancoTrabalhador, null, null);
      
      if (bancoUsuario != null
            && bancoTrabalhador != null)
      {
         throw new AptareException("msg.geral", new String[] {"Já existe um usuário e trabalhador para este CPF."});
      }
      
      if (bancoUsuario == null)
      {
         // inserir usuario
         entity = UsuarioService.getInstancia().inserir(session, entity);
         session.flush();
      }
      
      if (bancoTrabalhador == null)
      {
         // inserir trabalhador
         Trabalhador entityTrabalhador = new Trabalhador();
         entityTrabalhador.setCodigoCadastroUnico(entity.getCodigoCadastroUnico());
         entityTrabalhador.setSituacao(SITUACAO_PENDENTE);
         entityTrabalhador.setAuditoria(entity.getAuditoria());
         
         session.save(entityTrabalhador);
      }
      
   }

    public void salvarManutencao(Trabalhador entity) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            this.salvarManutencao(session, entity);
            tx.commit();
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

    public void salvarManutencao(Session session, Trabalhador entity) throws AptareException
    {
        if(entity.getListaTrabalhadorAgenda() != null)
        {
            for (TrabalhadorAgenda item : entity.getListaTrabalhadorAgenda())
            {
                session.merge(item);
            }
        }
    }

    public Trabalhador alterarSituacaoDeIngresso(Trabalhador entity) throws AptareException
    {
        Session session = getSession();
        session.setFlushMode(FlushMode.COMMIT);
        Transaction tx = session.beginTransaction();

        try
        {
            Trabalhador retorno = this.alterarSituacaoDeIngresso(session, entity);
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

    public Trabalhador alterarSituacaoDeIngresso(Session session, Trabalhador entity) throws AptareException
    {
        // Get tipoacao somente com o codigo
        Trabalhador trabalhador = new Trabalhador();
        trabalhador.setCodigo(entity.getCodigo());

        trabalhador = this.get(session, trabalhador, null, null);

        // Inserindo Log de Trabalhador
        TrabalhadorLog trabalhadorLog = new TrabalhadorLog();
        trabalhadorLog.setSituacaoAnterior(trabalhador.getSituacaoIngresso());
        trabalhadorLog.setSituacaoNova(entity.getSituacaoIngresso());
        trabalhadorLog.setDataOperacao(new Date());
        trabalhadorLog.setCodigoUsuarioOperacao(entity.getAuditoria().getCodigoUsuarioAlteracao());
        TrabalhadorLogService.getInstancia().inserir(session, trabalhadorLog);

        // Alterando Situção De Ingresso
        trabalhador.setSituacaoIngresso(entity.getSituacaoIngresso());

        //ALTERANDO SITUÇÃO
        if(entity.getSituacao()!=null) {
            trabalhador.setSituacao(entity.getSituacao());
        }

        trabalhador.setMotivoAtivacao(entity.getMotivoAtivacao());
        trabalhador.setMotivoInativacao(entity.getMotivoInativacao());
        trabalhador.setObservacao(entity.getObservacao());

        trabalhador.getAuditoria().setDataAlteracao(new Date());
        trabalhador.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());

        session.merge(trabalhador);


        return trabalhador;
    }
}
