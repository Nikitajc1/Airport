import java.lang.reflect.Array;
import java.util.*;

public class TicketManager {
    private TicketRepository repos;

    public TicketManager(TicketRepository repos) {
        this.repos = repos;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Arrays.sort(repos.repository(), comparator);
        int index = 0;

        Ticket[] item = new Ticket[repos.repository().length];
        for (Ticket item2 : repos.repository()) {
            if (from.equals(item2.getAirportOut())) {
                item[index] = item2;
                index++;
            }
        }
        item = removeNull(item);
        return item;
    }

    public Ticket[] removeNull(Ticket[] item){
        Ticket[] withoutNull = new Ticket[item.length];
        int count = -1;

        for(Ticket s : item) {
            if(s != null) {
                withoutNull[++count] = s;
            }
        }

        item = Arrays.copyOf(withoutNull, count + 1);
        return item;
    }

    public void removeManager(int id) {
        repos.removeById(id);
    }

    public void add(Ticket ticket) {
        repos.save(ticket);
    }

}
