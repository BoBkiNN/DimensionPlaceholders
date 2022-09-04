package xyz.bobkinn_.dimplaceholders;

import org.bukkit.entity.Player;
import org.bukkit.World;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.md_5.bungee.api.ChatColor;

public class DimPExpansion extends PlaceholderExpansion {

    @Override
    public String getAuthor() {
        return "BoBkiNN_";
    }
    
    @Override
    public String getIdentifier() {
        return "dimplc";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String params){
        World world = player.getWorld();
        String worldName = world.getName();
        // Main.plugin.getLogger().info(player.toString()+" "+worldName+" "+params);
        if (params.equalsIgnoreCase("color")){
            String color = Main.config.getString("colors."+worldName, "");
            return ChatColor.translateAlternateColorCodes('&', color);
        }
        if (params.equalsIgnoreCase("folder")){
            return world.getName();
        }
        if (params.equalsIgnoreCase("namespacedkey")){
            return world.getKey().getNamespace()+":"+world.getKey().getKey();
        }
        if (params.equalsIgnoreCase("namespace")){
            return world.getKey().getNamespace();
        }
        if (params.equalsIgnoreCase("key")){
            return world.getKey().getKey();
        }
        if (params.equalsIgnoreCase("loadedchunks")){
            return String.valueOf(world.getLoadedChunks().length);
        }
        return null;
    }
}