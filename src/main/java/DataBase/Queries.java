/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.PreparedStatement;

/**
 *
 * @author patryk
 */
public class Queries {

    public static String AllTeamsQuery = "Select ID,Name,team_value,founded_date,founder from Teams";
    public static String AllTeamsSortByValueQuery = "Select  ID,Name,team_value,founded_date,founder from Teams order by team_value asc";
    public static String AllTeamsSortByDateQuery = "Select  ID,Name,team_value,founded_date,founder from Teams order by founded_date desc";
    public static String AllTeamsSortByValueInViewQuery = "Select ID,Name,team_value,founded_date,founder from TEAMSORTBYVALUE";
    public static String TeamsCountQuery ="Select count(t.id) from teams t";
    public static String TeamClassQuery = "select tcv.* from teamvalueclass tcv";
    public static String InsertTeamQuery = "Insert into teams(NAME,FOUNDED_DATE,FOUNDER,TEAM_VALUE) values (?,?,?,?)";

}
