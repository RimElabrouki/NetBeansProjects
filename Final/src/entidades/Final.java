/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import ClasesDAO.CandidatoDAO;



/**
 *
 * @author Rim
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Candidato c1= new Candidato(4, 300, 2, "Windows 8");
        Candidato c2 = new Candidato(5, 1500, 4, "Linux Suse");
        Candidato c3 = new Candidato(6, 512, 8, "iOS");
        CandidatoDAO cDAO = new CandidatoDAO();
        cDAO.insertarEquipo(c1);
        cDAO.insertarEquipo(c2);
        cDAO.insertarEquipo(c3);

    }

}
