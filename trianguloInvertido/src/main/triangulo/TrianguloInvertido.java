public class TrianguloInvertido {
    public static void main(String[] args) {
        System.out.println("Triángulo Invertido");


        // Tipos de datos primitivos
        byte edad = 25;
        short año = 2024;
        int poblacion = 8000000;
        long distancia = 384400000L; // Distancia a la luna en metros
        float precio = 99.99f;
        double pi = 3.1415926535;
        char inicial = 'J';
        boolean esJavaDivertido = true;
        
        // Tipos de referencia
        String mensaje = "¡Hola, Java!";
        int[] numeros = {1, 2, 3, 4, 5};
        java.util.ArrayList<String> lista = new java.util.ArrayList<>();
        lista.add("Uno");
        lista.add("Dos");
        
        // Imprimir valores
        System.out.println("Edad: " + edad);
        System.out.println("Año: " + año);
        System.out.println("Población: " + poblacion);
        System.out.println("Distancia a la luna: " + distancia + " metros");
        System.out.println("Precio: " + precio);
        System.out.println("Valor de Pi: " + pi);
        System.out.println("Inicial: " + inicial);
        System.out.println("¿Es Java divertido? " + esJavaDivertido);
        System.out.println("Mensaje: " + mensaje);
        System.out.print("Array: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println("\nLista: " + lista);
        System.out.println();
        System.out.println();

        // 1. Variables y Operadores
        int n = 5;
        System.out.println("Ejercicio 1: Variables y Operadores");
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // 2. If/Else
        System.out.println("\nEjercicio 2: If/Else");
        for (int i = n; i > 0; i--) {
            if (i % 2 == 0) {
                System.out.println("Fila par: " + i);
            } else {
                System.out.println("Fila impar: " + i);
            }
        }
        
        // 3. Concatenación
        System.out.println("\nEjercicio 3: Concatenación");
        String resultado = "";
        for (int i = n; i > 0; i--) {
            resultado += "*".repeat(i) + "\n";
        }
        System.out.println(resultado);
        
        // 4. Arrays
        System.out.println("\nEjercicio 4: Arrays");
        String[] triangulo = new String[n];
        for (int i = n; i > 0; i--) {
            triangulo[n - i] = "*".repeat(i);
        }
        for (String fila : triangulo) {
            System.out.println(fila);
        }
        
        // 5. Matrices
        System.out.println("\nEjercicio 5: Matrices");
        char[][] matriz = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                matriz[i][j] = '*';
            }
        }
        for (char[] fila : matriz) {
            for (char c : fila) {
                System.out.print(c == '*' ? c : ' ');
            }
            System.out.println();
        }
        
        // 6. HashMap
        System.out.println("\nEjercicio 6: HashMap");
        java.util.HashMap<Integer, String> mapa = new java.util.HashMap<>();
        for (int i = n; i > 0; i--) {
            mapa.put(i, "*".repeat(i));
        }
        for (int key : mapa.keySet()) {
            System.out.println("Fila " + key + ": " + mapa.get(key));
        }
        
        // 7. Funciones
        System.out.println("\nEjercicio 7: Funciones");
        imprimirTriangulo(n);
    }
    
    public static void imprimirTriangulo(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println("*".repeat(i));
        }
    }
}

// javac TrianguloInvertido.java
// java TrianguloInvertido
// choco install watchexec
// watchexec -e java -- powershell -Command "javac TrianguloInvertido.java; java TrianguloInvertido"
