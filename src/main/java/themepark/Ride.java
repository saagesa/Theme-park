package themepark;


public class Ride {
    private final String id;
    private String name;
    private int capacity;
    private boolean open;

    public Ride(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.open = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public boolean isOpen() { return open; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void open() { this.open = true; }
    public void close() { this.open = false; }
    @Override
    public String toString() { return id+":"+name+"("+(open?"OPEN":"CLOSED")+")"; }
}
