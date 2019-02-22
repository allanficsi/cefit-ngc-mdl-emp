package br.com.aptare.cefit.espaco.dto;

import java.io.Serializable;
import java.util.Set;

import br.com.aptare.cefit.cadastroUnico.dto.EnderecoDTO;
import br.com.aptare.cefit.common.dto.AuditoriaDTO;

public class EspacoDTO  implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private String nome;
   
   private Integer capacidade;
   
   private String descricao;
   
   private Long codigoEndereco;
   
   private EnderecoDTO endereco;
   
   private Long codigoLocal;
   
   private LocalDTO local;
   
   private Integer qtdItensManutencao;
   
   private String flagAtivo;
   
   private AuditoriaDTO auditoria;
   
   private Set<EspacoItemEspacoDTO> listaEspacoItemEspaco;

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

   public Integer getCapacidade()
   {
      return capacidade;
   }

   public void setCapacidade(Integer capacidade)
   {
      this.capacidade = capacidade;
   }

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Long getCodigoEndereco()
   {
      return codigoEndereco;
   }

   public void setCodigoEndereco(Long codigoEndereco)
   {
      this.codigoEndereco = codigoEndereco;
   }

   public AuditoriaDTO getAuditoria()
   {
      return auditoria;
   }

   public void setAuditoria(AuditoriaDTO auditoria)
   {
      this.auditoria = auditoria;
   }

   public String getFlagAtivo()
   {
      return flagAtivo;
   }

   public void setFlagAtivo(String flagAtivo)
   {
      this.flagAtivo = flagAtivo;
   }

   public EnderecoDTO getEndereco()
   {
      return endereco;
   }

   public void setEndereco(EnderecoDTO endereco)
   {
      this.endereco = endereco;
   }

   public Set<EspacoItemEspacoDTO> getListaEspacoItemEspaco()
   {
      return listaEspacoItemEspaco;
   }

   public void setListaEspacoItemEspaco(Set<EspacoItemEspacoDTO> listaEspacoItemEspaco)
   {
      this.listaEspacoItemEspaco = listaEspacoItemEspaco;
   }

   public Long getCodigoLocal()
   {
      return codigoLocal;
   }

   public void setCodigoLocal(Long codigoLocal)
   {
      this.codigoLocal = codigoLocal;
   }

   public LocalDTO getLocal()
   {
      return local;
   }

   public void setLocal(LocalDTO local)
   {
      this.local = local;
   }

   public Integer getQtdItensManutencao()
   {
      return qtdItensManutencao;
   }

   public void setQtdItensManutencao(Integer qtdItensManutencao)
   {
      this.qtdItensManutencao = qtdItensManutencao;
   }
}
