package themepark;

import java.util.*;
import java.util.stream.Collectors;

public class ParkService {
    private final Repository<String, Ride> rideRepo;
    private final Repository<String, Ticket> ticketRepo;
    private final Repository<String, User> userRepo;

    public ParkService(Repository<String,Ride> rideRepo,
                       Repository<String,Ticket> ticketRepo,
                       Repository<String,User> userRepo) {
        this.rideRepo = rideRepo; this.ticketRepo = ticketRepo; this.userRepo = userRepo;
    }

    public Ride addRide(Ride r, User actor) {
        if(actor==null || actor.getRole() == User.Role.GUEST) throw new SecurityException("Not allowed");
        rideRepo.save(r); return r; }

    public Optional<Ride> getRide(String id) { return rideRepo.findById(id); }
    public Collection<Ride> listRides() { return rideRepo.findAll(); }

    public Ticket buyTicket(String userId, String rideId) {
        User u = userRepo.findById(userId).orElseThrow();
        Ride r = rideRepo.findById(rideId).orElseThrow();
        if(!r.isOpen()) throw new IllegalStateException("Ride closed");
        String tid = UUID.randomUUID().toString();
        Ticket t = new Ticket(tid, userId, rideId);
        ticketRepo.save(t);
        return t;
    }

    public List<Ticket> ticketsForUser(String userId) {
        return ticketRepo.findAll().stream().filter(t->t.getUserId().equals(userId)).collect(Collectors.toList());
    }
}