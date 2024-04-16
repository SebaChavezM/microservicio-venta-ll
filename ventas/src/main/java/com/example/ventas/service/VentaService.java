package com.example.ventas.service;

import com.example.ventas.model.Venta;

import java.math.BigDecimal;
import java.util.List;

public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Long id);
    Venta saveVenta(Venta venta);
    void deleteVenta(Long id);
    BigDecimal calcularGananciasDiarias();
    BigDecimal calcularGananciasMensuales();
    BigDecimal calcularGananciasAnuales();
}