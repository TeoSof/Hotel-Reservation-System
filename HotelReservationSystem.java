package hotelreservationsystem;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class HotelReservationSystem {
    
    

    public static void main(String[] args) {
        String PrintMenu = new String("[1]Insert Amenity" + "\n" +
                                 "[2]Insert Room (Standard or Superior)" + "\n" +
                                 "[3]Insert Client" + "\n" +
                                 "[4]Book Room" + "\n" +
                                 "[5]Cancel Room Reservation" + "\n" +
                                 "[6]Order Amenity (Available only in Superior Rooms)" + "\n" +
                                 "[7}Hotel Capacity" + "\n" +
                                 "[8]Room Availability" + "\n" +
                                 "[0]Exit" + "\n");
        
        ArrayList<Amenity> AmenityArray = new ArrayList<Amenity>();
        ArrayList<Room> RoomArray = new ArrayList<Room>();
        ArrayList<Client> ClientArray = new ArrayList<Client>();
        ArrayList<Integer> ReservedRooms = new ArrayList<Integer>();
        ArrayList<Reservation> ReservationArray = new ArrayList<Reservation>();
        
        Date date = new Date();
        Scanner MenuSc = new Scanner(System.in);
        
        System.out.println(PrintMenu);
        
        int Menu = MenuSc.nextInt();
        MenuSc.nextLine();
        int flagA = 0, flagR = 0, flagC = 0;
        
        while(Menu != 0){
            
            if(Menu == 1){                                      //AMENITY
                if(flagA == 0){
                    System.out.println("Amenity Number:");
                    String AN = MenuSc.nextLine();
                    System.out.println("Amenity Category:");
                    String AC = MenuSc.nextLine();
                    System.out.println("Amenity Description:");
                    String AD = MenuSc.nextLine();
                    System.out.println("Amenity Price:");
                    double AP = MenuSc.nextDouble();
                    MenuSc.nextLine();
                
                    Amenity AmenityObj = new Amenity(AN, AC, AD, AP);
                
                    AmenityArray.add(AmenityObj);
                    flagA = 1;
                    
                    System.out.println(PrintMenu);
                    Menu = MenuSc.nextInt();
                    MenuSc.nextLine();
                }else{
                    System.out.println("Amenity Number:");
                    MenuSc.nextLine();
                    String AN = MenuSc.nextLine();
                    
                    int flag;
                    
                    do{
                        flag = 0;
                        for(int i = 0; i < AmenityArray.size(); i++){       
                            if(AN.equals(AmenityArray.get(i).getAmenityNumber())){  
                                System.out.println("Amenity " + AN + " already exists! Enter another amenity:");
                                AN = MenuSc.nextLine();
                                flag = 1;
                                break;
                            }
                        }
                    }while(flag == 1);
                    
                    System.out.println("Amenity Category:");
                    String AC = MenuSc.nextLine();
                    System.out.println("Amenity Description:");
                    String AD = MenuSc.nextLine();
                    System.out.println("Amenity Price:");
                    double AP = MenuSc.nextDouble();
                
                    Amenity AmenityObj = new Amenity(AN, AC, AD, AP);
                
                    AmenityArray.add(AmenityObj);

                    System.out.println(PrintMenu);
                    Menu = MenuSc.nextInt();
                    MenuSc.nextLine();
                }   
            }else if(Menu == 2){                                        //ROOM
                System.out.println("[a]Insert a standard room" + "\n"
                                    + "[b]Insert a superior room");
                String SubMenu = MenuSc.nextLine();
                if(SubMenu.equals("a")){                                //StandardRoom
                    if(flagR == 0){                             //if (first time)
                        System.out.println("Room Number:");
                        String RN = MenuSc.nextLine();
                        System.out.println("Floor:");
                        int FL = MenuSc.nextInt();
                        System.out.println("Room Capacity:");
                        int RC = MenuSc.nextInt();
                        System.out.println("Room Price:");
                        double RP = MenuSc.nextDouble();
                        
                        flagR = 1;
                        
                        StandardRoom StandardRoomObj = new StandardRoom(RN, FL, RC, RP);
                        
                        RoomArray.add(StandardRoomObj);
                        ReservedRooms.add(0);
                    }else{
                        int flag;
                        
                        System.out.println("Room Number:");
                        String RM = MenuSc.nextLine();
                        
                        do{
                            flag = 1;
                            for(int i = 0; i < RoomArray.size(); i++){
                                if(RM.equals(RoomArray.get(i).getRoomNumber())){
                                    System.out.println("Room " + RM + " is not available. Enter another room number:");
                                    flag = 0;
                                    break;
                                }
                            }
                            if(flag == 0){
                                RM = MenuSc.nextLine();
                            }
                        }while(flag == 0);
                        
                        System.out.println("Floor:");
                        int FL = MenuSc.nextInt();
                        System.out.println("Room Capacity:");
                        int RC = MenuSc.nextInt();
                        System.out.println("Room Price:");
                        double RP = MenuSc.nextDouble();
                        MenuSc.nextLine();
                            
                        StandardRoom StandardRoomObj = new StandardRoom(RM, FL, RC, RP);
                        RoomArray.add(StandardRoomObj);
                        ReservedRooms.add(0);
                         
                        
                    }
                }else if(SubMenu.equals("b")){                                  //Superior Room
                    if(flagR == 0){                             //if (first time)
                        String Am = null;
                        ArrayList<String> SupRoomAmenities = new ArrayList<String>();
                                
                        System.out.println("Room Number:");
                        String RN = MenuSc.nextLine();
                        System.out.println("Floor:");
                        int FL = MenuSc.nextInt();
                        System.out.println("Room Capacity:");
                        int RC = MenuSc.nextInt();
                        System.out.println("Room Price:");
                        double RP = MenuSc.nextDouble();
                        MenuSc.nextLine();
                        if(!AmenityArray.isEmpty()){
                            System.out.println("Available amenities:");
                            for(int i = 0; i < AmenityArray.size(); i++){
                                System.out.println("Amenity number: " + AmenityArray.get(i).getAmenityNumber());
                                System.out.println("Amenity description: " + AmenityArray.get(i).getAmenityDescription());
                            }
                            
                            do{
                                int isAmenityCorrect = 0;
                                do{
                                    System.out.println("Insert available room amenity or enter '0' to exit:");
                                    Am = MenuSc.nextLine();
                                    for(int i = 0; i < AmenityArray.size(); i++){
                                        if(Am.equals(AmenityArray.get(i).getAmenityNumber())){
                                            isAmenityCorrect = 1;
                                            break;
                                        }
                                    }
                                    try{
                                        if(Integer.parseInt(Am) == 0){
                                            isAmenityCorrect = 1;
                                        }
                                    }catch(Exception e){
                                        
                                    }
                                }while(isAmenityCorrect == 0);
                                try{
                                    if(Integer.parseInt(Am) != 0){
                                        SupRoomAmenities.add(Am);
                                    }
                                }catch(Exception e){
                                    
                                }
                            }while(Am == "0");
                        }else{
                            System.out.println("There are no available amenities.");
                        }
                        
                        
                        flagR = 1;
                        if(SupRoomAmenities.isEmpty()){
                            SuperiorRoom SuperiorRoomObj = new SuperiorRoom(RN, FL, RC, RP, null);
                            RoomArray.add(SuperiorRoomObj);
                        }else{
                            SuperiorRoom SuperiorRoomObj = new SuperiorRoom(RN, FL, RC, RP, SupRoomAmenities);
                            RoomArray.add(SuperiorRoomObj);
                        }
                        
                        ReservedRooms.add(0);
                        
                        System.out.println(PrintMenu);
                        Menu = MenuSc.nextInt();
                        MenuSc.nextLine();
                    }else{
                        ArrayList<String> SupRoomAmenities = new ArrayList<String>();
                        String Am = null;
                        int flag;
                        
                        System.out.println("Room Number:");
                        String RN = MenuSc.nextLine();
                        
                        do{
                            flag = 1;
                            for(int i = 0; i < RoomArray.size(); i++){
                                if(RN.equals(RoomArray.get(i).getRoomNumber())){
                                    System.out.println("Room " + RN + " already exists. Enter another room number:");
                                    flag = 0;
                                    break;
                                }
                            }
                            if(flag == 0){
                                RN = MenuSc.nextLine();
                            }
                        }while(flag == 0);
                        
                        System.out.println("Floor:");
                        int FL = MenuSc.nextInt();
                        System.out.println("Room Capacity:");
                        int RC = MenuSc.nextInt();
                        System.out.println("Room Price:");
                        double RP = MenuSc.nextDouble();
                        MenuSc.nextLine();
                        if(!AmenityArray.isEmpty()){
                            System.out.println("Available amenities:");
                            for(int i = 0; i < AmenityArray.size(); i++){
                                System.out.println("Amenity number: " + AmenityArray.get(i).getAmenityNumber());
                                System.out.println("Amenity description: " + AmenityArray.get(i).getAmenityDescription());
                            }
                            
                            do{
                                int isAmenityCorrect = 0;
                                do{
                                    System.out.println("Insert available room amenity or enter '0' to exit:");
                                    Am = MenuSc.nextLine();
                                    for(int i = 0; i < AmenityArray.size(); i++){
                                        if(Am.equals(AmenityArray.get(i).getAmenityNumber())){
                                            isAmenityCorrect = 1;
                                            break;
                                        }
                                    }
                                    try{
                                        if(Integer.parseInt(Am) == 0){
                                            isAmenityCorrect = 1;
                                        }
                                    }catch(Exception e){
                                        
                                    }
                                }while(isAmenityCorrect == 0);
                                try{
                                    if(Integer.parseInt(Am) != 0){
                                        SupRoomAmenities.add(Am);
                                    }
                                }catch(Exception e){
                                    
                                }
                            }while(Am == "0");
                        }else{
                            System.out.println("There are no available amenities.");
                        }
                        
                        
                        flagR = 1;
                        if(SupRoomAmenities.isEmpty()){
                            SuperiorRoom SuperiorRoomObj = new SuperiorRoom(RN, FL, RC, RP, null);
                            RoomArray.add(SuperiorRoomObj);
                        }else{
                            SuperiorRoom SuperiorRoomObj = new SuperiorRoom(RN, FL, RC, RP, SupRoomAmenities);
                            RoomArray.add(SuperiorRoomObj);
                        }
                             
                        ReservedRooms.add(0);
                    }
                }
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
            }else if(Menu == 3){            //client
                if(flagC == 0){
                    System.out.println("Identity Number:");
                    String ID = MenuSc.nextLine();
                    System.out.println("Name:");
                    String CN = MenuSc.nextLine();
                    System.out.println("Address:");
                    String Ad = MenuSc.nextLine();
                    System.out.println("Contact Number:");
                    int CNum = MenuSc.nextInt();
                    MenuSc.nextLine();
                
                    Client ClientObj = new Client(ID, CN, Ad, CNum);
                
                    ClientArray.add(ClientObj);
                    flagC = 1;
                    
                    System.out.println(PrintMenu);
                    Menu = MenuSc.nextInt();
                    MenuSc.nextLine();
                }else{
                    System.out.println("Identity Number:");
                    String ID = MenuSc.nextLine();
                    
                    int flag;
                    
                    do{
                        flag = 0;
                        for(int i = 0; i < ClientArray.size(); i++){       
                            if(ID.equals(ClientArray.get(i).getID())){  
                                System.out.println("ID number " + ID + " already exists! Enter a new ID number:");
                                ID = MenuSc.nextLine();
                                flag = 1;
                                break;
                            }
                        }
                    }while(flag == 1);
                    
                    System.out.println("Name:");
                    String CN = MenuSc.nextLine();
                    System.out.println("Address:");
                    String Ad = MenuSc.nextLine();
                    System.out.println("Contact Number:");
                    int CNum = MenuSc.nextInt();
                    MenuSc.nextLine();
                
                    Client ClientObj = new Client(ID, CN, Ad, CNum);
                
                    ClientArray.add(ClientObj);

                    System.out.println(PrintMenu);
                    Menu = MenuSc.nextInt();
                    MenuSc.nextLine();
                }
            }else if(Menu == 4){        //reservation
                String CI;
                String CO;
                System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                int flag;
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CI = MenuSc.nextLine();
                        if(dateFormat(CI)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-in date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, "1/1/1", 0)){
                        flag = 1;
                    }else{
                        System.out.println("Check-in date should be >= to the current date.");
                        System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                
                System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CO = MenuSc.nextLine();
                        if(dateFormat(CO)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, CO, 1)){
                        flag = 1;
                    }else{
                        System.out.println("Check-out date should be >= to the current date and >= to the check-in date.");
                        System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                flag = 0;
                if(flagR == 1){   //are there any rooms?                                  
                    flag = 0;
                    System.out.println("Available rooms:");
                    for(int i = 0; i < RoomArray.size(); i++){
                        if(ReservedRooms.get(i) == 0){  //are there available rooms?
                            flag = 1;
                            System.out.println(RoomArray.get(i).getRoomNumber());
                        }
                        if(ReservedRooms.get(i) == 1){
                            if(reservedRoomDateCompare(CI, CO, ReservationArray.get(i).getCheckIn(), ReservationArray.get(i).getCheckOut())){
                                System.out.println(RoomArray.get(i).getRoomNumber());
                            }
                        }
                    }
                    if(flag == 0){
                        System.out.println("There are no rooms available.");
                    }
                }else{
                    System.out.println("There are no rooms!");
                }
                
                if(flag == 1){                   //are there available rooms?
                    String roomChoice;
                    int RoomPosition = 0;
                    int tempFlag = 0;
                    do{
                        System.out.println("Choose one of the available rooms:");
                        roomChoice = MenuSc.nextLine();
                        for(int i = 0; i < RoomArray.size(); i++){
                            if(roomChoice.equals(RoomArray.get(i).getRoomNumber()) && ReservedRooms.get(i) == 0){
                                tempFlag = 1;
                                RoomPosition = i;
                                break;
                            }
                        }
                        if(tempFlag == 0){      //if roomChoice is incorrect
                            System.out.println("Available rooms:");
                            for(int i = 0; i < RoomArray.size(); i++){
                                if(ReservedRooms.get(i) == 0){
                                    System.out.println(RoomArray.get(i).getRoomNumber());
                                }
                            }
                        }
                    }while(tempFlag == 0);
                    
                    System.out.println("Client ID:");
                    String cID = MenuSc.nextLine();
                    int isClientRegistered = 0;
                    for(int i = 0; i < ClientArray.size(); i++){
                        if(cID.equals(ClientArray.get(i).getID())){
                            isClientRegistered = 1;
                        }
                    }
                    
                    String CN;
                    
                    if(isClientRegistered != 1){        //client is not registered
                        System.out.println("Client name:");
                        CN = MenuSc.nextLine();
                        System.out.println("Client address:");
                        String CAd = MenuSc.nextLine();
                        System.out.println("Client contact number:");
                        int CNum = MenuSc.nextInt();
                        
                        Client ClientObj = new Client(cID, CN, CAd, CNum);
                        ClientArray.add(ClientObj);
                    }else{                      //client is registered
                        System.out.println("Client name:");
                        CN = MenuSc.nextLine();
                    }
                    
                    System.out.println("Room capacity:");
                    int RC = MenuSc.nextInt();
                    System.out.println("Discount:");
                    double Dis = MenuSc.nextDouble();
                    MenuSc.nextLine();
                    
                    double TCost = RoomArray.get(RoomPosition).getRoomPrice();
                    
                    Reservation ReservationObj = new Reservation(roomChoice, CN, RC, CI, CO, Dis, TCost);
                    ReservationArray.add(ReservationObj);
                    
                    for(int i = 0; i < RoomArray.size(); i++){
                        if(roomChoice.equals(RoomArray.get(i).getRoomNumber())){
                            ReservedRooms.set(i, 1);
                            break;
                        }
                    }
                }
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
            }else if(Menu == 5){
                String YN = "N";
                if(ReservationArray.isEmpty()){
                    System.out.println("There are no reservations.");
                }else{
                    do{
                        int isRoomCorrect = 0;
                        int roomIndex = 0;
                        do{
                            System.out.println("Insert room:"); 
                            String room = MenuSc.nextLine();
                            for(int i = 0; i < ReservationArray.size(); i++){
                                if(room.equals(ReservationArray.get(i).getRoom())){
                                    isRoomCorrect = 1;
                                    roomIndex = i;
                                    break;
                                }
                            }
                            if(isRoomCorrect == 0){
                                System.out.println("This reservation does not exist.");
                            }
                        }while(isRoomCorrect == 0);
                        
                        for(int i = 0; i < RoomArray.size(); i++){
                            if(ReservationArray.get(roomIndex).getRoom().equals(RoomArray.get(i).getRoomNumber())){
                                ReservedRooms.set(i, 0);
                                break;
                            }
                        }
                        
                        ReservationArray.remove(roomIndex);
                        
                        System.out.println("Do you want to cancel another reservation? Y/N");
                        YN = MenuSc.nextLine();
                    }while(YN.equals("Y") || YN.equals("y"));
                }
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
            }else if(Menu == 6){ 
                if(ReservationArray.isEmpty()){
                    System.out.println("There are no reservations.");
                }else{
                    int isRoomCorrect = 0;
                    int roomIndex = 0;
                    String resRoom = null;
                    do{
                        System.out.println("Insert room number:");
                        resRoom = MenuSc.nextLine();
                        for(int i = 0; i < ReservationArray.size(); i++){
                            if(resRoom.equals(ReservationArray.get(i).getRoom())){
                                isRoomCorrect = 1;
                                roomIndex = i;
                                break;
                            }
                        }
                        if(isRoomCorrect == 0){
                            System.out.println("Incorrect room number!");
                        }
                    }while(isRoomCorrect == 0);
                    
                    int isRoomSuperior = 0;
                    int RoomIndex = 0;
                    for(int i = 0; i < RoomArray.size(); i++){
                        if(ReservationArray.get(roomIndex).getRoom().equals(RoomArray.get(i).getRoomNumber())){
                            if(RoomArray.get(i) instanceof SuperiorRoom){
                                RoomIndex = i;
                                isRoomSuperior = 1;
                            }
                            break;
                        }
                    }
                    if(isRoomSuperior == 1){
                        if(((SuperiorRoom)(RoomArray.get(RoomIndex))).getAmenityList().isEmpty()){       
                            System.out.println("There are no amenities available for this room.");
                        }else{

                            System.out.println(((SuperiorRoom)(RoomArray.get(RoomIndex))).getAmenityList());   
                                                                                
                            int isAmenityCorrect = 0;
                            String AN = null;
                            do{
                                System.out.println("Select an amenity number: ");
                                AN = MenuSc.nextLine();
                                for(int i = 0; i < ((SuperiorRoom)(RoomArray.get(RoomIndex))).getAmenityList().size(); i++){
                                    if(AN.equals(((SuperiorRoom)(RoomArray.get(RoomIndex))).getAmenityListIndex(i))){
                                        isAmenityCorrect = 1;
                                        break;
                                    }
                                }
                            }while(isAmenityCorrect == 0);
                            
                            if(isAmenityCorrect == 1){
                                int AmenityPosition = 0;
                                for(int i = 0; i < AmenityArray.size(); i++){
                                    if(AN.equals(AmenityArray.get(i).getAmenityNumber())){
                                        AmenityPosition = i;
                                        break;
                                    }
                                }
                                ReservationArray.get(roomIndex).setAmenities(AN);
                                ReservationArray.get(RoomIndex).setTotalCost(ReservationArray.get(RoomIndex).getTotalCost() + AmenityArray.get(AmenityPosition).getAmenityPrice());
                            }
                        }
                    }else{
                        System.out.println("Room " + resRoom + " is not superior.");
                    }
                }
                
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
            }else if(Menu == 7){
                String CI;
                String CO;
                System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                int flag;
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CI = MenuSc.nextLine();
                        if(dateFormat(CI)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-in date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, "1/1/1", 0)){
                        flag = 1;
                    }else{
                        System.out.println("Check-in date should be >= to the current date.");
                        System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                
                System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CO = MenuSc.nextLine();
                        if(dateFormat(CO)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, CO, 1)){
                        flag = 1;
                    }else{
                        System.out.println("Check-out date should be >= to the current date and >= to the check-in date.");
                        System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                
                int allRoomsReserved = 1;
                
                if(ReservedRooms.isEmpty()){
                    System.out.println("There are no rooms.");
                }else{
                    allRoomsReserved = 1;
                    for(int i = 0; i < ReservedRooms.size(); i++){
                        if(ReservedRooms.get(i) == 0){
                            allRoomsReserved = 0;
                            break;
                        }
                    }
                }
                
                if(allRoomsReserved == 0){
                    System.out.println("Available rooms:");
                    for(int i = 0; i < ReservedRooms.size(); i++){
                        System.out.println(RoomArray.get(i).getRoomNumber());
                    }
                }
                
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
                
            }else if(Menu == 8){
                String CI;
                String CO;
                System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                int flag;
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CI = MenuSc.nextLine();
                        if(dateFormat(CI)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-in date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, "1/1/1", 0)){
                        flag = 1;
                    }else{
                        System.out.println("Check-in date should be >= to the current date.");
                        System.out.println("Enter check-in date using the following format 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                
                System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                do{
                    flag = 0;
                    int tempFlag;
                    do{
                        tempFlag = 0;
                        CO = MenuSc.nextLine();
                        if(dateFormat(CO)){
                            tempFlag = 1;
                        }else{
                            System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                        }
                    }while(tempFlag == 0);
                    if(dateCompare(CI, CO, 1)){
                        flag = 1;
                    }else{
                        System.out.println("Check-out date should be >= to the current date and >= to the check-in date.");
                        System.out.println("Enter check-out date using the following format: 'dd/MM/yyyy':");
                    }
                }while(flag == 0);
                
                if(RoomArray.isEmpty()){
                    System.out.println("There are no rooms.");
                }else{    
                    printHotelRooms(RoomArray, ReservedRooms);
                }
                
                System.out.println(PrintMenu);
                Menu = MenuSc.nextInt();
                MenuSc.nextLine();
            }
        }
    }
    
    public static boolean dateFormat(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        
        try{
            date = sdf.parse(dateString);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public static boolean dateCompare(String CheckInDate, String CheckOutDate, int boo){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ciDate = null;
        Date coDate = null;
        Date thisDate = new Date();
        
        try{
            ciDate = sdf.parse(CheckInDate);
            coDate = sdf.parse(CheckOutDate);
        }catch(Exception e){
            return false;
        }
        
        if(boo == 0){
            if(ciDate.compareTo(thisDate) >= 0){
                
                return true;
            }else{
                return false;
            }
        }else{
            if(coDate.compareTo(thisDate) >= 0 && coDate.compareTo(ciDate) >= 0){
                return true;
            }else{
                return false;
            }
        }
    }
    
    public static boolean reservedRoomDateCompare(String CheckIn, String CheckOut, String bookedRoomCheckIn, String bookedRoomCheckOut){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date ciDate = null;
        Date coDate = null;
        Date bciDate = null;
        Date bcoDate = null;
        Date thisDate = new Date();
        
        try{
            ciDate = sdf.parse(CheckIn);
            coDate = sdf.parse(CheckOut);
            bciDate = sdf.parse(bookedRoomCheckIn);
            bcoDate = sdf.parse(bookedRoomCheckOut);
        }catch(Exception e){
            return false;
        }
        
        if((ciDate.compareTo(bcoDate) >= 0 && ciDate.compareTo(thisDate) >= 0) || (ciDate.compareTo(thisDate) >= 0 && coDate.compareTo(bciDate) <= 0)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void printHotelRooms(ArrayList<Room> RoomArr, ArrayList<Integer> ReservedR){
        ArrayList<Integer> WholeArray = new ArrayList<Integer>();
        
        ArrayList<Integer> FirstFloor = new ArrayList<Integer>();
        ArrayList<Integer> SecondFloor = new ArrayList<Integer>();
        
        ArrayList<Integer> FirstFloorReservations = new ArrayList<Integer>();
        ArrayList<Integer> SecondFloorReservations = new ArrayList<Integer>();
        
        for(int i = 0; i < RoomArr.size(); i++){
            WholeArray.add(Integer.parseInt(RoomArr.get(i).getRoomNumber()));
        }
        
        for(int i = 0; i < WholeArray.size(); i++){
            for(int j = 1; j <WholeArray.size() - i; j++){
                if(WholeArray.get(j - 1) > WholeArray.get(j)){
                    int temp = WholeArray.get(j - 1);
                    WholeArray.set(j - 1, WholeArray.get(j));
                    WholeArray.set(j, temp);
                    
                    int temp2 = ReservedR.get(j - 1);
                    ReservedR.set(j - 1, ReservedR.get(j));
                    ReservedR.set(j, temp2);
                }
            }
        }
        //if first time
        for(int i = 0; i < WholeArray.size(); i ++){
            if(WholeArray.get(i) >= 0 && WholeArray.get(i) <= 99){
                FirstFloor.add(WholeArray.get(i));
                if(ReservedR.get(i) == 1){
                    FirstFloorReservations.add(1);
                }else{
                    FirstFloorReservations.add(0);
                }
            }else if(WholeArray.get(i) >= 100 && WholeArray.get(i) <= 199){
                SecondFloor.add(WholeArray.get(i));
                if(ReservedR.get(i) == 1){
                    SecondFloorReservations.add(1);
                }else{
                    SecondFloorReservations.add(0);
                }
            }
        }
        
        for(int i = 0; i < FirstFloor.size(); i++){
            if(FirstFloor.get(i) >= 0 && FirstFloor.get(i) <= 9){
                if(FirstFloorReservations.get(i) == 0){
                    System.out.print(" 00" + FirstFloor.get(i) + " ");
                }else{
                    System.out.print(" [00" + FirstFloor.get(i) + "] ");
                }
            }else{
                if(FirstFloorReservations.get(i) == 0){
                    System.out.print(" 0" + FirstFloor.get(i) + " ");
                }else{
                    System.out.print(" [0" + FirstFloor.get(i) + "] ");
                }
            }
        }
        
        System.out.println("");
        
        for(int i = 0; i < SecondFloor.size(); i++){
            if(FirstFloorReservations.get(i) == 0){
                System.out.print(" " + FirstFloor.get(i) + " ");
            }else{
                System.out.print(" [" + FirstFloor.get(i) + "] ");
            }
        }
    }
}
