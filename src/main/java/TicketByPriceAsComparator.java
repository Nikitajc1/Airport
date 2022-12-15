import java.util.Comparator;

public class TicketByPriceAsComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getTimeInMinute() < o2.getTimeInMinute()){
            return - 1;
        } else if (o1.getTimeInMinute() > o2.getTimeInMinute()) {
            return 1;
        } else {
            return 0;
        }
    }
}