package me.Ryalane.Leaders.commands.Leaders;

import java.util.HashMap;
import java.util.Map;

import me.Ryalane.Leaders.commands.Gyms.CommandBase;
import me.Ryalane.Leaders.commands.Gyms.GymCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LeaderCMD implements CommandExecutor {
	private Map<String, CommandBase> commands = new HashMap<String, CommandBase>();
	private LeaderCommand leaderCommand;
	
	public LeaderCMD() {
		this.leaderCommand = new LeaderCommand();
		commands.put("gym", new GymCommand());
		commands.put("info", new InfoCommand());
		commands.put("add", new AddCommand());
		commands.put("del", new DelCommand());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		CommandBase command;
		if (args.length == 0)
		{
			command = commands.get("info");
		}
		else if (commands.containsKey(args[0]))
		{
			command = commands.get(args[0]);
		}
		else
		{
			command = this.leaderCommand;
		}
		
		command.execute(sender, args);
		return true;
	}

}
