package me.Ryalane.Leaders;

import java.io.File;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

// Commands:
// leader
// leader list
// leader open <gym>
// leader close <gym>
// leader add
// leader del
// Gym <name>
// Gyms

@SuppressWarnings("unused")
public class Main extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void defaultConfig()
	{
		this.getConfig().set("GymTypes", Arrays.asList("Water", "Electric", "Grass",
				"Rock", "Normal", "Ground", "Ice", "Fighting", "Fire",
				"Psychic"));
		this.getConfig().set("Gyms.Water.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Water.Status", "Closed");
		this.getConfig().set("Gyms.Electric.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Electric.Status", "Closed");
		this.getConfig().set("Gyms.Grass.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Grass.Status", "Closed");
		this.getConfig().set("Gyms.Rock.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Rock.Status", "Closed");
		this.getConfig().set("Gyms.Normal.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Normal.Status", "Closed");
		this.getConfig().set("Gyms.Ground.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Ground.Status", "Closed");
		this.getConfig().set("Gyms.Ice.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Ice.Status", "Closed");
		this.getConfig().set("Gyms.Fighting.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Fighting.Status", "Closed");
		this.getConfig().set("Gyms.Fire.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Fire.Status", "Closed");
		this.getConfig().set("Gyms.Psychic.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Psychic.Status", "Closed");
	}
	
	public void configHandler()
	{
		File configFile;
		configFile = new File(getDataFolder(), "config.yml");
		this.reloadConfig();
		if (!configFile.exists())
		{
			this.saveDefaultConfig();
		
			defaultConfig();
		}
		
		this.saveConfig();
	}
	
	public void onEnable()
	{
		configHandler();
		System.out.println("Leaders plugin Enabled");
	}
	
	public void onDisabled()
	{
		this.saveConfig();
		System.out.println("Leaders plugin Disabled");
	}
	
	public boolean Gym(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> GymTypes = Main.this.getConfig().getStringList("GymTypes");
		Player player = (Player)sender;
		if (args.length == 1)
		{
			for (String i : GymTypes)
			{
				if (args[0].equalsIgnoreCase(i))
				{
					String gymStatus = Main.this.getConfig().getString("Gyms." + i + ".Status");
					ChatColor statusColour = (gymStatus == "Open") ? ChatColor.GREEN : ChatColor.RED;
					player.sendMessage(i + " gym is : " + statusColour + gymStatus);
					return true;
				}
			}
		}
		else if (args.length == 0)
		{		
			player.sendMessage("List of Gyms:");
			
			for (String i : GymTypes)
			{
				String gymStatus = Main.this.getConfig().getString("Gyms." + i + ".Status");
				ChatColor statusColour = (gymStatus == "Open") ? ChatColor.GREEN : ChatColor.RED;
				player.sendMessage(i + " gym is : " + statusColour + gymStatus);
			}
			return true;
		}
		else
		{
			return false;
		}
	return false;
	}
	
	public boolean Leader(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> GymTypes = Main.this.getConfig().getStringList("GymTypes");
		Player player = (Player)sender;
		
			if (args.length==2) // Must have 2 arguments
			{
				if (args[0].equalsIgnoreCase("Open"))
				{
					// Go through the list of gyms and open/close based on whats available
					for (String i : GymTypes)
					{
						if (args[1].equalsIgnoreCase(i))
						{
							Main.this.getConfig().set("Gyms." + i + ".Status", "Open");
							Main.this.saveConfig();
							Bukkit.broadcastMessage( i + " gym is now " + ChatColor.GREEN + "open!");
						}
					}
				}
				if (args[0].equalsIgnoreCase("Close"))
				{
					for (String i : GymTypes)
					{
						if (args[1].equalsIgnoreCase(i))
						{
							Main.this.getConfig().set("Gyms." + i + ".Status", "Closed");
							Main.this.saveConfig();
							Bukkit.broadcastMessage( i + " gym is now " + ChatColor.RED + "closed.");
						}
					}
				}
				return true;
			}
		return false;
	}

	public boolean ListLeaders(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> GymTypes = Main.this.getConfig().getStringList("GymTypes");
		if (args.length == 2)
		{
			if (args[0].equalsIgnoreCase("List"))
			{
				for (String i : GymTypes)
				{
					if (args[1].equalsIgnoreCase(i))
					{
						sender.sendMessage("Leaders of " + i + ": ");
						for (String s : Main.this.getConfig().getStringList("Gyms." + i + ".Leaders"))
						{
							sender.sendMessage(s);
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public boolean AddLeader(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> GymTypes = Main.this.getConfig().getStringList("GymTypes");
		if (args.length == 3)
		{ 
			if (args[0].equalsIgnoreCase("Add"))
			{
				for (String i : GymTypes)
				{
					// Check for the gym
					if (args[1].equalsIgnoreCase(i))
					{
						String newGym = args[1];
						// check for the name
						List<String> Leaders = Main.this.getConfig().getStringList("Gyms." + i + ".Leaders");
						
						Leaders.add(args[2]);
						
						Main.this.getConfig().set("Gyms." + i + ".Leaders", Leaders);
						Main.this.saveConfig();
						sender.sendMessage("Added " + args[2] + " to the " + i + " gym.");
					}
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean DelLeader(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> GymTypes = Main.this.getConfig().getStringList("GymTypes");
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
						List<String> Leaders = Main.this.getConfig().getStringList("Gyms." + i + ".Leaders");
						
						if (Leaders.contains(args[2]))
						{
							Leaders.remove(args[2]);
							Main.this.getConfig().set("Gyms." + i + ".Leaders", Leaders);
							Main.this.saveConfig();
							sender.sendMessage("Removed " + args[2] + " from the " + i + " gym.");
						}
						else
						{
							sender.sendMessage("Failed to remove " + args[2] + "From the " + i + " gym.");
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("leader"))
		{
			if (player.hasPermission("leaders.leader"))
			{
				if (args[0].equalsIgnoreCase("Open") || args[0].equalsIgnoreCase("Close"))
				{
					Leader(sender, cmd, label, args);
					return true;
				}
			}
			else
			{
				sender.sendMessage("You don't have permission to open and close gyms.");
				return false;
			}
			if (player.hasPermission("leaders.add"))
			{
				if (args[0].equalsIgnoreCase("Add"))
				{
					AddLeader(sender, cmd, label, args);
					return true;
				}
			}
			else
			{
				sender.sendMessage("You don't have permission to add new leaders.");
				return false;
			}
			if (player.hasPermission("leaders.del"))
			{
				if (args[0].equalsIgnoreCase("Del"))
				{
					DelLeader(sender, cmd, label, args);
					return true;
				}
			}
			else
			{
				sender.sendMessage("You don't have permission to delete leaders.");
				return false;
			}
		}
		if (cmd.getName().equalsIgnoreCase("gym"))
		{
			if (player.hasPermission("leaders.list") && args.length >= 2)
			{
				if (args[0].equalsIgnoreCase("List"))
				{
					ListLeaders(sender, cmd, label, args);
					return true;
				}
			}
			else if (player.hasPermission("leaders.gym") && args.length < 2)
			{
				Gym(sender, cmd, label, args);
				return true;
			}
		}
		return false;
	}
}
