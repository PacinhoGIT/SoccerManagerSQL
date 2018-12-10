/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import lombok.Getter;

/**
 *
 * @author patryk
 */
public class Constant {

    @Getter
    private static String FirebirdDatabasePath = "jdbc:firebirdsql:localhost:D:\\Database\\DB_FIREBIRD.FDB?encoding=WIN1250";
    @Getter
    private static String FirebirdUserName = "sysdba";
    @Getter
    private static String FirebirdUserPassword = "masterkey";
    @Getter
    private static SimpleDateFormat TimeWithSecondsFormat = new SimpleDateFormat("HH:mm:ss:SSS");

}
