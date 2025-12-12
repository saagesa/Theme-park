package themepark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkServiceTest {
    private ParkService park;
    private InMemoryRepository<String, User> userRepo;

    @BeforeEach
    void setup() {
        var rideRepo = new InMemoryRepository<String, Ride>(r->r.getId());
        var ticketRepo = new InMemoryRepository<String, Ticket>(t->t.getId());
        userRepo = new InMemoryRepository<String, User>(u->u.getId());
        park = new ParkService(rideRepo, ticketRepo, userRepo);

        var admin = new User("u-admin","Admin","a@a.com", "h", User.Role.ADMIN);
        userRepo.save(admin);
        rideRepo.save(new Ride("r1","Ferris",30));
    }

    @Test
    void buyTicket_success() {
        var u = new User("u1","C","c@c","h", User.Role.GUEST);
        userRepo.save(u);
        var ticket = park.buyTicket(u.getId(), "r1");
        assertNotNull(ticket);
        assertEquals(u.getId(), ticket.getUserId());
    }

    @Test
    void buyTicket_rideClosed_throws() {
        var u = new User("u2","D","d@d","h", User.Role.GUEST);
        userRepo.save(u);
        var ride = park.getRide("r1").get();
        ride.close();
        assertThrows(IllegalStateException.class, () -> park.buyTicket(u.getId(), "r1"));
    }

    @Test
    void adminCanAddRide() {
        var admin = userRepo.findAll().stream().filter(x->x.getRole()==User.Role.ADMIN).findFirst().orElseThrow();
        var r = new Ride("r2","NewRide",10);
        var added = park.addRide(r, admin);
        assertEquals(r.getId(), added.getId());
    }
} 
