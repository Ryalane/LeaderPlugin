package me.Ryalane.Leaders.commands.Leaders;

import java.util.List;

import org.bukkit.command.CommandSender;

import me.Ryalane.Leaders.Leader;
import me.Ryalane.Leaders.commands.Gyms.CommandBase;

public class AddCommand extends CommandBase {
	public Leader instance = Leader.instance;
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");
		if (args.length == 3)
		{ 
			if (args[0].equalsIgnoreCase("Add"))
			{
				for (String i : GymTypes)
				{
					// Check for the gym
					if (args[1].equalsIgnoreCase(i))
					{
						// check for the name
						List<String> Leaders = instance.getConfig().getStringList("Gyms." + i + ".Leaders");
						
						Leaders.add(args[2]);
						
						instance.getConfig().set("Gyms." + i + ".Leaders", Leaders);
						instance.saveConfig();
						sender.sendMessage("Added " + args[2] + " to the " + i + " gym.");
					}
				}
			}
		}
	}

	@Override
	public String getPermission() {
		return "leaders.add";
	}

	@Override
	public boolean playersOnly() {
		return true;
	}

}
