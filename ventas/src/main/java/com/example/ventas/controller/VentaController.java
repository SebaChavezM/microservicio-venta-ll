package com.example.ventas.controller;

import com.example.ventas.model.Venta;
import com.example.ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id);
    }

    @PostMapping
    public Venta saveVenta(@RequestBody Venta venta) {
        return ventaService.saveVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }

    @GetMapping("/ganancias-diarias")
    public BigDecimal calcularGananciasDiarias() {
        return ventaService.calcularGananciasDiarias();
    }

    @GetMapping("/ganancias-mensuales")
    public BigDecimal calcularGananciasMensuales() {
        return ventaService.calcularGananciasMensuales();
    }

    @GetMapping("/ganancias-anuales")
    public BigDecimal calcularGananciasAnuales() {
        return ventaService.calcularGananciasAnuales();
    }
}