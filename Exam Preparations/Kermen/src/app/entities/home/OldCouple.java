package app.entities.home;

import app.entities.device.Device;
import app.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constants.OLD_COUPLE_ROOM_ELECTRICITY_COST;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OldCouple extends Home {

    public OldCouple(double income, List<Device> devices) {
        super(income, devices);
    }
    public int getPopulation() {
        return 2;
    }


    @Override
    protected void setRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            rooms.add(new Room(OLD_COUPLE_ROOM_ELECTRICITY_COST));
        }
        super.setRooms(rooms);
    }
}
