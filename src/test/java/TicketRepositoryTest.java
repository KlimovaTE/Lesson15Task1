import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket item1 = new Ticket(1, 5000, "SVO", "LED", 90);
    Ticket item2 = new Ticket(2, 25000, "MUC", "SVO", 180);
    Ticket item3 = new Ticket(3, 15000, "LED", "KZN", 100);
    Ticket item4 = new Ticket(4, 8000, "KUF", "SVO", 95);

    @Test
    public void testSave() {
        repo.save(item1);
        repo.save(item3);

        Ticket[] expected = {item1, item3};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        repo.removeById(3);

        Ticket[] expected = {item1, item2, item4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
