package lab1;

import lab1.Passenger;

public class NonMember extends Passenger {

    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double price) {
        if (this.getAge() > 65) {
            return price * 0.9;
        } else {
            return price;
        }
    }
}
