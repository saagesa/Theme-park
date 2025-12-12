package themepark;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<String, User> userRepo = new InMemoryRepository<>(u -> u.getId());
        InMemoryRepository<String, Ride> rideRepo = new InMemoryRepository<>(r -> r.getId());
        InMemoryRepository<String, Ticket> ticketRepo = new InMemoryRepository<>(t -> t.getId());

        AuthService auth = new AuthService(userRepo);
        ParkService park = new ParkService(rideRepo, ticketRepo, userRepo);

        // seed admin & ride
        User admin = auth.register("admin","admin@example.com","adminpass");
        admin.setRole(User.Role.ADMIN);
        userRepo.save(admin);
        rideRepo.save(new Ride("ride1","RollerCoaster",24));

        Scanner in = new Scanner(System.in);
        System.out.println("Simple Theme Park Console (demo). Type 'exit' to quit.");
        while(true) {
            System.out.print("cmd> ");
            String line = in.nextLine();
            if(line == null) break;
            line = line.trim();
            if(line.equalsIgnoreCase("exit")) break;
            try {
                if(line.startsWith("login")) {
                    String[] parts = line.split(" ");
                    java.util.Optional<User> opt = auth.login(parts[1], parts[2]);
                    System.out.println(opt.isPresent() ? "OK" : "FAIL");
             
                } else if(line.startsWith("buy")) {
                    String[] p = line.split(" ");
                    Ticket ticket = park.buyTicket(p[1], p[2]);
                    System.out.println("Bought: " + ticket);
                } else {
                    System.out.println("unknown");
                }
            } catch(Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }
}
