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

    //instance variables
    //window for GUI

    private JFrame window = new JFrame("Nile.com");
    /*
    private JPanel base;
    private JPanel entry;
    private JPanel cart;
    private JPanel controls;
    */

    //Windchill():  constructor
    public EShop() {

        //configure GUI
        window.setTitle("Nile.com - Spring 2025"); //set title of the frame
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set frame size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //register event listener

        //define a content pane to hold everything
        Container pane = window.getContentPane();

        //create grid layouts
        GridLayout grid6by2 = new GridLayout(6,2,8,4);
        GridLayout grid7by2 = new GridLayout(7,2,8,4);

        //GridLayout grid5by2 = new GridLayout(5,2,8,6); //buttons
        //GridLayout grid6by2X = new GridLayout(6,2,2,2); //cart

        //create panels
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        //set layouts for panels
        northPanel.setLayout(grid6by2);
        centerPanel.setLayout(grid7by2);
        southPanel.setLayout(grid6by2);

        //add panels to content pane using BorderLayout
        pane.add(northPanel, BorderLayout.NORTH);
        pane.add(centerPanel, BorderLayout.CENTER);
        pane.add(southPanel, BorderLayout.SOUTH);

        //style panes
        pane.setBackground(Color.DARK_GRAY);
        northPanel.setBackground(Color.darkGray);
        //northPanel.setForeground(Color.yellow); //text color

        centerPanel.setBackground(Color.LIGHT_GRAY);
        southPanel.setBackground(Color.blue);
        //Font font = new Font("Tahoma", Font.PLAIN, 30);
        //northPanel.setFont(new java.awt.Font("Tahoma",Font.PLAIN,60));

        //centerFrame(WIDTH, HEIGHT);

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