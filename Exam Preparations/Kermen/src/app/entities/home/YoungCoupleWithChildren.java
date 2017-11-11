package app.entities.home;

import app.entities.device.Device;
import app.entities.people.Child;
import app.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constants.YOUNG_COUPLE_WITH_CHILDREN_ROOM_ELECTRICITY_COST;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class YoungCoupleWithChildren extends Home {

    public YoungCoupleWithChildren(double income, List<Device> devices, List<Child> children) {
        super(income, devices);
        super.setChildren(children);

    }

    public int getPopulation() {
        return 2 + super.getChildren().size();
    }

    @Override
    protected void setRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            rooms.add(new Room(YOUNG_COUPLE_WITH_CHILDREN_ROOM_ELECTRICITY_COST));
        }
        super.setRooms(rooms);
    }
}
