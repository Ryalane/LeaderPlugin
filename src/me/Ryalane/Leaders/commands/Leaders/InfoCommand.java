package me.Ryalane.Leaders.commands.Leaders;

import me.Ryalane.Leaders.commands.Gyms.CommandBase;
import me.Ryalane.Leaders.*;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InfoCommand extends CommandBase {
	public Leader plugin = Leader.instance;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		ChatColor green = ChatColor.DARK_GREEN;
		ChatColor red = ChatColor.RED;
		ChatColor white = ChatColor.WHITE;
		// Plugin info
		inform(sender, red + "=== " + white + "Leader plugin" + red + " ===");
		inform(sender, green + "Version: " + red + plugin.getDescription().getVersion());
		// Commands
		inform(sender, "Commands:");
		// Gym commands (trainers)
		inform(sender, "/gym" + green + " - List the status of every gym.");
		inform(sender, "/gym " + red + "<gym name>" + green + " - Lists the status of the specified gym.");
		inform(sender, "/gym list " + red + "<gym name>" + green + " - Lists the leaders of the specified gym.");
		// Leader commands (leader+)
		inform(sender, "/leader "  + red + "<Open/Close> <gym name>" + green + " - Open or close a gym.");
		inform(sender, "/leader add " + red + "<gym name> <player name>" + green + " - Adds the player to the specified gym as a leader.");
		inform(sender, "/leader del " + red + "<gym name> <player name>" + green + " - Removes the player from the specified gym.");
		inform(sender, "/leader givebadge " + red + "<player> <badge name/id>" + green +" - Gives the player a badge");
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public boolean playersOnly() {
		
		return false;
	}

}
