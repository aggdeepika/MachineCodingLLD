package ParkingLot.src;

import java.util.List;
import java.util.Objects;

public class ParkingLot {

    private String name;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot() {
    }

    public ParkingLot(String name, List<ParkingFloor> parkingFloorList) {
        this.name = name;
        this.parkingFloorList = parkingFloorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }


    public  void assignTicket(Vechile vechile){
        ParkingSlot slot=getParkingSlot(vechile);
        if(Objects.nonNull(slot)){
            Ticket ticket=Ticket.createTicket(vechile,slot);
           int charges= scanAndPay(ticket);
           System.out.println("charges are"+123);
        }
    }

    private int  scanAndPay(Ticket ticket) {

        long duration= ticket.getEndTime()- ticket.getStartTime();

        int charges= (int) (duration*1);


        return charges;

    }

    private ParkingSlot getParkingSlot(Vechile vechile) {

        ParkingSlot slot=null;
        for(ParkingFloor floor: parkingFloorList){
            slot=floor.getRelevantFloorForVechile(vechile);
            if(slot!=null){
                break;
            }
        }

       return slot;
    }
}
