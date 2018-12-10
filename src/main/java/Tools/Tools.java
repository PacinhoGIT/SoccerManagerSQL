/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import DataBase.Constant;
import POJO.TEAMS;
import View.ResultView;
import Utils.SpringUtilities;
import View.View;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author patryk
 */
public class Tools {

    public static int START = 1;
    public static int STOP = 2;
    public static int DURATION = 3;

    public static long START_TIME;
    public static long STOP_TIME;
    public static long DURATION_TIME;

    public static void PrintTimeToConsole(int choice) {

        switch (choice) {
            case 1:
                System.out.println("Start : " + GetTime());
                START_TIME = System.nanoTime();
                break;
            case 2:
                System.out.println("Stop : " + GetTime());
                STOP_TIME = System.nanoTime();
                break;
            case 3:
                System.out.println("Duration : " + GetDuration());
                break;
        }

    }

    public static String GetTime() {
        return Constant.getTimeWithSecondsFormat().format(new Date());
    }

    public static long GetDuration() {
        long duration = (STOP_TIME - START_TIME);
        duration = TimeUnit.NANOSECONDS.toMillis(duration);
        START_TIME = 0;
        STOP_TIME = 0;
        DURATION_TIME = duration;
        return duration;
    }

    public static void PrintInfoToGUI() {
        long Duration = Tools.GetDuration();
        //Global.view.InfoTA.append("Time : " + Double.valueOf(Duration) / 1000 + " s\n");
        //Global.view.InfoTA.append(Strings.BlockSeparator + "\n");
    }

    public static void CompareArray(ArrayList a1, ArrayList a2) {
        if (a1.equals(a1)) {
            System.out.println("Array the same");
        } else {
            System.out.println("Arrays different");
        }
    }

    public static void SaveChartToFile(JFreeChart chart) {
        try {
            ChartUtilities.saveChartAsJPEG(new File("D:\\Charts\\chart.jpg"), chart, 500, 300);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ShowChart(JFreeChart chart, ArrayList<JFreeChart> charts) {

        JFrame f1 = new JFrame("Chart");
        f1.setSize(650, 600);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel jPanel1 = CreateChartPanel(chart);
        tabbedPane.add("Operation Time", jPanel1);

        JPanel systemPropPanel = new JPanel();
        ArrayList<JPanel> panels = new ArrayList<>();
        for (JFreeChart chart1 : charts) {
            panels.add(CreateChartPanel(chart1));
        }

        systemPropPanel = new JPanel();
        systemPropPanel.setLayout(new SpringLayout());
        for (JPanel p : panels) {
            systemPropPanel.add(p);
        }
        SpringUtilities.makeGrid(systemPropPanel,
                2, 2, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad

        tabbedPane.add("System Property", systemPropPanel);

        f1.add(tabbedPane);
        f1.setVisible(true);
    }

    private static JPanel CreateChartPanel(JFreeChart chart) {
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        jPanel1.add(CP, BorderLayout.CENTER);
        return jPanel1;
    }

    public static void TeamsResultsFrame(List<TEAMS> teams) {

        //ResultView resultView = new ResultView(teams);
        //resultView.setVisible(true);
    }
}
