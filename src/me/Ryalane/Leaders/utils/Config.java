package me.Ryalane.Leaders.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import me.Ryalane.Leaders.Leader;

// TODO: Add a users folder to the leaders folder that contains a "{USERNAME}.yml" file for each user
// TODO: Add a gym file in the leader folders called "gyms.yml"
// TODO: Add a config.yml folder (already there) and have it hold settings instead of gyms
// TODO: Finish :>
// TODO: Add leader prefix if everything else is done

public class Config {
	static Plugin plugin;
	private Leader instance = Leader.instance;
	private static File pluginFolder = Leader.pluginFolder;
	private static File configFile = new File(pluginFolder, "config.yml");
	public static FileConfiguration config;
	
	public static void firstRun(Plugin p)
	{
		plugin = p;
		config = new YamlConfiguration();
		createFolder();
		createFile();
		loadConfig();
	}
	
	public static void createFolder()
	{
		
	}
	
	public static void createFile()
	{
		
	}
	
	public static void loadConfig()
	{
		
	}
	
	public static void saveConfig()
	{
		
	}
}
