package kitchen;
import java.util.ArrayList;

public class Order {
    public Integer number_table;
    public ArrayList<String> dishes;
    public double result;
    public Status status;

    public Order(Integer number_table, ArrayList<String> dishes, double result, Status status) {
        this.number_table = number_table;
        this.dishes = dishes;
        this.result = result;
        this.status = status;
    }

    public void getOrder() {
        System.out.println("Номер столика: " + this.number_table);
        System.out.println("Блюда: " + this.dishes);
        System.out.println("Сумма: " + result);
        System.out.println("Статус: " + this.status);
    }
}