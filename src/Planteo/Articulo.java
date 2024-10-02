package Planteo;

import java.util.Objects;

public class Articulo {

    private String idArticulo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Articulo(String idArticulo, String nombre, int cantidad, double precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s, Cantidad: %d, Precio: %.2f)", nombre, idArticulo, cantidad, precio);
    }

    @Override
    public boolean equals(Object o) {
        // Verifica si el objeto actual es el mismo que el objeto pasado como parámetro
        if (this == o)
            return true;
        // Verifica si el objeto pasado como parámetro no es una instancia de la clase
        // Articulo
        if (!(o instanceof Articulo))
            return false;
        // Realiza un casting del objeto pasado como parámetro a la clase Articulo
        Articulo articulo = (Articulo) o;
        return idArticulo.equals(articulo.idArticulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticulo);
    }

    public String getidArticulo() {
        return idArticulo;
    }

    public void setidArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
