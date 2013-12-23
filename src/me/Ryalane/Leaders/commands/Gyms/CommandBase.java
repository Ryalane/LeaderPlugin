package me.Ryalane.Leaders.commands.Gyms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Created by lenis0012
// Edited by Ryalane
// Date: 2013-12-22

public abstract class CommandBase {
	private boolean isPlayer;
	
	public final void execute(CommandSender sender, String[] args) {
		this.isPlayer = sender instanceof Player;
		
		if (this.playersOnly() && !this.isPlayer) {
			error(sender, "MEOW MEOW MEOW MEOW MEOW MEOW MEOW");
			return;
		}
		
		if (this.getPermission() != null && !sender.hasPermission(this.getPermission())) {
			error(sender, "Sorry, you don't have permission for this command.");
			return;
		}
		
		this.perform(sender, args);
	}
	
	public void error(CommandSender sender, String msg) {
		String color = this.isPlayer ? ChatColor.RED.toString() : ChatColor.WHITE.toString();
		sender.sendMessage(ChatColor.BLUE + "[Leader Error] " + color + msg);
	}
	
	public void broadcast(CommandSender sender, String msg) {
		String color = this.isPlayer ? ChatColor.DARK_AQUA.toString() : "";
		Bukkit.broadcastMessage(ChatColor.RED + "[Leader] " + color + msg);
	}
	
	public void inform(CommandSender sender, String msg) {
		String color = this.isPlayer ? ChatColor.GREEN.toString() : "";
		sender.sendMessage(color + msg);
	}
	
	boolean isPlayer() {
		return this.isPlayer;
	}
	
	public abstract void perform(CommandSender sender, String[] args);
	
	public abstract String getPermission();
	
	public abstract boolean playersOnly();
}
