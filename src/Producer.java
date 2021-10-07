public class Producer {
    double production;
    double level;
    double price;

    public Producer(double produc, double cost) {
        production = produc;
        price = cost;
        level = 1;
    }

    public double levelupcost() {
        return price;
    }

    public double levelup() {
        price = price*1.15;
        level++;
        return production;
    }
}