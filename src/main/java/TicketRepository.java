import java.util.Arrays;
public class TicketRepository {
    protected Ticket[] items = new Ticket[0];

    public TicketRepository(Ticket[] items) {
        this.items = items;
    }

    public TicketRepository() {
    }

    public Ticket[] findAll() {
        return items;
    }

    public void save(Ticket newTicket) {
        Ticket[] tmp = new Ticket[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = newTicket;
        items = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[items.length - 1];
        int copyToIndex = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }
}
