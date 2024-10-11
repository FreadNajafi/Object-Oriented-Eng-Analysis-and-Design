package lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   @Test
   public void testConstructor() {
        Flight flight = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000);
        assertEquals(1030, flight.getFlightNumber());
        assertEquals("Toronto", flight.getOrigin());
        assertEquals("Kolkata", flight.getDestination());
        assertEquals("03/02/99 7:50 pm", flight.getDepartureTime());
        assertEquals(100, flight.getCapacity());
        assertEquals(100, flight.getNumberOfSeatsLeft());
        assertEquals(1000, flight.getOriginalPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        Flight flight = new Flight(1030, "Toronto", "Toronto", "03/02/99 7:50 pm", 100, 1000);
    }

    @Test
    public void testGettersAndSetters() {
        Flight flight = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000);
        flight.setFlightNumber(1031);
        assertEquals(1031, flight.getFlightNumber());
        flight.setOrigin("New York");
        assertEquals("New York", flight.getOrigin());
        flight.setDestination("Delhi");
        assertEquals("Delhi", flight.getDestination());
        flight.setDepartureTime("03/03/99 8:00 pm");
        assertEquals("03/03/99 8:00 pm", flight.getDepartureTime());
        flight.setCapacity(120);
        assertEquals(120, flight.getCapacity());
        flight.setNumberOfSeatsLeft(110);
        assertEquals(110, flight.getNumberOfSeatsLeft());
        flight.setOriginalPrice(1100);
        assertEquals(1100, flight.getOriginalPrice(), 0);
    }

    @Test
    public void testBookASeat() {
        Flight flight = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000);
        assertTrue(flight.bookASeat());
        assertEquals(99, flight.getNumberOfSeatsLeft());
        for (int i = 0; i < 100; i++) {
            flight.bookASeat();
        }
        assertFalse(flight.bookASeat());
    }

    @Test
    public void testToString() {
        Flight flight;
        flight = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000);
        assertEquals("Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price: 1000.0$", flight.toString());
    }
}
