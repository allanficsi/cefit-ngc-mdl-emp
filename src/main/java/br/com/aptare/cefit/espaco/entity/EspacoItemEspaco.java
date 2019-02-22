package br.com.aptare.cefit.espaco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

@Entity
@Table(schema = "SC_ESP", name = "TBL_ESP_ITE")
@Proxy(lazy = true)
public class EspacoItemEspaco implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_ESP_ITE")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ESP_ITE")
   @SequenceGenerator(name = "SQ_ESP_ITE", sequenceName = "SC_ESP.SQ_ESP_ITE")
   private Long codigo;

   @Column(name = "CD_ESP")
   private Long codigoEspaco;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_ESP", insertable = false, updatable = false)
   private Espaco espaco;
   
   @Column(name = "CD_ITE")
   private Long codigoItem;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_ITE", insertable = false, updatable = false)
   private ItemEspaco itemEspaco;
   
   @Column(name = "QT_ITE_ATV")
   private Integer quantidadeAtivos;
   
   @Column(name = "QT_ITE_MNT")
   private Integer quantidadeManutencao;
   
   @Formula("(QT_ITE_ATV + QT_ITE_MNT)")
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

   public Espaco getEspaco()
   {
      return espaco;
   }

   public void setEspaco(Espaco espaco)
   {
      this.espaco = espaco;
   }

   public ItemEspaco getItemEspaco()
   {
      return itemEspaco;
   }

   public void setItemEspaco(ItemEspaco itemEspaco)
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
