//importando clases externas
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * @author Mariono Reyes
 * @author Javier Mombiela
 *
 * Main.java esta es la clase que
 * se encarga de controlar el programa
 * y la que interactua con el usuario.
 *
 * */

public class Main{

    public static void main(String[] args) {

        //creando instancias
        Factory<String, String> fac = new Factory<>();
        Scanner scanner = new Scanner(System.in);

        //pidiendo al usuario que implementacion quiere usar
        System.out.println("\nQue mapa desea utilizar?");
        System.out.println("[1] SplayTree");
        System.out.println("[2] HashingMap");

        //creando la variable opcion
        int opcion;

        //creando un try catch para asegurar que se ingrese una opcion correcta entre 1 y 2
        while(true){
            try{
                System.out.print("\nOpcion> ");
                opcion = scanner.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 2 || opcion < 1){
                    System.out.println("Opcion invalida, intenta de nuevo..");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scanner.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        }  

        //creando el nuevo mapa dependiendo de la eleccion del usuario
        Association<String, String> diccionario = new Association<String,String>(fac.queMapa(opcion));

        //leyendo el archivo de texto
        //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Spanish.txt"));
            String linea = "";

            // Generates the map (dictionary)
            while((linea = lector.readLine()) != null) {

                //System.out.println(linea);
                //separanado las filas por comas, espacios o simbolos
                String[] palabras = linea.split("\\s+|,|\\( |\\[|/");

                // excluyendo las palabras que no tienen definicion en el archivo
                if(palabras[0].charAt(0) != '#' && palabras.length > 1) {
                    //agregando las palabras al mapa
                    diccionario.addEntry(palabras[0], palabras[1] + " ");
                }
            }


        // If there is an error generating the dictionary
        } catch (Exception E) {
            System.err.println("El archivo de texto Spanish.txt no se ha encontrado.");
        }
        
        // leyendo el archivo de texto para poder traducirlo
        try {
            BufferedReader lector = new BufferedReader(new FileReader("texto.txt"));
            String linea;

            while((linea = lector.readLine()) != null) {
                // separando la linea por comas y espacios y simbolos
                String textoInicial[] = linea.split("\\s+|,|\\.|!|\\[|/");
                String textoTraducido = "";

                // Traduciendo cada palabra desde el diccionario
                for (String palabra : textoInicial) {
                    textoTraducido += diccionario.getSpanishWord(palabra.toLowerCase());
                }

                System.out.println(textoTraducido); // imprimir el texto ya traducido
            }
        // se hace catch por si el archivo no se lee
        } catch (Exception E) {
            System.err.println("El archivo de texto texto.txt no ha sido encontrado");
        }
    }
}