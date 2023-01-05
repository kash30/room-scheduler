import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Kashish Gujral
 */
public class Dates {
        private static Connection connection;
        private static ArrayList<String> dates = new ArrayList<String>();
        private static PreparedStatement addDate;
        private static PreparedStatement getAllDates;
        private static ResultSet resultSet;
        
        public static void addDate(String date){

            connection = DBConnection.getConnection();
            
            try{
                //Date day = Date.valueOf(bookDaysCombo.getSelectedItem().toString());
                //java.util.Date date=new java.util.Date();
                //java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                addDate = connection.prepareStatement("insert into DATES(DATE) values (?)");
                addDate.setString(1,date);
                addDate.executeUpdate();

            }
            catch(SQLException sqlException)
        {
            JOptionPane.showConfirmDialog(null, sqlException);
        }
        
    }
        public static ArrayList<String> getAllDates(){
            connection = DBConnection.getConnection();
            ArrayList<String> dates = new ArrayList<String>();
        try
        {
            getAllDates = connection.prepareStatement("select DATE from DATES order by DATE");
            resultSet = getAllDates.executeQuery();
            
            while(resultSet.next())
            {
                dates.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return dates; 
            
        }
 

}


