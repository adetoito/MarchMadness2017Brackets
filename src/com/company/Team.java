package com.company;

public class Team implements Comparable {

    public Team (String n,int id){
        name = n;
        teamID = id;
    }
    public int i;
    public String name;
    public double wlr;
    public int wins;
    public int losses;
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

    public void iDubbbz (int w) {
        i += w;
    }

    public void FilthyFrank (int l) {
        i -= l;
    }
}
