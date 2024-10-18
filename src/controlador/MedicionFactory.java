package controlador;

import modelo.MedicionPrototype;
import modelo.Pulsaciones;

public class MedicionFactory {

    public MedicionPrototype crearMedicion(String tipo, int valor) {
        switch (tipo) {
            case "pulsaciones" -> {
                return new Pulsaciones(valor);
            }
            default ->
                throw new IllegalArgumentException("Tipo de medición no reconocido.");
        }

    }

}
