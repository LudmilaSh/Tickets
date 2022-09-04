package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1_000, "SVO", "RTW", 210);
    Ticket ticket2 = new Ticket(2, 2_000, "LED", "RTW", 120);
    Ticket ticket3 = new Ticket(3, 3_000, "SVO", "RTW", 90);
    Ticket ticket4 = new Ticket(4, 4_000, "BUS", "VVO", 600);
    Ticket ticket5 = new Ticket(5, 5_000, "SVO", "RTW", 180);
    Ticket ticket6 = new Ticket(6, 6_000, "PMI", "TIV", 300);
    Ticket ticket7 = new Ticket(7, 3_500, "BUS", "VVO", 410);
    Ticket ticket8 = new Ticket(8, 8_000, "SVO", "LWO", 380);

    @Test
    public void shouldFindFromSVOToRTW() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = manager.searchBy("SVO", "RTW");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFromSVOToSVX() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("SVO", "SVX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFromBUSToVVO() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7, ticket4};
        Ticket[] actual = manager.searchBy("BUS", "VVO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFromSVOToLWO() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.searchBy("SVO", "LWO");
        Assertions.assertArrayEquals(expected, actual);
    }

}
