package services.midnight.amar.heartsexchange;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import services.midnight.amar.heartsexchange.Files.DataYml;
import services.midnight.amar.heartsexchange.events.OnDamageEvent;
import services.midnight.amar.heartsexchange.events.PlayerJoinServerEvent;
import services.midnight.amar.heartsexchange.events.PlayerRegainHealthEvent;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

public final class HeartsExchange extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinServerEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerRegainHealthEvent(), this);
        loadConfigManager();
        getLogger().info("HeartsExchange " + getDescription().getVersion() + " by Amar has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("HeartsExchange " + getDescription().getVersion() + " by Amar has been DISABLED");
    }
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void loadConfigManager() {
        DataYml.setUpDataYml();
        DataYml.reloadDataYml();
        DataYml.getDataYml().addDefault("health", 20.0);
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }

}
