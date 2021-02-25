package com.nanokylin.mc.yalocation;

import com.nanokylin.mc.yalocation.config.ConfigHandler;
import com.nanokylin.mc.yalocation.event.PlayerMoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class YaLocation extends JavaPlugin {

    @Override
    public void onEnable() {
        // 加载配置文件
        new ConfigHandler();
        // 加载监听器
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getLogger().info("[YaLocation] Running");
    }

    @Override
    public void onDisable() {
        getLogger().info("[YaLocation] Disable");
    }
}
