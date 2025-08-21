package com.example.firstproject.activity.models;

public class MatchItem {
    private String team1;
    private int team1LogoRes;
    private String team2;
    private int team2LogoRes;
    private String matchTime;

    public MatchItem(String team1, int team1LogoRes, String team2, int team2LogoRes, String matchTime) {
        this.team1 = team1;
        this.team1LogoRes = team1LogoRes;
        this.team2 = team2;
        this.team2LogoRes = team2LogoRes;
        this.matchTime = matchTime;
    }

    public String getTeam1() {
        return team1;
    }

    public int getTeam1LogoRes() {
        return team1LogoRes;
    }

    public String getTeam2() {
        return team2;
    }

    public int getTeam2LogoRes() {
        return team2LogoRes;
    }

    public String getMatchTime() {
        return matchTime;
    }
}
