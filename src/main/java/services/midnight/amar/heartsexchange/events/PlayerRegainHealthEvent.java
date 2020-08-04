package services.midnight.amar.heartsexchange.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import services.midnight.amar.heartsexchange.Files.DataYml;
import services.midnight.amar.heartsexchange.HeartsExchange;

public class PlayerRegainHealthEvent implements Listener {
    @EventHandler
    public void PlayerHeathRegain(EntityRegainHealthEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(p.getHealth() == 19) {
                p.setHealth(20);
            }
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            if(!(onlinePlayers.getGameMode() == GameMode.SPECTATOR) || !(onlinePlayers.getGameMode() == GameMode.CREATIVE)) {

                    if (!onlinePlayers.getName().equalsIgnoreCase(p.getName())) {
                        DataYml.getDataYml().set("health", p.getHealth());
                        DataYml.saveDataYml();
                        onlinePlayers.setHealth(DataYml.getDataYml().getInt("health"));

                        onlinePlayers.sendMessage(HeartsExchange.colorize("&cYour hearts has been set to &b" + DataYml.getDataYml().getInt("health") + " &cbecause &a" + p.getName() + " &eRegained health"));
                    }
                }
            }


        }

    }
}
