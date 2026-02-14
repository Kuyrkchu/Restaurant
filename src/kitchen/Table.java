package kitchen;

public class Table {
    public Integer number = 0;
    public boolean isOccupied = false;
     public Order currentOrder = null;

    public void Table(Integer number){
        this.number = number;
        this.isOccupied = isOccupied;
        this.currentOrder = currentOrder;

    }

    public void occupy(Order order){
        this.isOccupied = true;
        this.currentOrder = order;
    }

    public void release(){
        this.isOccupied = false;
        this.currentOrder = null;
    }

    public int getNumber(){
        return number;
    }
    public boolean isOccupied(){
        return isOccupied;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
