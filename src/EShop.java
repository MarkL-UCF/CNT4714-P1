/* Name: <your name goes here>
Course: CNT 4714 – Spring 2025
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 26, 2025
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EShop extends JFrame{
    //class constants
    private static final int WINDOW_WIDTH = 900; //pixels
    private static final int WINDOW_HEIGHT = 500; //pixels
    final int itemCount = 0; //temporarily here to suppress compiler errors

    //private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

    //instance variables
    //window for GUI
    private JFrame window = new JFrame("Nile.com");

    private JLabel blankLabel, controlsLabel;
    private JButton blankButton, processB, confirmB, deleteB, finishB, newB, exitB;

    //declare reference variables for event handlers
    private ProcessButtonHandler procbHandler;
    private ConfirmButtonHandler confbHandler;
    private DeleteButtonHandler deletebHandler;
    private FinishButtonHandler finbHandler;
    private NewButtonHandler newbHandler;
    private ExitButtonHandler exitbHandler;



    //Windchill():  constructor
    public EShop() {
        //configure GUI
        window.setTitle("Nile.com - Spring 2025"); //set title of the frame
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set frame size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //instantiate JLabel objects
        blankButton = new JButton(" ");
        blankLabel = new JLabel(" ", SwingConstants.RIGHT);
        controlsLabel = new JLabel(" USER CONTROLS ", SwingConstants.RIGHT);


        //instantiate buttons and register handlers
        processB = new JButton("Search For Item #" + (itemCount+1));
        procbHandler = new ProcessButtonHandler();
        processB.addActionListener(procbHandler);

        confirmB = new JButton("Add Item #" + (itemCount+1) + " to Cart");
        confbHandler = new ConfirmButtonHandler();
        confirmB.addActionListener(confbHandler);

        deleteB = new JButton("Delete Last Item Added To Cart");
        deletebHandler = new DeleteButtonHandler();
        deleteB.addActionListener(deletebHandler);

        finishB = new JButton("Check Out");
        finbHandler = new FinishButtonHandler();
        finishB.addActionListener(finbHandler);

        newB = new JButton("Empty Cart - Start A New Order");
        newbHandler = new NewButtonHandler();
        newB.addActionListener(newbHandler);

        exitB = new JButton("Exit (Close App)");
        exitbHandler = new ExitButtonHandler();
        exitB.addActionListener(exitbHandler);

        //initial settings for buttons, fields
        confirmB.setEnabled(true);
        deleteB.setEnabled(true);
        finishB.setEnabled(true);
        blankButton.setBackground(Color.DARK_GRAY);
        blankButton.setVisible(false);

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

        southPanel.add(controlsLabel);
        controlsLabel.setHorizontalAlignment(JLabel.CENTER);
        southPanel.add(blankButton);

        southPanel.add(processB);
        southPanel.add(confirmB);
        southPanel.add(deleteB);
        southPanel.add(finishB);
        southPanel.add(newB);
        southPanel.add(exitB);

        centerFrame(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.show();
    }
    //actionPerformed(): run button action event handler
    public void actionPerformed(ActionEvent e) {

    }

    //centers frame on screen
    public void centerFrame(int frameWidth, int frameHeight) {
        //create a toolkit object
        Toolkit aToolkit = Toolkit.getDefaultToolkit();

        //create a dimension object with user screen information
        Dimension screen = aToolkit.getScreenSize();

        //assign x, y position of upper-left corner of frame
        int xPositionOfFrame = (screen.width - frameWidth) / 2;
        int yPositionOfFrame = (screen.height - frameHeight) / 2;

        //method to center frame on user's screen
        window.setBounds(xPositionOfFrame, yPositionOfFrame, frameWidth, frameHeight);
    }



    private class ProcessButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //set class vars

            System.out.println("The Find Item Button Was Clicked...");
            /*
            try {

            }
            catch {
                //file not found
                //IO exception
                //number format exception
            } //end method
             */
        }
    }

    private class ConfirmButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The Add Item To Cart Button Was Clicked...");
        }
    }

    private class DeleteButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The View Cart Button Was Clicked...");
        }
    }

    private class FinishButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The Check Out Button Was Clicked...");

            /*
            try {

            }
            catch {

            }
             */
        }
    }

    private class NewButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The New Button Was Clicked...");
        }
    }

    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The Exit Button Was Clicked...");

            System.exit(0);
        }
    }

    //main():  application entry point
    public static void main(String[] args) {
        EShop gui = new EShop();

        /*
        JFrame aNewStore = new EShop(); //create the frame object
        aNewStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aNewStore.setVisible(true); //display the frame
         */
    }
}