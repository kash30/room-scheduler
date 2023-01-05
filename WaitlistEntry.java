import java.sql.Date;
import java.sql.Timestamp;


/**
 *
 * @author Kashish Gujral
 */
public class WaitlistEntry {
    private String Faculty;
    private String Date;
    private int Seats;
    private String currentTimestamp;




        
    public WaitlistEntry(String Faculty,String Date,int Seats,String currentTimestamp){
        setFaculty(Faculty);
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
    public void setDate(String Date){
        this.Date=Date;
    }
    public String getDate(){
        return Date;
    }
    public void setSeats(int Seats){
        this.Seats=Seats;
    }
    public int getSeats(){
        return Seats;
    }
}
   
    