package com.demo.pocmonedaapih2jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CambioMonedaResponse {

  private double monto;
  private double montoCambio;
  private String monedaOrigen;
  private String monedaDestino;
  private double tipoCambio;
}
