package br.com.aptare.cefit.trabalhador.dto;

import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class CboDTO
{
   private Long codigo;
   
   private String nome;
   
   private String nomeCodigo;
   
   private String tipo;
   
   private String flagAtivo;
   
   private String nomePersonalizado;
   
   private String flagValorFixo;
   
   private Double valorServico;

   private Double valorVisita;
   
   public String getFlagValorFixo()
   {
      return flagValorFixo;
   }

   public void setFlagValorFixo(String flagValorFixo)
   {
      this.flagValorFixo = flagValorFixo;
   }

   public Double getValorServico()
   {
      return valorServico;
   }

   public void setValorServico(Double valorServico)
   {
      this.valorServico = valorServico;
   }

   public Double getValorVisita()
   {
      return valorVisita;
   }

   public void setValorVisita(Double valorVisita)
   {
      this.valorVisita = valorVisita;
   }

   private AuditoriaDTO auditoria;
   

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getNomeCodigo()
   {
      return nomeCodigo;
   }

   public void setNomeCodigo(String nomeCodigo)
   {
      this.nomeCodigo = nomeCodigo;
   }

   public String getTipo()
   {
      return tipo;
   }

   public void setTipo(String tipo)
   {
      this.tipo = tipo;
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

   public String getNomePersonalizado()
   {
      return nomePersonalizado;
   }

   public void setNomePersonalizado(String nomePersonalizado)
   {
      this.nomePersonalizado = nomePersonalizado;
   }
}
