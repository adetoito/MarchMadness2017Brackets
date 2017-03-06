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
                i += 1;
            case 2014:
                i += 2;
            case 2015:
                i += 3;
            case 2016:
                i += 4;
        }
    }

    public void addLoss (int yr) {
        switch (yr) {
            case 2013:
                i -= 1;
            case 2014:
                i -= 2;
            case 2015:
                i -= 3;
            case 2016:
                i -= 4;
        }
    }
}
