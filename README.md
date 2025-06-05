# Ejercicios creados con JAVA o con SPRINT vamos organizando temas poco a poco

# Temas vistos en el código mavenproject1

## 1. Estructura del proyecto  
- Proyecto en Java con NetBeans y Maven  
- Paquetes (`package`) e importaciones (`import`)  

## 2. Uso de la clase `Math` para operaciones matemáticas  
- Valor absoluto (`Math.abs`)  
- Funciones trigonométricas (`Math.sin`, `Math.cos`)  
- Raíz cuadrada (`Math.sqrt`)  

## 3. Formateo de números  
- Uso de `String.format()`  

## 4. Cálculo de media aritmética  

## 5. Generación de números aleatorios  
- Uso de la clase `Random`  

## 6. Manipulación de cadenas (`String`)  
- Longitud de una cadena (`length()`)  
- Conversión a mayúsculas y minúsculas (`toUpperCase()`, `toLowerCase()`)  
- Concatenación (`concat()`)  
- Subcadenas (`substring()`)  
- Reemplazo de caracteres y palabras (`replace()`)  
- Comparación de cadenas (`equals()`, `contains()`)  
- División de cadenas (`split()`, `join()`)  
- Eliminación de espacios extra (`trim()`)  
- Detección de cadenas vacías (`isEmpty()`, `isBlank()`)  

## 7. Expresiones regulares  
- Uso de `replaceAll()` para limpiar texto  

## 8. Condicionales (`if`, `else if`, `else`)  
- Verificación de edad  
- Verificación de números pares/impares y positivos/negativos  
- Cálculo de descuentos basado en condiciones  
- Evaluación de calificaciones  

## 9. Declaración y uso de variables  
- Tipos de datos: `String`, `int`, `float`, `double`, `char`  

## 10. Métodos en Java  
- Método `main()` como punto de entrada del programa  
- Llamado a funciones dentro del método `main()`  
- Estructura de métodos en Java (`public static void`)  




# Temas vistos en el código firstsqlite

## 1. Conexión a una base de datos SQLite  
- Uso del controlador JDBC para SQLite (`Class.forName("org.sqlite.JDBC")`)  
- Creación de una conexión con `DriverManager.getConnection()`  
- Manejo de excepciones con `ClassNotFoundException` y `SQLException`  

## 2. Creación de tablas en SQLite  
- Uso de `CREATE TABLE IF NOT EXISTS`  
- Definición de claves primarias (`PRIMARY KEY AUTOINCREMENT`)  
- Tipos de datos en SQLite (`INTEGER`, `TEXT`, `NOT NULL`)  
- Ejecución de comandos SQL con `Statement.execute()`  

## 3. Inserción de datos en SQLite  
- Uso de `INSERT INTO` para agregar registros  
- Uso de `PreparedStatement` para evitar inyecciones SQL  
- Asignación de valores con `pstmt.setString()` y `pstmt.setInt()`  
- Ejecución de consultas con `executeUpdate()`  

## 4. Consultas en SQLite  
- Seleccionar todos los registros con `SELECT * FROM usuarios`  
- Uso de `Statement` y `ResultSet` para recorrer los resultados  
- Filtrado de datos con `WHERE` y parámetros en `PreparedStatement`  
- Consulta de un usuario por ID con `SELECT * FROM usuarios WHERE id = ?`  
- Consulta de usuarios mayores de cierta edad con `SELECT * FROM usuarios WHERE edad > ?`  

## 5. Manejo de resultados en consultas  
- Iteración de resultados con `while (rs.next())`  
- Obtención de datos con `rs.getInt()`, `rs.getString()`  
- Validación de existencia de datos con `if (rs.next())`  

## 6. Manejo de excepciones en Java  
- Uso de `try-catch` para capturar errores de conexión y SQL  
- Captura de `ClassNotFoundException` para verificar el driver JDBC  
- Captura de `SQLException` para errores en la base de datos  

## 7. Uso de `try-with-resources` en Java  
- Uso de `try (Connection conn = DriverManager.getConnection(url))` para cerrar automáticamente la conexión  
- Uso de `try (Statement stmt = conn.createStatement())` para cerrar automáticamente el `Statement`  
- Uso de `try (PreparedStatement pstmt = conn.prepareStatement(sql))` para manejar consultas parametrizadas  

## 8. Organización del código en métodos  
- Creación de métodos reutilizables (`crearTabla()`, `insertarUsuario()`, `consultarTodos()`, etc.)  
- Paso de parámetros a métodos (`insertarUsuario(Connection conn, String nombre, int edad)`)  
- Uso de `private static` para encapsular lógica dentro de la clase  

## 9. Impresión de mensajes en consola  
- Uso de `System.out.println()` para mensajes informativos  
- Uso de emojis en mensajes para mejorar la claridad
- 

Crear un proyecto para mi completamente en JAVA -> darwinyusef.com
Integrar todo a DOCKER con Postgresql en digital ocean


