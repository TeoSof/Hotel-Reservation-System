package hotelreservationsystem;

public class Room {
    private String RoomNumber;
    private int Floor;
    private int RoomCapacity;
    private double RoomPrice;
    
    Room(String RoomNumber, int Floor, int RoomCapacity, double RoomPrice ){
        this.setRoomNumber(RoomNumber);
        this.setFloor(Floor);
        this.setRoomCapacity(RoomCapacity);
        this.setRoomPrice(RoomPrice);
    }
    
    Room(){
        
    }
    
    public void setRoomNumber(String RoomNumber){
        this.RoomNumber = RoomNumber;
    }
    
    public String getRoomNumber(){
        return this.RoomNumber;
    }
    
    public void setFloor(int Floor){
        this.Floor = Floor;
    }
    
    public int getFloor(){
        return this.Floor;
    }
    
    public void setRoomCapacity(int RoomCapacity){
        this.RoomCapacity = RoomCapacity;
    }
    
    public int getRoomCapacity(){
        return this.RoomCapacity;
    }
    
    public void setRoomPrice(double RoomPrice){
        this.RoomPrice = RoomPrice;
    }
    
    public double getRoomPrice(){
        return this.RoomPrice;
    }
}
