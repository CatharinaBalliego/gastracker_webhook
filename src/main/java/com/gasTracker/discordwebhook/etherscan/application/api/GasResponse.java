package com.gasTracker.discordwebhook.etherscan.application.api;

import com.gasTracker.discordwebhook.etherscan.domain.Gas;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GasResponse {
    private int safeGasPrice;
    private int proposeGasPrice;
    private int fastGasPrice;

    public GasResponse(Gas gas){
        this.safeGasPrice = gas.getResult().getSafeGasPrice();
        this.proposeGasPrice = gas.getResult().getProposeGasPrice();
        this.fastGasPrice = gas.getResult().getFastGasPrice();
    }

    public boolean validate(){
        return this.proposeGasPrice <= 40;
    }
}
