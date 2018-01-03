package minecraft.guishopplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopBuildManager {

    public void openMainShop(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3, "Shop");

        for(int i = 0; i < 9*3; i++) {
            inventory.setItem(i, Items.createItem(Material.STAINED_GLASS_PANE, 1, 15, ""));
        }

        inventory.setItem(11, Items.createItem(Material.COAL, 1, 15, "Sell shop"));

        player.openInventory(inventory);
    }

}

