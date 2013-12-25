package me.Ryalane.Leaders.commands.Leaders;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.Ryalane.Leaders.Leader;
import me.Ryalane.Leaders.commands.Gyms.CommandBase;

public class DelCommand extends CommandBase {
	public Leader instance = Leader.instance;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");

		if (args.length == 3)
		{ 
			if (args[0].equalsIgnoreCase("Del"))
			{
				for (String i : GymTypes)
				{
					// Check for the gym
					if (args[1].equalsIgnoreCase(i))
					{
						// check for the name
						List<String> Leaders = instance.getConfig().getStringList("Gyms." + i + ".Leaders");
						
						if (Leaders.contains(args[2]))
						{
							Leaders.remove(args[2]);
							instance.getConfig().set("Gyms." + i + ".Leaders", Leaders);
							instance.saveConfig();
							informWithPermission(getPermission(), "Removed " + args[2] + " from the " + i + " gym.");
							informConsole("Removed " + args[2] + " from the " + i + " gym.");
						}
						else
						{
							inform(sender, "Failed to remove " + args[2] + " From the " + i + " gym.");
							if (sender instanceof Player)
							{
								informConsole("Failed to remove " + args[2] + " From the " + i + " gym.");
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String getPermission() {
		return "leaders.del";
	}

	@Override
	public boolean playersOnly() {
		return false;
	}

}
