package xyz.bobkinn_;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import xyz.bobkinn_.dimplaceholders.Main;

public class ReloadCmd implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Main.reload();
        String rlMsg = Main.config.getString("reloadMsg");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rlMsg));
        return true;
    }


}
