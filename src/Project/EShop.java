/* Name: Mark Lee
Course: CNT 4714 – Spring 2025
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 29, 2025
*/

package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class EShop extends JFrame{
    //class constants
    private static final int WINDOW_WIDTH = 900; //pixels
    private static final int WINDOW_HEIGHT = 500; //pixels
    private static final double TAX = 0.06; //tax constant
    int itemCount = 0; //temporarily here to suppress compiler errors

    //private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

    //instance variables
    //window for GUI
    private JFrame window = new JFrame("Nile.com");

    private JLabel blankLabel, controlsLabel, cartHeader, cart1, cart2, cart3, cart4, cart5;
    private JLabel inputIDHeader, inputQuantHeader, detailsHeader, subtotalHeader, detailsLabel, subtotalLabel;
    private JButton blankButton, processB, confirmB, deleteB, finishB, newB, exitB;
    private JTextField inputID, inputQuant;

    //declare reference variables for event handlers
    private ProcessButtonHandler procbHandler;
    private ConfirmButtonHandler confbHandler;
    private DeleteButtonHandler deletebHandler;
    private FinishButtonHandler finbHandler;
    private NewButtonHandler newbHandler;
    private ExitButtonHandler exitbHandler;

    //math stuff
    private CartItem curItem; //store a found item
    private CartItem[] cart; //the actual cart
    private Double curSubtotal = 0.0;
    DecimalFormat moneyFormat = new DecimalFormat("'$'0.00");
    DecimalFormat percentFormat = new DecimalFormat("###'%'");



    //Windchill():  constructor
    public EShop() {
        //instantiate math stuff
        curItem = null;
        cart = new CartItem[5];

        //configure GUI
        window.setTitle("Nile.com - Spring 2025"); //set title of the frame
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set frame size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //instantiate JLabel objects
        blankButton = new JButton(" ");
        blankLabel = new JLabel(" ", SwingConstants.RIGHT);
        controlsLabel = new JLabel(" USER CONTROLS ", SwingConstants.RIGHT);

        inputIDHeader = new JLabel("Enter ID for Item #" + (itemCount + 1) + ":", SwingConstants.RIGHT);
        inputQuantHeader = new JLabel("Enter quantity for Item #"  + (itemCount + 1) + ":", SwingConstants.RIGHT);
        detailsHeader = new JLabel("Details for Item #"  + (itemCount + 1) + ":", SwingConstants.RIGHT);
        subtotalHeader = new JLabel("Current Subtotal for 0 item(s):", SwingConstants.RIGHT);
        inputID = new JTextField();
        inputQuant = new JTextField();
        detailsLabel = new JLabel();
        subtotalLabel = new JLabel();

        cartHeader = new JLabel("Your Shopping Cart Is Currently Empty", SwingConstants.CENTER);
        cart1 = new JLabel(" ", SwingConstants.LEFT);
        cart2 = new JLabel(" ", SwingConstants.LEFT);
        cart3 = new JLabel(" ", SwingConstants.LEFT);
        cart4 = new JLabel(" ", SwingConstants.LEFT);
        cart5 = new JLabel(" ", SwingConstants.LEFT);


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
        confirmB.setEnabled(false);
        deleteB.setEnabled(false);
        finishB.setEnabled(false);
        blankButton.setBackground(Color.DARK_GRAY);
        blankButton.setVisible(false);

        //define a content pane to hold everything
        Container pane = window.getContentPane();

        //create grid layouts
        GridLayout grid6by2 = new GridLayout(6,2,8,4);
        GridLayout grid7by2 = new GridLayout(7,2,8,4);

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
        //northPanel.setFont(new java.awt.Font("Tahoma",Font.PLAIN,60));s


        inputIDHeader.setForeground(Color.YELLOW);
        inputQuantHeader.setForeground(Color.YELLOW);
        detailsHeader.setForeground(Color.RED);
        subtotalHeader.setForeground(Color.CYAN);
        inputID.setOpaque(true);
        inputQuant.setOpaque(true);
        detailsLabel.setOpaque(true);
        subtotalLabel.setOpaque(true);
        inputID.setBackground(Color.WHITE);
        inputQuant.setBackground(Color.WHITE);
        detailsLabel.setBackground(Color.WHITE);
        subtotalLabel.setBackground(Color.WHITE);


        cartHeader.setForeground(Color.RED);
        cart1.setOpaque(true);
        cart2.setOpaque(true);
        cart3.setOpaque(true);
        cart4.setOpaque(true);
        cart5.setOpaque(true);
        cart1.setBackground(Color.WHITE);
        cart2.setBackground(Color.WHITE);
        cart3.setBackground(Color.WHITE);
        cart4.setBackground(Color.WHITE);
        cart5.setBackground(Color.WHITE);

        northPanel.add(inputIDHeader);
        northPanel.add(inputID);
        northPanel.add(inputQuantHeader);
        northPanel.add(inputQuant);
        northPanel.add(detailsHeader);
        northPanel.add(detailsLabel);
        northPanel.add(subtotalHeader);
        northPanel.add(subtotalLabel);

        centerPanel.add(cartHeader);
        centerPanel.add(cart1);
        centerPanel.add(cart2);
        centerPanel.add(cart3);
        centerPanel.add(cart4);
        centerPanel.add(cart5);

        southPanel.add(controlsLabel);
        controlsLabel.setHorizontalAlignment(JLabel.CENTER);
        southPanel.add(blankButton);

        southPanel.add(processB);
        southPanel.add(confirmB);
        southPanel.add(deleteB);
        southPanel.add(finishB);
        southPanel.add(newB);
        southPanel.add(exitB);

        CenterFrame(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true); //display the frame
        //window.show();
    }

    //centers frame on screen
    public void CenterFrame(int frameWidth, int frameHeight) {
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

    //updates the cart area of the GUI
    public void updateCart() {
        if(itemCount > 0) {
            cartHeader.setText("Your Shopping Cart Currently Contains " + (itemCount) + " Item(s)");
            subtotalHeader.setText("Current Subtotal for " + (itemCount)  + " item(s)");
            subtotalLabel.setText(moneyFormat.format(curSubtotal));
            processB.setText("Search For Item #" + (itemCount + 1));
            confirmB.setText("Add Item #" + (itemCount + 1) + " To Cart");
            inputIDHeader.setText("Enter item ID for Item " + (itemCount + 1) + ":");
            inputQuantHeader.setText("Enter quantity for Item #" + (itemCount + 1) + ":");
            deleteB.setEnabled(true);
            finishB.setEnabled(true);

        }
        else {
            cartHeader.setText("Your Shopping Cart Is Currently Empty");
            subtotalHeader.setText("Current Subtotal for 0 item(s)");
            subtotalLabel.setText("");
            processB.setText("Search For Item #1");
            confirmB.setText("Add Item #1 To Cart");
            inputIDHeader.setText("Enter item ID for Item #1:");
            inputQuantHeader.setText("Enter quantity for Item #1:");
            deleteB.setEnabled(false);
            finishB.setEnabled(false);
        }

        if(cart[0] != null) {
            cart1.setText("Item 1 - SKU: " + cart[0].itemID + ", Desc: " + cart[0].desc + ", Price Ea. " + moneyFormat.format(cart[0].price) + ", Qty: " + cart[0].reqQuant + ", Total: " + moneyFormat.format(cart[0].finalPrice));
        }
        else
            cart1.setText(" ");
        if(cart[1] != null) {
            cart2.setText("Item 2 - SKU: " + cart[1].itemID + ", Desc: " + cart[1].desc + ", Price Ea. " + moneyFormat.format(cart[1].price) + ", Qty: " + cart[1].reqQuant + ", Total: " + moneyFormat.format(cart[1].finalPrice));
        }
        else
            cart2.setText(" ");
        if(cart[2] != null) {
            cart3.setText("Item 3 - SKU: " + cart[2].itemID + ", Desc: " + cart[2].desc + ", Price Ea. " + moneyFormat.format(cart[2].price) + ", Qty: " + cart[2].reqQuant + ", Total: " + moneyFormat.format(cart[2].finalPrice));
        }
        else
            cart3.setText(" ");
        if(cart[3] != null) {
            cart4.setText("Item 4 - SKU: " + cart[3].itemID + ", Desc: " + cart[3].desc + ", Price Ea. " + moneyFormat.format(cart[3].price) + ", Qty: " + cart[3].reqQuant + ", Total: " + moneyFormat.format(cart[3].finalPrice));
        }
        else
            cart4.setText(" ");
        if(cart[4] != null) {
            cart5.setText("Item 5 - SKU: " + cart[4].itemID + ", Desc: " + cart[4].desc + ", Price Ea. " + moneyFormat.format(cart[4].price) + ", Qty: " + cart[4].reqQuant + ", Total: " + moneyFormat.format(cart[4].finalPrice));
            confirmB.setEnabled(false); //prevents confirmButton from working if cart is full to avoid overflow
        }
        else
            cart5.setText(" ");
    }

    private class ProcessButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            System.out.println("The Find Item Button Was Clicked...");

            try {
                String inString1 = inputID.getText();
                String inString2 = inputQuant.getText();

                Integer searchID = Integer.parseInt(inString1);
                Integer searchQuant = Integer.parseInt(inString2);

                CartItem searchedItem = ItemFinder.SearchInventoryFile(searchID, searchQuant);

                //searched item had no issues
                if(searchedItem != null) {
                    curItem = searchedItem;

                    //update GUI
                    detailsLabel.setText(curItem.itemID +  " " + curItem.desc + " " + moneyFormat.format(curItem.price) + " " + percentFormat.format(curItem.disc * 100) + " " + moneyFormat.format(curItem.finalPrice));
                    detailsHeader.setText("Details for Item #"  + (itemCount + 1) + ":");

                    confirmB.setEnabled(true);
                }

                //if item has issue, nothing changes
                //everything is as if the search never occurred;

            } //end try
            catch(NumberFormatException numberFormatException){
                JOptionPane.showMessageDialog(null, "Error: Input must be an integer and not too large", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
            } //IO and FNF exceptions handled in ItemFinder()

        }
    }

    private class ConfirmButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The Add Item To Cart Button Was Clicked...");

            //add current item to cart and subtotal
            if(itemCount < 5) {
                cart[itemCount] = curItem;
                curSubtotal += curItem.finalPrice;
            }
            else {
                System.out.println("Somehow tried to add more items than allowed");
                return;
            } //theoretically should never trigger

            ++itemCount;

            updateCart(); //reflect changes

            //clear input fields and disable confirmation button
            confirmB.setEnabled(false);
            inputID.setText("");
            inputQuant.setText("");

            System.out.println("Item successfully added to cart");
        }
    }

    private class DeleteButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("The Delete Button Was Clicked...");

            //delete item from cart and subtotal
            if(itemCount > 0) {
                curSubtotal -= cart[itemCount - 1].finalPrice;
                cart[itemCount - 1] = null;
            }
            else{
                System.out.println("Somehow tried to delete items out of an empty cart");
                return;
            } //theoretically shouldn't trigger

            --itemCount;

            updateCart();

            System.out.print("Item successfully deleted");
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

            //wipe cart data and subtotal data
            for(int i = 0; i < 5; ++i)
                cart[i] = null;
            curSubtotal = 0.0;
            itemCount = 0;

            updateCart();

            System.out.println("The cart was emptied");
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
        EShop gui = new EShop(); // create the frame object
        //CartItem debugItem = ItemFinder.SearchInventoryFile(234887, 1);
    }
}