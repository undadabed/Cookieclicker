import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class App {
    public static void main(String[] args) throws Exception {
        int totalcookies = 0;
        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("Cookieclicker"); //sets the title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the application when the frame is closed
        frame.setSize(1280,720); //sets the x and y dimensions of the frame
        frame.setVisible(true); //makes the frame visible

        ImageIcon image = new ImageIcon("src/Images/cookieclicker.png"); //create new imageicon
        frame.setIconImage(image.getImage()); //change icon image of frame
        frame.getContentPane().setBackground(new Color(255,255,255)); //change color of background EDIT IT LATER ON
    }
}
