package com.nanokylin.mc.yalocation.config;

import com.nanokylin.mc.yalocation.config.model.Actions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;

/**
 * 扫描目录 并加载有效yml配置文件
 *
 * @author Hanbings
 */
public class ConfigHandler {
    // 文件列表
    private final List<File> files = new ArrayList<>();
    // 坐标Map
    public static Map<Location, Actions> locationActionsMap = new HashMap<>();

    /**
     * 加载满足条件的yml
     */
    public ConfigHandler() {
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "[YaLocation] Loading Config ...");
        getFiles(new File("./plugins/YaLocation/config/"));
        FileConfiguration configuration;
        for (int i = 0; i < files.size(); i++) {
            configuration = YamlConfiguration.loadConfiguration(files.get(i));
            Location location = new Location(Bukkit.getWorld(Objects.requireNonNull(configuration.getString("world"))), configuration.getDouble("x"), configuration.getDouble("y"), configuration.getDouble("z"));
            Actions actions = new Actions();
            actions.setCommands(configuration.getStringList("commands"));
            if (configuration.getString("title") != null) {
                actions.setSeeTitle(true);
                actions.setTitle(configuration.getString("title"));
            }
            if (configuration.getString("subtitle") != null) {
                actions.setSeeSubtitle(true);
                actions.setSubtitle(configuration.getString("subtitle"));
            }
            locationActionsMap.put(location, actions);
        }
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "[YaLocation] Loaded " + locationActionsMap.size() + 1 + "Config");
    }

    /**
     * 递归获取所有配置文件
     *
     * @param path 路径文件对象
     */
    public void getFiles(File path) {
        ArrayList<String> files = new ArrayList<String>();
        File[] tempList = path.listFiles();
        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (tempList[i].isFile()) {
                this.files.add(tempList[i]);
            }
            if (tempList[i].isDirectory()) {
                getFiles(tempList[i]);
            }
        }
    }
}
