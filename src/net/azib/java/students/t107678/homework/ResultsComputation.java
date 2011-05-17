package net.azib.java.students.t107678.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultsComputation {

    ArrayList<Record> records;

    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader inputDataReader = new BufferedReader(inputStreamReader);

    public ResultsComputation() {
        records = new ArrayList<Record>();
    }

    public void readRecords(CSVReader reader) throws RecordFormatException, IOException {

        Record record;
        while ((record = reader.getNext()) != null) {
            records.add(record);
        }

    }

    public void readRecords(ConsoleReader reader) throws RecordFormatException, IOException {
        String answer = "";
        Record record;
        do {
            if ((record = reader.getNext()) != null) {
                records.add(record);
            }
            System.out.println("Do You want to enter new Record [Y/N]?");
            answer = inputDataReader.readLine();
        } while (answer.trim().toUpperCase().compareTo("N") != 0);


    }

    public void readRecords(DataBaseReader reader) throws RecordFormatException, IOException, SQLException {
        Record record;
        while ((record = reader.getNext()) != null) {
            records.add(record);
        }



    }

    public void computeRecordsResults() {   //bubble sort

        Record tempRecord;
        Record iRecord;
        Record jRecord;
        for (int i = 0; i < (records.size() - 1); i++) {
            iRecord = records.get(i);
            for (int j = i + 1; j < records.size(); j++) {
                jRecord = records.get(j);
                if (iRecord.getTotalPoints() < jRecord.getTotalPoints()) {
                    tempRecord = jRecord;
                    jRecord = iRecord;
                    iRecord = tempRecord;
                    records.set(i, iRecord);
                    records.set(j, jRecord);
                }
            }
        }

    }

    public ArrayList<Record> getRecords() {
        return this.records;
    }
}