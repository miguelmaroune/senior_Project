package army.handler;

import army.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserHandler {

    public static void update_meeting_status(Vector<String> v, Connection connection, String CurrentUser) throws SQLException {
//        "UPDATE meeting SET Meeting_Status = "+ v.get(3)+" WHERE Id_Meeting = "+v.get(0)  ;
      
        try {
            String query = "UPDATE meeting SET Meeting_Status = ? WHERE Id_Meeting = ? "  ;
                    

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, v.get(3));
            preparedStmt.setString(2, v.get(0));
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    the username must be the soldierID 
    public User getCurrUser() {
        User CurrentUser = User.getinstance();
        return CurrentUser;
    }

    public Vector<Vector<String>> getSchedule(Connection connection, String CurrentUser) throws SQLException {
        Vector<Vector<String>> sch = new Vector<Vector<String>>();

        try {
            String query = "SELECT Attendance_flag , Full_Date "
                    + "FROM workdays w , calender c "
                    + " where w.Calender_Id = c.Calender_Id  "
                    + " and w.Soldier_Id = " + CurrentUser
                    + " ORDER BY Full_Date DESC";
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Attendance_flag"));
                day.add(rs.getString("Full_Date"));
                sch.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sch;
    }

    public HashMap<String, Vector<Vector<String>>> getTask(Connection connection, String CurrentUser) throws SQLException {
//        Vector<String> tasks = new Vector<String>();
        HashMap<String, Vector<Vector<String>>> tasks = new HashMap<>();
        try {
            String query = "SELECT Date_Assigned ,Task_duration,Description,Reference "
                    + "FROM assigned_task  a, task t "
                    + " WHERE a.Task_Id = t.Task_Id  "
                    + " AND   a.Soldier_Id = " + CurrentUser
                    + " ORDER BY Date_Assigned DESC ";
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            String FULL_DATE;

            while (rs.next()) {
                Vector<Vector<String>> dataAll = new Vector<>();
                Vector<String> task = new Vector<>();
                task.add(rs.getString("Task_duration"));
                task.add(rs.getString("Description"));
                task.add(rs.getString("Reference"));
                FULL_DATE = rs.getString("Date_Assigned");
                FULL_DATE = FULL_DATE.replace("-", "");
//               
                dataAll.add(task);
                if (tasks.containsKey(FULL_DATE)) {
                    dataAll = tasks.get(FULL_DATE);
                    dataAll.add(task);
                    tasks.put(FULL_DATE, dataAll);
                } else {
                    tasks.put(FULL_DATE, dataAll);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;
    }

    public ArrayList<String> dailyTasks(Connection connection, String CurrentUser) throws SQLException {
        ArrayList<String> dailyTask = new ArrayList<>();

        try {
            String query = "SELECT Description,Reference "
                    + "FROM assigned_task  a, task t "
                    + " WHERE a.Task_Id = t.Task_Id  "
                    + " AND   a.Soldier_Id = " + CurrentUser
                    + " AND  Date_Assigned = CURDATE() ";
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dailyTask.add(rs.getString("Description") + ";" + rs.getString("Reference"));

            } 

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dailyTask;
    }

    public void request_meeting(Connection connection, String CurrentUser, String request) throws SQLException {
        //pending date_NotSet
        try {
            String query = " insert into meeting (Meeting_Date ,Meeting_Subject,Meeting_Result, Meeting_Status, Soldier_Id)"
                    + " values (?, ?, ?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, "");
            preparedStmt.setString(2, request);
            preparedStmt.setString(3, " ");
            preparedStmt.setString(4, "Pending Date_NotSet");
            preparedStmt.setString(5, CurrentUser);

            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<Vector<String>> check_meeting(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting,Meeting_Subject,Meeting_Status ,COALESCE(NULLIF(Meeting_Date, ''), 'NOT SET') "
                    + "AS Meeting_Date  "
                    + "FROM meeting"
                    + " where Soldier_Id = " + CurrentUser
                    +" AND Meeting_Status IN('Pending Date_NotSet','Pending Date_Set')";
                     
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Meeting_Subject"));
                day.add(rs.getString("Meeting_Status"));
                day.add(rs.getString("Meeting_Date"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    public Vector<Vector<String>> meetings_history(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result "
                    + "FROM meeting "
                    + "WHERE Meeting_Result <> '' "
                    + " AND Soldier_Id = " + CurrentUser;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Meeting_Subject"));
                day.add(rs.getString("Meeting_Status"));
                day.add(rs.getString("Meeting_Date"));
                day.add(rs.getString("Meeting_Result"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    public Vector<Object> ViewProfile(Connection connection, String CurrentUser) throws SQLException {
        Vector<Object> prof = new Vector<>();

        try {
            String query = "SELECT Soldier_Id , Platoon_Id , First_Name , Last_Name , "
                    + "  Phone_Number , Rank , Position , Available ,DOB ,"
                    + "  Blood_Type , image "
                    + " FROM soldier "
                    + " WHERE Soldier_Id = " + CurrentUser;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                prof.add(rs.getInt("Soldier_Id"));
                prof.add(rs.getInt("Platoon_Id"));
                prof.add(rs.getString("First_Name"));
                prof.add(rs.getString("Last_Name"));
                prof.add(rs.getInt("Phone_Number"));
                prof.add(rs.getString("Rank"));
                prof.add(rs.getString("Position"));
                prof.add(rs.getInt("Available"));
                prof.add(rs.getString("DOB"));
                prof.add(rs.getString("Blood_Type"));
                prof.add(rs.getBlob("image"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prof;

    }

    public Vector<Vector<String>> training(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

//        SELECT description , reference , start , end , location  , Evaluation 
//FROM achieve_training a, training t 
//WHERE a.training_Id = t.training_Id 
        try {
            String query = "SELECT description , reference , start , end , location , Evaluation "
                    + "FROM achieve_training a, training t "
                    + "WHERE a.training_Id = t.training_Id "
                    + " AND a.Soldier_Id = " + CurrentUser;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("description"));
                day.add(rs.getString("reference"));
                day.add(rs.getString("start"));
                day.add(rs.getString("end"));
                day.add(rs.getString("location"));
                day.add(rs.getString("Evaluation"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    public Vector<Vector<String>> rest(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

//        SELECT description , reference , start , end , location  , Evaluation 
//FROM achieve_training a, training t 
//WHERE a.training_Id = t.training_Id 
        try {
            String query = "SELECT Type_Rest , Reference_Rest , Start , End , Cause  "
                    + "FROM rest "
                    + "WHERE Soldier_Id = " + CurrentUser;

//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Type_Rest"));
                day.add(rs.getString("Reference_Rest"));
                day.add(rs.getString("start"));
                day.add(rs.getString("end"));
                day.add(rs.getString("Cause"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    public Vector<Vector<String>> sanctions(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

//SELECT  description , start , end , duration , executed , date_Commited , deduction , status
//FROM execute_sanction e , sanction s 
//WHERE e.Sanction_ID = S.Sanction_ID
        try {
            String query = "SELECT description,reference , start , end , e.duration , executed , date_Commited , deduction , status  "
                    + "FROM execute_sanction e , sanction s "
                    + "WHERE e.Sanction_ID = S.Sanction_ID"
                    + " AND   e.Soldier_Id = " + CurrentUser;

//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("description"));
                day.add(rs.getString("reference"));
                day.add(rs.getString("start"));
                day.add(rs.getString("end"));
                day.add(rs.getString("duration"));
                day.add(rs.getString("executed"));
                day.add(rs.getString("date_Commited"));
                day.add(rs.getString("deduction"));
                day.add(rs.getString("status"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

     

    public Vector<Vector<String>> Secretary_meeting(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();
//        

        try {
            String query = "SELECT Id_Meeting,Soldier_id,Meeting_Subject,Meeting_Status ,COALESCE(NULLIF(Meeting_Date, ''), 'NOT SET') "
                    + "AS Meeting_Date  "
                    + " FROM meeting "
                    + " WHERE Meeting_Status <> 'Accomplished'"
                    + " AND Meeting_Status <> 'canceled'";
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Soldier_id"));
                day.add(rs.getString("Meeting_Subject"));
                day.add(rs.getString("Meeting_Status"));
                day.add(rs.getString("Meeting_Date"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    public void update_meeting_Date(Vector<String> v, Connection con, String username) throws SQLException {
   try {
            String query = "UPDATE meeting SET Meeting_Date = ? WHERE Id_Meeting = ? "  ;
                    

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, v.get(4));
            preparedStmt.setString(2, v.get(0));
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    public static void update_meeting_Result(Vector<String> v, Connection connection, String CurrentUser) throws SQLException {
//        "UPDATE meeting SET Meeting_result = "+ v.get(5)+" WHERE Id_Meeting = "+v.get(0)  ;
      
        try {
            String query = "UPDATE meeting SET Meeting_Result = ? WHERE Id_Meeting = ? "  ;
                    

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, v.get(5));
            preparedStmt.setString(2, v.get(0));
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Vector<Vector<String>> meetings_historyid(Connection connection, String Currentid) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result "
                    + "FROM meeting "
                    + "WHERE "
                    + " id_Meeting = " + Currentid;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Meeting_Subject"));
                day.add(rs.getString("Meeting_Status"));
                day.add(rs.getString("Meeting_Date"));
                day.add(rs.getString("Meeting_Result"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    
    
    public Vector<Vector<String>> meetings_historyall(Connection connection) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result "
                    + "FROM meeting "
                    ;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Meeting_Subject"));
                day.add(rs.getString("Meeting_Status"));
                day.add(rs.getString("Meeting_Date"));
                day.add(rs.getString("Meeting_Result"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    
    
}


 