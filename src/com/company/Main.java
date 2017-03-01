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
        /*
        System.out.println(teams.size()); // Tests out how many teams there are
        Team test = (Team)teams.get(0);
        System.out.println("Team ID of " + test.name + ": " +test.returnID());
        */
    }
}
