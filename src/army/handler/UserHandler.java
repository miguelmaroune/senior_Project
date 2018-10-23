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

    public void request_meeting(Connection connection, String CurrentUser, String request) {
        //pending date_NotSet
        try {
            String query = " insert into meeting (Meeting_Subject, Meeting_Status, Soldier_Id)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, request);
            preparedStmt.setString(2, "Pending Date_NotSet");
            preparedStmt.setString(3, CurrentUser);

            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<Vector<String>> check_meeting(Connection connection, String CurrentUser) {
//
        Vector<Vector<String>> chk = new Vector<Vector<String>>();

        try {
            String query = "SELECT Id_Meeting,COALESCE(NULLIF(Meeting_Date, ''), 'NOT SET') "
                    + "AS Meeting_Date ,Meeting_Status  "
                    + "FROM meeting"
                    + " where Soldier_Id = " + CurrentUser;
//               
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<String> day = new Vector<String>();
                day.add(rs.getString("Id_Meeting"));
                day.add(rs.getString("Meeting_Date"));
                day.add(rs.getString("Meeting_Status"));
                chk.add(day);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
}
