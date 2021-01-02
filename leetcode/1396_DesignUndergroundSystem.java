// Design a subway system
// The API has two main methods - checkIn checks in a customer at a station
//                              - checkOut checks out a customer at a station

import java.util.*;

class Route {
    public static Map<String, Route> all = new HashMap<>();

    private String startStationId;
    private String endStationId;
    
    public Route(String startStationId, String endStationId) throws Exception {
        if (Route.find(startStationId, endStationId).isPresent()) {
            throw new Exception("Route already exists");
        }
        
        this.startStationId = startStationId;
        this.endStationId = endStationId;
    }

    public static Optional<Route> find(String startStationId, String endStationId) {
        String hashKey = Route.generateHashKey(startStationId, endStationId);

        if (Route.all.containsKey(hashKey)) {
            return Optional.of(Route.all.get(hashKey));
        }

        return null;
    }

    private static String generateHashKey(String startStationId, String endStationId) {
        return String.format("%s->%s", startStationId, endStationId);
    }
}

enum TripStatus {
    ONGOING,
    COMPLETED
}

class Trip {
    private int customerId;
    private String startStationId;
    private String endStationId;
    private int startTime;
    private int endTime;
    private TripStatus status;

    public static List<Trip> all = new ArrayList<>();
    
    public Trip(int customerId, String startStationId, int startTime,
                String endStationId, int endTime, TripStatus status) {
        this.customerId = customerId;
        this.startStationId = startStationId;
        this.startTime = startTime;
        this.endStationId = endStationId;
        this.endTime = endTime;
        this.status = status;
    }

    public Trip(int customerId, String startStationId, int startTime) {
        this(customerId, startStationId, startTime, "ONGOING", Integer.MAX_VALUE,
             TripStatus.ONGOING);
    }

    public void complete(String endStationId, int endTime) {
        this.endStationId = endStationId;
        this.endTime = endTime;
        this.status = TripStatus.COMPLETED;
    }
}

class UndergroundSystem {
    public UndergroundSystem() {
    }

    public void checkIn(int customerId, String stationId, int timestamp) {
    }

    public void checkOut(int customerId, String stationId, int timestamp) {
    }

    public double getAverageTime(String startStationId, String endStationId) {
        return 0.0;
    }
}
