package me.Ryalane.Leaders;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ryalane.Leaders.commands.Gyms.*;
import me.Ryalane.Leaders.commands.Leaders.LeaderCMD;
import me.Ryalane.Leaders.utils.*;

@SuppressWarnings("unused")
public class Leader extends JavaPlugin
{
	public final Logger logger = Bukkit.getLogger();
	public static Leader instance;
	public static String pluginName;
	public static File pluginFolder;
	public static String pluginVersion;
	public PluginDescriptionFile pluginDescription;
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;

	@Override
	public void onEnable()
	{
		pluginName = getDescription().getName();
		pluginFolder = getDataFolder();
		pluginVersion = getDescription().getVersion();
		pluginDescription = this.getDescription();
		instance = this;
		FileConfiguration config = this.getConfig();
		
		// Setup config.yml
		config.addDefault("GymTypes", Arrays.asList("Water", "Electric", "Grass",
				"Rock", "Normal", "Ground", "Ice", "Fighting", "Fire",
				"Psychic"));
		config.options().copyDefaults(true);
		this.saveConfig();
		
		// Setup gyms.yml
		FileConfiguration gymCfg = this.getCustomConfig();
		//gymCfg.addDefault("GymTypes", Arrays.asList("Water", "Electric", "Grass",
		//		"Rock", "Normal", "Ground", "Ice", "Fighting", "Fire",
		//		"Psychic"));
		//gymCfg.options().copyDefaults(true);
		//this.saveCustomConfig();
		
		// Setup commands
		getCommand("leader").setExecutor(new LeaderCMD());
		getCommand("gym").setExecutor(new GymCMD());
		
		logger.info(pluginDescription.getName() + " version: " + pluginDescription.getVersion() + " Has been enabled!");
	}
	
	public void onDisabled()
	{
		pluginDescription = this.getDescription();
		this.saveConfig();
		logger.info(pluginDescription.getName() + " Has been disabled");
	}
	
	public Player getPlayer(String name) {
		Player player = Bukkit.getServer().getPlayer(name);
		
		if (player != null) {
			if (player.isOnline())
			{
				return player;
			}
			
			for (Player p : this.getServer().getOnlinePlayers()) {
				if (player.getName().toLowerCase().startsWith(name) || player.getName().startsWith(name)) {
					return player;
				}
			}
			
			for (Player p : this.getServer().getOnlinePlayers()) {
				if (player.getName().toLowerCase().endsWith(name) || player.getName().endsWith(name)) {
					return player;
				}
			}
			
			for (Player p : this.getServer().getOnlinePlayers()) {
				if (player.getName().toLowerCase().contains(name) || player.getName().contains(name)) {
					return player;
				}
			}
		}
		
		return null;
	}
	
	public void reloadCustomConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(getDataFolder(), "config.yml");
		}
	}
	
	public FileConfiguration getCustomConfig() {
		if (customConfigFile == null) {
			this.reloadCustomConfig();
		}
		return customConfig;
	}
	
	public void saveCustomConfig() {
		if (customConfig == null || customConfigFile == null) {
			return;
		} try {
			getCustomConfig().save(customConfigFile);
		} catch (IOException e) {
			this.getLogger().log(Level.SEVERE,  "Couldn't save config to " + customConfigFile, e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
