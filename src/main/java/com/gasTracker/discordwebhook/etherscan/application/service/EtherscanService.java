package com.gasTracker.discordwebhook.etherscan.application.service;

import com.gasTracker.discordwebhook.etherscan.application.api.GasResponse;

public interface EtherscanService {
    public GasResponse getGasPrice();
}
