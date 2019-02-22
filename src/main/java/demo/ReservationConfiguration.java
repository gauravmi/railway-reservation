package demo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.constraints.NotNull;

class ReservationConfiguration extends Configuration {
    @NotNull
    @JsonProperty
    private String host;

    public String getHost() {
        return host;
    }
}
