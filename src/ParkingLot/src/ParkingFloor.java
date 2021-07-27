package ParkingLot.src;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    private String name;
    Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlotMap=new HashMap<ParkingSlotType,Map<String,ParkingSlot>>();

    public ParkingFloor() {
    }

    public ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotMap) {
        this.name = name;
        this.parkingSlotMap = parkingSlotMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<ParkingSlotType, Map<String, ParkingSlot>> getParkingSlotMap() {
        return parkingSlotMap;
    }

    public void setParkingSlotMap(Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotMap) {
        this.parkingSlotMap = parkingSlotMap;
    }

    public ParkingSlot getRelevantFloorForVechile(Vechile vechile) {
        ParkingSlot slot=null;

        VechileCategory category=vechile.getCategory();
        ParkingSlotType slotType=getParkingSlotType(category);
        Map<String,ParkingSlot> map=parkingSlotMap.get(slotType);

        for(Map.Entry<String,ParkingSlot> entry: map.entrySet()){
            if(entry.getValue().isAvailable) {
                slot=entry.getValue();
                break;

            }
        }
        return slot;
    }

    private ParkingSlotType getParkingSlotType(VechileCategory category) {

        if(category.equals("Scooter"))
            return ParkingSlotType.TWO_WHEELERS;
        if(category.equals("SUV"))
            return ParkingSlotType.MOTOR;

        return null;
    }
}
