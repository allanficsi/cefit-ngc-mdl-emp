package br.com.aptare.cefit.acao.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.acao.entity.Acao;
import br.com.aptare.cefit.acao.entity.AcaoLog;
import br.com.aptare.cefit.acao.entity.AcaoProfissional;
import br.com.aptare.cefit.acao.entity.Agenda;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;

public class AcaoService extends AptareService<Acao>
{
   private static AcaoService instancia;

   public static final long ACAO_PENDENTE = 1;
   public static final long ACAO_ATIVA = 2;
   public static final long ACAO_ABERTA_INSCRICOES = 3;
   public static final long ACAO_CONFIRMADA = 4;
   public static final long ACAO_REALIZADA = 5;
   public static final long ACAO_CANCELADA = 6;
   
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
      adicionarFiltro("nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "nome");
      adicionarFiltro("listaAgenda.dataAgenda", CatalogoRestricoes.MAIOR_IGUAL, "filtro.dataAgendaInicial");
      adicionarFiltro("listaAgenda.dataAgenda", CatalogoRestricoes.MENOR_IGUAL, "filtro.dataAgendaFinal");
      adicionarFiltro("codigo", CatalogoRestricoes.DIFERENTE, "filtro.notCodigo");
   }
   
   @Override
   protected void validarInserir(Session session, Acao entity) throws AptareException
   {
      Acao acao = new Acao();
      acao.setFiltro(new HashMap<String, Object>());
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
      acao.setFiltro(new HashMap<String, Object>());
      acao.getFiltro().put("descricao", entity.getNome());
      
      acao = this.get(session, acao, null, null);
      
      if(acao != null 
            && acao.getCodigo().longValue() != entity.getCodigo().longValue())
      {
         throw new AptareException("Esta Ação já existe em nossa base de dados.");
      }
   }
   
   public void validarAcaoEspacoAgendamento(Session session, Acao entity) throws AptareException
   {
      // ****** Recuperar todas as acoes do periodo informado na agenda
      Acao acaoEntity = new Acao();
      acaoEntity.setCodigo(entity.getCodigo());
      acaoEntity = this.get(acaoEntity, new String[] { "listaAgenda" , "listaAcaoProfissional" }, null);

      List<Agenda> listaAgenda = new ArrayList<Agenda>(acaoEntity.getListaAgenda());
      
      Collections.sort(listaAgenda, new Comparator<Agenda>()
      {
         public int compare(Agenda a1, Agenda a2)
         {

            return a1.getDataAgenda().compareTo(a2.getDataAgenda());
         }
      }); 
      
      Date dataInicioAgenda = listaAgenda.get(0).getDataAgenda();
      Date dataFimAgenda = listaAgenda.get(listaAgenda.size() - 1).getDataAgenda();
      
      // Espaco-Agenda
      
      Acao acaoPesquisa = new Acao();
      acaoPesquisa.setFiltro(new HashMap<String, Object>());
      acaoPesquisa.getFiltro().put("dataAgendaInicial", dataInicioAgenda);
      acaoPesquisa.getFiltro().put("dataAgendaFinal", dataFimAgenda);
      acaoPesquisa.getFiltro().put("notCodigo", acaoEntity.getCodigo());
      
      
      List<Acao> listaAcao = this.pesquisar(session, acaoPesquisa, new String[] { "listaAgenda" , "listaAcaoProfissional" }, null);
      
      if(listaAcao != null && listaAcao.size() > 0)
      {
         for (Acao acao : listaAcao)
         {
            
            if(acaoEntity.getCodigoEsp().longValue() == acao.getCodigoEsp().longValue())
            {
               for (Agenda agendaEntity : acaoEntity.getListaAgenda())
               {
                  for (Agenda agendaAcao : acao.getListaAgenda())
                  {
                     if(!this.validarIntervaloAgenda(agendaEntity, agendaAcao))
                     {
                        throw new AptareException("Existe choque de horário com espaço");
                     }
                  }
               }
            }
            
            // Profissional-Agenda
            
            boolean existeProfissional = false;
            
            for (AcaoProfissional acaoProfissionalEntity : acaoEntity.getListaAcaoProfissional())
            {
               for (AcaoProfissional acaoProfissionalAcao : acao.getListaAcaoProfissional())
               {
                  if(acaoProfissionalEntity.getCodigoPrf().longValue() == acaoProfissionalAcao.getCodigoPrf().longValue())
                  {
                     existeProfissional = true;
                  }
               }
            }
            
            if(existeProfissional)
            {
               for (Agenda agendaEntity : acaoEntity.getListaAgenda())
               {
                  for (Agenda agendaAcao : acao.getListaAgenda())
                  {
                     if(!this.validarIntervaloAgenda(agendaEntity, agendaAcao))
                     {
                        throw new AptareException("Existe choque de horário com profissional!");
                     }
                  }
               }
            }
         }
      }
      
   }
   
   private boolean validarIntervaloAgenda(Agenda agenda, Agenda agendaBanco) 
   {
      boolean flag = true;
      
      if(agenda.getNrHor1() != null && agenda.getNrHor2() != null && agenda.getNrHor3() != null && agenda.getNrHor4() != null
            && agendaBanco.getNrHor1() != null && agendaBanco.getNrHor2() != null && agendaBanco.getNrHor3() != null && agendaBanco.getNrHor4() != null)
      {
      
         int h1 = Integer.parseInt(agenda.getNrHor1());
         int h2 = Integer.parseInt(agenda.getNrHor2());
         int h3 = Integer.parseInt(agenda.getNrHor3());
         int h4 = Integer.parseInt(agenda.getNrHor4());
         
         int hb1 = Integer.parseInt(agendaBanco.getNrHor1());
         int hb2 = Integer.parseInt(agendaBanco.getNrHor2());
         int hb3 = Integer.parseInt(agendaBanco.getNrHor3());
         int hb4 = Integer.parseInt(agendaBanco.getNrHor4());
         
         if( ((h1 >= hb1 && h1 <= hb2) || (h1 >= hb3 && h1 <= hb4))
               || ((h2 >= hb1 && h2 <= hb2) || (h2 >= hb3 && h2 <= hb4))
               || ((h3 >= hb1 && h3 <= hb2) || (h3 >= hb3 && h3 <= hb4))
               || ((h4 >= hb1 && h4 <= hb2) || (h4 >= hb3 && h4 <= hb4)) )
         {
            flag = false;
         }
      }
      
      return flag;
   }
   
   @Override
   public Acao inserir(Session session, Acao entity) throws AptareException
   {
      // Acao
      session.save(entity);
      
      // Profissional
      if(entity.getListaAcaoProfissional() != null
            && entity.getListaAcaoProfissional().size() > 0)
      {
         List<AcaoProfissional> listaAcaoProfissional = new ArrayList<AcaoProfissional>(entity.getListaAcaoProfissional());
      
         for (AcaoProfissional acaoProfissional : listaAcaoProfissional)
         {
            AcaoProfissional objInserirAcaoProfissional = new AcaoProfissional();
            objInserirAcaoProfissional.setCodigoAca(entity.getCodigo());
            objInserirAcaoProfissional.setCodigoPrf(acaoProfissional.getCodigoPrf());
            
            AcaoProfissionalService.getInstancia().inserir(session, objInserirAcaoProfissional);
         }
      }
      
      // Agenda
      if(entity.getListaAgenda() != null
            && entity.getListaAcaoProfissional().size() > 0)
      {
         List<Agenda> listaAgenda = new ArrayList<Agenda>(entity.getListaAgenda());
      
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
            
            AgendaService.getInstancia().inserir(session, objInserirAgenda);
         }
      }
      
         
      return entity;
   }
   
   @Override
   public Acao alterar(Session session, Acao entity) throws AptareException
   {
      // Alterar Acao
      session.merge(entity);
      
      // Deletar todas Acoes Profissional
      AcaoProfissionalService.getInstancia().atualizarListaAcaoProfissional(session, new ArrayList<AcaoProfissional>(entity.getListaAcaoProfissional()), entity.getCodigo());
      
      // Inserir novas Acoes Profissional
      AgendaService.getInstancia().atualizarAgenda(session, new ArrayList<Agenda>(entity.getListaAgenda()), entity.getCodigo());

      return entity;
   }
   
   public Acao alterarSituacaoAcao(Acao entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           Acao retorno = this.alterarSituacaoAcao(session, entity);
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

   public Acao alterarSituacaoAcao(Session session, Acao entity) throws AptareException
   {
      // Get tipoacao somente com o codigo
      Acao acao = new Acao();
      acao.setCodigo(entity.getCodigo());
      
      acao = this.get(session, acao, null, null);
      
      if(entity.getSituacao().intValue() == ACAO_CONFIRMADA)
      {
         this.validarAcaoEspacoAgendamento(session, entity);
      }
      
      // Inserindo Log de Acao
      AcaoLog acaoLog = new AcaoLog();
      acaoLog.setSituacaoAnterior(acao.getSituacao());
      acaoLog.setSituacaoNova(entity.getSituacao());
      acaoLog.setDataOperacao(new Date());
      acaoLog.setCodigoUsuarioOperacao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      AcaoLogService.getInstancia().inserir(session, acaoLog);
      
      // Alterndo Acao
      acao.setSituacao(entity.getSituacao());
      acao.getAuditoria().setDataAlteracao(new Date());
      acao.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(acao);
      
      
      return acao;
   }

}
