package com.gasTracker.discordwebhook.discord.api.service;

import com.gasTracker.discordwebhook.Etherscan.GasTracker.application.api.GasResponse;
import com.gasTracker.discordwebhook.discord.domain.DiscordWebhook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;

@Service
public class DiscordApplicationService implements  DiscordService {
    @Value("${discord.webhook}")
    private String webhookUrl;
    @Value("${discord.role.snipers}")
    private String role;
    @Override
    public void sendMessage(GasResponse gasResponse) throws IOException {
        DiscordWebhook discordWebhook = new DiscordWebhook(webhookUrl);
        discordWebhook.setTts(true);
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("O gas está baixo!")
                .setDescription("")
                .setColor(Color.getHSBColor(222,64,36))
                .addField("Fast Gas Price", String.valueOf(gasResponse.getFastGasPrice()), true)
                .addField("Average Gas price", String.valueOf(gasResponse.getProposeGasPrice()), true)
                .addField("Safe Gas price", String.valueOf(gasResponse.getSafeGasPrice()), false)
                .setThumbnail("https://cdn-icons-png.freepik.com/512/6820/6820972.png")
              //  .setFooter("Footer text", "https://kryptongta.com/images/kryptonlogodark.png")
              //  .setImage("https://miro.medium.com/v2/resize:fit:1024/0*ya-QfIZ6t6nYrKEi.png")
                .setAuthor("Etherscan", "https://etherscan.io/gastracker", "https://miro.medium.com/v2/resize:fit:1024/0*ya-QfIZ6t6nYrKEi.png")
                .setUrl("https://etherscan.io/gastracker"));
//        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject()
//                .setDescription("Just another added embed object!"));
        discordWebhook.setContent(role);
        discordWebhook.execute();
        //discordWebhook.setContent(String.valueOf(gasResponse.getProposeGasPrice()));
    }
}
