package net.azib.java.students.t103640.homework;

import java.io.*;
import java.util.ArrayList;


public class DataToCSVWriter {

	/**
	 * This method outputs and formats given data to given path of CVS file.
	 * @param athletes  given data to output
	 * @param outputParam  given filepath to where output the given data
	 */

    public void writeDataToCSV(ArrayList<Athlete> athletes, String outputParam) {
         ArrayList<String> athletesData = new CustomUtilities().fromAthleticToStringCSVFormat(athletes);

        BufferedWriter bufferedWriter = null;
        try{
            System.out.println("Writing the records of "+athletes.size() + " athletes to " + new File(outputParam).getAbsolutePath());
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputParam), "UTF-8"));


            for (String s : athletesData) {
               bufferedWriter.write(s);
                bufferedWriter.newLine();
               }

        } catch (FileNotFoundException e) {
            System.out.println("Cant write to file "+ outputParam);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Cant write CSV file into UTF-8 encoding");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
    e.printStackTrace();
}
            }
        }

    }
}
