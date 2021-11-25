package me.davi;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiBOT extends JavaPlugin {

	public static AntiBOT plugin;

	@Override
	public void onEnable() {
		plugin = this;

		new PlayerJoin(plugin);
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

}
