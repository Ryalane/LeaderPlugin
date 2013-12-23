package me.Ryalane.Leaders.commands.Leaders;

import java.util.List;

import me.Ryalane.Leaders.Leader;
import me.Ryalane.Leaders.commands.Gyms.CommandBase;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class LeaderCommand extends CommandBase {
	public Leader instance = Leader.instance;
	public boolean isPlayer;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		List<String> GymTypes = instance.getConfig().getStringList("GymTypes");
		this.isPlayer = sender instanceof Player;
		
		if (sender instanceof Player)
		{
			if (args.length==2) // Must have 2 arguments
			{
				if (args[0].equalsIgnoreCase("Open"))
				{
					// Go through the list of gyms and open/close based on whats available
					for (String i : GymTypes)
					{
						if (args[1].equalsIgnoreCase(i))
						{
							boolean gymStatus = instance.getConfig().getBoolean("Gyms." + i + ".Status");
							if (gymStatus == false)
							{
							instance.getConfig().set("Gyms." + i + ".Status", true);
							instance.saveConfig();
							broadcast(sender, i + " gym is now " + ChatColor.GREEN + "open!");
							}
							else
							{
								inform(sender, "This gym is already open.");
							}
						}
					}
				}
				if (args[0].equalsIgnoreCase("Close"))
				{
					for (String i : GymTypes)
					{
						if (args[1].equalsIgnoreCase(i))
						{
							boolean gymStatus = instance.getConfig().getBoolean("Gyms." + i + ".Status");
							if (gymStatus == false)
							{
								inform(sender, "This gym is already closed.");
							}
							else
							{
							instance.getConfig().set("Gyms." + i + ".Status", false);
							instance.saveConfig();
							broadcast(sender, i + " gym is now " + ChatColor.RED + "closed.");
							}
						}
					}
				}
			}
			else// Do the default since there's no arguments
			{
				if (args[0].equalsIgnoreCase("Close") || args[0].equalsIgnoreCase("Open"))
				{
					error(sender, "Sorry, you need to specify which gym to " + args[0].toLowerCase() + ".");
				}
				else
				{
					error(sender, "Sorry, there was an error in LeaderCommand (tell Rya).");
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
		return "leaders.toggle";
	}

	@Override
	public boolean playersOnly() {
		return false;
	}

}
