import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class CookieFrame extends JFrame implements ActionListener {

    JButton cookie;
    JButton cur,gra,far,min,fac,ban,tem,wiz,shi,alc,por,tim,ant,pri,cha,fra,jav,idl;
    Producer cursor, grandma, farm, mine, factory, bank, temple, wizardTower, shipment, alchemyLab, portal, timeMachine, antimatterCondenser, prism, chancemaker, fractalEngine, javascriptConsole, idleverse;
    double totalcookies, production, click, displaycookies;
    int transfer;
    JLabel cookiecount, CPS;
    int power;
    Timer timer;
    String thousands;

    CookieFrame() {
        totalcookies = 10000;
        production = 10000;
        click = 1;
        power = 0;
        transfer = 0;
        displaycookies = 0;

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
        this.setLayout(null);
        this.setSize(1920,1080); //sets the x and y dimensions of the frame
        this.setVisible(true); //makes the frame visible

        ImageIcon icon = new ImageIcon("src/Images/cookieclicker.png"); //create new imageicon
        this.setIconImage(icon.getImage()); //change icon image of frame
        this.getContentPane().setBackground(new Color(255,255,255)); //change color of background EDIT IT LATER ON

        //Make cookie panel
        JPanel cookiepanel = new JPanel();
        cookiepanel.setBounds(100,400,600,1080);
        cookiepanel.setBackground(Color.white);

        //Make panel for cookiecount
        JPanel counter = new JPanel();
        counter.setBounds(100,100,600,100);
        counter.setBackground(Color.white);
        counter.setLayout(new GridLayout(2,1));

        //Make cookie counter
        cookiecount = new JLabel("Cookies: 0", SwingConstants.CENTER);
        cookiecount.setFont(new Font("Roboto", Font.BOLD, 36));
        counter.add(cookiecount);
        CPS = new JLabel("per second: 0", SwingConstants.CENTER);
        counter.add(CPS);

        //Make clickable cookie
        cookie = new JButton();
        cookie.setFocusPainted(false);
        cookie.setBorder(null);
        cookie.setBackground(Color.white);
        cookie.setIcon(new ImageIcon("src/Images/clickcookie.png"));
        cookiepanel.add(cookie);
        cookie.addActionListener(this);

        //Buttons for upgrades
        cur = new JButton();
        cur.setBounds(1620,0,300,50);
        cur.setText("Cursor: " + cursor.display());
        this.add(cur);
        cur.addActionListener(this);
        
        gra = new JButton();
        gra.setBounds(1620,50,300,50);
        gra.setText("Grandma: " + grandma.display());
        this.add(gra);
        gra.addActionListener(this);
        
        far = new JButton();
        far.setBounds(1620,100,300,50);
        far.setText("Farm: " + farm.display());
        this.add(far);
        far.addActionListener(this);
        
        min = new JButton();
        min.setBounds(1620,150,300,50);
        min.setText("Mine: " + mine.display());
        this.add(min);
        min.addActionListener(this);

        fac = new JButton();
        fac.setBounds(1620,200,300,50);
        fac.setText("Factory: " + factory.display());
        this.add(fac);
        fac.addActionListener(this);

        ban = new JButton();
        ban.setBounds(1620,250,300,50);
        ban.setText("Bank: " + bank.display());
        this.add(ban);
        ban.addActionListener(this);

        tem = new JButton();
        tem.setBounds(1620,300,300,50);
        tem.setText("Temple: " + temple.display());
        this.add(tem);
        tem.addActionListener(this);

        wiz = new JButton();
        wiz.setBounds(1620,350,300,50);
        wiz.setText("Wizard Tower: " + wizardTower.display());
        this.add(wiz);
        wiz.addActionListener(this);

        shi = new JButton();
        shi.setBounds(1620,400,300,50);
        shi.setText("Shipment: " + shipment.display());
        this.add(shi);
        shi.addActionListener(this);

        alc = new JButton();
        alc.setBounds(1620,450,300,50);
        alc.setText("Alchemy Lab: " + alchemyLab.display());
        this.add(alc);
        alc.addActionListener(this);

        //Add everything to the frame
        this.add(cookiepanel);
        this.add(counter);
        this.revalidate();
        setTimer();
        timer.start();
    }

    public static double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    totalcookies += production;
                    displaycookies = round(totalcookies/Math.pow(1000,transfer));
                    if (displaycookies > 100000) {
                        displaycookies = displaycookies/1000;
                        transfer++;
                    }
                    else if (displaycookies < 1) {
                        displaycookies = displaycookies * 1000;
                        transfer--;
                    }
                    cookiecount.setText("Cookies: " + displaycookies + " " + bignum(transfer));
            }
        });
    }

    public String bignum(int x) {
        if (x == 0) {
            return "";
        }
        if (x == 1) {
            return "thousand";
        }
        if (x == 2) {
            return "million";
        }
        if (x == 3) {
            return "billion";
        }
        if (x == 4) {
            return "trillion";
        }
        if (x == 5) {
            return "quadrillion";
        }
        if (x == 6) {
            return "quintillion";
        }
        if (x == 7) {
            return "sextillion";
        }
        if (x == 8) {
            return "septillion";
        }
        if (x == 9) {
            return "octillion";
        }
        if (x == 10) {
            return "nonillion";
        }
        if (x == 11) {
            return "decillion";
        }
        if (x == 12) {
            return "undecillion";
        }
        if (x == 13) {
            return "duodecillion";
        }
        if (x == 14) {
            return "tresdecllion";
        }
        if (x == 15) {
            return "quattuordecillion";
        }
        if (x == 16) {
            return "quindecillion";
        }
        if (x == 17) {
            return "sexdecillion";
        }
        if (x == 18) {
            return "septendecillion";
        }
        if (x == 19) {
            return "octodecillion";
        }
        if (x == 20) {
            return "novemdecillion";
        }
        if (x == 21) {
            return "vigintillion";
        }
        return "error";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cookie) {
            totalcookies += click;
            displaycookies = totalcookies/Math.pow(1000,transfer);
        }
        else if (e.getSource() == cur) {
            if (totalcookies >= cursor.levelupcost()) {
                totalcookies -= cursor.levelupcost();
                production += cursor.levelup();
                CPS.setText("per second: " + round(production));
                cur.setText("Cursor! Level up cost: " + cursor.display());
            }
        }
        else if (e.getSource() == gra) {
            if (totalcookies >= grandma.levelupcost()) {
                totalcookies -= grandma.levelupcost();
                production += grandma.levelup();
                CPS.setText("per second: " + round(production));
                gra.setText("Grandma! Level up cost: " + grandma.display());
            }
        }
        else if (e.getSource() == far) {
            if (totalcookies >= farm.levelupcost()) {
                totalcookies -= farm.levelupcost();
                production += farm.levelup();
                CPS.setText("per second: " + round(production));
                far.setText("Farm! Level up cost: " + farm.display());
            }
        }
        else if (e.getSource() == min) {
            if (totalcookies >= mine.levelupcost()) {
                totalcookies -= mine.levelupcost();
                production += mine.levelup();
                CPS.setText("per second: " + round(production));
                min.setText("Mine! Level up cost: " + mine.display());
            }
        }
        displaycookies = round(totalcookies/Math.pow(1000,transfer));
        cookiecount.setText("Cookies: " + displaycookies + " " + bignum(transfer));
    }
}
