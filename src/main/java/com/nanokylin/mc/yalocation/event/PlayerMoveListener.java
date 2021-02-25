package com.nanokylin.mc.yalocation.event;

import com.nanokylin.mc.yalocation.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class PlayerMoveListener implements Listener {
    // 肉便器
    Location location = new Location(Bukkit.getWorlds().get(0), 0, 0, 0);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        this.location.setWorld(event.getPlayer().getWorld());
        this.location.setX((int) event.getPlayer().getLocation().getX());
        this.location.setY((int) event.getPlayer().getLocation().getY());
        this.location.setZ((int) event.getPlayer().getLocation().getZ());

        Bukkit.getServer().getLogger().info("[YaLocation] [DEBUG] On " + this.location);
        Bukkit.getServer().getLogger().info("[YaLocation] [DEBUG] E " + ConfigHandler.locationActionsMap.containsKey(this.location));
        Bukkit.getServer().getLogger().info("[YaLocation] [DEBUG] MAP " + ConfigHandler.locationActionsMap);
        Bukkit.getServer().getLogger().info("[YaLocation] [DEBUG] MAP " + ConfigHandler.executeCountMap);

        if (ConfigHandler.locationActionsMap.containsKey(this.location)) {
            // 先为玩家创建Map元素
            if (!ConfigHandler.executeCountMap.containsKey(event.getPlayer())) {
                ConfigHandler.executeCountMap.put(event.getPlayer(), true);
            }
            // 执行指令后
            if (ConfigHandler.executeCountMap.get(event.getPlayer())) {
                // 考虑下设计任务队列
                List<String> commands = ConfigHandler.locationActionsMap.get(this.location).getCommands();
                // 指令改完逻辑再写
                if (ConfigHandler.locationActionsMap.get(this.location).isCanSeeTitle() && ConfigHandler.locationActionsMap.get(this.location).isCanSeeSubtitle()) {
                    event.getPlayer().sendTitle(ConfigHandler.locationActionsMap.get(this.location).getTitle(), ConfigHandler.locationActionsMap.get(this.location).getSubtitle(), 20, 70, 10);
                } else if (ConfigHandler.locationActionsMap.get(this.location).isCanSeeTitle()) {
                    event.getPlayer().sendTitle(ConfigHandler.locationActionsMap.get(this.location).getTitle(), " ", 20, 70, 10);
                } else if (ConfigHandler.locationActionsMap.get(this.location).isCanSeeSubtitle()) {
                    event.getPlayer().sendTitle(" ", ConfigHandler.locationActionsMap.get(this.location).getTitle(), 20, 70, 10);
                }
                // 标识玩家已经被执行过一次指令
                ConfigHandler.executeCountMap.put(event.getPlayer(), false);
            }
            return;
        }
        // 离开指定坐标后再复原玩家的标志位
        if (ConfigHandler.executeCountMap.containsKey(event.getPlayer())) {
            ConfigHandler.executeCountMap.put(event.getPlayer(), true);
        }
    }
}
