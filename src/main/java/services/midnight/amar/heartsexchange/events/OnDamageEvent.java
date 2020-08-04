package services.midnight.amar.heartsexchange.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import services.midnight.amar.heartsexchange.Files.DataYml;
import services.midnight.amar.heartsexchange.HeartsExchange;

public class OnDamageEvent implements Listener {

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            double finalHealth = p.getHealth() - e.getFinalDamage();
            if(e.getFinalDamage() >= p.getHealth()) {
                for(Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    onlinePlayers.setHealth(20);
                    onlinePlayers.sendMessage(HeartsExchange.colorize("&a" + p.getName() + " &chas been sacrificed to reset your health!"));
                }
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(HeartsExchange.colorize("&cYour life has been sacrificed for everyone's health to be reset."));

        } else if(finalHealth >= 20) {

            }else {
                for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    if (!(onlinePlayers.getGameMode() == GameMode.SPECTATOR) || !(onlinePlayers.getGameMode() == GameMode.CREATIVE)) {
                        if (!onlinePlayers.getName().equalsIgnoreCase(p.getName())) {
                            onlinePlayers.setHealth(finalHealth);
                            DataYml.getDataYml().set("health", (int) finalHealth);
                            DataYml.saveDataYml();
                            onlinePlayers.sendMessage(HeartsExchange.colorize("&cYour hearts has been set to &b" + (int) finalHealth + " &cbecause &a" + p.getName() + " &4took damage"));
                        }
                    } else {
                    }
                }

            }


        }


    }
}
