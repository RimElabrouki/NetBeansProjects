/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhashset;

/**
 *
 * @author Rim
 */
public class RecintoException1 {

    public RecintoException1(String msj) {

    }

    public static boolean isValidI(int id) {
        boolean ret = true;
        if (id <= 0 || id > Integer.MAX_VALUE) {
            ret = false;
        }
        return ret;
    }

    public static boolean isValidSector(char sector) {
        return sector == 'A' || sector == 'E' || sector == 'I';
    }

    public static boolean isValidArea(double area) {
        return area > 0.0;
    }

}
