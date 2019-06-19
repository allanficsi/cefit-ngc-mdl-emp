package br.com.aptare.cefit.vagas.service;

import java.util.HashMap;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.trabalhador.entity.Trabalhador;
import br.com.aptare.cefit.trabalhador.service.TrabalhadorService;
import br.com.aptare.cefit.vagas.entity.Encaminhamento;
import br.com.aptare.cefit.vagas.entity.Vaga;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class EncaminhamentoService extends AptareService<Encaminhamento>
{
   private static EncaminhamentoService instancia;

   public static EncaminhamentoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EncaminhamentoService();
      }
      return instancia;
   }

   private EncaminhamentoService()
   {
   }

   public List<Trabalhador> listarTrabalhadoresDisponiveis(Vaga vaga) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      try
      {
         return this.listarTrabalhadoresDisponiveis(session, vaga);
      }
      catch (Exception ae)
      {
         throw TratamentoPadraoErro.getInstancia().catchHBConsultaSession(ae);
      }
      finally
      {
         session.close();
      }
   }

   public List<Trabalhador> listarTrabalhadoresDisponiveis(Session session, Vaga vaga) throws AptareException
   {
      Long[] codigoNaoAtendidoIN = EncaminhamentoNaoAtendidoService.getInstancia().retornarCodigoNaoAtendido(session, vaga.getCodigo());

      Trabalhador trabalhador = new Trabalhador();
      trabalhador.setFiltroMap(new HashMap<String, Object>());
      trabalhador.getFiltroMap().put("codigoVaga", vaga.getCodigo());
      trabalhador.getFiltroMap().put("codigoTrabalhadorNotIN", codigoNaoAtendidoIN);
      trabalhador.setSituacaoIngresso(TrabalhadorService.APROVADO);

      List<Trabalhador> lista = TrabalhadorService.getInstancia().pesquisar(session, trabalhador, new String[] { "listaTrabalhadorCbo.cbo.listaVaga", 
                                                                                                                 "cadastroUnico.pessoaFisica.listaTelefone", 
                                                                                                                 "auditoria.usuarioInclusao" },
                                                                                                  new String[] { "cadastroUnico.nome" });

      return lista;
   }

   public Encaminhamento inativar(Encaminhamento entity) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();

      try
      {
         Encaminhamento retorno = this.inativar(session, entity);
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

   public Encaminhamento inativar(Session session, Encaminhamento entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Encaminhamento encaminhamento = new Encaminhamento();
      encaminhamento.setCodigo(entity.getCodigo());

      encaminhamento = this.get(session, encaminhamento, null, null);

      encaminhamento.setFlagAtivo(entity.getFlagAtivo());
      encaminhamento.setDataCancelamento(entity.getDataCancelamento());
      encaminhamento.setCodigoUsuarioCancelamento(entity.getCodigoUsuarioCancelamento());

      session.merge(encaminhamento);

      return encaminhamento;
   }

}
