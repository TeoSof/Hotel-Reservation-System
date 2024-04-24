package hotelreservationsystem;

public class Reservation {
    private String Room;
    private String ClientName;
    private int Capacity;
    private String CheckIn;
    private String CheckOut;
    private double Discount;
    private String Amenities;
    private double TotalCost;
    
    Reservation(String Room, String ClientName, int Capacity, String CheckIn, String CheckOut, double Discount, double TotalCost){
        this.setRoom(Room);
        this.setClientName(ClientName);
        this.setCapacity(Capacity);
        this.setCheckIn(CheckIn);
        this.setCheckOut(CheckOut);
        this.setDiscount(Discount);
        this.setTotalCost(TotalCost);
    }
    
    public void setRoom(String Room){
        this.Room = Room;
    }
    
    public String getRoom(){
        return this.Room;
    }
    
    public void setClientName(String ClientName){
        this.ClientName = ClientName;
    }
    
    public String getClientName(){
        return this.ClientName;
    }
    
    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }
    
    public int getCapacity(){
        return this.Capacity;
    }
    
    public void setCheckIn(String CheckIn){
        this.CheckIn = CheckIn;
    }
    
    public String getCheckIn(){
        return this.CheckIn;
    }
    
    public void setCheckOut(String CheckOut){
        this.CheckOut = CheckOut;
    }
    
    public String getCheckOut(){
        return this.CheckOut;
    }
    
    public void setDiscount(double Discout){
        this.Discount = Discount;
    }
    
    public double getDiscount(){
        return this.Discount;
    }
    
    public void setAmenities(String Amenities){
        this.Amenities = Amenities;
    }
    
    public String getAmenities(){
        return this.Amenities;
    }
    
    public void setTotalCost(double TotalCost){
        this.TotalCost = TotalCost;
    }
    
    public double getTotalCost(){
        return this.TotalCost;
    }
}
