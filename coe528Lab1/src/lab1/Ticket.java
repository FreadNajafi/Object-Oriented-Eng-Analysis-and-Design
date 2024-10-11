
package lab1;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private static int number = 0;
    private int ticketNumber;

    public Ticket(Passenger p, Flight flight, double price) {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        this.ticketNumber = ++number;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger p) {
        this.passenger = p;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
    
    public void setTicketNumber(int n){
        this.ticketNumber = n;
    }

    @Override
    public String toString() {
        return passenger.getName() + ", " + flight.toString() + ", ticket price: $" + price;
    }
}

