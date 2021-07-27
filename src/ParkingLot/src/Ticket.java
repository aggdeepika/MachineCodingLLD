package ParkingLot.src;

public class Ticket {

    private String number;
    private long startTime;
    private long endTime;
    private Vechile vechile;
    private ParkingSlot slot;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public static Ticket createTicket(Vechile vechile, ParkingSlot slot){

            Ticket ticket=new Ticket();
            ticket.setNumber("11");
            ticket.setStartTime(232);
            ticket.setEndTime(5556);
            ticket.setVechile(vechile);
            ticket.setSlot(slot);
            return ticket;

    }
}
