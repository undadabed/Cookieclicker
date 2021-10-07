import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

public class App {
    public static void main(String[] args) throws Exception {
        double totalcookies = 0;
        double production = 0;
        int power = 0;

        Producer cursor = new Producer(0.1, 0, 15);
        Producer grandma = new Producer(1, 0, 100);
        Producer farm = new Producer(8, 0, 1100);
        Producer mine = new Producer(47, 0, 12000);
        Producer factory = new Producer(260, 0, 130000);
        Producer bank = new Producer(1.4, 1, 1400);
        Producer temple = new Producer(7.8, 1, 20000);
        Producer tower = new Producer(44, 1, 330000);

        JPanel cookiepanel = new JPanel();
        cookiepanel.setBackground(Color.red);
        cookiepanel.setBounds(0,0,400,720);
        JPanel assetspanel = new JPanel();
        assetspanel.setBackground(Color.blue);
        assetspanel.setBounds(400,0,480,720);
        JPanel shoppanel = new JPanel();
        shoppanel.setBackground(Color.green);
        shoppanel.setBounds(880,0,400,720);

        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("Cookieclicker"); //sets the title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the application when the frame is closed
        frame.setSize(1280,720); //sets the x and y dimensions of the frame
        frame.setVisible(true); //makes the frame visible

        ImageIcon icon = new ImageIcon("src/Images/cookieclicker.png"); //create new imageicon
        frame.setIconImage(icon.getImage()); //change icon image of frame
        frame.getContentPane().setBackground(new Color(255,255,255)); //change color of background EDIT IT LATER ON

        frame.add(cookiepanel);
        frame.add(assetspanel);
        frame.add(shoppanel);
    }
}
