package lab4;

import java.util.ArrayList;
import java.util.List;

public class FoodCategory extends FoodComponent {
    private List<FoodComponent> foodComponents;
    
    public FoodCategory(String name) {
        super(name);
        foodComponents = new ArrayList<>();
    }
    
    public void add(FoodComponent foodComponent) {
        foodComponents.add(foodComponent);
    }
    
    public void remove(FoodComponent foodComponent) {
        foodComponents.remove(foodComponent);
    }
    
    public double getPrice() {
        double totalPrice = 0.0;
        for (FoodComponent foodComponent : foodComponents) {
            totalPrice += foodComponent.getPrice();
        }
        return totalPrice;
    }
    
    public void print(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append("FoodCategory (").append(getName()).append(", ").append(getPrice()).append(") contains:");
        System.out.println(sb.toString());
        for (FoodComponent foodComponent : foodComponents) {
            foodComponent.print(level + 1);
        }
    }
}