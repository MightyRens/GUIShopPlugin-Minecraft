package minecraft.guishopplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopBuildManager {

    public void openMainShop(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3, "Shop");

        for(int i = 0; i < 9*3; i++) {
            inventory.setItem(i, Items);
        }

        player.openInventory(inventory);
    }

}

