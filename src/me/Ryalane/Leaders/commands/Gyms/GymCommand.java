package me.Ryalane.Leaders.commands.Gyms;

import java.util.List;

import me.Ryalane.Leaders.Leader;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GymCommand extends CommandBase {
	public Leader instance = Leader.instance;
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");

		if (args.length == 1)
		{
			for (String i : GymTypes)
			{
				if (args[0].equalsIgnoreCase(i))
				{
					String gymStatus = instance.getConfig().getString("Gyms." + i + ".Status");
					ChatColor statusColour = (gymStatus == "Open") ? ChatColor.GREEN : ChatColor.RED;
					inform(sender, i + " gym is : " + statusColour + gymStatus);

				}
			}
		}
		else if (args.length == 0)
		{		
			inform(sender, "List of Gyms:");
			
			for (String i : GymTypes)
			{
				String gymStatus = instance.getConfig().getString("Gyms." + i + ".Status");
				ChatColor statusColour = (gymStatus == "Open") ? ChatColor.GREEN : ChatColor.RED;
				inform(sender, i + " gym is : " + statusColour + gymStatus);
			}

		}
		else
		{

		}
	}

	@Override
	public String getPermission() {
		return "gym.*";
	}

	@Override
	public boolean playersOnly() {
		return true;
	}

}
