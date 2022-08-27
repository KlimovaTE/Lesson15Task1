import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket item1 = new Ticket(1, 5000, "SVO", "LED", 90);
    Ticket item2 = new Ticket(2, 25000, "MUC", "SVO", 180);
    Ticket item3 = new Ticket(3, 15000, "LED", "KZN", 100);
    Ticket item4 = new Ticket(4, 8000, "KUF", "SVO", 95);
    Ticket item5 = new Ticket(5, 15000, "MUC", "KZN", 95);

    @Test
    public void testCompareTo1() {
        int actual = item2.compareTo(item3);
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareTo2() {
        int actual = item4.compareTo(item2);
        int expected = -1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareTo3() {
        int actual = item3.compareTo(item5);
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }
}
