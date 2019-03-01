/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.FileXML;

/**
 *
 * @author juan_c.guzman_s
 */
public class Ejemplomap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Cliente> lista=new LinkedList<>();
        LinkedList<Cliente> lista2=new LinkedList<>();
        Map<Integer,LinkedList<Cliente>> map = new HashMap<>();
       lista.add(new Cliente("David", "1130", "Uao"));
        lista.add(new Cliente("Sofia", "1131", "Tigo"));
        lista.add(new Cliente("Marcos", "1132", "Sura"));
        lista.add(new Cliente("Maria", "133", "Herbalife"));
        map.put(3, lista);
        
        lista2.add(new Cliente("Orlando", "1136", "Campo"));
        lista2.add(new Cliente("Antonio", "1137", "Casa"));
        lista2.add(new Cliente("Alejandro", "1138", "Emcali"));
        lista2.add(new Cliente("Carlos", "139", "Jave"));
        map.put(36, lista2);
        
         Map<Integer,Cliente> map2 = new LinkedHashMap<>();
          Map<Integer,Cliente> map3 = new TreeMap<>();
          
         /* map.put(55, new Cliente("David", "1130", "Uao"));
          map.put(4, new Cliente("Sofia", "1131", "Tigo"));
          map.put(5, new Cliente("Marcos", "1132", "Sura"));
          map.put(78, new Cliente("Maria", "133", "Herbalife"));
         */
map2.put(55, new Cliente("David", "1130", "Uao"));
          map2.put(4, new Cliente("Sofia", "1131", "Tigo"));
          map2.put(5, new Cliente("Marcos", "1132", "Sura"));
          map2.put(78, new Cliente("Maria", "133", "Herbalife"));
          map3.put(55, new Cliente("David", "1130", "Uao"));
          map3.put(4, new Cliente("Sofia", "1131", "Tigo"));
          map3.put(5, new Cliente("Marcos", "1132", "Sura"));
          map3.put(78, new Cliente("Maria", "133", "Herbalife"));
String m1=mostrarDatosMap(map);
//String m2=mostrarDatosMap(map2);
//String m3=mostrarDatosMap(map3);
        System.out.println(m1);
      //  System.out.println("_______________");
     //   System.out.println(m2);
       // System.out.println("_______________");
      //  System.out.println(m3);
      
      
      boolean t=FileXML.creararchivoXML(map);
    if(t){
        JOptionPane.showMessageDialog(null, "Archivo creado");
    }
    else{
        JOptionPane.showMessageDialog(null, "Archivo no creado");
    }
    }
    public static String mostrarDatosMap(Map<Integer, LinkedList<Cliente>>m){
        String mostrar="";
        Iterator<Map.Entry<Integer,LinkedList<Cliente>>>it=m.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,LinkedList<Cliente>>pair=it.next();
            mostrar+=pair.getKey()+"\n";
            for(int i=0;i<pair.getValue().size();i++){
                mostrar+=pair.getValue().get(i)+"\n";
            }
            
        }
    return mostrar;
    }
    
}
