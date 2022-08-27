import java.util.Arrays;

public class TicketManager {
protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addNew(Ticket newTicket)
    {
        repo.save(newTicket);
    }

public Ticket[] findAllManager(String from, String to) {
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
}
