package com.gasTracker.discordwebhook.Etherscan.GasTracker.application.service;

import com.gasTracker.discordwebhook.Etherscan.GasTracker.application.api.GasResponse;

public interface EtherscanService {
    public GasResponse getGasPrice();
}
