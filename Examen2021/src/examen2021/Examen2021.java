/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import Clases_DAO.EquipoDAO;

/**
 *
 * @author Rim
 */
public class Examen2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Equipo e1 = new Equipo(4, 300, 2, "Windows 8");
        Equipo e2 = new Equipo(5, 1500, 4, "Linux Suse");
        Equipo e3 = new Equipo(6, 512, 8, "iOS");
        EquipoDAO eDAO = new EquipoDAO();
        eDAO.insertarEquipo(e1);
        eDAO.insertarEquipo(e2);
        eDAO.insertarEquipo(e3);

    }

}
