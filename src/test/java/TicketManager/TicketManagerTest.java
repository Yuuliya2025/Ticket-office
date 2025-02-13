package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


class TicketTest {

    @Test
    public void testSoftFewTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket5, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSoftZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSoftOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("UFA", "SPB");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSoftTicketWitsComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket1, ticket2, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testZeroTicketWitsComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("UFA", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneTicketWitsComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 10, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5000, 12, 14);
        Ticket ticket3 = new Ticket("UFA", "SPB", 3000, 9, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 4000, 5, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "UFA", comparator);
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }
}
