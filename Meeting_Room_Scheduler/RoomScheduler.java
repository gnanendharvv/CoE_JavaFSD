import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomScheduler {
    private Map<String, MeetingRoom> meetingRooms;

    public RoomScheduler() {
        meetingRooms = new HashMap<>();
    }

    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.getRoomId(), room);
        System.out.println("Successfully added: " + room.getRoomName() + " (Room ID: " + room.getRoomId() + ")");
    }

    public String bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = meetingRooms.get(roomId);
        if (room != null && room.getFeatures().containsAll(requiredFeatures)) {
            return "Congratulations! Room " + roomId + " has been successfully booked.";
        } else {
            return "Sorry! The requested room does not match all required features.";
        }
    }

    public List<String> listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = meetingRooms.values().stream()
                .filter(room -> room.getFeatures().containsAll(requiredFeatures))
                .map(MeetingRoom::getRoomName)
                .collect(Collectors.toList());

        return availableRooms.isEmpty() ? List.of("No rooms available with the requested features.") : availableRooms;
    }
}
