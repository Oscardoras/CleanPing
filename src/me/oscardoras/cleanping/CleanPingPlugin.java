package me.oscardoras.cleanping;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class CleanPingPlugin extends Plugin implements Listener {
	
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerListener(this, this);
	}
	
	@EventHandler
	public void onPing(ProxyPingEvent e) {
		ServerPing serverPing = e.getResponse();
		Protocol protocol = serverPing.getVersion();
		protocol.setName(ProxyServer.getInstance().getVersion().split(":")[2].split("-")[0]);
		serverPing.setVersion(protocol);
		e.setResponse(serverPing);
	}
	
}