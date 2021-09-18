/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rim
 */
// first things should to know, u cant creat object from abstract classe
public abstract class Employe {
    private String nombre;
    private double age;
    public double salary;
    private String rank;
    private String job;
// constructr por defecto
    public Employe() {
    }
     
// constructor con todos los argumentos
    public Employe(String nombre, double age, double salary, String rank, String job) {
        this.nombre = nombre;
        this.age = age;
        this.salary = salary;
        this.rank = rank;
        this.job = job;
    }
    // setters of salery

    public void setSalary(double salary) {
        this.salary = salary;
    }
    // getters of salary
   // we will convert getsalary to abstract methode

    public abstract double getSalary();
    
    
    
}
