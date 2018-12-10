/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author patryk
 */
@Data

public class TEAMS {

    private int ID;
    private String NAME;
    private Double TEAM_VALUE;
    private String FOUNDER;
    private Date FOUNDED_DATE;
    private String WORLD_CLASS;

    public TEAMS() {
        WORLD_CLASS = "";
    }

    public int compareTo(Date o) {
        return this.FOUNDED_DATE.compareTo(o);
    }
}
