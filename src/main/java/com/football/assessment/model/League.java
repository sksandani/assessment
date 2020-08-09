package com.football.assessment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class League {
    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
}
