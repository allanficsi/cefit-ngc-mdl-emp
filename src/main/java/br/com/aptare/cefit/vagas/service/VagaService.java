package br.com.aptare.cefit.vagas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cefit.vagas.entity.Vaga;
import br.com.aptare.cefit.vagas.entity.VagaAgendamento;
import br.com.aptare.cefit.vagas.entity.VagaDia;
import br.com.aptare.cefit.vagas.entity.VagaLog;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;

public class VagaService extends AptareService<Vaga>
{
   private static VagaService instancia;
   
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
   public Vaga inserir(Session session, Vaga entity) throws AptareException
   {
      // Vaga
      session.save(entity);
      
      // Vaga Agendamento
      if(entity.getListaVagaAgendamento() != null
            && entity.getListaVagaAgendamento().size() > 0)
      {
         List<VagaAgendamento> listaVagaAgendamento = new ArrayList<VagaAgendamento>(entity.getListaVagaAgendamento());
      
         for (VagaAgendamento vagaAgendamento : listaVagaAgendamento)
         {
            vagaAgendamento.setCodigoVaga(entity.getCodigo());
            VagaAgendamentoService.getInstancia().inserir(session, vagaAgendamento);
         }
      }
      
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
      
         
      return entity;
   }
   
   @Override
   public Vaga alterar(Session session, Vaga entity) throws AptareException
   {
      // Vaga
      session.merge(entity);
      
      // Atualizar Agendamentos
      VagaAgendamentoService.getInstancia().atualizarListaVagaAgendamento(session, new ArrayList<VagaAgendamento>(entity.getListaVagaAgendamento()), entity.getCodigo());
      
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

}
