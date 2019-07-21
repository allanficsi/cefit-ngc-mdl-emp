package br.com.aptare.cefit.vagas.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "SC_VAG", name = "TBL_VAG_DIA")
@Proxy(lazy = true)
public class VagaDia implements Serializable
{

   private static final long serialVersionUID = 1431211184645188934L;

   @Id
   @Column(name = "CD_VAG_DIA")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_VAG_DIA")
   @SequenceGenerator(name = "SQ_VAG_DIA", sequenceName = "SC_VAG.SQ_VAG_DIA")
   private Long codigo;

   @Column(name = "CD_VAG")
   private Long codigoVaga;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CD_VAG", insertable = false, updatable = false)
   private Vaga vaga;
   
   @Column(name = "DT_VAG")
   private Date data;
   
   @Column(name = "NR_HOR1")
   private String horarioEntrada;

   @Column(name = "NR_HOR2")
   private String horarioSaida;


   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public Long getCodigoVaga()
   {
      return codigoVaga;
   }

   public void setCodigoVaga(Long codigoVaga)
   {
      this.codigoVaga = codigoVaga;
   }

   public Vaga getVaga()
   {
      return vaga;
   }

   public void setVaga(Vaga vaga)
   {
      this.vaga = vaga;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }

   public String getHorarioEntrada()
   {
      return horarioEntrada;
   }

   public void setHorarioEntrada(String horarioEntrada)
   {
      this.horarioEntrada = horarioEntrada;
   }

   public String getHorarioSaida()
   {
      return horarioSaida;
   }

   public void setHorarioSaida(String horarioSaida)
   {
      this.horarioSaida = horarioSaida;
   }
}
