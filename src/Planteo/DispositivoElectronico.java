package Planteo;

public class DispositivoElectronico extends Articulo {
    private int mesesGarantia;

    public DispositivoElectronico(String idArticulo, String nombre, int cantidad, double precio, int mesesGarantia) {
        super(idArticulo, nombre, cantidad, precio);
        this.mesesGarantia = mesesGarantia;
    }

    public boolean tieneGarantiaVigente() {
        return mesesGarantia > 0;
    }

    public void aplicarDescuentoFueraDeGarantia() {
        if (!tieneGarantiaVigente()) {
            setPrecio(getPrecio() * 0.85); // 15% de descuento
        }
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Meses de Garantía: %d", mesesGarantia);
    }
}
