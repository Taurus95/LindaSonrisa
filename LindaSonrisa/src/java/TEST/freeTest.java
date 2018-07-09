/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.Calendar;

/**
 *
 * @author andres
 */
public class freeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("fecha actual: " + date.toString());
        
        java.sql.Date prueba = new java.sql.Date(0);
    }

}
