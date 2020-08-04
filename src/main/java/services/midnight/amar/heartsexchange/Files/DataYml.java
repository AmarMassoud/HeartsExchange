package services.midnight.amar.heartsexchange.Files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import services.midnight.amar.heartsexchange.HeartsExchange;

import java.io.File;
import java.io.IOException;

public class DataYml {

    private static final HeartsExchange plugin = HeartsExchange.getPlugin(HeartsExchange.class);

    public static FileConfiguration dataYml;
    public static File dataFile;


    public static void setUpDataYml() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        dataFile = new File(plugin.getDataFolder(), "data.yml");


        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(HeartsExchange.colorize("&cCould not load data.yml"));
                e.printStackTrace();
            }

        }

        dataYml = YamlConfiguration.loadConfiguration(dataFile);


    }

    public static FileConfiguration getDataYml() {
        return dataYml;
    }

    public static void saveDataYml() {
        try {
            dataYml.save(dataFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(HeartsExchange.colorize("&cCould not save data.yml"));
            e.printStackTrace();
        }
    }

    public static void reloadDataYml() {
        dataYml = YamlConfiguration.loadConfiguration(dataFile);
    }


}
