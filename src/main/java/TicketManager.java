import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addNew(Ticket newTicket) {
        repo.save(newTicket);
    }

    public Ticket[] findAllSortByPrice(String from, String to) {
        Ticket[] result = new Ticket[0];
        TicketRepository tmp = new TicketRepository();
        for (Ticket ticket : repo.findAll()) {
            if (ticket.matches(from, to)) {
                tmp.save(ticket);
                result = tmp.findAll();
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAllSortByTravelTime(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        TicketRepository tmp = new TicketRepository();
        for (Ticket ticket : repo.findAll()) {
            if (ticket.matches(from, to)) {
                tmp.save(ticket);
                result = tmp.findAll();
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

}
