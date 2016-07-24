/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreative.goeuro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ahmed
 */
public class CsvTemplate {

    APICaller api = new APICaller();
    //CSV file header
    private static final Object[] FILE_HEADER = {"_id", "name", "type", "longitude", "latitude"};

    void generate(String aCity) {
        FileWriter fileWriter = null;
        try {
            JSONObject responce = api.query(aCity);
            fileWriter = new FileWriter(aCity + ".csv");
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
            CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            try {
                csvFilePrinter.printRecord(FILE_HEADER);
                ArrayList<String> cityData = new ArrayList<>();
                for (Object key : FILE_HEADER) {
                    try {
                        if (key.equals("longitude") || key.equals("latitude")) {
                            JSONObject geoPosition = (JSONObject) responce.get("geo_position");
                            cityData.add(String.valueOf(geoPosition.get(key.toString())));
                        } else {
                            cityData.add(String.valueOf(responce.get(key.toString())));
                        }
                    } catch (JSONException e) {
                        System.err.println(e);
                    }
                }
                csvFilePrinter.printRecord(cityData);
            } catch (IOException ex) {
                Logger.getLogger(CsvTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvTemplate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(CsvTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
