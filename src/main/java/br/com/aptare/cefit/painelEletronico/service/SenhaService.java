package br.com.aptare.cefit.painelEletronico.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.aptare.cefit.painelEletronico.entity.Senha;
import br.com.aptare.cefit.painelEletronico.entity.TipoSenha;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import br.com.aptare.fda.exception.TratamentoPadraoErro;

public class SenhaService extends AptareService<Senha>
{

   private static SenhaService instancia;

   public static SenhaService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new SenhaService();
      }
      return instancia;
   }

   @Override
   @SuppressWarnings("static-access")
   public Senha inserir(Session session, Senha senha) throws AptareException
   {
      Long ultimaSenha = this.retornarUltimaSenha(session, senha);
      Long proximaSenha = ultimaSenha + 1;
      
      TipoSenha tipoSenha = new TipoSenha();
      tipoSenha.setCodigo(senha.getCodigoTipoSenha());
      tipoSenha = TipoSenhaService.getInstancia().get(session, tipoSenha, null, null);

      String descricaoSenha = tipoSenha.getDescricao().substring(0, 2) + "" + String.format("%05d", proximaSenha);;
      
      senha.setNumero(proximaSenha);
      senha.setDataInclusao(new Date());
      senha.setDescricao(descricaoSenha);
      senha.setFlagAtivo(true);

      session.save(senha);
      
      try
      {
         Thread.currentThread().sleep(2000);
      }
      catch (InterruptedException e)
      {
         throw new AptareException(e);
      }
      
      // Imprimir cupom senha
      
      
      
      return senha;
   }

   public Long retornarUltimaSenha(Session session, Senha senha)
   {
      Long retorno = 0L;
      
      Criteria criteria = session.createCriteria(Senha.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.max("numero"));

      if (senha.getCodigoTipoSenha() != null && senha.getCodigoTipoSenha().intValue() > 0)
      {
         criteria.add(Restrictions.eq("codigoTipoSenha", senha.getCodigoTipoSenha()));
      }
      
      if (senha.getData() != null && !senha.getData().toString().trim().equals(""))
      {
         criteria.add(Restrictions.eq("data", senha.getData()));
      }
      
      if (senha.getFlagAtivo() != null)
      {
         criteria.add(Restrictions.eq("flagAtivo", senha.getFlagAtivo()));
      }
      
      criteria.setProjection(projection);
      
      Object resultado = criteria.uniqueResult();
      
      if(resultado != null) 
      {
         retorno = Long.parseLong(resultado.toString());
      }
      
      
      return retorno;
   }
   
   public Senha retornarUltima(Session session, Senha entity) throws AptareException
   {
      Long codigo = null;
      
      Criteria criteria = session.createCriteria(Senha.class);

      ProjectionList projection = Projections.projectionList();
      projection.add(Projections.max("codigo"));
      criteria.add(Restrictions.eq("flagAtivo", true));
      criteria.add(Restrictions.eq("data", new Date()));
      
      criteria.setProjection(projection);
      
      Object resultado = criteria.uniqueResult();
      
      Senha senha = null;
      
      if(resultado != null) 
      {
         codigo = Long.parseLong(resultado.toString());
         
         senha = new Senha();
         senha.setCodigo(codigo);
         
         senha = this.get(session, senha, null, null);
      }
      
      return senha;
   }
   
   public void resetarSenha(Long codigoUsuario) throws AptareException
   {
      Session session = getSession();
      session.setFlushMode(FlushMode.COMMIT);
      Transaction tx = session.beginTransaction();
      
      try
      {
         this.resetarSenha(session, codigoUsuario);
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

   public void resetarSenha(Session session, Long codigoUsuario) throws AptareException
   {
      Senha senha = new Senha();
      senha.setData(new Date());
      senha.setFlagAtivo(true);
      
      List<Senha> lista = this.pesquisar(session, senha, null, null);
      
      if(lista != null
            && lista.size() > 0)
      {
         for (Senha obj : lista)
         {
            obj.setFlagAtivo(false);
            obj.setCodigoUsuarioAlteracao(codigoUsuario);
            obj.setDataAlteracao(new Date());
            
            session.merge(obj);
         }
      }
         
      
   }
   
}
