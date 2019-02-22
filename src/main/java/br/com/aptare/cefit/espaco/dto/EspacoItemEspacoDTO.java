package br.com.aptare.cefit.espaco.dto;

import java.io.Serializable;

public class EspacoItemEspacoDTO  implements Serializable
{
   private static final long serialVersionUID = 8059018496629414759L;

   private Long codigo;

   private Long codigoEspaco;
   
   private ItemEspacoDTO itemEspaco;

   private Long codigoItem;
   
   private Integer quantidadeAtivos;
   
   private Integer quantidadeManutencao;
   
   private Integer totalItens;

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

   public Long getCodigoItem()
   {
      return codigoItem;
   }

   public void setCodigoItem(Long codigoItem)
   {
      this.codigoItem = codigoItem;
   }

   public Integer getQuantidadeAtivos()
   {
      return quantidadeAtivos;
   }

   public void setQuantidadeAtivos(Integer quantidadeAtivos)
   {
      this.quantidadeAtivos = quantidadeAtivos;
   }

   public Integer getQuantidadeManutencao()
   {
      return quantidadeManutencao;
   }

   public void setQuantidadeManutencao(Integer quantidadeManutencao)
   {
      this.quantidadeManutencao = quantidadeManutencao;
   }

   public ItemEspacoDTO getItemEspaco()
   {
      return itemEspaco;
   }

   public void setItemEspaco(ItemEspacoDTO itemEspaco)
   {
      this.itemEspaco = itemEspaco;
   }

   public Integer getTotalItens()
   {
      return totalItens;
   }

   public void setTotalItens(Integer totalItens)
   {
      this.totalItens = totalItens;
   }
}
