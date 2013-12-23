package me.Ryalane.Leaders.commands.Gyms;

import java.util.HashMap;
import java.util.Map;

import me.Ryalane.Leaders.commands.Leaders.InfoCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GymCMD implements CommandExecutor {
	private Map<String, CommandBase> commands = new HashMap<String, CommandBase>();
	private GymCommand gymCommand;
	
	public GymCMD() {
		this.gymCommand = new GymCommand();
		commands.put("gym", new GymCommand());
		commands.put("gyms", new GymsCommand());
		commands.put("info", new InfoCommand());
		commands.put("list", new ListCommand());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		CommandBase command;
		if (args.length == 0)
		{
			command = commands.get("gyms");
		}
		else if (commands.containsKey(args[0]))
		{
			command = commands.get(args[0]);
		}
		else
		{
			command = this.gymCommand;
		}
		
		command.execute(sender, args);
		return true;
	}

}
