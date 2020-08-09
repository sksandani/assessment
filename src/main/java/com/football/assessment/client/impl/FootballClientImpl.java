package com.football.assessment.client.impl;

import com.football.assessment.client.FootballClient;
import com.football.assessment.model.Country;
import com.football.assessment.model.League;
import com.football.assessment.model.TeamStandResponse;
import com.football.assessment.model.TeamStandResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Service
public class FootballClientImpl implements FootballClient {

    @Autowired
    @Qualifier("footballApiUrl")
    private String url;

    @Autowired
    @Qualifier("apiKey")
    private String apiKey;

    public TeamStandResponses getTeamStand(String leagueId) {
        TeamStandResponses teamStandResponses = new TeamStandResponses();
        TeamStandResponse[] responses = null;
        URI uri = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("action", "get_standings")
                .queryParam("league_id", leagueId)
                .queryParam("APIkey", apiKey)
                .build().toUri();
        RestTemplate restTemplate = new RestTemplate();
        responses = restTemplate.getForEntity(uri, TeamStandResponse[].class).getBody();
        if(null != responses && responses.length > 0) {
            teamStandResponses.setResponses(Arrays.asList(responses));
        }
        return teamStandResponses;
    }

    public Map<String, String> getCountries() {
        Map<String, String> countries = new HashMap<>();
        Country[] responses = null;
        URI uri = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("action", "get_countries")
                .queryParam("APIkey", apiKey)
                .build().toUri();
        RestTemplate restTemplate = new RestTemplate();
        responses = restTemplate.getForEntity(uri, Country[].class).getBody();
        if(null != responses && responses.length > 0) {
            for (Country country: responses) {
                countries.put(country.getCountry_name().toLowerCase(), country.getCountry_id());
            }
        }
        return countries;
    }

    public List<String> getLeagues(String countryCode) {
        List<String> leagueIds = new ArrayList<>();
        URI uri = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("action", "get_leagues")
                .queryParam("country_id", countryCode)
                .queryParam("APIkey", apiKey)
                .build().toUri();
        RestTemplate restTemplate = new RestTemplate();
        League[] leagues = restTemplate.getForEntity(uri, League[].class).getBody();
        if(null != leagues && leagues.length > 0) {
            for (League league: leagues) {
                leagueIds.add(league.getLeague_id());
            }
        }
        return leagueIds;
    }



}
