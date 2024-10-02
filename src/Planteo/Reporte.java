package Planteo;

public class Reporte {

    private final Inventario inventario;

    public Reporte(Inventario inventario) {
        this.inventario = inventario;
    }

    public void generarReporteTotalArticulos() {
        System.out.println("Reporte Total de Articulos");
        System.err.println("Total de Articulos: " + inventario.getArticulos().size());
    }

    public void generarReportePerecederosAPuntoDeCaduca() {
        System.out.println("Reporte de Alimentos Perecederos a Punto de Caducar:");

        for (Articulo articulo : inventario.getArticulos().values()) {
            if (articulo instanceof AlimentoPerecedero perecedero) {
                if (perecedero.estaProximoACaducar()) {
                    System.out.println(perecedero);
                }
            }
        }
    }

    public void generarReporteElectronicosFueraDeGarantia() {
        System.out.println("Reporte de Dispositivos Electrónicos Fuera de Garantía:");
        for (Articulo articulo : inventario.getArticulos().values()) {
            if (articulo instanceof DispositivoElectronico) {
                DispositivoElectronico electronico = (DispositivoElectronico) articulo;
                if (!electronico.tieneGarantiaVigente()) {
                    System.out.println(electronico);
                }
            }
        }
    }
}
