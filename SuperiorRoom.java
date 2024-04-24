package hotelreservationsystem;
import java.util.ArrayList;

public class SuperiorRoom extends Room{
    private ArrayList<String> Amenities = new ArrayList<String>();
    
    SuperiorRoom(String RoomNumber, int Floor, int RoomCapacity, double RoomPrice, ArrayList<String> Amenities){
        super(RoomNumber, Floor, RoomCapacity, RoomPrice);
        this.Amenities = Amenities;
    }
    
    SuperiorRoom(){
        
    }
    
    public void setAmenityList(String Amenities){
        this.Amenities.add(Amenities);
    }
    
    public ArrayList<String> getAmenityList(){
        return (Amenities);
    }
    
    public String getAmenityListIndex(int i){
        return this.Amenities.get(i);
    }
}
