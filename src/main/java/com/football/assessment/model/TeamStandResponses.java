
package com.football.assessment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TeamStandResponses {
    List<TeamStandResponse> responses;
}
