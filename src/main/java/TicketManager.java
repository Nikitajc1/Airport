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

    public Ticket[] findAll(String from, String to, Comparator<Ticket>comparator) {
        Arrays.sort(repos.repository(), comparator);
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;

        Ticket[] LEDMOW = new Ticket[5];
        Ticket[] OGZFRU = new Ticket[2];
        Ticket[] KUFGOJ = new Ticket[2];
        Ticket[] MOWOGZ = new Ticket[1];
        Ticket[] DoesNotExist = new Ticket[0];
        for (Ticket items : repos.repository()) {
            if (items.getAirportOut().equals("LED")) {
                LEDMOW[index1] = items;
                index1++;
            }
        }
        for (Ticket items : repos.repository()) {
            if (items.getAirportOut().equals("OGZ")) {
                OGZFRU[index2] = items;
                index2++;
            }
        }
        for (Ticket items : repos.repository()) {
            if (items.getAirportOut().equals("KUF")) {
                KUFGOJ[index3] = items;
                index3++;
            }
        }
        for (Ticket items : repos.repository()) {
            if (items.getAirportOut().equals("MOW")) {
                MOWOGZ[index4] = items;
                index4++;
            }
        }
        if (from.equals("LED")) {
            return LEDMOW;
        } else if (from.equals("OGZ")) {
            return OGZFRU;
        } else if (from.equals("KUF")) {
            return KUFGOJ;
        } else if (from.equals("MOW")) {
            return MOWOGZ;
        }
        return DoesNotExist;
    }

    public void removeManager(int id){
        repos.removeById(id);
    }

    public void add(Ticket ticket) {
        repos.save(ticket);
    }

}
