package br.com.aptare.cefit.acao.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.Acao;
import br.com.aptare.cefit.acao.entity.AcaoProfissional;
import br.com.aptare.cefit.acao.entity.Agenda;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class AcaoService extends AptareService<Acao>
{
   private static AcaoService instancia;

   public static final long ACAO_PENDENTE = 1;
   public static final long ACAO_ATIVA = 2;
   
   public static AcaoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new AcaoService();
      }
      return instancia;
   }

   private AcaoService()
   {
      adicionarFiltro("descricao", CatalogoRestricoes.IGUAL, "filtro.descricao");
   }
   
   @Override
   protected void validarInserir(Session session, Acao entity) throws AptareException
   {
      Acao acao = new Acao();
      acao.setFiltro(new HashMap<Object, String>());
      acao.getFiltro().put("nome", entity.getNome());
      
      acao = this.get(session, acao, null, null);
      
      if(acao != null)
      {
         throw new AptareException("Esta Ação já existe em nossa base de dados.");
      }
   }

   @Override
   protected void validarAlterar(Session session, Acao entity) throws AptareException
   {
      Acao acao = new Acao();
      acao.setFiltro(new HashMap<Object, String>());
      acao.getFiltro().put("descricao", entity.getNome());
      
      acao = this.get(session, acao, null, null);
      
      if(acao != null 
            && acao.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta Ação já existe em nossa base de dados.");
      }
   }
   
   @Override
   public Acao inserir(Session session, Acao entity) throws AptareException
   {
      // Acao
      session.save(entity);
      
      // Profissional
      List<AcaoProfissional> listaAcaoProfissional = new ArrayList<AcaoProfissional>(entity.getListaAcaoProfissional());
      
      if(listaAcaoProfissional != null)
      {
         for (AcaoProfissional acaoProfissional : listaAcaoProfissional)
         {
            AcaoProfissional objInserirAcaoProfissional = new AcaoProfissional();
            objInserirAcaoProfissional.setCodigoAcao(entity.getCodigo());
            objInserirAcaoProfissional.setCodigoProfissional(acaoProfissional.getCodigoProfissional());
            
            AcaoProfissionalService.getInstancia().inserir(session, objInserirAcaoProfissional);
         }
      }
      
      // Agenda
      List<Agenda> listaAgenda = new ArrayList<Agenda>(entity.getListaAgenda());
      
      if(listaAgenda != null)
      {
         for (Agenda agenda : listaAgenda)
         {
            Agenda objInserirAgenda = new Agenda();
            objInserirAgenda.setCodigoAcao(entity.getCodigo());
            objInserirAgenda.setDataAgenda(agenda.getDataAgenda());
            objInserirAgenda.setFgFeriado(agenda.getFgFeriado());
            objInserirAgenda.setNrHor1(agenda.getNrHor1());
            objInserirAgenda.setNrHor2(agenda.getNrHor2());
            objInserirAgenda.setNrHor3(agenda.getNrHor3());
            objInserirAgenda.setNrHor4(agenda.getNrHor4());
            
            objInserirAgenda.setAuditoria(new Auditoria());
            objInserirAgenda.getAuditoria().setCodigoUsuarioInclusao(agenda.getAuditoria().getCodigoUsuarioInclusao());
            objInserirAgenda.getAuditoria().setDataInclusao(agenda.getAuditoria().getDataInclusao());
            objInserirAgenda.setFlagAtivo(agenda.getFlagAtivo());
            
            AgendaService.getInstancia().inserir(session, objInserirAgenda);
         }
      }
      
         
      return entity;
   }
   
   public Acao ativarInativar(Acao entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           Acao retorno = this.ativarInativar(session, entity);
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

   public Acao ativarInativar(Session session, Acao entity) throws AptareException
   {
      // Get tipoacao somente com o codigo
      Acao acao = new Acao();
      acao.setCodigo(entity.getCodigo());
      
      acao = this.get(session, acao, null, null);
      
      //acao.setFlagAtivo(entity.getFlagAtivo()); //setar para cancelado
      acao.setAuditoria(new Auditoria());
      acao.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      acao.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(acao);
      
      return acao;
   }

}
