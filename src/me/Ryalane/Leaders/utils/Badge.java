package me.Ryalane.Leaders.utils;

import java.util.Map;

import org.apache.commons.lang.Validate;

import com.google.common.collect.Maps;

public enum Badge {
	BALANCE(10200, "balance"),
	BEACON(20201, "beacon"),
	BOULDER(10202, "boulder"),
	CASCADE(10203, "cascade"),
	COAL(10204, "coal"),
	COBBLE(10205, "cobble"),
	DYNAMO(10206, "dynamo"),
	EARTH(10207, "earth"),
	FEATHER(10208, "feather"),
	FEN(10209, "fen"),
	FOG(10210, "fog"),
	FOREST(10211, "forest"),
	GLACEIR(10212, "glaceir"),
	HEAT(10213, "heat"),
	HIVE(10214, "hive"),
	ICICLE(10215, "icicle"),
	KNUCKLE(10216, "knuckle"),
	MARSH(10217, "marsh"),
	MIND(10218, "mind"),
	MINE(10219, "mine"),
	MINERAL(10220, "mineral"),
	PLAIN(10221, "plain"),
	RAIN(10222, "rain"),
	RAINBOW(10223, "rainbow"),
	RELIC(10224, "relic"),
	RISING(10225, "rising"),
	SOUL(10226, "soul"),
	STONE(10227, "stone"),
	STORM(10228, "storm"),
	THUNDER(10229, "thunder"),
	VOLCANO(10230, "volcano"),
	ZEPHYR(10231, "zephyr");
	
	private static final Map<Integer, Badge> BY_ID = Maps.newHashMap();
	private static final Map<String, Badge> BY_STRING = Maps.newHashMap();
	
	private Integer id;
	private String name;
	
	Badge(Integer ID, String NAME)
	{
		this.id = ID;
		this.name = NAME;
	}
	
	public Integer getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getFormalName()
	{
		return this.name().substring(0, 1).toUpperCase() + this.name.substring(1);
	}
	
	public static Badge fromInt(int num)
	{
		return BY_ID.get(num);
	}
	
	public static Badge fromString(String name)
	{
		return BY_STRING.get(name);
	}
	
	static
	{
		for (Badge badge : values())
		{
			BY_ID.put(Integer.valueOf(badge.id), badge);
			BY_STRING.put(String.valueOf(badge.name), badge);
		}
	}
}
