package de.pxav.kelp.core.event.kelpevent;

import de.pxav.kelp.core.inventory.type.KelpInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public class KelpInventoryOpenEvent extends PlayerEvent {

  private static final HandlerList handlers = new HandlerList();
  private KelpInventory inventory;
  private boolean animatedInventory;

  public KelpInventoryOpenEvent(Player who, KelpInventory inventory, boolean isAnimated) {
    super(who);
    this.inventory = inventory;
    this.animatedInventory = isAnimated;
  }

  public KelpInventory getInventory() {
    return inventory;
  }

  public boolean isAnimatedInventory() {
    return animatedInventory;
  }

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }

}
