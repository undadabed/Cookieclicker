import java.math.BigDecimal;
import java.math.RoundingMode;

public class Producer {
    double production;
    double level;
    double price;
    int pow;
    double displayCost;

    public Producer(double produc, double cost) {
        production = produc;
        price = cost;
        level = 1;
        pow = 0;
        displayCost = cost;
        while (displayCost > 1000) {
            displayCost = displayCost/1000;
            pow++;
        }
    }

    public double levelupcost() {
        return price;
    }

    public double levelup() {
        price = price*1.15;
        level++;
        displayCost = price/Math.pow(1000,pow);
        if (displayCost > 1000) {
            displayCost = displayCost/1000;
            pow++;
        }
        return production;
    }

    public double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String display() {
        return "" + round(displayCost) + " " + bignum(pow);
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
}