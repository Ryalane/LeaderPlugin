package me.Ryalane.Leaders.commands.Leaders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Ryalane.Leaders.commands.Gyms.CommandBase;
import me.Ryalane.Leaders.utils.Badge;

// DONT USE THIS COMMAND WITHOUT PIXELMON INSTALLED ON THE SERVER

public class GiveBadge extends CommandBase {
	
	Badge badge;
	
	@Override
	public void perform(CommandSender sender, String[] args) {
		if (args.length < 3)
		{
			inform(sender, "Usage: /give <player> <badge>");
		}

		Player player = Bukkit.getPlayerExact(args[1]);
		
		try
		{
		badge = Badge.fromInt(Integer.parseInt(args[2]));
		}
		catch (NumberFormatException e)
		{
			badge = Badge.fromString(args[2].toLowerCase());
		}
		if (badge == null)
		{
			badge = Badge.fromString(args[2]);
			if (badge == null)
			{
			inform(sender, "Please enter a valid badge id");
			return;
			}
		}
		
		if (player != null)
		{
			Material material = Material.matchMaterial(badge.getID().toString());
			if (material != null)
			{
				int amount = 1;
				short data = 0;
				
				player.getInventory().addItem(new ItemStack[] { new ItemStack(material, amount, data) });
				
				broadcast(sender, player.getDisplayName() + ChatColor.WHITE + " Has just received the " + ChatColor.GOLD + badge.getFormalName() + ChatColor.WHITE + " badge!");
			}
			else
			{
				inform(sender, "Invalid badge ID: " + args[2]);
			}
		}
		else
		{
			inform(sender, "Can't find the player named: " + args[1]);
		}
	}

	@Override
	public String getPermission() {
		return "leaders.toggle";
	}

	@Override
	public boolean playersOnly() {
		return true;
	}

}
