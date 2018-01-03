package minecraft.guishopplugin;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractShopListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        try {
        if(event.getRightClicked() instanceof Villager) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            Main.getInstance().getShopManager().openMainShop(player);
        }} catch(NullPointerException exception) {

        }
    }

}
