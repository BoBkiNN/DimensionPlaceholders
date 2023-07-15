package xyz.bobkinn_.dimplaceholders;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

    public static Main plugin;
    public static Configuration config;
    private DimPExpansion expansion;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            plugin = this;
            expansion = new DimPExpansion();
            expansion.register();
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        reload();
        getCommand("dimplcrl").setExecutor(new ReloadCmd());
    }

    @Override
    public void onDisable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            try {
                expansion.unregister();
            } catch (Exception ignored) {}
        }
    }

    public static void reload(){
        try {
            plugin.reloadConfig();
        } catch (Exception e){
            plugin.getLogger().severe("Failed to reload config");
        }
        Main.config = plugin.getConfig();
    }
}
