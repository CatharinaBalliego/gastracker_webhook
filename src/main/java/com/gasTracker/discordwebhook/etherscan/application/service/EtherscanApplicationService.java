package com.gasTracker.discordwebhook.etherscan.application.service;

import com.gasTracker.discordwebhook.etherscan.application.api.GasResponse;
import com.gasTracker.discordwebhook.etherscan.domain.Gas;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Log4j2
@Service
public class EtherscanApplicationService implements EtherscanService{

    @Value("${etherscan.api.token}")
    private String url;
    @Override
    public GasResponse getGasPrice() {

        //implementar handler

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) {
                log.info("Erro ao conectar com a api");
                return null;
            }

            else {
                GasResponse gasResponse = new GasResponse(Gas.fromJson(response.body()));

                return gasResponse;
            }

        } catch(Exception e) {
            Thread.currentThread().interrupt();
            log.info("Erro: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
