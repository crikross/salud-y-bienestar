
package modelo;

public class Saludd {
    private static Saludd instance;
    private int pulsaciones;
    private int pasos;
    private int nivelEstres;

    private Saludd () {}

    public static Saludd getInstance() {
        if (instance == null) {
            instance = new Saludd();
        }
        return instance;
    }

    public void setPulsaciones(int pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    public int getPulsaciones() {
        return pulsaciones;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public int getPasos() {
        return pasos;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }
    
}
