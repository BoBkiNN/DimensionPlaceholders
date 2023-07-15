package xyz.bobkinn_.dimplaceholders;

import org.bukkit.entity.Player;
import org.bukkit.World;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

public class DimPExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getAuthor() {
        return "BoBkiNN_";
    }
    
    @Override
    public @NotNull String getIdentifier() {
        return "dimplc";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String params){
        if (player == null) return null;
        World world = player.getWorld();
        String worldName = world.getName();
        
        if (params.equalsIgnoreCase("color")){
            String color = Main.config.getString("colors."+worldName, "");
            return ChatColor.translateAlternateColorCodes('&', color);
        }
        if (params.equalsIgnoreCase("folder")) return world.getName();
        if (params.equalsIgnoreCase("namespacedkey")) return world.getKey().getNamespace()+":"+world.getKey().getKey();
        if (params.equalsIgnoreCase("namespace")) return world.getKey().getNamespace();
        if (params.equalsIgnoreCase("key")) return world.getKey().getKey();
        if (params.equalsIgnoreCase("loadedchunks")) return String.valueOf(world.getLoadedChunks().length);
        return null;
    }
}