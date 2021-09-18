
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rim
 */
public class Sakaried_Employee extends Employe {

    double bonus;
    double deduction;

    @Override
    public double getSalary() {
        return salary + bonus - deduction;
    }

}
