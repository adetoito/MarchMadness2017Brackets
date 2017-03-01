package com.company;

public class Team implements Comparable {

    public Team (String n, int w, int l, int id){
        name = n;
        wins = w;
        losses = l;
        teamID = id;
    }

    public String name;
    public double wlr;
    public int wins;
    public int losses;
    public int teamID;

    public int compareTo (Object t) {
        Team tt = (Team)t;

        if (tt.wlr > wlr) {
            return -1;
        } else if (tt.wlr == wlr) {
            return 0;
        } else {
            return 1;
        }
    }

    public void addWin () {
        if (wins != 1) {
            wins++;
        }
    }

    public void addLoss () {
        if (losses != 1) {
            losses++;
        }
    }
}
