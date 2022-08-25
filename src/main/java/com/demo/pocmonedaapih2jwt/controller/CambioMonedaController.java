package com.demo.pocmonedaapih2jwt.controller;

import com.demo.pocmonedaapih2jwt.business.CambioMonedaBusiness;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaRequest;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api-demo/v1/cambio-moneda")
public class CambioMonedaController {

  private final CambioMonedaBusiness service;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public CambioMonedaResponse ejecutarCambio(@RequestBody CambioMonedaRequest request) {
    return service.ejecutarCambio(request);
  }
}