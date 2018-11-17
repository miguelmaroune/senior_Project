package army.handler;

import army.model.User;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserHandler {
 
 //    the username must be the soldierID 
    public User getCurrUser() {
        User CurrentUser = User.getinstance();
        return CurrentUser;
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
    
    
    
    //notsorted
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
    public Vector<Vector<String>> search(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            
            String query = "SELECT  s.Soldier_Id , First_Name , Last_Name , Rank , DOB , Platoon_Id , Phone_Number , Position , Blood_Type  , "
                    + "    IFNULL(e.reference , '') as reference , IFNULL(t.description , '') as description "
                    + " FROM soldier s"
                    + " LEFT OUTER JOIN execute_sanction e ON s.Soldier_id = e.Soldier_id "
                    + " LEFT JOIN achieve_training a ON s.Soldier_id = a.Soldier_id "
                    + " LEFT JOIN TRAINING  t on t.training_Id = a.training_id ";
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("First_Name"));
                day.add(rs.getString("Last_Name"));
                day.add(rs.getString("Rank"));
                day.add(rs.getString("DOB"));
                day.add(rs.getString("Platoon_Id"));
                day.add(rs.getString("Phone_Number"));
                day.add(rs.getString("Position"));
                day.add(rs.getString("Blood_Type"));
                day.add(rs.getString("reference"));
                day.add(rs.getString("description"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public Vector<Vector<String>> search_param(Connection connection, String CurrentUser , String choice , String soldiertbl , String trainingtbl, String sanctiontbl) throws SQLException {
//
//String query = "SELECT name,companyname,phone,email"
//					+ (fuzzyName != null ? ",similarity(name,'"+fuzzyName+"') AS nameSimilarity" : "") 
//					+ (company != null ? ",similarity(companyname,'"+company+"') AS companySimilarity" : "")
//					+ " from customer where 1=1 "
//					+ (fuzzyName != null ? " AND similarity(name,'"+fuzzyName+"') >= " + SettingsManager.customerMatchingSimilarity : "")
//					+ (company != null ? " AND similarity(companyname,'"+company+"') >= " + SettingsManager.customerMatchingSimilarity : "")
//					+ " ORDER BY " + getOrderByString(fuzzyName, company) + " Desc limit " + SettingsManager.customerSearchLimit;

        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String where_clause = (!soldiertbl.trim().isEmpty()  ? 
                    "AND S." +choice + " = '"+soldiertbl+"'  ": " ") ;
            String trn = (!trainingtbl.trim().isEmpty()   ? 
                    "AND training_id  = '"+trainingtbl+"'  ":
                    " ");
                    
                     
           String san=  ( !sanctiontbl.trim().isEmpty()  ? 
                    "AND sanction_id  = '"+sanctiontbl+"'  "
                     : " ");
// SELECT  s.Soldier_Id , First_Name , Last_Name , Rank , DOB , Platoon_Id , Phone_Number , Position , Blood_Type  ,     IFNULL(e.reference , '') as reference , IFNULL(t.description , '') as sanction  FROM soldier s LEFT OUTER JOIN execute_sanction e ON s.Soldier_id = e.Soldier_id  LEFT JOIN achieve_training a ON s.Soldier_id = a.Soldier_id
//LEFT JOIN TRAINING  t on t.training_Id
//= a.training_id WHERE 1 = 1   AND sanction_id  = '1'             
//            
            
            String query = "SELECT  s.Soldier_Id , First_Name , Last_Name , Rank , DOB , Platoon_Id , Phone_Number , Position , Blood_Type  , "
                    + "    IFNULL(e.reference , '') as reference , IFNULL(t.description , '') as description "
                    + " FROM soldier s"
                    + " LEFT OUTER JOIN execute_sanction e ON s.Soldier_id = e.Soldier_id "
                    + " LEFT JOIN achieve_training a ON s.Soldier_id = a.Soldier_id "
                    + " LEFT JOIN TRAINING  t on t.training_Id = a.training_id "
                    + " WHERE 1 = 1 "
                    + where_clause
                    +trn
                    +san;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("First_Name"));
                day.add(rs.getString("Last_Name"));
                day.add(rs.getString("Rank"));
                day.add(rs.getString("DOB"));
                day.add(rs.getString("Platoon_Id"));
                day.add(rs.getString("Phone_Number"));
                day.add(rs.getString("Position"));
                day.add(rs.getString("Blood_Type"));
                day.add(rs.getString("reference"));
                day.add(rs.getString("description"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    } 

    
//task methods
 public Vector<Vector<String>> tasksearchbyaid(Connection connection, String aid) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT * from assigned_task where Assignement_id ="+ aid;
          
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("Date_Assigned"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("report"));
            
            chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
 public Vector<Vector<String>> tasksearchbyMid(Connection connection, String Mid) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT * from assigned_task where Soldier_id ="+ Mid;
          
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("Date_Assigned"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("report"));
            
            chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
 public Vector<Vector<String>> tasksearchall(Connection connection) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT * from assigned_task" ;
          
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("Date_Assigned"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("report"));
            
            chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
 public Vector<Vector<String>> tasksearchbydate(Connection connection,String x) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT * from assigned_task where Date_Assigned =' "+ x+"'";
          
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("Date_Assigned"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("report"));
            
            chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
 public static void addtask(Vector<String> v, Connection connection) throws SQLException {

      
        try {
            String query = "INSERT INTO `assigned_task`(`Task_Id`,`Soldier_Id`,`Date_Assigned`,`Reference`,`report`,`Status`,`highlights`) VALUES (?,?,?,?,?,?,?)"  ;
                    
// order from the table Assignement_id,Task_Id,Soldier_Id,Date_Assigned,Reference,Status,highlights,report
            // create the mysql insert preparedstatement                           
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, v.get(0));
            preparedStmt.setString(2, v.get(1));
            preparedStmt.setString(3, v.get(2));
            preparedStmt.setString(4, v.get(3));
            preparedStmt.setString(5, v.get(6));
            preparedStmt.setString(6, v.get(4));
            preparedStmt.setString(7, v.get(5));
           
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Added Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
 public static void updatetask(Vector<String> v, Connection connection) throws SQLException {

      
        try {
            String query = "UPDATE `assigned_task` SET `Task_Id`=?,"
                    + "`Soldier_Id`=?,`Date_Assigned`=?,"
                    + "`Reference`=?,`report`=?,`Status`=?,"
                    + "`highlights`=? WHERE `Assignement_Id`=?"  ;
                    
        // order from the database Assignement_id,Task_Id,Soldier_Id,Date_Assigned,Reference,report,Status,highlights
            // create the mysql insert preparedstatement                           
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, v.get(1));
            preparedStmt.setString(2, v.get(2));
            preparedStmt.setString(3, v.get(3));
            preparedStmt.setString(4, v.get(4));
            preparedStmt.setString(5, v.get(7));
            preparedStmt.setString(6, v.get(5));
            preparedStmt.setString(7, v.get(6));
            preparedStmt.setString(8, v.get(0));
        //order from the gui   ass id ,task id,soldier id ,date,reference,status ,highlight,report
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
 public static void deletetask(Vector<String> v, Connection connection) throws SQLException {
try {
            String query = "DELETE FROM `assigned_task` WHERE `Assignement_Id`=?"  ;
                    
        // order from the database Assignement_id,Task_Id,Soldier_Id,Date_Assigned,Reference,report,Status,highlights
            // create the mysql insert preparedstatement                           
            PreparedStatement preparedStmt = connection.prepareStatement(query);
           
            preparedStmt.setString(1, v.get(0));
        //order from the gui   ass id ,task id,soldier id ,date,reference,status ,highlight,report
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
 }
 public Vector<Vector<String>> checkowndailytask(Connection connection, String CurrentUser) throws SQLException {
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Assignement_id,Task_Id,Status,Reference,report,highlights,`Date_Assigned`\n" +
"                   \n" +
"                   FROM assigned_task\n" +
"                   where Soldier_Id =" +CurrentUser+
"                     AND  Date_Assigned = CURDATE() " +
"                     AND Status IN('unfinished')";
                     
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("report"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("Date_Assigned"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            System.out.println("test test test :"+ex);
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
public void update_report(Vector<String> v, Connection con, String username) throws SQLException {
   try {
            String query = "UPDATE assigned_task SET report = ? WHERE Assignement_Id = ? "  ;
                    

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, v.get(5));
            preparedStmt.setString(2, v.get(0));
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public Vector<Vector<String>> tasksearchbyplatoon(Connection connection,String user) throws SQLException {

        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT * from assigned_task" ;
          //and where platoonid =current platoonid
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Vector<String> day = new Vector<String>();
                day.add(rs.getString("Assignement_id"));
                day.add(rs.getString("Task_Id"));
                day.add(rs.getString("Soldier_Id"));
                day.add(rs.getString("Date_Assigned"));
                day.add(rs.getString("Reference"));
                day.add(rs.getString("Status"));
                day.add(rs.getString("highlights"));
                day.add(rs.getString("report"));
            
            chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

 //meeting methods
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
public static void update_meeting_Result(Vector<String> v, Connection connection, String CurrentUser) throws SQLException {

      
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
public void request_meeting(Connection connection, String CurrentUser, String request) throws SQLException {
        //pending date_NotSet
        try {
            String query = " insert into meeting (Meeting_Date ,Meeting_Subject,Meeting_Result, Meeting_Status, Soldier_Id)"
                    + " values (?, ?, ?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, "");
            preparedStmt.setString(2, request);
            preparedStmt.setString(3, "");
            preparedStmt.setString(4, "Pending date not set");
            preparedStmt.setString(5, CurrentUser);

            // execute the preparedstatement
            preparedStmt.execute();
JOptionPane.showMessageDialog(null, "Request sent");
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public Vector<Vector<String>> meetings_historymeetingid(Connection connection, String Currentid) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result, Soldier_Id "
                    + "FROM meeting "
                    + "WHERE "
                    + " Id_Meeting = " + Currentid;
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
                day.add(rs.getString("Soldier_Id"));
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
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result ,Soldier_Id"
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
                day.add(rs.getString("Soldier_Id"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
public Vector<Vector<String>> showallpendingmeetings(Connection connection, String CurrentUser) throws SQLException {
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
public Vector<Vector<String>> checkownmeeting(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting,Meeting_Subject,Meeting_Status ,COALESCE(NULLIF(Meeting_Date, ''), 'NOT SET') "
                    + "AS Meeting_Date  "
                    + "FROM meeting"
                    + " where Soldier_Id = " + CurrentUser
                    +" AND Meeting_Status IN('Pending date not set','Pending date set')";
                     
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
public Vector<Vector<String>> meetings_historystatus(Connection connection, String x) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result,Soldier_Id "
                    + "FROM meeting "
                    + "WHERE "
                    + " Meeting_Status = " + x;
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
                day.add(rs.getString("Soldier_Id"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
public Vector<Vector<String>> meetingsearchbydate(Connection connection, String x) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result, Soldier_Id "
                    + "FROM meeting "
                    + "WHERE "
                    + " Meeting_Date = '" + x+"'";
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
                day.add(rs.getString("Soldier_Id"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
public Vector<Vector<String>> meetings_historymilitaryid(Connection connection, String CurrentUser) throws SQLException {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting , Meeting_Subject , Meeting_Status , Meeting_Date , Meeting_Result,Soldier_Id "
                    + "FROM meeting "
                    + "WHERE  "
                    + " Soldier_Id = " + CurrentUser;
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
                day.add(rs.getString("Soldier_Id"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }




}
