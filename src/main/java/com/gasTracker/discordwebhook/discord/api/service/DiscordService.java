package com.gasTracker.discordwebhook.discord.api.service;

import com.gasTracker.discordwebhook.etherscan.application.api.GasResponse;

import java.io.IOException;

public interface DiscordService {
    void sendMessage(GasResponse gasResponse) throws IOException;
}
