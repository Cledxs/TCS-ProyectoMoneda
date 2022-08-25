package com.demo.pocmonedaapih2jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "tipocambio")
@AllArgsConstructor
public class TipoCambio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCambio;

  @Column(name = "monedaOrigen")
  private String monedaOrigen;

  @Column(name = "monedaDestino")
  private String monedaDestino;

  @Column(name = "tipoCambio")
  private double tipoCambio;

  public TipoCambio() {

  }
}
