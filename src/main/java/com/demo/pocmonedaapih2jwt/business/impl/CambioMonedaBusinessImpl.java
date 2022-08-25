package com.demo.pocmonedaapih2jwt.business.impl;

import com.demo.pocmonedaapih2jwt.business.CambioMonedaBusiness;
import com.demo.pocmonedaapih2jwt.entity.TipoCambio;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaRequest;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaResponse;
import com.demo.pocmonedaapih2jwt.repository.TipoCambioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CambioMonedaBusinessImpl implements CambioMonedaBusiness {

  private final TipoCambioRepository repository;

  @Override
  public CambioMonedaResponse ejecutarCambio(CambioMonedaRequest request) {
    return repository.findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(), request.getMonedaDestino())
                     .map(data -> CambioMonedaResponse.builder()
                                                      .monto(request.getMonto())
                                                      .montoCambio(request.getMonto() * data.getTipoCambio())
                                                      .monedaDestino(request.getMonedaDestino())
                                                      .monedaOrigen(request.getMonedaOrigen())
                                                      .tipoCambio(data.getTipoCambio()).build()
                     ).orElseThrow(() -> new RuntimeException("No existe moneda registrada"));
  }

  @Override
  public TipoCambio registrarTipoCambio(TipoCambio tipoCambio) {
    Optional<TipoCambio> tipoCambioRes = repository.findByMonedaOrigenAndMonedaDestino(tipoCambio.getMonedaOrigen(), tipoCambio.getMonedaDestino());

    if (tipoCambioRes.isPresent()) {
      throw new RuntimeException("Ya existe el tipo de cambio");
    }

    return repository.save(tipoCambio);
  }

  @Override
  public void actualizarTipoCambio(TipoCambio tipoCambio) {
    Optional<TipoCambio> tipoCambioRes = repository.findById(tipoCambio.getIdCambio());

    if (tipoCambioRes.isEmpty()) {
      throw new RuntimeException("No existe el tipo de cambio");
    } else {
      repository.save(tipoCambio);
    }
  }

  @Override
  public List<TipoCambio> listarTipoCambio() {
    return repository.findAll();
  }
}