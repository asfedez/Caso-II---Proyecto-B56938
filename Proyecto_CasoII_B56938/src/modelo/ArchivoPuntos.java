/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoPuntos {
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    ArrayList<Puntaje> listaDePuntajes;
    int contador = 0;
    


    public ArchivoPuntos() {
        
    }
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("puntajes.dat"));
            
           
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo");
            
        }
    }
    
    public void escribirEnElArchivo(Puntaje puntaje)
    {
        try
        {
            archivoSalida.reset();
            archivoSalida.writeObject(puntaje);
            
           
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en archivo"+e);
        }
    }
    
    public ArrayList<Puntaje> leerEnElArchivo()
    {
        listaDePuntajes = new ArrayList <Puntaje>();
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("puntajes.dat"));
            
            while(true)
            {
                listaDePuntajes.add((Puntaje)archivoEntrada.readObject());
                contador++;
            }
        }
        catch(Exception e)
        {
            //System.out.println("Fin del archivo"+e);
        }
        return listaDePuntajes;
    }
    
    
   public int devolverContador()
   {
       return contador;
   }
   

    
}
