public class TicketRepository {
    private Ticket[] repo = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] item = new Ticket[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            item[i] = repo[i];
        }
        item[item.length - 1] = ticket;
        repo = item;
    }

    public void removeById(int id) {
        Ticket[] item = new Ticket[repo.length - 1];
        int index = 0;
        for (Ticket tmp : repo) {
            if (tmp.getId() != id) {
                item[index] = tmp;
                index++;
            }
            repo = item;
        }
    }

    public Ticket findById(int id) {
        for (Ticket item : repo) {
            if (item == null || item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Ticket[] repository() {
        return repo;
    }

}
