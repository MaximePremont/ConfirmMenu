package fr.mpremont.confirmmenu.events.custom;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CancelEvent extends Event{

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
    	
        return HANDLERS;
        
    }

    public static HandlerList getHandlerList() {
    	
        return HANDLERS;
        
    }
    
    private Player player;
    private String action;
    
    public CancelEvent(Player player, String action) {
    	
    	this.player = player;
    	this.action = action;
    	
    }
    
    public Player getPlayer() {
    	
    	return player;
    	
    }
    
    public String getAction() {
    	
    	return action;
    	
    }

}
