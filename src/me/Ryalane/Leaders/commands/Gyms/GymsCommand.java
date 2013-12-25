package me.Ryalane.Leaders.commands.Gyms;

import java.util.List;

import me.Ryalane.Leaders.Leader;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GymsCommand extends CommandBase {
	public Leader instance = Leader.instance;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		instance.reloadConfig();
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");
		ChatColor statusColour;
			inform(sender, "List of Gyms:");
			
			for (String i : GymTypes)
			{
				boolean gymStatus = instance.getConfig().getBoolean("Gyms." + i + ".Status");
				ChatColor gymColor = ChatColor.valueOf(instance.getConfig().getString("Gyms." + i + ".Color"));
				
				String status = gymStatus ? "Open" : "Closed";
				statusColour = gymStatus ? ChatColor.GREEN : ChatColor.RED;
				inform(sender, gymColor + i + informColor + " gym is : " + statusColour + status);
			}

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
