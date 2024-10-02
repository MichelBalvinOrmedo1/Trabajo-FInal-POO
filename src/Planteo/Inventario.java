package Planteo;

import java.util.HashMap;

public class Inventario {

    // clave : string : Valor : Articulo
    private final HashMap<String, Articulo> articulos;

    public Inventario() {
        articulos = new HashMap<>();
    }

    public void agregarArticulo(Articulo articulo) {
        articulos.put(articulo.getidArticulo(), articulo);
    }

    public void aplicarDescuento() {
        for (Articulo articulo : articulos.values()) {
            if (articulo instanceof AlimentoPerecedero perecedero) {
                perecedero.aplicarDescuentoProximoACaducar();
            } else if (articulo instanceof DispositivoElectronico electronico) {
                electronico.aplicarDescuentoFueraDeGarantia();
            }
        }
    }

    public void mostrarInventario() {
        articulos.values().forEach(System.out::println); // imprime cada articulo en la consola
    }

    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }
}
