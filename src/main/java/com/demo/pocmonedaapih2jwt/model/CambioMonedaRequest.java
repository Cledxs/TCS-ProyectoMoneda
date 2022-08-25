package com.demo.pocmonedaapih2jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CambioMonedaRequest {

  private double monto;
  private String monedaOrigen;
  private String monedaDestino;
}
