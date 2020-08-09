package com.football.assessment.service.impl;

import com.football.assessment.client.FootballClient;
import com.football.assessment.model.TeamStand;
import com.football.assessment.model.TeamStandResponse;
import com.football.assessment.model.TeamStandResponses;
import com.football.assessment.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FootballServiceImpl implements FootballService {

    @Autowired
    private FootballClient footballClient;

    @Override
    public List<TeamStand> getTeamStandings(String countryName, String leagueName, String teamName) {

        List<TeamStand> teamStands = new ArrayList<>();
        if(!StringUtils.isEmpty(countryName)) {
            String countryId = footballClient.getCountries().get(countryName.toLowerCase());
            List<String> leagueIds = footballClient.getLeagues(countryId);
            if(null != leagueIds && leagueIds.size() > 0) {
                for (String league: leagueIds) {
                    if(!StringUtils.isEmpty(league)) {
                        TeamStandResponses standResponses = footballClient.getTeamStand(league);
                        List<TeamStandResponse> teamStandResponses = standResponses.getResponses();
                        if(!StringUtils.isEmpty(leagueName)) {
                            teamStandResponses = teamStandResponses
                                    .stream()
                                    .filter(stands -> (stands.getLeagueName().equalsIgnoreCase(leagueName)))
                                    .collect(Collectors.toList());
                        }
                        if(!StringUtils.isEmpty(teamName)) {
                            teamStandResponses = teamStandResponses
                                    .stream()
                                    .filter(stands -> (stands.getTeamName().equalsIgnoreCase(teamName)))
                                    .collect(Collectors.toList());
                        }
                        prepareTeamStand(teamStandResponses, teamStands, countryId);
                    }
                }
            }
        }
            return teamStands;
    }

    private void prepareTeamStand(List<TeamStandResponse> teamStandResponses, List<TeamStand> teamStands, String countryId) {

        if(teamStandResponses != null) {
            for (TeamStandResponse response:teamStandResponses) {
                TeamStand teamStand = new TeamStand();
                teamStand.setCountryId(countryId);
                teamStand.setCountryName(response.getCountryName());
                teamStand.setLeagueId(response.getLeagueId());
                teamStand.setLeagueName(response.getLeagueName());
                teamStand.setTeamId(response.getTeamId());
                teamStand.setTeamName(response.getTeamName());
                teamStand.setPosition(response.getOverallLeaguePosition());
                teamStands.add(teamStand);
            }
        }
    }
}
