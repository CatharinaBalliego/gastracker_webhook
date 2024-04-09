package com.gasTracker.discordwebhook.etherscan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class Gas {
    public String status;
    public String message;
    public Result result;


    public static Gas fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Gas.class);
    }

    @Getter
    @Setter
    public static class Result {
        @JsonProperty("LastBlock")
        private String lastBlock;
        @JsonProperty("SafeGasPrice")
        private int safeGasPrice;
        @JsonProperty("ProposeGasPrice")
        private int proposeGasPrice;
        @JsonProperty("FastGasPrice")
        private int fastGasPrice;
        @JsonProperty("suggestBaseFee")
        private String suggestBaseFee;
        @JsonProperty("gasUsedRatio")
        private String gasUsedRatio;
    }
}
