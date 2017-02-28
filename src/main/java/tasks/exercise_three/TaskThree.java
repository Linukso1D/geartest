/*
 *
 * Maksym Sorokin
 *
 * Copyright © 2010 - 2016 SysGears. All rights reserved.
 *
 * This software is the confidential and proprietary information of SysGears
 *
 *
 */

package tasks.exercise_three;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import tasks.R;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxxl on 16.09.2016.
 * Class create csv file by template:
 * /==
 * "шифр","код водителя","код путевого листа","опасный","хрупкий","температура","наименование"
 * "CAZgRf820167151156145","CAZg","Rf820","false","true",,"wine"
 * /==
 *
 * @version 1.0 16 Sep 2016
 * @author Sorokin Maksym
 */

public class TaskThree {
    /** List included obj csvStructure */
    private List <CsvStructure> CsvCodes;

    public TaskThree() {
        CsvCodes = new ArrayList <CsvStructure> ();
    }
    /**
     * Adds object CsvStructure into the list CsvCodes
     * */
    public void addRecordCodes (CsvStructure once) {
        CsvCodes.add(once);
    }
    /**
     * Remove object CsvStructure from the list CsvCodes
     * */
    public void delRecordCodes (CsvStructure once) {
        CsvCodes.remove(once);
    }
    /**
     * Getter of the list CsvCodes
     * */
    public List<CsvStructure> getCsvCodes() {
        return CsvCodes;
    }

    /**
     * Factory method writeCSV it's generated a csv file with name csvTaskThree.csv
     * */
    public void writeCSV () {
        FileWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;
        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(",\n");
        try {
            //initialize FileWriter object
            fileWriter = new FileWriter("csvTaskThree.csv");
            //initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            //Create CSV file header
            csvFilePrinter.printRecord(R.CONST.CSV_FILE_HEADER);
            //Write a new csvline object list to the CSV file
            for (CsvStructure code : CsvCodes) {
                List codesDataRecord = new ArrayList<CsvStructure>();
                codesDataRecord.add(code.getCode());
                codesDataRecord.add(code.getDriverCode());
                codesDataRecord.add(code.getTravelSheetCode());
                codesDataRecord.add(code.isDangerous());
                codesDataRecord.add(code.isFragile());
                codesDataRecord.add(code.getTemperature()!=-Integer.MIN_VALUE?code.getTemperature():"");
                codesDataRecord.add(code.getName());
                csvFilePrinter.printRecord(codesDataRecord);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }
}
