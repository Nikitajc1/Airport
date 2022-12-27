import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TicketManager {
    private TicketRepository repos;

    public TicketManager(TicketRepository repos) {
        this.repos = repos;
    }

    public Ticket[] findAll(String from, String to) {
        Arrays.sort(repos.repository());
        int index = 0;

        Ticket[] item = new Ticket[repos.repository().length];
        for (Ticket item2 : repos.repository()) {
            if (from.equals(item2.getAirportOut())) {
                item[index] = item2;
                index++;
            }
        }
        Ticket[] cleanedArray = Arrays.stream(item).filter(Objects::nonNull).toArray(Ticket[]::new);
        return cleanedArray;
    }


    public void removeManager(int id) {
        repos.removeById(id);
    }

    public void add(Ticket ticket) {
        repos.save(ticket);
    }

}
