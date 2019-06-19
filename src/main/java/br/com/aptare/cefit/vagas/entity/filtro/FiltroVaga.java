package br.com.aptare.cefit.vagas.entity.filtro;

import java.io.Serializable;

public class FiltroVaga implements Serializable
{
   private static final long serialVersionUID = 1L;
   
   private String[] tipoVagaIN;
   
   private String codigoIsNull;
   
   private String flagAtivoDiferenteEncaminhamento;

   public String[] getTipoVagaIN()
   {
      return tipoVagaIN;
   }

   public void setTipoVagaIN(String[] tipoVagaIN)
   {
      this.tipoVagaIN = tipoVagaIN;
   }

   public String getCodigoIsNull()
   {
      return codigoIsNull;
   }

   public void setCodigoIsNull(String codigoIsNull)
   {
      this.codigoIsNull = codigoIsNull;
   }

   public String getFlagAtivoDiferenteEncaminhamento()
   {
      return flagAtivoDiferenteEncaminhamento;
   }

   public void setFlagAtivoDiferenteEncaminhamento(String flagAtivoDiferenteEncaminhamento)
   {
      this.flagAtivoDiferenteEncaminhamento = flagAtivoDiferenteEncaminhamento;
   }

}
