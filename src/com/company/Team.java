package com.company;

public class Team implements Comparable {

    public Team (String n, int w, int l, int id){
        name = n;
        wlr = w/l;
        teamID = id;
    }

    public String name;
    public double wlr;
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

    public int returnID () {
        return teamID;
    }

}
