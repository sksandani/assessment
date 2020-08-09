
package com.football.assessment.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "team_key",
    "team_name",
    "team_badge",
    "players",
    "coaches"
})
public class Teams {

    @JsonProperty("team_key")
    public String teamKey;
    @JsonProperty("team_name")
    public String teamName;
    @JsonProperty("team_badge")
    public String teamBadge;
    @JsonProperty("players")
    public List<Player> players = null;
    @JsonProperty("coaches")
    public List<Coach> coaches = null;

}
