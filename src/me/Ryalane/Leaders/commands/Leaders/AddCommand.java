package me.Ryalane.Leaders.commands.Leaders;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.Ryalane.Leaders.Leader;
import me.Ryalane.Leaders.commands.Gyms.CommandBase;

public class AddCommand extends CommandBase {
	public Leader instance = Leader.instance;
	public boolean isPlayer;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");
		
		this.isPlayer = sender instanceof Player;
		
		if (sender instanceof Player)
		{
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
							inform(sender, "Added " + args[2] + " to the " + i + " gym.");
							informConsole("Added " + args[2] + " to the " + i + " gym.");
						}
					}
				}
			}
		}
		else if (sender instanceof ConsoleCommandSender)
		{
			informConsole("Oh dear");
		}
	}

	@Override
	public String getPermission() {
		return "leaders.add";
	}

	@Override
	public boolean playersOnly() {
		return false;
	}

}
