package Project;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ItemFinder {
    public static CartItem SearchInventoryFile(Integer inputID, Integer inputQuant) {
        File inputFile = new File("src/Project/inventory.csv"); //for data input
        FileReader inputFileReader = null;
        BufferedReader inputBufReader = null;
        Scanner aScanner = null;
        String inventoryLine;
        String itemIDFromFile;
        boolean found = false;

        CartItem item = null;
        Integer id = 0, quant = 0;
        Double price = 0.0;
        String desc = null;
        Boolean inStock = false;

        String searchItem = inputID.toString(); //searches for inputted ID

        try {
            //immediately try to cancel search if 0 quantity is entered
            if(inputQuant <= 0) {
                System.out.println("Search aborted");
                JOptionPane.showMessageDialog(null, "Please enter a positive, non-zero quantity", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }

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

                    //record all the details from aScanner
                    id = Integer.parseInt(searchItem);
                    System.out.println("ID = " + id);

                    desc = aScanner.next();
                    System.out.println("Description = " + desc);

                    inStock = Boolean.parseBoolean(aScanner.next());
                    System.out.println("InStock = " + inStock);

                    //catch out of stock error
                    if(inStock.equals(false)) {
                        System.out.println("Search aborted");
                        JOptionPane.showMessageDialog(null, "Sorry... that item is out of stock, please try another item", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }

                    quant = Integer.parseInt(aScanner.next());
                    System.out.println("Quantity = " + quant);

                    //catch too large quantity error
                    if(inputQuant > quant) {
                        System.out.println("Search aborted");
                        JOptionPane.showMessageDialog(null, "Sorry... only " + quant + " of that item is in stock and you requested " + inputQuant, "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }

                    price = Double.parseDouble(aScanner.next());
                    System.out.println("Price = " + price);

                    break;
                }
                else{
                    inventoryLine = inputBufReader.readLine(); //read in next line from file
                }
            }
            if (!found) {
                System.out.println("Search Item Not In File!");
                JOptionPane.showMessageDialog(null, "item ID " + inputID + " not in file", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else {
                //create the item
                System.out.println("Item successfully created and returned");
                return new CartItem(id, quant, inputQuant, price, desc);
            }

        }
        catch(FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, "Error: File not found", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error: Problem reading from file", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(null, "Error: Inventory file has incorrect formatting", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
