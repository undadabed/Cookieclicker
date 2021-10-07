import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class CookieFrame extends JFrame implements ActionListener {

    JButton cookie;
    JButton cur,gra,far,min,fac,ban,tem,wiz,shi,alc,por,tim,ant,pri,cha,fra,jav,idl;
    Producer cursor, grandma, farm, mine, factory, bank, temple, wizardTower, shipment, alchemyLab, portal, timeMachine, antimatterCondenser, prism, chancemaker, fractalEngine, javascriptConsole, idleverse;
    double totalcookies, production, click;
    JLabel cookiecount;
    double cookiedisplay;
    int power;

    CookieFrame() {
        totalcookies = 0;
        production = 0;
        click = 1;
        cookiedisplay = 0;
        power = 0;

        cursor = new Producer(0.1,15.0);
        grandma = new Producer(1.0,100.0);
        farm = new Producer(8.0,1100.0);
        mine = new Producer(47.0,12000.0);
        factory = new Producer(260.0,130000.0);
        bank = new Producer(1400.0,1400000.0);
        temple = new Producer(7800.0,20000000.0);
        wizardTower = new Producer(44000.0,330000000.0);
        shipment = new Producer(260000.0,5100000000.0);
        alchemyLab = new Producer(1600000.0,75000000000.0);
        portal = new Producer(10000000.0,1000000000000.0);
        timeMachine = new Producer(65000000.0,14000000000000.0);
        antimatterCondenser = new Producer(430000000.0,170000000000000.0);
        prism = new Producer(2900000000.0,2100000000000000.0);
        chancemaker = new Producer(21000000000.0,26000000000000000.0);
        fractalEngine = new Producer(150000000000.0,310000000000000000.0);
        javascriptConsole = new Producer(1100000000000.0,71000000000000000000.0);
        idleverse = new Producer(8300000000000.0,12000000000000000000000.0);


        this.setTitle("Cookieclicker"); //sets the title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the application when the frame is closed
        this.setSize(1280,720); //sets the x and y dimensions of the frame
        this.setVisible(true); //makes the frame visible

        ImageIcon icon = new ImageIcon("src/Images/cookieclicker.png"); //create new imageicon
        this.setIconImage(icon.getImage()); //change icon image of frame
        this.getContentPane().setBackground(new Color(255,255,255)); //change color of background EDIT IT LATER ON

        //Make cookie panel
        JPanel cookiepanel = new JPanel();
        cookiepanel.setBorder(BorderFactory.createEmptyBorder(0,0,400,720));
        cookiecount = new JLabel("Cookies: 0");
        cookiecount.setFont(new Font("Roboto", Font.BOLD, 36));
        cookiepanel.add(cookiecount);

        //Make clickable cookie
        cookie = new JButton(new ImageIcon("src/Images/clickcookie.png"));
        cookie.addActionListener(this);
        cookiepanel.add(cookie);
        this.add(cookiepanel);
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cookie) {
            totalcookies += click;
        }
        else if (e.getSource() == cur) {
            if (totalcookies >= cursor.levelupcost()) {
                totalcookies -= cursor.levelupcost();
                production += cursor.levelup();
            }
        }
        else if (e.getSource() == gra) {
            if (totalcookies >= grandma.levelupcost()) {
                totalcookies -= grandma.levelupcost();
                production += grandma.levelup();
            }
        }
        else if (e.getSource() == far) {
            if (totalcookies >= farm.levelupcost()) {
                totalcookies -= farm.levelupcost();
                production += farm.levelup();
            }
        }
        else if (e.getSource() == mine) {
            if (totalcookies >= mine.levelupcost()) {
                totalcookies -= mine.levelupcost();
                production += mine.levelup();
            }
        }
        cookiecount.setText("Cookies: " + totalcookies);
    }
}
