package com.football.assessment.controller;

import com.football.assessment.model.TeamStand;
import com.football.assessment.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class FootballController {

    @Autowired
    private FootballService footballService;

    @GetMapping(value = "/standings")
    public List<TeamStand> getTeamStandings(@RequestParam(value = "countryName", required = false) String countryName,
                                            @RequestParam(value = "leagueName", required = false) String leagueName,
                                            @RequestParam(value = "teamName", required = false) String teamName) {

        List<TeamStand> responses = footballService.getTeamStandings(countryName, leagueName, teamName);
        return responses;
    }

}
