package br.com.aptare.cefit.trabalhador.service;

import br.com.aptare.cefit.trabalhador.entity.Documento;
import br.com.aptare.comum.entidade.Parametro;
import br.com.aptare.comum.servico.ParametroService;
import br.com.aptare.fda.crud.service.AptareService;
import br.com.aptare.fda.exception.AptareException;
import org.hibernate.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class DocumentoService extends AptareService<Documento>
{
   
   public static final int TIPO_FOTO = 1;
   public static final int TIPO_CPF = 2;
   public static final int TIPO_RG = 3;
   public static final int TIPO_CURRICULO = 4;
   
   private static DocumentoService instancia;
   
   public static DocumentoService getInstancia()
   {
      if (instancia == null)
      {
         instancia = new DocumentoService();
      }
      return instancia;
   }
   
   private DocumentoService()
   {
   }
   
   @Override
   public Documento inserir(Session session, Documento entity) throws AptareException
   {
      try
      {
         entity = super.inserir(session, entity);;
         session.flush();
         
         Parametro parametro = new Parametro();
         parametro.setNome("PATH_DCM_TRB");
         
         parametro = ParametroService.getInstancia().get(session, parametro, null, null);
         String pathImagem = parametro.getValor();
         
         if (entity.getBase64() != null
               && !"".equalsIgnoreCase(entity.getBase64().trim()))
         {
            byte[] imagemBytes = Base64.getDecoder().decode(entity.getBase64());  
            FileOutputStream fos = new FileOutputStream(new File(pathImagem + entity.getCodigo() + "." + entity.getExtensao()));  
            fos.write(imagemBytes);  
            fos.flush();
            fos.close();
         }
         
         return entity;
      }
      catch (AptareException ae)
      {
         throw ae;
      }
      catch (Exception e)
      {
         throw new AptareException(e);
      }
   }
   
   @Override
   public Documento alterar(Session session, Documento entity) throws AptareException
   {
      try
      {
         entity = super.alterar(session, entity);;
         session.flush();
         
         Parametro parametro = new Parametro();
         parametro.setNome("PATH_DCM_TRB");
         
         parametro = ParametroService.getInstancia().get(session, parametro, null, null);
         String pathImagem = parametro.getValor();
         
         if (entity.getBase64() != null
               && !"".equalsIgnoreCase(entity.getBase64().trim()))
         {
            byte[] imagemBytes = Base64.getDecoder().decode(entity.getBase64());  
            FileOutputStream fos = new FileOutputStream(new File(pathImagem + entity.getCodigo() + "." + entity.getExtensao()));  
            fos.write(imagemBytes);  
            fos.flush();
            fos.close();
         }
         
         return entity;
      }
      catch (AptareException ae)
      {
         throw ae;
      }
      catch (Exception e)
      {
         throw new AptareException(e);
      }
   }
   
}
