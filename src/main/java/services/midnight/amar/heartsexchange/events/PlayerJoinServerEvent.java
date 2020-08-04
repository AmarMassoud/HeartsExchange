package services.midnight.amar.heartsexchange.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import services.midnight.amar.heartsexchange.Files.DataYml;
import services.midnight.amar.heartsexchange.HeartsExchange;


public class PlayerJoinServerEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        for(Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            if (Bukkit.getOnlinePlayers().size() != 1) {
                if (!onlinePlayers.getName().equalsIgnoreCase(p.getName())) {
                    onlinePlayers.setHealth(p.getHealth());
                    DataYml.saveDataYml();
                } else {
                    System.out.println("hi");

                }
            } else {
                onlinePlayers.setHealth(DataYml.getDataYml().getInt("health"));

            }
        }
    }
}
