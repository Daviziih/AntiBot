package me.davi;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerJoin implements Listener {

	public PlayerJoin(AntiBOT main) {
		Bukkit.getPluginManager().registerEvents(this, main);
	}

	ArrayList<String> permitidos = new ArrayList<String>();

	@EventHandler(priority = EventPriority.HIGHEST)
	private void onPingServer(ServerListPingEvent e) {
		String jogador = e.getAddress().getHostAddress();
		permitidos.add(jogador);
	}

	@EventHandler
	private void onLogin(PlayerLoginEvent e) {

		Player jogador = e.getPlayer();

		if (!permitidos.contains(jogador.getName())) {
			e.setKickMessage("§e§lANTI-BOT" + "\n\n" + "§fEspera a MOTD carregar para entrar no servidor");

			e.setResult(PlayerLoginEvent.Result.KICK_OTHER);

		}
	}
}
