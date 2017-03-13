package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanTeams = new Scanner(new File("src/com/company/Teams.csv"));
        ArrayList<Team> teams = new ArrayList();
        while (scanTeams.hasNextLine()) {
            String line = scanTeams.nextLine(); // Takes the line that the scanner is reading.
            String[] divisions = line.split(","); // Splits the line into a String array at a comma.
            teams.add(new Team(divisions[1], Integer.parseInt(divisions[0])));
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
            String[] divisions = line.split(",");
            //Season,Daynum,Wteam,Wscore,Lteam,Lscore,Wloc,Numot
            for (int i = 0; i < teams.size(); i++) {
                Team temp = teams.get(i);
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

        }
        // Sort all teams based off of integer "i"
        // NEW GOAL: Sort this in the opposite order!
        // Brandon seized the means of production
        Collections.sort(teams);
        ArrayList<Team> sixtyfour = new ArrayList();
        int [] odds = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62};
        int [] evens = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59,61,63};

        for (int i = teams.size() - 1; i > teams.size() - 65; i--) {
            sixtyfour.add(teams.get(i));
        }

        // Prints out the 64 teams in the bracket
        // Myers you might need this: \/ \/ \/
        System.out.println("TEAMS:");
        for (int i = 0; i < sixtyfour.size(); i++) {
            Team temp = sixtyfour.get(i);
            System.out.println(i + 1 + ": " + temp.name + " // Wins-Losses(weighted,over past 3 years): " + temp.i);
        }
        System.out.println("=============================\n");

        // Divisions
        ArrayList<Team> d1 = new ArrayList();
        ArrayList<Team> d2 = new ArrayList();

        for (int i = 0; i < odds.length; i++) {
            int index = odds[i];
            Team temp = sixtyfour.get(index);
            d1.add(temp);
          //  System.out.println(i + 1 + ": " + temp.name);
        }
        for (int i = 0; i < evens.length; i++) {
            int index = evens[i];
            Team temp = sixtyfour.get(index);
            d2.add(temp);
           // System.out.println(i + 1 + ": " + temp.name);
        }
        ArrayList<Team> dd1 = new ArrayList();
        ArrayList<Team> dd2 = new ArrayList();
        ArrayList<Team> d3 = new ArrayList();
        ArrayList<Team> d4 = new ArrayList();
        for (int i = 0; i < d1.size(); i++) {
            if(i % 2 != 0){
                d3.add(d1.get(i));
            }
            else{
                d4.add(d1.get(i));
            }
        }
        for (int i = 0; i < d2.size(); i++) {
            if(i % 2 != 0){
                dd2.add(d2.get(i));
            }
            else{
             dd1.add(d2.get(i));
            }
        }

        System.out.println("Div 1");
        System.out.println("===============");

        for (int i = 0; i < dd1.size(); i++) {
            System.out.println(dd1.get(i).name);
        }
        System.out.println("===============");

        System.out.println("Div 2");
        System.out.println("===============");

        for (int i = 0; i < dd2.size(); i++) {
            System.out.println(dd2.get(i).name);
        }
        System.out.println("===============");

        System.out.println("Div 3");
        System.out.println("===============");

        for (int i = 0; i < d3.size(); i++) {
            System.out.println(d3.get(i).name);
        }
        System.out.println("===============");

        System.out.println("Div 4");
        System.out.println("===============");

        for (int i = 0; i < d4.size(); i++) {
            System.out.println(d4.get(i).name);
        }
        System.out.println("============");

        System.out.println("div 1 round 1");
        System.out.println("============");
       dd1 =  brakk(dd1);
        System.out.println("============");

        System.out.println("div 2 round 1");
        System.out.println("============");

        dd2 = brakk(dd2);
        System.out.println("============");

        System.out.println("div 3 round 1");
        System.out.println("============");

       d3= brakk(d3);
        System.out.println("============");

        System.out.println("div 4 round 1");
        System.out.println("============");

        d4=brakk(d4);

        /*
        WEW LAD
         */

        System.out.println("============");

        System.out.println("div 1 round 2");
        System.out.println("============");
        dd1 =  brakk(dd1);
        System.out.println("============");

        System.out.println("div 2 round 2");
        System.out.println("============");

        dd2 = brakk(dd2);
        System.out.println("============");

        System.out.println("div 3 round 2");
        System.out.println("============");

        d3= brakk(d3);
        System.out.println("============");

        System.out.println("div 4 round 2");
        System.out.println("============");

        d4=brakk(d4);

        /*
       LAD WEW
         */

        System.out.println("============");

        System.out.println("div 1 round 3");
        System.out.println("============");
        dd1 =  brakk(dd1);
        System.out.println("============");

        System.out.println("div 2 round 3");
        System.out.println("============");

        dd2 = brakk(dd2);
        System.out.println("============");

        System.out.println("div 3 round 3");
        System.out.println("============");

        d3= brakk(d3);
        System.out.println("============");

        System.out.println("div 4 round 3");
        System.out.println("============");

        d4=brakk(d4);
        /*
        die
         */
        System.out.println("============");

        System.out.println("div 1 round 4");
        System.out.println("============");
        dd1 =  brakk(dd1);
        System.out.println("============");

        System.out.println("div 2 round 4");
        System.out.println("============");

        dd2 = brakk(dd2);
        System.out.println("============");

        System.out.println("div 3 round 4");
        System.out.println("============");

        d3= brakk(d3);
        System.out.println("============");

        System.out.println("div 4 round 4");
        System.out.println("============");

        d4=brakk(d4);
        /*
        meme
         */
        ArrayList<Team> one = new ArrayList<>();
        one.add(dd1.get(0));
        one.add(dd2.get(0));
        ArrayList<Team> two = new ArrayList<>();
        two.add(d3.get(0));
        two.add(d4.get(0));
        System.out.println("============");

        System.out.println("Semifinals round 1");
        System.out.println("============");

        one= brakk(one);
        System.out.println("============");

        System.out.println("Semifinals round 2");
        System.out.println("============");

        two=brakk(two);
        /*
        harambe lol
         */
        ArrayList<Team> yeah = new ArrayList<>();
        yeah.add(one.get(0));
        yeah.add(two.get(0));
        System.out.println("============");

        System.out.println("Final round");
        System.out.println("============");

        yeah= brakk(yeah);


    }
    public static ArrayList brakk (ArrayList<Team> a){
      //  System.out.println("g?");
        for(Object o : a){
            if(o instanceof Team){
                //System.out.println(((Team) o).getName());
            }
        }
      //  System.out.println("idk");
        ArrayList div = new ArrayList();
        ArrayList newList = new ArrayList<Team>();
        for (int i = 0; i < a.size(); i++) {
            if(true){
                div.add(new ArrayList<Team>(2));
            }
        }
      //  System.out.println("the siakjfqekjwfnjkjk erwga:  " + div.size());
        for (int i = 0; i < div.size(); i++) {
           // System.out.println(i);
            if(i%2==0) {
                ArrayList kms = (ArrayList)div.get(i);
                    kms.add(a.get(i));
                   // System.out.println("no " + a.get(i).name + " :idk:" + i);
                    kms.add(a.get(i + 1));
                 //   System.out.println("yeah "+ a.get(i + 1).name);


            }
        }
        int jews = 0;
        for(Object ar: div){
            if(ar instanceof ArrayList && jews%2==0){
                ArrayList lad = (ArrayList)div.get(jews);
                Team g = (Team)lad.get(0);
                Team n = (Team)lad.get(1);
                System.out.println(g.name + " vs " + n.name);
                if(g.compareTo(n) == 1){
                    System.out.println(g.name+" wins");
                    newList.add(g);
                    System.out.println(" ");
                }
                else{
                    System.out.println(n.name+ " wins");
                    newList.add(n);
                    System.out.println(" ");
                }
            }
            jews++;
        }
  //      System.out.println("the holocaust");
        for(Object o : newList){
            if(o instanceof Team){
          //      System.out.println(((Team) o).getName());
            }
        }
       // System.out.println("lmao");
        return newList;
    }
}