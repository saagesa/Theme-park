package themepark;

import java.time.LocalDateTime;

public class Ticket {
    private final String id;
    private final String userId;
    private final String rideId; // nullable for general park tickets
    private final LocalDateTime createdAt;

    public Ticket(String id, String userId, String rideId) {
        this.id = id;
        this.userId = userId;
        this.rideId = rideId;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getRideId() { return rideId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    @Override
    public String toString() { return "Ticket{"+id+" user="+userId+" ride="+rideId+"}"; }
}
