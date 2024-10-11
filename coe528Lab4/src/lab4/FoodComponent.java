package lab4;

public abstract class FoodComponent {
    private String name;
    
    public FoodComponent(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract double getPrice();
    
    public abstract void print(int level);
}
