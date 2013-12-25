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
		ChatColor statusColour;

		if (args.length == 1)
		{
			for (String i : GymTypes)
			{
				if (args[0].equalsIgnoreCase(i))
				{
					boolean gymStatus = instance.getConfig().getBoolean("Gyms." + i + ".Status");
					ChatColor gymColor = ChatColor.valueOf(instance.getConfig().getString("Gyms." + i + ".Color"));
					
					String status = gymStatus ? "Open" : "Closed";
					statusColour = gymStatus ? ChatColor.GREEN : ChatColor.RED;
					inform(sender, gymColor + i + informColor + " gym is : " + statusColour + status);
				}
			}
		}
	}

	@Override
	public String getPermission() {
		return "gym.*";
	}

	@Override
	public boolean playersOnly() {
		return false;
	}

}
