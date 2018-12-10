/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Tools.Global;
import Tools.RandomData;
import Tools.Tools;
import java.sql.PreparedStatement;

/**
 *
 * @author patryk
 */
public class InsertData {

    public static boolean InserTeam(int count) {

        Global.view.Progress.setMaximum(count);
        Tools.START_TIME = System.nanoTime();
        try {
            PreparedStatement pst = DBManager.GetInsertTeamPST();
            for (int i = 0; i < count; i++) {
                String name = RandomData.randomString(RandomData.randomNumber(5, 40));
                java.sql.Date date = new java.sql.Date(RandomData.randomDate().getTime());
                String founder = RandomData.randomString(RandomData.randomNumber(5, 10)) + " " + RandomData.randomString(RandomData.randomNumber(5, 10));
                Double value = RandomData.randomDouble(1, 1000);
                pst.clearParameters();
                pst.setString(1, name);
                pst.setDate(2, date);
                pst.setString(3, founder);
                pst.setDouble(4, value);
                pst.executeUpdate();
                Global.view.Progress.setValue(i + 1);
            }
        } catch (Exception ex) {
            System.out.println("Insert Team error " + ex.getMessage());
            return false;

        }
        Tools.STOP_TIME = System.nanoTime();
        Tools.PrintInfoToGUI();
        Global.OperationTime.add(Double.valueOf(Tools.DURATION_TIME).toString());
        return true;
    }
}
