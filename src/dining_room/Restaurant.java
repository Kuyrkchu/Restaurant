package dining_room;
import kitchen.*;
import java.util.ArrayList;

public class Restaurant {
    public ArrayList<Dish> menu = new ArrayList<>();
    public Table[] tables = new Table[10];
    public double revenue = 0;

    public Restaurant() {
        for (int i = 0; i < 10; i++) {
            tables[i] = new Table();
            tables[i].Table(i + 1);
        }
    }

    public void addDish(String name, double price, String cat) {
        Dish d = new Dish();
        d.Option(name, price, cat);
        menu.add(d);
    }

    public void showMenu() {
        for (Dish d : menu) d.getDish();
    }

    public double calculateSum(Order o) {
        return o.result;
    }

    public void createOrder(int tableNumber, ArrayList<String> dishNames, double total) {
        Order newOrder = new Order(tableNumber, dishNames, total, Status.ПРИНЯТ);
        tables[tableNumber - 1].occupy(newOrder);
        System.out.println("Заказ для стола " + tableNumber + " создан!");
    }
}