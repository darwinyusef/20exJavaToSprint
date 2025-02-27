package firstsqlite;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db"; // Base de datos local

        try {
            // 🔹 Asegurar que el driver se carga correctamente
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    System.out.println("Conectado a SQLite");

                    // Crear tabla si no existe
                    crearTabla(conn);

                    // Insertar datos
                    // insertarUsuario(conn, "Alice", 25);
                    // insertarUsuario(conn, "Bob", 30);
                    insertarUsuario(conn, "Pepito", 37);

                    // Consultas
                    System.out.println("\n🔍 Todos los usuarios:");
                    consultarTodos(conn);

                    System.out.println("\n🔍 Usuarios mayores de 25:");
                    consultarMayoresDe(conn, 25);

                    System.out.println("\n🔍 Usuario con ID 2:");
                    consultarPorId(conn, 2);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de SQLite.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    private static void crearTabla(Connection conn) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    edad INTEGER NOT NULL
                );
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'usuarios' creada correctamente.");
        }
    }

    private static void insertarUsuario(Connection conn, String nombre, int edad) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, edad) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.executeUpdate();
            System.out.println("✅ Insertado: " + nombre);
        }
    }

    private static void consultarTodos(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Edad: " + rs.getInt("edad"));
            }
        }
    }

    private static void consultarMayoresDe(Connection conn, int edad) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE edad > ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, edad);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Nombre: " + rs.getString("nombre") +
                            ", Edad: " + rs.getInt("edad"));
                }
            }
        }
    }

    private static void consultarPorId(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Nombre: " + rs.getString("nombre") +
                            ", Edad: " + rs.getInt("edad"));
                } else {
                    System.out.println("❌ No se encontró un usuario con ID " + id);
                }
            }
        }
    }
}