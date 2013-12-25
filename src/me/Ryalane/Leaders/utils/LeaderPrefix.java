package me.Ryalane.Leaders.utils;

import me.Ryalane.Leaders.Leader;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LeaderPrefix extends JavaPlugin implements Listener {
	Leader plugin = Leader.instance;
	String pluginName = plugin.getDescription().getName();
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerChat(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();
		// TODO: Add leader titles?
	}
}
