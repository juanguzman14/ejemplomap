/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author juan_c.guzman_s
 */
public class FileXML {
    public static boolean creararchivoXML(Map<Integer,LinkedList<Cliente>> m ){
        boolean t=false;
     
        try{
            Element clientes=new Element ("clientes");
            Document doc=new Document(clientes);
                   
             Iterator<Map.Entry<Integer,LinkedList<Cliente>>>it=m.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,LinkedList<Cliente>>pair=it.next();
            Element key1= new Element("Key");
            key1.setAttribute(new Attribute("id",String.valueOf(pair.getKey())));
            doc.getRootElement().addContent(key1);
            for(int i=0;i<pair.getValue().size();i++){
                Cliente obj= pair.getValue().get(i);
            Element cliente1 =new Element("cliente");
            cliente1.setAttribute(new Attribute("nombre",obj.getNombre()));
            cliente1.setAttribute(new Attribute("id",obj.getIdcliente()));
            cliente1.setAttribute(new Attribute("Empresa",obj.getEmpresa()));
             doc.getRootElement().addContent(cliente1);}
        }
        XMLOutputter xmloutput =new XMLOutputter();
        
        xmloutput.setFormat(Format.getPrettyFormat());
        xmloutput.output(doc, new FileWriter("FileClientes.xml"));
         t=true;
        }catch(IOException ice){
           
        }
        
        return t;
    }
    
    
    
            
    
}
