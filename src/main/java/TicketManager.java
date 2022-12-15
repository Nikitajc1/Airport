import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketManager {
    private TicketRepository repos;

    public TicketManager(TicketRepository repos) {
        this.repos = repos;
    }

    public ArrayList<Ticket> findAll(String from, String to) {
        Arrays.sort(repos.repository());

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
