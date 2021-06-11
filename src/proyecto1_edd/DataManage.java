/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_edd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

/**
 * 
 * @author Nicolás 
 */
public class DataManage {
    
    public void readtxt(){
        File file = new File("Test Packages/almacenes.txt"); 
        try{
            boolean empty = file.createNewFile();
            if(empty){
                System.out.println("Archivo creado");
            }else{
                //lectura completa de archivo
                byte[] alltxt = Files.readAllBytes(Paths.get("Test Packages/almacenes.txt"));
                String info = new String(alltxt);
                
                //División del texto para enviar a grafo
                String[] infoorder = info.split(";");
                Lista almacenes = new Lista();
                for(int i = 0; i < infoorder.length; i++){
                    if(infoorder[i].contains("Almacen ")){
                        String[] data = infoorder[i].split(":");
                        almacenes.insertarAlmacen(data[0]); //creacion almacenes
                        String[] products = data[1].split("\n");
                        for(int n = 1; n <= (products.length-1); n++){ //creacion productos
                            String[] atr = products[n].split(",");
                            //atr por los atributos del producto (nombre, cantidad)
                            almacenes.AgregarProducto(n-1, atr[0], Integer.parseInt(atr[1]));
                            
                        }
                    }else{
                        if(infoorder[i].contains("Rutas")){
                            String[] rutas = infoorder[i+1].split("\n");
                            for(int m = 1; m <= (rutas.length-1); m++){ //creacion rutas
                                almacenes.setEdges(almacenes.getpFirst(), rutas[m]);
                            }
                        }
                    }
                }
            }
        }catch (NumberFormatException | IOException e){
            System.out.println("No funciona");
        }  
    }
}
