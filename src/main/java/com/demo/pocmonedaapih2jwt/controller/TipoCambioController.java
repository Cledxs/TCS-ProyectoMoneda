package com.demo.pocmonedaapih2jwt.controller;

import com.demo.pocmonedaapih2jwt.business.CambioMonedaBusiness;
import com.demo.pocmonedaapih2jwt.entity.TipoCambio;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api-demo/v1/tipo-cambio")
public class TipoCambioController {

  private final CambioMonedaBusiness service;

  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.CREATED)
  public TipoCambio registrarTipoCambio(@RequestBody TipoCambio tipoCambio) {
    return service.registrarTipoCambio(tipoCambio);
  }

  @PatchMapping(
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void actualizarTipoCambio(@RequestBody TipoCambio tipoCambio) {
    service.actualizarTipoCambio(tipoCambio);
  }

  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<TipoCambio> listar() {
    return service.listarTipoCambio();
  }
}
