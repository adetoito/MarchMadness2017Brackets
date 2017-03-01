package com.company;

/**
 * Created by vianrosal on 3/1/17.
 */
public class Team implements Comparable{
    public Team(String n,int w,int l){
        name = n;
        wlr = w/l;
    }
    //wew la
    public String name;
    public double wlr;
    public int compareTo(Object t){
        Team tt = (Team)t;
        if(tt.wlr > wlr){
            return -1;
        }
        else if( tt.wlr== wlr){
            return 0;
        }
        else{
            return 1;
        }
    }
}
