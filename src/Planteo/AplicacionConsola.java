package Planteo;

import java.time.LocalDate;
import java.util.Scanner;

public class AplicacionConsola {
    private final Inventario inventario;
    private final Reporte reporte;
    private final Scanner scanner;

    public AplicacionConsola() {
        this.inventario = new Inventario();
        this.reporte = new Reporte(inventario);
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> agregarArticulo();
                case 2 -> mostrarInventario();
                case 3 -> aplicarDescuentos();
                case 4 -> buscarArticulo();
                case 5 -> eliminarArticulo();
                case 6 -> generarReportes();
                case 0 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de Inventario ---");
        System.out.println("1. Agregar Artículo");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Aplicar Descuentos");
        System.out.println("4. Buscar Artículo");
        System.out.println("5. Eliminar Artículo");
        System.out.println("6. Generar Reportes");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarArticulo() {
        System.out.print("Ingrese el tipo de artículo (1. Alimento Perecedero, 2. Dispositivo Electrónico): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el ID del artículo: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nombre del artículo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        if (tipo == 1) {
            System.out.print("Ingrese la fecha de caducidad (YYYY-MM-DD): ");
            String fechaCaducidad = scanner.next();
            AlimentoPerecedero alimento = new AlimentoPerecedero(id, nombre, cantidad, precio,
                    LocalDate.parse(fechaCaducidad));
            inventario.agregarArticulo(alimento);
        } else if (tipo == 2) {
            System.out.print("Ingrese los meses de garantía: ");
            int mesesGarantia = scanner.nextInt();
            DispositivoElectronico dispositivo = new DispositivoElectronico(id, nombre, cantidad, precio,
                    mesesGarantia);
            inventario.agregarArticulo(dispositivo);
        } else {
            System.out.println("Tipo de artículo no válido.");
        }
    }

    private void mostrarInventario() {
        System.out.println("\n--- Inventario ---");
        inventario.mostrarInventario();
    }

    private void aplicarDescuentos() {
        inventario.aplicarDescuento();
        System.out.println("Descuentos aplicados.");
    }

    private void buscarArticulo() {
        System.out.print("Ingrese el ID del artículo a buscar: ");
        String id = scanner.nextLine();
        Articulo articulo = inventario.getArticulos().get(id);
        if (articulo != null) {
            System.out.println("Artículo encontrado: " + articulo);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private void eliminarArticulo() {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        String id = scanner.nextLine();
        Articulo articuloEliminado = inventario.getArticulos().remove(id);
        if (articuloEliminado != null) {
            System.out.println("Artículo eliminado: " + articuloEliminado);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private void generarReportes() {
        System.out.println("\n--- Reportes ---");
        System.out.println("1. Total de artículos");
        System.out.println("2. Productos perecederos a punto de caducar");
        System.out.println("3. Productos electrónicos fuera de garantía");
        System.out.print("Seleccione un reporte: ");
        int reporteOpcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (reporteOpcion) {
            case 1 -> reporte.generarReporteTotalArticulos();

            case 2 -> reporte.generarReportePerecederosAPuntoDeCaduca();

            case 3 -> reporte.generarReporteElectronicosFueraDeGarantia();

            default -> System.out.println("Opción no válida.");
        }
    }
}