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
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ryalane.Leaders.commands.Gyms.*;
import me.Ryalane.Leaders.commands.Leaders.LeaderCMD;

@SuppressWarnings("unused")
public class Leader extends JavaPlugin
{
	public final Logger logger = Bukkit.getLogger();
	public static Leader instance;
	public PluginDescriptionFile pluginDescription;
	
	public void defaultConfig()
	{
		this.getConfig().set("GymTypes", Arrays.asList("Water", "Electric", "Grass",
				"Rock", "Normal", "Ground", "Ice", "Fighting", "Fire",
				"Psychic"));
		this.getConfig().set("Gyms.Water.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Water.Status", false);
		this.getConfig().set("Gyms.Water.Color", "BLUE");
		this.getConfig().set("Gyms.Electric.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Electric.Status", false);
		this.getConfig().set("Gyms.Electric.Color", "GOLD");
		this.getConfig().set("Gyms.Grass.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Grass.Status", false);
		this.getConfig().set("Gyms.Grass.Color", "GREEN");
		this.getConfig().set("Gyms.Rock.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Rock.Status", false);
		this.getConfig().set("Gyms.Rock.Color", "DARK_GRAY");
		this.getConfig().set("Gyms.Normal.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Normal.Status", false);
		this.getConfig().set("Gyms.Normal.Color", "LIGHT_PURPLE");
		this.getConfig().set("Gyms.Ground.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Ground.Status", false);
		this.getConfig().set("Gyms.Ground.Color", "GRAY");
		this.getConfig().set("Gyms.Ice.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Ice.Status", false);
		this.getConfig().set("Gyms.Ice.Color", "AQUA");
		this.getConfig().set("Gyms.Fighting.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Fighting.Status", false);
		this.getConfig().set("Gyms.Fighting.Color", "BOLD");
		this.getConfig().set("Gyms.Fire.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Fire.Status", false);
		this.getConfig().set("Gyms.Fire.Color", "RED");
		this.getConfig().set("Gyms.Psychic.Leaders", Arrays.asList("Ryalane"));
		this.getConfig().set("Gyms.Psychic.Status", false);
		this.getConfig().set("Gyms.Psychic.Color", "DARK_PURPLE");
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
	
	@Override
	public void onEnable()
	{
		pluginDescription = this.getDescription();
		instance = this;
		getCommand("leader").setExecutor(new LeaderCMD());
		getCommand("gym").setExecutor(new GymCMD());
		configHandler();
		logger.info(pluginDescription.getName() + " version: " + pluginDescription.getVersion() + " Has been enabled!");
	}
	
	public void onDisabled()
	{
		pluginDescription = this.getDescription();
		this.saveConfig();
		logger.info(pluginDescription.getName() + " Has been disabled");
	}
}
