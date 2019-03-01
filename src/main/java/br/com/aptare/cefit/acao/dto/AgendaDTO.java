package br.com.aptare.cefit.acao.dto;

import java.util.Date;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class AgendaDTO
{
   private Long codigo;

   private Long codigoEspaco;
   
   private Date dataAgenda;
   
   private Boolean fgFeriado;
   
   private String nrHor1;
   
   private String nrHor2;
   
   private String nrHor3;
   
   private String nrHor4;
   
   private String flagAtivo;
   
   private AuditoriaDTO auditoria;

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoEspaco()
   {
      return codigoEspaco;
   }

   public void setCodigoEspaco(Long codigoEspaco)
   {
      this.codigoEspaco = codigoEspaco;
   }

   public Date getDataAgenda()
   {
      return dataAgenda;
   }

   public void setDataAgenda(Date dataAgenda)
   {
      this.dataAgenda = dataAgenda;
   }

   public Boolean getFgFeriado()
   {
      return fgFeriado;
   }

   public void setFgFeriado(Boolean fgFeriado)
   {
      this.fgFeriado = fgFeriado;
   }

   public String getNrHor1()
   {
      return nrHor1;
   }

   public void setNrHor1(String nrHor1)
   {
      this.nrHor1 = nrHor1;
   }

   public String getNrHor2()
   {
      return nrHor2;
   }

   public void setNrHor2(String nrHor2)
   {
      this.nrHor2 = nrHor2;
   }

   public String getNrHor3()
   {
      return nrHor3;
   }

   public void setNrHor3(String nrHor3)
   {
      this.nrHor3 = nrHor3;
   }

   public String getNrHor4()
   {
      return nrHor4;
   }

   public void setNrHor4(String nrHor4)
   {
      this.nrHor4 = nrHor4;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }
}
