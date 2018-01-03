package minecraft.guishopplugin;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public static ItemStack createItem(Material mat, int amount, int subid, String name) {
        short newsubid = (short) subid;
        ItemStack i = new ItemStack(mat, amount, newsubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(name);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack createEnchantment(Material mat, int amount, int subid, String name, Enchantment ench, int enchPower) {
        short newsubid = (short) subid;
        ItemStack i = new ItemStack(mat, amount, newsubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(name);
        m.addEnchant(ench, enchPower, true);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack addLore(String name, Material mat, String lore, int amount) {
        ItemStack s = new ItemStack(mat, amount);
        ItemMeta m = s.getItemMeta();
        m.setDisplayName(name);
        List<String> lore1 = new ArrayList<>();
        lore1.add(lore);
        m.setLore(lore1);
        s.setItemMeta(m);
        return s;
    }

    public static ItemStack addGlow(String name, Material mat, String lore, int amount) {
        ItemStack s = new ItemStack(mat, amount);
        ItemMeta m = s.getItemMeta();
        m.setDisplayName(name);
        List<String> lore1 = new ArrayList<>();
        lore1.add(lore);
        m.setLore(lore1);
        m.addEnchant(Enchantment.DURABILITY, 1, true);
        m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        s.setItemMeta(m);
        return s;
    }

}
