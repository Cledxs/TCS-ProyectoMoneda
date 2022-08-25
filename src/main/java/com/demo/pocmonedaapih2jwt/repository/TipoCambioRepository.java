package com.demo.pocmonedaapih2jwt.repository;

import com.demo.pocmonedaapih2jwt.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

  Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
