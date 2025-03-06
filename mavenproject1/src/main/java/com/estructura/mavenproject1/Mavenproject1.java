/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.estructura.mavenproject1;
import java.util.Random;
/**
 *
 * @author aquicreamos
 */
public class Mavenproject1 {

     public static void calcularValorAbsoluto() {
        int numero = -10;
        int valorAbsoluto = Math.abs(numero);
        System.out.println("El valor absoluto de " + numero + " es: " + valorAbsoluto);
    }

    public static void calcularTrigonometria() {
        double anguloGrados = 30.0;
        double anguloRadianes = anguloGrados * Math.PI / 180.0;
        double seno = Math.sin(anguloRadianes);
        double coseno = Math.cos(anguloRadianes);
        System.out.println("El seno de " + anguloGrados + " grados es: " + seno);
        System.out.println("El coseno de " + anguloGrados + " grados es: " + coseno);
    }

    public static void formatearNumero() {
        double numero = 3.14159265359;
        String numeroFormateado = String.format("%.2f", numero);
        System.out.println(numeroFormateado);
    }

    public static void calcularRaizCuadrada() {
        double numero = 25.0;
        double raizCuadrada = Math.sqrt(numero);
        System.out.println("La raíz cuadrada de " + numero + " es: " + raizCuadrada);
    }

    public static void calcularMedia() {
        double[] numeros = {1.0, 2.0, 3.0, 4.0, 5.0};
        double suma = 0.0;
        for (double num : numeros) {
            suma += num;
        }
        double media = suma / numeros.length;
        System.out.println("La media es: " + media);
    }

    public static void generarNumerosAleatorios() {
        Random random = new Random();
        int numeroAleatorioEntero = random.nextInt(10);
        System.out.println("Número aleatorio entero: " + numeroAleatorioEntero);

        int numeroAleatorioRango = random.nextInt(10) + 5;
        System.out.println("Número aleatorio en rango: " + numeroAleatorioRango);

        double numeroAleatorioDecimal = random.nextDouble();
        System.out.println("Número aleatorio decimal: " + numeroAleatorioDecimal);

        boolean booleanoAleatorio = random.nextBoolean();
        System.out.println("Booleano aleatorio: " + booleanoAleatorio);
    }

    public static void limpiarTexto() {
        String texto = "123-456-7890";
        String textoLimpio = texto.replaceAll("[^A-Za-z0-9 ]", "");
        System.out.println(textoLimpio);
    }

    public static void manipularCadenas() {
        String texto = "Kotlin es un lenguaje poderoso";
        String texto2 = "Kotlin es bueno";

        System.out.println("Longitud: " + texto.length());
        System.out.println("Mayúsculas: " + texto.toUpperCase());
        System.out.println("Minúsculas: " + texto.toLowerCase());
        System.out.println("Concatenación: " + texto.concat(" y versátil"));
        System.out.println("Subcadena: " + texto.substring(7, 9));
        System.out.println("Reemplazo de char: " + texto.replace('o', '0'));
        System.out.println("Reemplazo de palabra: " + texto2.replace("bueno", "genial"));
        System.out.println("Empieza con 'Kotlin': " + texto.startsWith("Kotlin"));
        System.out.println("Termina con 'poderoso': " + texto.endsWith("poderoso"));
        System.out.println("Índice de 'lenguaje': " + texto.indexOf("lenguaje"));
        System.out.println("Última ocurrencia de 'o': " + texto.lastIndexOf('o'));
        System.out.println("Texto sin espacios extra: " + texto.trim());
        System.out.println("División por espacios: " + String.join(",", texto.split(" ")));
        System.out.println("Texto vacío: " + texto.isEmpty());
        System.out.println("Texto en blanco: " + "   ".isBlank());
        System.out.println("Igualdad de cadenas: " + texto.equals(texto2));
        System.out.println("Contiene 'lenguaje': " + texto.contains("lenguaje"));
    }

    public static void verificarEdad() {
        int edad = 25;
        if (edad >= 18 && edad <= 65) {
            System.out.println("Eres adulto en edad laboral.");
        } else if (edad < 18) {
            System.out.println("Eres menor de edad.");
        } else {
            System.out.println("Eres un adulto mayor.");
        }
    }

    public static void verificarNumero() {
        int numero = 10;
        if (numero > 0 && numero % 2 == 0) {
            System.out.println("El número es par y positivo.");
        } else if (numero <= 0) {
            System.out.println("El número no es positivo.");
        } else {
            System.out.println("El número es impar.");
        }
    }

    public static void calcularDescuento() {
        double compra = 120.0;
        boolean esMiembro = true;
        if (compra > 100 && esMiembro) {
            System.out.println("Tienes un descuento del 20%.");
        } else if (compra > 100) {
            System.out.println("Tienes un descuento del 10%.");
        } else {
            System.out.println("No tienes descuento.");
        }
    }

    public static void evaluarCalificacion() {
        int calificacion = 85;
        if (calificacion >= 90) {
            System.out.println("Excelente");
        } else if (calificacion >= 80) {
            System.out.println("Bueno");
        } else if (calificacion >= 70) {
            System.out.println("Regular");
        } else {
            System.out.println("Necesitas mejorar");
        }
    }
    
    public static void main(String[] args) {
        String studentName = "John Doe";
        int studentID = 15;
        int studentAge = 23;
        // al flotante se debe agregar la f al final del punto flotante 1.2f = mira el punto 1😁2f 👈🏻 mira la f
        float studentFee = 75.25f;
        double studenDoble = 75.24;
        char studentGrade = 'B';

        // Print variables
        System.out.println("Student name: " + studentName);
        System.out.println("Student id: " + studentID);
        System.out.println("Student age: " + studentAge);
        System.out.println("Student float: " + studentFee);
        System.out.println("Student doble: " + studenDoble);
        System.out.println("Student grade: " + studentGrade);
        
        calcularValorAbsoluto();
        calcularTrigonometria();
        formatearNumero();
        calcularRaizCuadrada();
        calcularMedia();
        generarNumerosAleatorios();
        limpiarTexto();
        manipularCadenas();
        verificarEdad();
        verificarNumero();
        calcularDescuento();
        evaluarCalificacion();
    }
}



