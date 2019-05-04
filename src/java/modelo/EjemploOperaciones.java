/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jhonny
 */
public class EjemploOperaciones {
    
    public ArrayList<Ejemplo> getEjemplo(){  
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session  session = sesion.openSession(); //abrir un metodo open
        Transaction tx = session.beginTransaction();
        //Esto cambiara lo debemos debe ir siempre para conectarse
        ArrayList<Ejemplo> arreglo = new ArrayList<Ejemplo>();
        //Se Hace un consulta a la base pero pasando por el POJO
        Query q = session.createQuery("from Ejemplo");
        List<Ejemplo> lista = q.list();//Por defecto esto retorna una lista
        //Esto es para guardar la lista en un ArrayLista
        Iterator<Ejemplo> iter = lista.iterator();
        
        //Aqui finaliza la magia
        tx.commit(); //Para que se ejecute la transacccion
        session.close();
        //Aqui termina todo solo Ahora tomamos la lista y lo pasamos a un arrayList.
        while (iter.hasNext()) {
            Ejemplo next = (Ejemplo) iter.next();
            arreglo.add(next);
            
        }
        
        return arreglo;
    }
}
