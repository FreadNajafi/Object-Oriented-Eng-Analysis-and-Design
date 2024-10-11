package lab1;

import lab1.Passenger;

public class Member extends Passenger {
    private int yearsOfMembership;
    public Member (String n, int a) {
        super (n, a);
    }
    @Override
    public double applyDiscount (double p) {
        if (yearsOfMembership > 5)
            return p * 0.5;
        else if (yearsOfMembership > 1 && yearsOfMembership <= 5)
            return p * 0.9;
        else
            return p;
    }
}
