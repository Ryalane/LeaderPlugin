package me.Ryalane.Leaders.commands.Leaders;

import java.util.List;

import org.bukkit.command.CommandSender;

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
							sender.sendMessage("Removed " + args[2] + " from the " + i + " gym.");
						}
						else
						{
							sender.sendMessage("Failed to remove " + args[2] + "From the " + i + " gym.");
						}
					}
				}
			}
		}
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return "leaders.del";
	}

	@Override
	public boolean playersOnly() {
		// TODO Auto-generated method stub
		return true;
	}

}
