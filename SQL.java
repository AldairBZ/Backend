import java.sql.*;

public class SQL {
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "tu_contraseña";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver JDBC de MySQL.");
            e.printStackTrace();
        }
    }

    public static boolean registrarUsuario(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Conexión a la base de datos exitosa.");
            // Verificar si el usuario ya existe
            String checkQuery = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                System.out.println("El usuario ya existe en la base de datos.");
                return false; // Usuario ya existe
            }
            // Insertar nuevo usuario
            String insertQuery = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            System.out.println("Usuario insertado correctamente en la base de datos.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error de base de datos al registrar usuario:");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean loginUsuario(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error de base de datos al hacer login:");
            e.printStackTrace();
            return false;
        }
    }
}
