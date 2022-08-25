package com.demo.pocmonedaapih2jwt.business;

import com.demo.pocmonedaapih2jwt.entity.TipoCambio;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaRequest;
import com.demo.pocmonedaapih2jwt.model.CambioMonedaResponse;

import java.util.List;

public interface CambioMonedaBusiness {

  CambioMonedaResponse ejecutarCambio(CambioMonedaRequest request);

  TipoCambio registrarTipoCambio(TipoCambio tipoCambio);

  void actualizarTipoCambio(TipoCambio tipoCambio);

  List<TipoCambio> listarTipoCambio();
}
