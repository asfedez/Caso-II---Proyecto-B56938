/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Casa
 */
public class MetodosPuntaje {
    
  private ArrayList <Puntaje> listaDePuntajes;
  
  ArchivoPuntos archivoPuntos = new ArchivoPuntos();
   
    
    public MetodosPuntaje()
    {
        listaDePuntajes =new ArrayList<Puntaje>();
        crearArchivo();
    }
    public void agregarPuntaje(String informacion[])
    {
        Puntaje temporal=new Puntaje(informacion[0], Integer.parseInt(informacion[1]));
        listaDePuntajes.add(temporal);
        
    }
    
    public void escribirInformacionEnArchivos()
    {
        archivoPuntos.crearArchivo();
        for (int i = 0; i < listaDePuntajes.size(); i++) 
        {
              archivoPuntos.escribirEnElArchivo(listaDePuntajes.get(i));
        }
    }
    
   public void crearArchivo()
   {
      archivoPuntos.leerEnElArchivo();
      if(archivoPuntos.devolverContador()==0)
      {
          archivoPuntos.crearArchivo();
      }
      else
      {
          this.leerArchivo(archivoPuntos.leerEnElArchivo());
      }
   }
   
   public ArrayList<Puntaje> getInformacionArchivosPlanos()
   {
       ArrayList<Puntaje> lista = archivoPuntos.leerEnElArchivo();
       return lista;
   }
    
   
  
    
    ///****Archivos**////
    public ArrayList<Puntaje> getInformacionEnPuntajes()
    {
        return listaDePuntajes;
    }
    
    public void guardarInformacionDeArchivos(ArrayList<Puntaje> lista)
    {
        for (int i = 0; i < lista.size(); i++) {
            listaDePuntajes.add(lista.get(i));
            
        }
    }
    
   
   public void leerArchivo(ArrayList<Puntaje> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           listaDePuntajes.add(lista.get(i));
       }
   }
    
  
}
