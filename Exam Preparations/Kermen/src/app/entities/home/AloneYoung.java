package app.entities.home;

import app.entities.device.Device;
import app.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constants.YOUNG_PERSON_ELECTRICITY_COST;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AloneYoung extends Home {

    public AloneYoung(double income, List<Device> devices) {
        super(income,  devices);
    }
    public int getPopulation() {
        return 1;
    }


    @Override
    protected void setRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            rooms.add(new Room(YOUNG_PERSON_ELECTRICITY_COST));
        }
        super.setRooms(rooms);
    }
}
