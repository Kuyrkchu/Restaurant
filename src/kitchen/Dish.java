package kitchen;
class Food { public String name; public double price; }
public class Dish extends Food {
    String name="Мамалыга";
    double price=322.0;
    String category="Каши";


    public void Option(String name,double price,String category){
        this.name = name;
        this.price = price;
        this.category = category;

    }

        public void getDish(){
        System.out.println("Название:"+name);
        System.out.println("Цена:"+price);
        System.out.println("Категория:"+category);
    }
}
