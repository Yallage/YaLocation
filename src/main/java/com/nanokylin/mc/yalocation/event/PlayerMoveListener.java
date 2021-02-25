package com.nanokylin.mc.yalocation.event;

import com.nanokylin.mc.yalocation.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    // 肉便器
    Location location = new Location(Bukkit.getWorlds().get(0), 0, 0, 0);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        this.location = event.getPlayer().getLocation();
        this.location.setYaw(0);
        this.location.setPitch(0);
        if (ConfigHandler.locationActionsMap.containsKey(this.location)) {
            Bukkit.getServer().getLogger().info("[YaLocation] [DEBUG] On Location");
            //TODO: 执行指令等
        }
    }
}
