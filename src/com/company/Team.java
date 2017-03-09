package com.company;

public class Team implements Comparable {

    public Team (String n,int id){
        name = n;
        teamID = id;
    }
    public int i;
    public String name;
    public int teamID;

    public int compareTo (Object t) {
        Team tt = (Team)t;

        if (tt.i > i) {
            return -1;
        } else if (tt.i == i) {
            return 0;
        } else {
            return 1;
        }
    }

    public void addWin (int yr) {
        switch (yr) {
            case 2013:
                i += 10;
            case 2014:
                i += 11;
            case 2015:
                i += 12;
            case 2016:
                i += 13;
        }
    }

    public void addLoss (int yr) {
        switch (yr) {
            case 2013:
                i -= 10;
            case 2014:
                i -= 11;
            case 2015:
                i -= 12;
            case 2016:
                i -= 13;
        }
    }
}
