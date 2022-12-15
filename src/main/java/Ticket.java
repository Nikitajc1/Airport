import java.util.Comparator;

public class Ticket implements Comparable<Ticket>, Comparator<Ticket> {
    private int id;
    private int price;
    private String AirportOut;
    private String AirportIn;
    private int timeInMinute;

    public Ticket (int id, int price, String AirportOut, String AirportIn, int timeInMinute){
        this.id = id;
        this.price = price;
        this. AirportOut = AirportOut;
        this.AirportIn = AirportIn;
        this.timeInMinute = timeInMinute;
    }

    public Ticket () {

    }

    public String getAirportOut() {
        return AirportOut;
    }

    public void setAirportOut(String airportOut) {
        AirportOut = airportOut;
    }

    public String getAirportIn() {
        return AirportIn;
    }

    public void setAirportIn(String airportIn) {
        AirportIn = airportIn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTimeInMinute() {
        return timeInMinute;
    }

    public void setTimeInMinute(int timeInMinute) {
        this.timeInMinute = timeInMinute;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()){
            return - 1;
        } else if (this.price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
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
