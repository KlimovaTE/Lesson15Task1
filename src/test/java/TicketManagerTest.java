import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket item1 = new Ticket(1, 5000, "SVO", "LED", 90);
    Ticket item2 = new Ticket(2, 25000, "MUC", "SVO", 180);
    Ticket item3 = new Ticket(3, 15000, "LED", "KZN", 120);
    Ticket item4 = new Ticket(4, 8000, "KUF", "SVO", 95);
    Ticket item5 = new Ticket(5, 15000, "MUC", "KZN", 95);
    Ticket item6 = new Ticket(6, 14000, "LED", "KZN", 110);
    Ticket item7= new Ticket(7, 11000, "LED", "KZN", 111);
    Ticket item8= new Ticket(8, 10500, "LED", "KZN", 90);
    Ticket item9= new Ticket(9, 12500, "LED", "KZN", 130);
    Ticket item10 = new Ticket(10, 15000, "LED", "KZN", 120);

    @BeforeEach
    public void Setup() {
        manager.addNew(item1);
        manager.addNew(item2);
        manager.addNew(item3);
        manager.addNew(item4);
        manager.addNew(item5);
        manager.addNew(item6);
        manager.addNew(item7);
        manager.addNew(item8);
        manager.addNew(item9);
        manager.addNew(item10);
    }

@Test
public void testFindAllSortByPrice1() {

    Ticket[] expected = {item8,item7,item9, item6, item3,item10};
    Ticket[] actual = manager.findAllSortByPrice("LED", "KZN");

    Assertions.assertArrayEquals(expected, actual);
}
    @Test
    public void testFindAllSortByPrice2() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAllSortByPrice("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllSortByTravelTime1() {

        TicketByPriceAscComparator travelTimeComparator = new TicketByPriceAscComparator();
        Ticket[] expected = {};
        Ticket[] actual = manager.findAllSortByTravelTime("SVO", "KZN", travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllSortByTravelTime2() {

        TicketByPriceAscComparator travelTimeComparator = new TicketByPriceAscComparator();
        Ticket[] expected = {item8, item6, item7, item3, item10, item9};
        Ticket[] actual = manager.findAllSortByTravelTime("LED", "KZN", travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
