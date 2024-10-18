package modelo;

public class Pulsaciones extends MedicionPrototype{
    private final int pulsaciones;

    public Pulsaciones(int pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    @Override
    public MedicionPrototype clonar() {
        return new Pulsaciones(this.pulsaciones);
    }

    public int getPulsaciones() {
        return pulsaciones;
    }
}
