package me.Ryalane.Leaders.commands.Gyms;

import java.util.List;

import me.Ryalane.Leaders.Leader;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ListCommand extends CommandBase {
	public Leader instance = Leader.instance;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");
		
		if (args.length == 2)
		{
			if (args[0].equalsIgnoreCase("List"))
			{
				for (String i : GymTypes)
				{
					if (args[1].equalsIgnoreCase(i))
					{
						Integer count = 0;
						inform(sender, ChatColor.RED + "Leaders of " + i + ": ");
						for (String s : instance.getConfig().getStringList("Gyms." + i + ".Leaders"))
						{
							count++;
							inform(sender, count.toString() + ": " + s + GymTypes.size());
						}
					}
				}
			}
		}
		else
		{
			error(sender, "You need to type the gym you want to check. " + ChatColor.GREEN + "/gym list <gym>");
		}
	}

	@Override
	public String getPermission() {
		return "gym.list";
	}

	@Override
	public boolean playersOnly() {
		return true;
	}

}
