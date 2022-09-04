package xyz.bobkinn_.dimplaceholders;

import org.bukkit.entity.Player;
import org.bukkit.World;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

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
    public String onPlaceholderRequest(Player player, String identifier){
        World world = player.getWorld();
        
        if (identifier == "color"){
            return world.getName()+" "+identifier;
        }
        return null;
    }
}