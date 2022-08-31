import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket item1 = new Ticket(1, 5000, "SVO", "LED", 90);
    Ticket item2 = new Ticket(2, 25000, "MUC", "SVO", 180);
    Ticket item3 = new Ticket(3, 15000, "LED", "KZN", 100);
    Ticket item4 = new Ticket(4, 8000, "KUF", "SVO", 95);
    Ticket item5 = new Ticket(5, 15000, "MUC", "KZN", 95);
    Ticket item6 = new Ticket(6, 14000, "LED", "KZN", 110);
    Ticket item7 = new Ticket(7, 11000, "LED", "KZN", 111);

    @BeforeEach
    public void Setup() {
        manager.addNew(item1);
        manager.addNew(item2);
        manager.addNew(item3);
        manager.addNew(item4);
        manager.addNew(item5);
        manager.addNew(item6);
        manager.addNew(item7);
    }

    @Test
    public void testFindAllManager1() {

        Ticket[] expected = {item7, item6, item3};
        Ticket[] actual = manager.findAllManager("LED", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllManager2() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAllManager("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

}
