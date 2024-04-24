package hotelreservationsystem;

public class Amenity {
    private String AmenityNumber;
    private String AmenityCategory;
    private String AmenityDescription;
    private double AmenityPrice;
    
    Amenity(String AmenityNumber, String AmenityCategory, String AmenityDescription, double AmenityPrice){
        this.setAmenityNumber(AmenityNumber);
        this.setAmenityCategory(AmenityCategory);
        this.setAmenityDescription(AmenityDescription);
        this.setAmenityPrice(AmenityPrice);
    }
    
    public void setAmenityNumber(String AmenityNumber){
        this.AmenityNumber = AmenityNumber;
    }
    
    public String getAmenityNumber(){
        return this.AmenityNumber;
    }
    
    public void setAmenityCategory(String AmenityCategory){
        this.AmenityCategory = AmenityCategory;
    }
    
    public String getAmenityCategory(){
        return this.AmenityCategory;
    }
    
    public void setAmenityDescription(String AmenityDescription){
        this.AmenityDescription = AmenityDescription;
    }
    
    public String getAmenityDescription(){
        return this.AmenityDescription;
    }
    
    public void setAmenityPrice(double AmenityPrice){
        this.AmenityPrice = AmenityPrice;
    }
    
    public double getAmenityPrice(){
        return this.AmenityPrice;
    }
}
