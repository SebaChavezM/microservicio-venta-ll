package com.example.ventas.service;

import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public BigDecimal calcularGananciasDiarias() {
        LocalDate today = LocalDate.now();
        List<Venta> ventasDiarias = ventaRepository.findByFecha(today);
        BigDecimal gananciasDiarias = BigDecimal.ZERO;
        for (Venta venta : ventasDiarias) {
            gananciasDiarias = gananciasDiarias.add(venta.getTotal());
        }
        return gananciasDiarias;
    }

    @Override
    public BigDecimal calcularGananciasMensuales() {
        YearMonth currentMonth = YearMonth.now();
        List<Venta> ventasMensuales = ventaRepository.findByFechaBetween(currentMonth.atDay(1), currentMonth.atEndOfMonth());
        BigDecimal gananciasMensuales = BigDecimal.ZERO;
        for (Venta venta : ventasMensuales) {
            gananciasMensuales = gananciasMensuales.add(venta.getTotal());
        }
        return gananciasMensuales;
    }

    @Override
    public BigDecimal calcularGananciasAnuales() {
        int currentYear = YearMonth.now().getYear();
        List<Venta> ventasAnuales = ventaRepository.findByFechaBetween(LocalDate.of(currentYear, 1, 1), LocalDate.of(currentYear, 12, 31));
        BigDecimal gananciasAnuales = BigDecimal.ZERO;
        for (Venta venta : ventasAnuales) {
            gananciasAnuales = gananciasAnuales.add(venta.getTotal());
        }
        return gananciasAnuales;
    }
}
