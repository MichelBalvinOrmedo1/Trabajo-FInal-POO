package Planteo;

import java.time.LocalDate;

public class AlimentoPerecedero extends Articulo {
    private LocalDate fechaCaducidad;

    public AlimentoPerecedero(String idArticulo, String nombre, int cantidad, double precio, LocalDate fechaCaducidad) {
        super(idArticulo, nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean estaProximoACaducar() {
        return LocalDate.now().plusDays(7).isAfter(fechaCaducidad);
    }

    public void aplicarDescuentoProximoACaducar() {
        if (estaProximoACaducar()) {
            setPrecio(getPrecio() * 0.9); // 10% de descuento
        }
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Fecha de Caducidad: %s", fechaCaducidad);
    }

}
