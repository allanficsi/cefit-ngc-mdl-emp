package br.com.aptare.cefit.espaco.service;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.aptare.cadastroUnico.entidade.Endereco;
import br.com.aptare.cadastroUnico.servico.EnderecoService;
import br.com.aptare.cefit.espaco.entity.Espaco;
import br.com.aptare.cefit.espaco.entity.EspacoItemEspaco;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;
import br.com.aptare.fda.hibernate.CatalogoRestricoes;
import br.com.aptare.seguranca.entidade.Auditoria;

public class EspacoService extends AptareService<Espaco>
{
   private static EspacoService instancia;

   public static EspacoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new EspacoService();
      }
      return instancia;
   }

   private EspacoService()
   {
      adicionarFiltro("nome", CatalogoRestricoes.FAZ_PARTE_SEM_ACENTO, "nome");
      adicionarFiltro("listaEspacoItemEspaco.quantidadeManutencao", CatalogoRestricoes.MAIOR_QUE, "filtro.qtdItensManutencao");
   }
   
   @Override
   public Espaco inserir(Session session, Espaco entity) throws AptareException
   {
      // Endereco
      Endereco endereco = entity.getEndereco();
      EnderecoService.getInstancia().inserirSemValidar(session, endereco);
      
      entity.setCodigoEndereco(endereco.getCodigo());
      session.save(entity);
      
      //Itens de Espaco
      Set<EspacoItemEspaco> listaItens = entity.getListaEspacoItemEspaco();
      
      if(listaItens != null 
            && listaItens.size() > 0) 
      {
         for (EspacoItemEspaco espacoItemEspaco : listaItens)
         {
            espacoItemEspaco.setCodigoEspaco(entity.getCodigo());
            EspacoItemEspacoService.getInstancia().inserir(session, espacoItemEspaco);
         }
      }
         
      return entity;
   }
   
   @Override
   public Espaco alterar(Session session, Espaco entity) throws AptareException
   {
      this.validarAlterar(session, entity);
      
      //ENDERECO
      Endereco endereco = entity.getEndereco();
      EnderecoService.getInstancia().alterarSemValidar(session, endereco);
      
      //ITEM
      EspacoItemEspacoService.getInstancia().atualizarListaEspacoItemEspaco(session, new ArrayList<EspacoItemEspaco>(entity.getListaEspacoItemEspaco()), entity.getCodigo());
      
      session.update(entity);
         
      return entity;
   }
   
   public Espaco ativarInativar(Espaco entity) throws AptareException
   {
       Session session = getSession();
       session.setFlushMode(FlushMode.COMMIT);
       Transaction tx = session.beginTransaction();
       
       try
       {
           Espaco retorno = this.ativarInativar(session, entity);
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

   public Espaco ativarInativar(Session session, Espaco entity) throws AptareException
   {
      // Get cargo somente com o codigo
      Espaco espaco = new Espaco();
      espaco.setCodigo(entity.getCodigo());
      
      espaco = this.get(session, espaco, null, null);
      
      espaco.setFlagAtivo(entity.getFlagAtivo());
      espaco.setAuditoria(new Auditoria());
      espaco.getAuditoria().setDataAlteracao(entity.getAuditoria().getDataAlteracao());
      espaco.getAuditoria().setCodigoUsuarioAlteracao(entity.getAuditoria().getCodigoUsuarioAlteracao());
      
      session.merge(espaco);
      
      return espaco;
   }
   
   public void salvarManutencao(Espaco entity) throws AptareException
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

   public void salvarManutencao(Session session, Espaco entity) throws AptareException
   {
      if(entity.getListaEspacoItemEspaco() != null)
      {
         for (EspacoItemEspaco item : entity.getListaEspacoItemEspaco())
         {
            session.merge(item);
         }
      }
   }
}
