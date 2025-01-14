/* Name: <your name goes here>
Course: CNT 4714 – Spring 2025
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 26, 2025
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EShop implements ActionListener{
    //class constants
    //values currently double that of the example
    private static final int WINDOW_WIDTH = 900; //pixels
    private static final int WINDOW_HEIGHT = 470; //pixels
    private static final int FIELD_WIDTH = 40;   //characters
    private static final int AREA_WIDTH = 80;   //characters

    //private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

    private static final String LEGEND = "  This windchill " + "calculator is intended for wind speeds greater than 4 mph.";
    //instance variables
    //window for GUI
    private JFrame window = new JFrame("Nile.com");


    //Windchill():  constructor
    public EShop() {
        //configure GUI
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //register event listener

        //add components to the container
        Container c = window.getContentPane();
        //c.setLayout(LAYOUT_STYLE);
        c.setLayout(new GridLayout(3,1)); //using GridLayout instead

        //display GUI
        window.show();
    }
    //actionPerformed(): run button action event handler
    public void actionPerformed(ActionEvent e) {

    }

    //main():  application entry point
    public static void main(String[] args) {
        EShop gui = new EShop();
    }
}