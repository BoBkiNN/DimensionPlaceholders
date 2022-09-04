package xyz.bobkinn_.dimplaceholders;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{

    public static Main plugin;
    public static Configuration config;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
            plugin = this;
            new DimPExpansion().register();
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        reload();

        // getConfig().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDimChange(PlayerChangedWorldEvent e) {
        
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
        }
        InputStream from = plugin.getResource("config.yml");
        try {
            FileUtils.copyToFile(from, configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration config = YamlConfiguration.loadConfiguration(configFile);
        Main.config = config;
    }
}
