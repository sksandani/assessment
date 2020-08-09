
package com.football.assessment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player_key",
    "player_name",
    "player_number",
    "player_country",
    "player_type",
    "player_age",
    "player_match_played",
    "player_goals",
    "player_yellow_cards",
    "player_red_cards"
})
public class Player {

    @JsonProperty("player_key")
    public Integer playerKey;
    @JsonProperty("player_name")
    public String playerName;
    @JsonProperty("player_number")
    public String playerNumber;
    @JsonProperty("player_country")
    public String playerCountry;
    @JsonProperty("player_type")
    public String playerType;
    @JsonProperty("player_age")
    public String playerAge;
    @JsonProperty("player_match_played")
    public String playerMatchPlayed;
    @JsonProperty("player_goals")
    public String playerGoals;
    @JsonProperty("player_yellow_cards")
    public String playerYellowCards;
    @JsonProperty("player_red_cards")
    public String playerRedCards;

}
