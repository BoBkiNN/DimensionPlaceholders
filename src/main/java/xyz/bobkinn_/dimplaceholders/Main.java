package xyz.bobkinn_.dimplaceholders;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

    public static Main plugin;
    public static Configuration config;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            plugin = this;
            new DimPExpansion().register();
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        reload();
        getCommand("dimplcrl").setExecutor(new ReloadCmd());
    }

    @Override
    public void onDisable() {

    }

    public static void reload(){
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            if (!dataFolder.mkdir()) {
                plugin.getLogger().severe("Failed to create data folder!");
                Bukkit.getPluginManager().disablePlugin(plugin);
                return;
            }
        }
        File configFile = new File(dataFolder, "config.yml");
        if (!configFile.exists()){
            try {
                if (!configFile.createNewFile()){
                    plugin.getLogger().severe("Failed to create config file!");
                    Bukkit.getPluginManager().disablePlugin(plugin);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                plugin.getLogger().severe("Failed to create config file!");
                Bukkit.getPluginManager().disablePlugin(plugin);
                return;
            }
            InputStream from = plugin.getResource("config.yml");
            try {
                FileUtils.copyToFile(from, configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Configuration config = YamlConfiguration.loadConfiguration(configFile);
        Main.config = config;
    }
}
