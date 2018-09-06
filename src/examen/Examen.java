/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */
public class Examen {
    static int tamanoMatriz;
    static int menu;
    static int matriz[][];
    static int arr1[];
    static int arr2[];
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tamanoMatriz = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la matriz (Cuadrada):"));
        if(tamanoMatriz>0){
            crearMatriz(tamanoMatriz);   
        }else{
            JOptionPane.showMessageDialog(null, "La matriz debe contener enteros mayores a cero");
        }
    }
    
    static void crearMatriz(int tamano){
        int num;
        matriz = new int[tamano][tamano];
        for (int x=0; x < tamano; x++) {
            for (int y=0; y < tamano; y++) {
                num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor en ("+x+","+y+"):"));
                matriz[x][y]=num;
                //System.out.println (matriz[x][y]);
            }
        }
        menu();
    }
    
    static void menu(){
        menu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué desea hacer?\n\n"
                + "1. Imprimir la matriz\n"
                + "2. Mostrar la suma de las diagonales\n"
                + "3. Mostrar la multiplicación de los impares\n"
                + "4. Mostrar pilas con numeros aleatorio\n"
                + "5. Ver pilas ordenadas\n"
                + "6. Comparar datos de la pila y matriz\n"
                + "7. Salir\n\n "));
        switch(menu){
            case 1:
                for (int x=0; x < matriz.length; x++) {
                    System.out.print("|");
                    for (int y=0; y < matriz[x].length; y++) {
                    System.out.print (matriz[x][y]);
                        if (y!=matriz[x].length-1) System.out.print("\t");
                    }
                    System.out.println("|");
                }menu();
                break;
            case 2:
                int sumaDiagonal1 = 0;
                int sumaDiagonal2 = 0;
                double promedio1;
                double promedio2;
                for(int i=0; i<tamanoMatriz; i++){
                    sumaDiagonal1 = sumaDiagonal1 + matriz[i][i];
                    sumaDiagonal2 = sumaDiagonal2 + matriz[i][(tamanoMatriz-1)-i];
                }
                promedio1 = sumaDiagonal1/tamanoMatriz;
                promedio2 = sumaDiagonal2/tamanoMatriz;
                System.out.println("La suma de la diagonal principal es: "+sumaDiagonal1+", su promedio: "+promedio1);
                System.out.println("La suma de la diagonal secundaria es: "+sumaDiagonal2+", su promedio: "+promedio2);
                menu();
                break;
            case 3:
                int impar = 1;
                for (int x=0; x < matriz.length; x++) {
                    for (int y=0; y < matriz[x].length; y++) {
                        if(matriz[x][y]%2!=0){
                            impar = impar * matriz[x][y];
                        }
                    }
                }
                System.out.println("La multiplicación de los números impares es: "+impar);
                menu();
                break;
            case 4:
                Pila();
                break;
            case 5:
                burbujaAsc(arr1, 1);
                burbujaAsc2(arr2, 2);
                break;
            case 6:
                break;
            default:
                break;
        }
    }
    static void Pila(){
        int num1;
        int num2;
                arr1=new int[tamanoMatriz];
                arr2=new int[tamanoMatriz];
        pilaList pila1 = new pilaList();
        pilaList pila2 = new pilaList();
        for(int i=0; i<tamanoMatriz; i++){
            
            num1 = (int)(Math.random()*199)+1;
            num2 = (int)(Math.random()*199)+1;
            pila1.agregarPila(num1);
            pila2.agregarPila(num2);
            arr1[i]=num1;
            arr2[i]=num2;
        }
        System.out.println("Pila 1:");
        for(int a=0; a<tamanoMatriz; a++){ 
            float quitarPila = pila1.quitarPila();
            System.out.print(""+quitarPila + " | ");
        }
        System.out.println("\nPila 2:");
        for(int a=0; a<tamanoMatriz; a++){ 
            float quitarPila = pila2.quitarPila();
            System.out.print(""+quitarPila + " | ");
        }
        menu();
    }
    
    static void burbujaAsc(int arreglo[], int pila) {
        for(int i=0; i<arreglo.length-1; i++){
            for(int j=0; j<arreglo.length-1; j++){
                if (arreglo[j] > arreglo[j+1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        System.out.println("\nPila"+pila+" ordenada ascendente:");
        for(int i=0; i<arreglo.length; i++){
            System.out.print(arreglo[i]+" | ");
        }
       
    }
        static void burbujaAsc2(int arreglo[], int pila) {
        for(int i=0; i<arreglo.length-1; i++){
            for(int j=0; j<arreglo.length-1; j++){
                if (arreglo[j] > arreglo[j+1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        System.out.println("\nPila"+pila+" ordenada ascendente:");
        for(int i=0; i<arreglo.length; i++){
            System.out.print(arreglo[i]+" | ");
        }
        menu();
    }
}
