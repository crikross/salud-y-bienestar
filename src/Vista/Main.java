package Vista;

import controlador.SaludFacade;
import controlador.SignosVitales;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SaludFacade saludFacade = new SaludFacade();
            boolean continuar = true;

            // Variables para almacenar los valores ingresados
            int pulsaciones = -1;
            int pasos = -1;
            int estres = -1;
            int presionArterial = -1;
            float distancia = -1;
            int caloriasQuemadas = -1;
            String motivoEstres = "";
            int usuarioId = 1;  // ID del usuario predeterminado

            while (continuar) {
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Registrar Signos Vitales (Pulsaciones y Presion Arterial.)");
                System.out.println("2. Registrar Actividad Fisica (Pasos, Distancia y Calorias.)");
                System.out.println("3. Registrar Nivel de Estres.");
                System.out.println("4. Salir");
                System.out.print("Por favor, Ingrese un numero: ");
                int opcion = scanner.nextInt();
                // separacion
                        System.out.println("\n-------------------------------");

                switch (opcion) {
                    case 1 -> {
                        // Registrar pulsaciones y presión arterial
                        System.out.print("Ingrese las pulsaciones: ");
                        pulsaciones = scanner.nextInt();
                        saludFacade.registrarPulsaciones(pulsaciones);

                        //Registrar presion arterial
                        System.out.println("Ingrese la presion arterial: ");
                        presionArterial = scanner.nextInt();

                        // Registrar los signos vitales en la base de datos
                        SignosVitales.guardarSignosVitales(usuarioId, pulsaciones, presionArterial);

                        System.out.println("Signos vitales registrados correctamente.");
                        System.out.println("Diagnostico Registrado");
                        
                        // separacion
                        System.out.println("\n-------------------------------");
                        
                    }
                    case 2 -> {
                        // Registrar actividad física
                        System.out.print("Ingrese los pasos recorridos: ");
                        pasos = scanner.nextInt();

                        System.out.print("Ingrese la distancia recorrida (en km): ");
                        distancia = scanner.nextFloat();

                        System.out.print("Ingrese las calorias quemadas: ");
                        caloriasQuemadas = scanner.nextInt();

                        System.out.println("Actividad fisica registrada correctamente.");
                        System.out.println("Diagnostico Registrado");
                        
                        // separacion
                        System.out.println("\n-------------------------------");
                    }
                    case 3 -> {
                        // Registrar nivel de estrés
                        System.out.print("Ingrese el nivel de estrés: ");
                        estres = scanner.nextInt();

                        System.out.print("Ingrese el motivo del estrés: ");
                        scanner.nextLine(); // limpiar buffer
                        motivoEstres = scanner.nextLine();

                        System.out.println("Nivel de estrés registrado correctamente.");
                        System.out.println("Diagnostico Registrado");
                        
                        // separacion
                        System.out.println("\n-------------------------------");
                    }
                    case 4 -> {
                        // Mostrar diagnóstico cuando el usuario elija salir
                        saludFacade.diagnostico();

                        // Diagnóstico sobre las pulsaciones
                        if (pulsaciones > 90) {
                            System.out.println("- Pulsaciones altas.");
                        } else if (pulsaciones <= 60) {
                            System.out.println("- Pulsaciones dentro del rango normal.");
                        }

                        // Diagnóstico sobre la presión arterial
                        if (presionArterial >= 140) {
                            System.out.println("- Presión arterial muy alta (hipertensión).- Nota: Se recomienda consultar a un médico.");
                        } else if (presionArterial >= 120 && presionArterial < 140) {
                            System.out.println("- Presión arterial elevada.- Nota: Es recomendable controlarla.");
                        } else if (presionArterial >= 90 && presionArterial < 120) {
                            System.out.println("- Presión arterial dentro del rango normal.");
                        } else if (presionArterial >= 60 && presionArterial < 90) {
                            System.out.println("- Presion arterial baja.- Nota: Mantente atento a posibles síntomas de hipotensión.");
                        } else {
                            System.out.println("- Presion arterial muy baja (hipotensión).- Nota: Se recomienda consultar a un médico.");
                        }

                        // Diagnóstico sobre los pasos
                        if (pasos < 8000) {
                            System.out.println("- Nivel de actividad fisica bajo.");
                        } else if (pasos >= 8000) {
                            System.out.println("- Nivel de actividad fisica adecuado.");
                        }

                        // Diagnóstico sobre la distancia recorrida
                        if (distancia < 200) {
                            System.out.println("- Distancia recorrida: " + distancia + " km.");
                        }

                        // Diagnóstico sobre las calorías quemadas
                        if (caloriasQuemadas < 8000) {
                            System.out.println("- Calorias quemadas: " + caloriasQuemadas + " kcal.");
                        }

                        // Diagnóstico sobre el nivel de estrés
                        if (estres >= 300) {
                            System.out.println("- Alto nivel de estres.");
                        } else if (estres <= 299) {
                            System.out.println("- Nivel de estres dentro del rango normal.");
                        } else if (estres <= 150) {
                            System.out.println("- Nivel de estres dentro del rango bajo.");
                        }

                        // Motivo del estrés
                        if (!motivoEstres.isEmpty()) {
                            System.out.println("- Motivo del estres: " + motivoEstres);
                        }
                         
                        // separacion
                        System.out.println("\n-------------------------------");
                        
                        continuar = false;  // Salir del bucle
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }

            System.out.println("Saliendo del programa. Cuidate!");
        }
    }
}
