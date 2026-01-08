package themepark;

// TicketRepository trashëgon InMemoryRepository me tip Ticket
public class TicketRepository extends InMemoryRepository<String, Ticket> {

    private static TicketRepository instance;

    private TicketRepository() {
        super(t -> t.getId()); // merr ID nga Ticket
    }

    public static synchronized TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }
}
