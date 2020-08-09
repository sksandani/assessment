package com.football.assessment.service;

import com.football.assessment.model.TeamStand;

import java.util.List;

public interface FootballService {

    List<TeamStand> getTeamStandings(String countryName, String leagueName, String teamName);
}
