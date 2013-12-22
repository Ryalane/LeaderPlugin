package me.Ryalane.Leaders;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class Gyms {
// This isn't actually used at all now.
	public Gyms() {
		setM_Name("Default");
		setM_Colour(ChatColor.WHITE);
		setM_Status(false);
	}
	
	public Gyms(String name)
	{
		setM_Name(name);
		setM_Colour(ChatColor.WHITE);
		setM_Status(false);
	}
	
	public Gyms(String name, ChatColor colour)
	{
		setM_Name(name);
		setM_Colour(colour);
		setM_Status(false);
	}

	public Gyms(String name, ChatColor colour, boolean status)
	{
		setM_Name(name);
		setM_Colour(colour);
		setM_Status(status);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Gym Status
	protected boolean m_Status;
	
	public boolean isM_Status() {
		return m_Status;
	}

	public void setM_Status(boolean m_Status) {
		this.m_Status = m_Status;
	}
	
	// Gym Name
	protected String m_Name;
	
	public String getM_Name() {
		return m_Name;
	}

	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	// Chat Colour
	protected ChatColor m_Colour;
	
	public ChatColor getM_Colour() {
		return m_Colour;
	}

	public void setM_Colour(ChatColor m_Colour) {
		this.m_Colour = m_Colour;
	}
	
	// Leaders
	protected List<String> leaders = new ArrayList<String>();
	
	public List<String> getLeaders() {
		return leaders;
	}

	public void setLeaders(List<String> leaders) {
		this.leaders = leaders;
	}



}
