package xyz.bobkinn_.dimplaceholders;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCmd implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Main.reload();
        String rlMsg = Main.config.getString("reloadMsg","&aReloaded!");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rlMsg));
        return true;
    }


}
