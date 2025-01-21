package Project;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ItemFinder {
    public static void SearchInventoryFile() {
        File inputFile = new File("src/Project/inventory.csv"); //for data input
        FileReader inputFileReader = null;
        BufferedReader inputBufReader = null;
        Scanner aScanner = null;
        String inventoryLine;
        String itemIDFromFile;
        boolean found = false;

        String searchItem = "198"; //hardcoded test ID

        try {
            inputFileReader = new FileReader(inputFile);
            inputBufReader = new BufferedReader(inputFileReader);

            System.out.println("Search Item Is: " + searchItem);

            inventoryLine = inputBufReader.readLine();

            while(inventoryLine != null) {
                aScanner = new Scanner(inventoryLine).useDelimiter("\\s*,\\s*");
                itemIDFromFile = aScanner.next();
                if(itemIDFromFile.equals(searchItem)){
                    System.out.println("FOUND IT!!!");
                    found = true;
                    break;
                }
                else{
                    inventoryLine = inputBufReader.readLine(); //read in next line from file
                }
            }
            if (!found) {
                System.out.println("Search Item Not In File!");
            }
        }
        catch(FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, "Error: File not found", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error: Problem reading from file", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String [] args) {
        SearchInventoryFile();
    }
}
