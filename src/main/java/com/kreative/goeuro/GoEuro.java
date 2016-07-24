/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreative.goeuro;

import java.util.HashSet;

/**
 *
 * @author Ahmed
 */
public class GoEuro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        CsvTemplate csv = new CsvTemplate();
        csv.generate("berlin");
        /*
        for (String aCity : args) {
            if (!aCity.isEmpty() && !cities.contains(aCity)) {
                cities.add(aCity);
                csv.generate(aCity);
            }
        }
         */
        
        
    }

}
