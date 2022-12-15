import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TicketManager {
    private TicketRepository repos;

    public TicketManager(TicketRepository repos) {
        this.repos = repos;
    }
//    TicketByPriceAsComparator service = new TicketByPriceAsComparator();

    public ArrayList<Ticket> findAll(String from, String to, Comparator<Ticket>comparator) {
        Arrays.sort(repos.repository(), comparator);

        ArrayList<Ticket> list = new ArrayList<>();
        for (Ticket items : repos.repository()) {
            if (items.getAirportOut() == from & items.getAirportIn() == to) {
                list.add(items);
            }
        }
        return list;

    }

    public void removeManager(int id){
        repos.removeById(id);
    }

    public void add(Ticket ticket) {
        repos.save(ticket);
    }

}
