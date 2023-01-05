import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Kashish Gujral
 */
public class ReservationEntry {
    
    private String Faculty;
    private String Room;
    private String Date;
    private int Seats;
    private String currentTimestamp;
    
    
    public ReservationEntry(String Faculty,String Room,String Date,int Seats,String currentTimestamp){
        setFaculty(Faculty);
        setRoom(Room);
        setDate(Date);
        setSeats(Seats);
        setTimestamp(currentTimestamp);
    }
    public void setFaculty(String Faculty){
        this.Faculty=Faculty;
    }
    public String getFaculty(){
        return Faculty;
    }
    public void setTimestamp(String currentTimestamp){
        this.currentTimestamp=currentTimestamp;
    }
    public String getTimestamp(){
        return currentTimestamp;
    }
    public void setRoom(String Room){
        this.Room=Room;
    }
    public String getRoom(){
        return Room;
    }
    public void setSeats(int Seats){
        this.Seats=Seats;
    }
    public int getSeats(){
        return Seats;
    }
    
    public void setDate(String Date){
        this.Date=Date;
    }
    public String getDate(){
        return Date;
    }
    
    
}

