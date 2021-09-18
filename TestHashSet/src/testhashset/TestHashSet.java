/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhashset;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Rim
 */
public class TestHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //collecion de datos ciudades
        HashSet<String> ciudades;
        //un objeto
        ciudades = new HashSet<String>();
        ciudades.add("Barcelona");
        ciudades.add("Madrid");
        ciudades.add("Marruecos");
        ciudades.add("USA");
        ciudades.add("Japon");
        //size() devuelve los enteros que tienes
        System.out.println("Numero de elementos de la coleccion " + ciudades.size());
        Iterator<String> it = ciudades.iterator();
        /*while(it.hasNext())
             System.out.println("Ciudad :"+it.next()); 
         */
        //for each
        for (String Ciudad : ciudades) {
            System.out.println("Ciudad:" + Ciudad);
        }
        /*
       el objeto de  la segunda parte para imprimir la premira item 
        */
        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Get the iterator
        // Print the first item
        System.out.println(it.next());
        //ejemplo
        
    // Create a HashSet object called numbers
    HashSet<Integer> numbers = new HashSet<Integer>();

    // Add values to the set
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    // Show which numbers between 1 and 10 are in the set
    for(int i = 1; i <= 10; i++) {
      if(numbers.contains(i)) {
        System.out.println(i + " was found in the set.");
      } else {
        System.out.println(i + " was not found in the set.");
      

    }
}
    }
}
