package com.football.assessment.client;

import com.football.assessment.model.TeamStandResponses;

import java.util.List;
import java.util.Map;


public interface FootballClient {

    TeamStandResponses getTeamStand(String leagueId);

    Map<String, String> getCountries();

    List<String> getLeagues(String countryCode);

}
