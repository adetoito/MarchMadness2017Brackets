package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanTeams = new Scanner(new File("src/com/company/Teams.csv"));
        ArrayList teams = new ArrayList();
        while (scanTeams.hasNextLine()) {
            String line = scanTeams.nextLine(); // Takes the line that the scanner is reading.
            String [] divisions = line.split(","); // Splits the line into a String array at a comma.
            teams.add(new Team(divisions[1], 1, 1, Integer.parseInt(divisions[0])));
            /*
            Above:
            - Adds information into a Team object
            - Appends object into ArrayList
            - Win/Loss is set to 1 due to insufficient information (for now)
             */
        }

        Scanner scanResults = new Scanner(new File("src/com/company/RegularSeasonCompactResults.csv"));
        while (scanResults.hasNextLine()) {
            String line = scanResults.nextLine();
            String [] divisions = line.split(",");
            //Season,Daynum,Wteam,Wscore,Lteam,Lscore,Wloc,Numot
            for (int i = 0; i < teams.size(); i++) {
                Team temp = (Team)teams.get(i);
                int ID = temp.teamID;
                if (ID == Integer.parseInt(divisions[2])) {
                    temp.addWin();
                }
                if (ID == Integer.parseInt(divisions[4])) {
                    temp.addLoss();
                }
            }
        }
    }
}
