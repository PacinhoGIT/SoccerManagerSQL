/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author patryk
 */
public class DBManager {

//    -------------------------------------------------
//    public static int FIREBIRD_CONNECTION = 1;
//    public static int SQLITE_CONNECTION = 2;
//    public static int MYSQL_CONNECTION = 3;
//    -------------------------------------------------
    private static Connection connection;
    private static PreparedStatement TeamsPST;
    private static PreparedStatement TeamsSortByValuePST;
    private static PreparedStatement TeamsSortByDatePST;
    private static PreparedStatement TeamsSortByValueInViewPST;
    private static PreparedStatement TeamsCountPST;
    private static PreparedStatement TeamsClassPST;
    private static PreparedStatement InsertTeamPST = null;

    public static Connection GetConnection() throws SQLException, ClassNotFoundException {

        if (connection == null) {
            connection = DriverManager.getConnection(Constant.getFirebirdDatabasePath(), Constant.getFirebirdUserName(), Constant.getFirebirdUserPassword());
        }

        return connection;
    }
    
      public static PreparedStatement GetTeamsCount() throws SQLException {

        if (TeamsCountPST == null) {
            TeamsCountPST = connection.prepareStatement(Queries.TeamsCountQuery);
        }
        return TeamsCountPST;
    }

    public static PreparedStatement GetAllTeamsPST() throws SQLException {

        if (TeamsPST == null) {
            TeamsPST = connection.prepareStatement(Queries.AllTeamsQuery);
        }
        return TeamsPST;
    }
     public static PreparedStatement GetAllTeamsSortByDatePST() throws SQLException {

        if (TeamsSortByDatePST == null) {
            TeamsSortByDatePST = connection.prepareStatement(Queries.AllTeamsSortByDateQuery);
        }
        return TeamsSortByDatePST;
    }

    public static PreparedStatement GetAllTeamsSortByValuePST() throws SQLException {

        if (TeamsSortByValuePST == null) {
            TeamsSortByValuePST = connection.prepareStatement(Queries.AllTeamsSortByValueQuery);
        }
        return TeamsSortByValuePST;
    }

    public static PreparedStatement GetAllTeamsSortByValueInViewPST() throws SQLException {

        if (TeamsSortByValueInViewPST == null) {
            TeamsSortByValueInViewPST = connection.prepareStatement(Queries.AllTeamsSortByValueInViewQuery);
        }
        return TeamsSortByValueInViewPST;
    }
    
     public static PreparedStatement GetTeamsClassPST() throws SQLException {

        if (TeamsClassPST == null) {
            TeamsClassPST = connection.prepareStatement(Queries.TeamClassQuery);
        }
        return TeamsClassPST;
    } 
     
      public static PreparedStatement GetInsertTeamPST() throws SQLException {

        if (InsertTeamPST == null) {
            InsertTeamPST = connection.prepareStatement(Queries.InsertTeamQuery);
        }
        return InsertTeamPST;
    } 

}
