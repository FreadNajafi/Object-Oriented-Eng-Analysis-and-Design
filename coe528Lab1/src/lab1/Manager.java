package lab1;

import java.util.*;

public class Manager {

    static ArrayList<Flight> flights = new ArrayList<Flight>();
    static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public static void createFlights() {
        Scanner inp = new Scanner(System.in);
        System.out.println("How many new flights are there? ");
        int number = inp.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("\nFlight Number: ");
            int flightNumber = inp.nextInt();
            System.out.println("\nOrigin: ");
            String origin = inp.next();
            origin = inp.nextLine().trim();
            System.out.println("\nDestination: ");
            String destination = inp.nextLine().trim();
            System.out.println("\nDeparture Time: ");
            String departureTime = inp.nextLine().trim();
            System.out.println("\nCapacity: ");
            int capacity = inp.nextInt();
            System.out.println("\nOriginal Price: ");
            double originalPrice = inp.nextDouble();
            flights.add(new Flight(flightNumber, origin, destination, departureTime, capacity, originalPrice));
        }
    }

    public static void displayAvailableFlights(String origin, String destination) {
        for (Flight f : flights) {
            if (f.getOrigin().equals(origin) && f.getDestination().equals(destination) && f.getNumberOfSeatsLeft() > 0) {
                System.out.println(f);
            }
        }
    }

    public static Flight getFlight(int flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber() == flightNumber) {
                return f;
            }
        }
        return null;
    }

    public static void bookSeat(int flightNumber, Passenger p) {
        Flight flight = getFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found");
            return;
        }
        if (flight.bookASeat() == true) {
            tickets.add(new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice())));
            System.out.println("Your ticket has been booked for " + p.applyDiscount(flight.getOriginalPrice()));
        } else {
            System.out.println("No seats available");
        }
    }

    public static void main(String[] args) {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        for (int i = 0; i < 10; i++) {
            flights.add(new Flight(i, "toronto", "kolkata", i + "2/12/98 " + i + 5 + ":35", i + 1, (i + 1) * 100));
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                passengers.add(new Member("Jeff", i + 1));
                bookSeat(i, passengers.get(i));
            } else {
                passengers.add(new NonMember("Will", i + 1));
                bookSeat(i, passengers.get(i));
            }
        }
        displayAvailableFlights("toronto", "kolkata");
        System.out.println(getFlight(0));
        System.out.println(getFlight(1));
        createFlights();

    }
}