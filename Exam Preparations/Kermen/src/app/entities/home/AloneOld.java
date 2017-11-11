package app.entities.home;

import app.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constants.OLD_PERSON_ROOM_ELECTRICITY_COST;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AloneOld extends Home {
    public AloneOld(double income/*, List<Device> devices*/) {
        super(income, null/*,  devices*/);
    }

    public int getPopulation() {
        return 1;
    }

    @Override
    protected void setRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            rooms.add(new Room(OLD_PERSON_ROOM_ELECTRICITY_COST));
        }
        super.setRooms(rooms);
    }
}
