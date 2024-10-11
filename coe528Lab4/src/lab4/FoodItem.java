
package lab4;

public class FoodItem extends FoodComponent {
    private double price;
    
    public FoodItem(String name, double price) {
        super(name);
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void print(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append("FoodItem: ").append(getName()).append(", ").append(getPrice());
        System.out.println(sb.toString());
    }
}