package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import conexion.Conexion;
import java.sql.SQLException;
import java.sql.DriverManager;

public class SignosVitales {

    // Método para guardar los signos vitales
    public static void guardarSignosVitales(int usuarioId, int pulsaciones, int presionArterial) {
        Connection cn = Conexion.conectar();  // Usamos la nueva conexión

        if (cn != null) {
            try {
                // Llamada al procedimiento almacenado para guardar signos vitales
                CallableStatement stmt = cn.prepareCall("{CALL guardarSignosVitales(?, ?, ?)}");
                stmt.setInt(1, usuarioId);
                stmt.setInt(2, pulsaciones);
                stmt.setInt(3, presionArterial);
                stmt.execute();

            } catch (SQLException e) {
                System.out.println("Error al guardar los signos vitales: " + e.getMessage());
            } finally {
                try {
                    if (cn != null && !cn.isClosed()) {
                        cn.close();  // Cerramos la conexión
                    }
                } catch (SQLException e) {
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
        }
    }

    // Método para consultar los signos vitales
    public static void consultarSignosVitales(int usuarioId) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salud", "root", "root")) {
            CallableStatement stmt = con.prepareCall("{CALL consultarSignosVitales(?)}");
            stmt.setInt(1, usuarioId);
            boolean hasResults = stmt.execute();
            
            // Imprimir resultados si hay datos
            if (hasResults) {
                var rs = stmt.getResultSet();
                while (rs.next()) {
                    System.out.println("Usuario ID: " + rs.getInt("usuarioId"));
                    System.out.println("Pulsaciones: " + rs.getInt("pulsaciones"));
                    System.out.println("Presión Arterial: " + rs.getInt("presionArterial"));
                    System.out.println("Fecha de Registro: " + rs.getTimestamp("fechaRegistro"));
                }
            } else {
                System.out.println("No se encontraron registros para el usuario con ID " + usuarioId);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar los signos vitales: " + e.getMessage());
        }
    }
}

