import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 15499, "LED", "MOW", 180);
    Ticket ticket2 = new Ticket(2, 10799, "LED", "MOW", 270);
    Ticket ticket3 = new Ticket(3, 20000, "OGZ", "FRU", 560);
    Ticket ticket4 = new Ticket(4, 23299, "OGZ", "FRU", 490);
    Ticket ticket5 = new Ticket(5, 7999, "KUF", "GOJ", 90);
    Ticket ticket6 = new Ticket(6, 9999, "KUF", "GOJ", 80);
    Ticket ticket7 = new Ticket(7, 13999, "MOW", "OGZ", 210);
    Ticket ticket8 = new Ticket(8, 43599, "MOW", "BUH", 450);
    Ticket ticket9 = new Ticket(9, 35999, "MOW", "CAI", 670);
    Ticket ticket10 = new Ticket(10, 37000, "BUH", "LED", 550);

    @Test
    public void testFindAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        ArrayList<Ticket> expected = new ArrayList<>();
        expected.add(ticket2);
        expected.add(ticket1);

        ArrayList<Ticket> actual = manager.findAll("LED", "MOW");

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.removeManager(ticket2.getId());

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.repository();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket expected = ticket3;
        Ticket actual = repo.findById(ticket3.getId());

        Assertions.assertEquals(expected, actual);
    }

}
