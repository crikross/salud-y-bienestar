package controlador;

import modelo.Saludd;

public class SaludFacade {
    private final Saludd salud;

    public SaludFacade() {
        salud = Saludd.getInstance();
    }

    public void registrarPulsaciones(int pulsaciones) {
        salud.setPulsaciones(pulsaciones);
    }

    public void registrarPasos(int pasos) {
        salud.setPasos(pasos);
    }

    public void registrarEstres(int estres) {
        salud.setNivelEstres(estres);
    }

    public void diagnostico() {
        System.out.println("Diagnostico final:");   
    }
         
}
