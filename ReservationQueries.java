import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;


/**
 *
 * @author Kashish Gujral
 */
public class ReservationQueries {
    private static Connection connection;
    private static PreparedStatement getReservationsByDate;
    private static PreparedStatement getRoomsReservedByDate;
    private static PreparedStatement addReservationEntry;
    private static PreparedStatement cancelReservation;
    private static PreparedStatement getReservationsByFaculty;
    private static PreparedStatement deleteReservation;
    
    private static ResultSet resultSet;
    
    public static ArrayList<ReservationEntry> getReservationsByFaculty(String faculty){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservations=new ArrayList<ReservationEntry>();
        try{
            getReservationsByFaculty=connection.prepareStatement("SELECT FACULTY,ROOM,DATE,SEATS,TIME FROM RESERVATIONS WHERE FACULTY=? order by FACULTY");
            getReservationsByFaculty.setString(1,faculty);
            resultSet=getReservationsByFaculty.executeQuery();
            
            while(resultSet.next()){
                reservations.add(new ReservationEntry(
                resultSet.getString("FACULTY"),
                resultSet.getString("ROOM"),
                resultSet.getString("DATE"),
                resultSet.getInt("SEATS"),
                resultSet.getString("TIME")));
                
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return reservations;
                
        }
    
   
    
    public static void addReservationEntry(String faculty,String room,String date,int seats,Timestamp currentTimestamp)
    {
        connection = DBConnection.getConnection();
        //currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        try
        {
            addReservationEntry = connection.prepareStatement("insert into RESERVATIONS(FACULTY,ROOM,DATE,SEATS,TIME)values(?,?,?,?,?)");
            addReservationEntry.setString(1,faculty);
            addReservationEntry.setString(2,room);
            addReservationEntry.setString(3,date);
            addReservationEntry.setInt(4,seats);
            addReservationEntry.setString(5,currentTimestamp.toString());
            addReservationEntry.executeUpdate();
        }
        catch(Exception sqlException)
        {
            JOptionPane.showMessageDialog(null, sqlException);
        }
        
    }
    
    public static ArrayList<String> getRoomsReservedByDate(String date){
 
        connection = DBConnection.getConnection();
        ArrayList<String> reservedDates = new ArrayList<String>();

        try{
            getRoomsReservedByDate=connection.prepareStatement("SELECT ROOM FROM RESERVATIONS WHERE DATE=? order by DATE");
            getRoomsReservedByDate.setString(1,date);
            resultSet=getRoomsReservedByDate.executeQuery();
            while(resultSet.next())
            {
                reservedDates.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return reservedDates;
        
        
    }
    public static ArrayList<String> getRoomsReserved(){
         connection = DBConnection.getConnection();
        ArrayList<String> reservedrooms = new ArrayList<String>();

        try{
            PreparedStatement getRoomsReserved=connection.prepareStatement("SELECT ROOM FROM RESERVATIONS order by DATE");
            resultSet=getRoomsReserved.executeQuery();
            while(resultSet.next())
            {
                reservedrooms.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return reservedrooms;
        
    }
    public static ArrayList<String> getFacultyOnReservationList(){
         connection = DBConnection.getConnection();
        ArrayList<String> faculty = new ArrayList<String>();

        try{
            PreparedStatement getFacultyOnReservationList=connection.prepareStatement("SELECT FACULTY FROM RESERVATIONS");
            resultSet=getFacultyOnReservationList.executeQuery();
            while(resultSet.next())
            {
                faculty.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return faculty;
        
    }
    public static ArrayList<String> getFacultybyReservedDates(String date){
 
        connection = DBConnection.getConnection();
        ArrayList<String> reservedfaculty = new ArrayList<String>();

        try{
            getRoomsReservedByDate=connection.prepareStatement("SELECT FACULTY FROM RESERVATIONS WHERE DATE=? order by DATE");
            getRoomsReservedByDate.setString(1,date);
            resultSet=getRoomsReservedByDate.executeQuery();
            while(resultSet.next())
            {
                reservedfaculty.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return reservedfaculty;
        
        
    }
    
    public static void cancelReservation(String faculty,String date){
        connection = DBConnection.getConnection();
        try
        {
            cancelReservation=connection.prepareStatement("DELETE FROM RESERVATIONS WHERE FACULTY=? AND DATE=?");
            cancelReservation.setString(1,faculty);
            cancelReservation.setString(2,date);
            cancelReservation.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        

    }
    public static void deleteReservation(String roomname){
        connection = DBConnection.getConnection();
        try
        {
            //System.out.println("ROOM: "+roomname);
            deleteReservation=connection.prepareStatement("DELETE FROM JAVA.RESERVATIONS WHERE ROOM=?");
            deleteReservation.setString(1,roomname);
            deleteReservation.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        

    }
    
    public static ArrayList<ReservationEntry> getReservationsByDate(String date){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservationlist=new ArrayList<>();
        try{
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            PreparedStatement getReservationsByDate=connection.prepareStatement("Select * FROM RESERVATIONS WHERE DATE=?");
            getReservationsByDate.setString(1,date);
            resultSet=getReservationsByDate.executeQuery();
            
            while(resultSet.next()){
            reservationlist.add(new ReservationEntry(resultSet.getString("FACULTY"),resultSet.getString("ROOM"),resultSet.getString("DATE"),resultSet.getInt("SEATS"),resultSet.getString("TIME")));
            
            
        }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return reservationlist;
    
    }
    public static ArrayList<ReservationEntry> getReservationsByRoom(String  roomname){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservationlist=new ArrayList<>();
        try{
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            PreparedStatement getReservationsByRoom=connection.prepareStatement("Select * FROM RESERVATIONS WHERE ROOM=?");
            getReservationsByRoom.setString(1,roomname);
            resultSet=getReservationsByRoom.executeQuery();
            
            while(resultSet.next()){
            reservationlist.add(new ReservationEntry(resultSet.getString("FACULTY"),resultSet.getString("ROOM"),resultSet.getString("DATE"),resultSet.getInt("SEATS"),resultSet.getString("TIMESTAMP")));
            
            
        }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return reservationlist;
    
    }
    
}