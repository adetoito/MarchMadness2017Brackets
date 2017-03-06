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
            teams.add(new Team(divisions[1],  Integer.parseInt(divisions[0])));
        }

        Scanner scanResults = new Scanner(new File("src/com/company/RegularSeasonCompactResults.csv"));
        /*
        2013: Lose = -1, Win = 1
        2014: Lose = -2, Win = 2
        2015: Lose = -3, Win = 3
        2016: Lose = -4, Win = 4
         */
        while (scanResults.hasNextLine()) {
            String line = scanResults.nextLine();
            String [] divisions = line.split(",");
            //Season,Daynum,Wteam,Wscore,Lteam,Lscore,Wloc,Numot
            for (int i = 0; i < teams.size(); i++) {
                Team temp = (Team)teams.get(i);
                int ID = temp.teamID;
                if (ID == Integer.parseInt(divisions[2])) {
                    temp.addWin(Integer.parseInt(divisions[0]));
                }
                if (ID == Integer.parseInt(divisions[4])) {
                    temp.addLoss(Integer.parseInt(divisions[0]));
                }
            }
            /*
            for (int ID = 1101; ID < 1464; ID++) {
                if (ID == Integer.parseInt(divisions[2])) {
                    (Team)teams.get(ID - 1101).addWin(Integer.parseInt(divisions[0]));
                }
                if (ID == Integer.parseInt(divisions[4])) {
                    (Team)teams.get(ID - 1101).addLoss(Integer.parseInt(divisions[0]));
                }
            }
            */

            // This is a test for the above methods:

            // Sort all teams based off of integer "i" (Brandon type your code below)
        }
    }
}
