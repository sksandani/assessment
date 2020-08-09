
package com.football.assessment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coach_name",
    "coach_country",
    "coach_age"
})
public class Coach {

    @JsonProperty("coach_name")
    public String coachName;
    @JsonProperty("coach_country")
    public String coachCountry;
    @JsonProperty("coach_age")
    public String coachAge;

}
