package themepark;

// RideRepository trashëgon InMemoryRepository me tip Ride
public class RideRepository extends InMemoryRepository<String, Ride> {

    private static RideRepository instance;

    private RideRepository() {
        super(r -> r.getId()); // ky thjesht merr ID nga Ride
    }

    public static synchronized RideRepository getInstance() {
        if (instance == null) {
            instance = new RideRepository();
        }
        return instance;
    }
}
