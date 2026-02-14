package kitchen;
import dining_room.Restaurant;

import java.sql.Time;
import java.util.Scanner;
import java.util.ArrayList;

public class UI {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Restaurant rest = new Restaurant();

        rest.addDish("Мамалыга", 322.0, "Каши");
        rest.addDish("Брынза", 150.0, "Закуски");
        rest.addDish("Negru de Purcari", 670, "Алкоголь");
        rest.addDish("jagermeister", 777, "Алкоголь");
        rest.addDish("Шаурма от Артыма",299, "ОТборное \uD83D\uDCA9");
        rest.addDish("Масло от Заура",7000, "Особое");

        while (true) {
            System.out.println("\nСемпай приветствую,отведай мою киску ой не то... 1. Официант | 2. Админ | 0. Выход");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Номер столика-а-а-а (1-10): ");
                int tableNum = input.nextInt();

                ArrayList<String> selectedDishes = new ArrayList<>();
                double totalSum = 0;



                System.out.println(" Меню ( -1 для завершения) ");
                for (int i = 0; i < rest.menu.size(); i++) {
                    System.out.print("[" + i + "] ");
                    rest.menu.get(i).getDish();
                }

                while (true) {
                    System.out.print("Номер блюда: ");
                    int dishIdx = input.nextInt();
                    if (dishIdx == -1) break;

                    if (dishIdx >= 0 && dishIdx < rest.menu.size()) {
                        Dish selected = rest.menu.get(dishIdx);
                        selectedDishes.add(selected.name);
                        totalSum += selected.price;
                        System.out.println("Добавлено: " + selected.name);
                    } else {
                        System.out.println("Ошибкеррррр! отведай моей...");
                    }
                }
                input.nextLine();

                if (selectedDishes.isEmpty()) {
                    System.out.println("Заказ пустооойййййй Заполни пж");
                    continue;
                }

                rest.createOrder(tableNum, selectedDishes, totalSum);
                Order myOrder = rest.tables[tableNum - 1].getCurrentOrder();

                System.out.println("Статус: " + myOrder.status + ". Жмите Enter -> ГОТОВ");
                input.nextLine();
                myOrder.status = Status.ГОТОВ;

                System.out.println("Статус: " + myOrder.status + ". Жмите Enter -> ВЫДАН");
                input.nextLine();
                myOrder.status = Status.ВЫДАН;

                rest.revenue += rest.calculateSum(myOrder);
                myOrder.getOrder();

            } else if (choice == 2) {
                System.out.println("1. Добавить блюдо | 2. Показать продажи");
                int adminMode = input.nextInt();
                input.nextLine();

                if (adminMode == 1) {
                    System.out.print("Название: ");
                    String n = input.nextLine();
                    System.out.print("Цена: ");
                    double p = input.nextDouble();
                    input.nextLine();
                    rest.addDish(n, p, "Общее");
                } else {
                    System.out.println("Выручка за день: " + rest.revenue);
                }
            } else break;
        }
        System.out.println("Сэмпай, всё готово! (=^.^=)");
    }
}