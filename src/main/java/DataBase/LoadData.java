/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import POJO.TEAMS;
import Tools.Global;
import Tools.Strings;
import Tools.Tools;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author patryk
 */
public class LoadData {

    private static boolean team_class = false;

    public static int GetTeamsCount() {
        int count = 0;
        try {
            ResultSet rs = DBManager.GetTeamsCount().executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }
        return count;
    }

    private static ArrayList<TEAMS> Team(PreparedStatement stm) {
        ArrayList<TEAMS> teams = new ArrayList<>();

        try {
            PreparedStatement teamsPST = stm;
            ResultSet teamsRS = teamsPST.executeQuery();

            int count = 0;
            while (teamsRS.next()) {
                TEAMS team = new TEAMS();
                team.setID(teamsRS.getInt("ID"));
                team.setNAME(teamsRS.getString("Name"));
                team.setTEAM_VALUE(teamsRS.getDouble("team_value"));
                team.setFOUNDED_DATE(teamsRS.getDate("founded_date"));
                team.setFOUNDER(teamsRS.getString("founder"));
                if (team_class) {
                    team.setWORLD_CLASS(teamsRS.getString("CLASSVALUE"));
                }
                teams.add(team);

                count++;
                //Global.view.Progress.setValue(count);
            }
            System.out.println("Rows count : " + count);
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }

        return teams;
    }

    public static ArrayList<TEAMS> GetAllTeam(boolean calc_time) throws SQLException {

        ArrayList<TEAMS> teams = null;

        if (calc_time) {
            Tools.START_TIME = System.nanoTime();
            teams = Team(DBManager.GetAllTeamsPST());
            Tools.STOP_TIME = System.nanoTime();
            Tools.PrintInfoToGUI();
            Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        } else {
            teams = Team(DBManager.GetAllTeamsPST());
        }
        System.out.println(Strings.BlockSeparator);
        return teams;

    }

    //Order by Value ASC
    public static ArrayList<TEAMS> GetAllTeamsSortByValueSQL() throws SQLException {

        System.out.println("All Teams Sort By Value SQL");
        ArrayList<TEAMS> teams = null;

        Tools.START_TIME = System.nanoTime();
        teams = Team(DBManager.GetAllTeamsSortByValuePST());
        Tools.STOP_TIME = System.nanoTime();
        Tools.PrintInfoToGUI();

        Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        return teams;
    }
    
    //Order by Date DESC
    public static ArrayList<TEAMS> GetAllTeamsSortByDateSQL() throws SQLException {

        System.out.println("All Teams Sort By Date SQL");
        ArrayList<TEAMS> teams = null;
        Tools.START_TIME = System.nanoTime();
        teams = Team(DBManager.GetAllTeamsSortByDatePST());
        Tools.STOP_TIME = System.nanoTime();
        Tools.PrintInfoToGUI();

        Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        return teams;
    }

    public static ArrayList<TEAMS> GetAllTeamsSortByValueInViewSQL() throws SQLException {

        System.out.println("All Teams Sort By Value in View SQL");
        ArrayList<TEAMS> teams = null;
        Tools.START_TIME = System.nanoTime();
        teams = Team(DBManager.GetAllTeamsSortByValueInViewPST());
        Tools.STOP_TIME = System.nanoTime();
        Tools.PrintInfoToGUI();
        Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        return teams;
    }

    public static ArrayList<TEAMS> GetTeamClassSQL() throws SQLException {

        team_class = true;
        System.out.println("Calculate Team Class using Procedure in View");
        ArrayList<TEAMS> teams = null;
        Tools.START_TIME = System.nanoTime();
        teams = Team(DBManager.GetTeamsClassPST());
        Tools.STOP_TIME = System.nanoTime();
        Tools.PrintInfoToGUI();
        Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        team_class = false;

        return teams;
    }

}
