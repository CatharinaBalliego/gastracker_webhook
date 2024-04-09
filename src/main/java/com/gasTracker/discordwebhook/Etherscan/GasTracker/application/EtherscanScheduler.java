package com.gasTracker.discordwebhook.Etherscan.GasTracker.application;

import com.gasTracker.discordwebhook.Etherscan.GasTracker.application.api.GasResponse;
import com.gasTracker.discordwebhook.Etherscan.GasTracker.application.service.EtherscanService;
import com.gasTracker.discordwebhook.discord.api.service.DiscordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableScheduling
@Log4j2
@RequiredArgsConstructor
public class EtherscanScheduler {
    private final EtherscanService etherscanService;
    private final DiscordService discordService;


    @Scheduled(cron = "0 * * * * *")
    public void verificarGas(){
        GasResponse gasResponse = etherscanService.getGasPrice();
        log.info("EtherscansScheduler");
        log.info("Gas Response: {}", gasResponse.getProposeGasPrice());
        if(gasResponse.validate()){
            try {
                discordService.sendMessage(gasResponse);
                Thread.sleep(1800000); //30 minutos
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
