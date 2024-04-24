package hotelreservationsystem;

public class Client {
    private String ID;
    private String Name;
    private String Address;
    private int ContactNumber;
    
    Client(String ID, String Name, String Address, int ContactNumber){
        this.setID(ID);
        this.setName(Name);
        this.setAddress(Address);
        this.setContactNumber(ContactNumber);
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    public String getAddress(){
        return this.Address;
    }
    
    public void setContactNumber(int ContactNumber){
        this.ContactNumber = ContactNumber;
    }
    
    public int getContactNumber(){
        return this.ContactNumber;
    }
}
