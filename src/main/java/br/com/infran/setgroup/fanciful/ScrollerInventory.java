package br.com.infran.setgroup.fanciful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ScrollerInventory {
    public ArrayList<Inventory> pages = new ArrayList();
    public UUID id = UUID.randomUUID();
    public int currpage = 0;
    public int atual = 1;
    public static HashMap<UUID, ScrollerInventory> users = new HashMap();

    public ScrollerInventory(ArrayList<ItemStack> items, String name, Player p) {
        Inventory page = this.getBlankPage(name);
        ++this.atual;
        int slot = 0;
        int a = -1;

        for(int b = 0; b < 1000 && a + 1 != items.size(); ++b) {
            if (slot == 35) {
                this.pages.add(page);
                page = this.getBlankPage(name);
                ++this.atual;
                slot = 0;
                if (slot >= 9 && slot != 17 && slot != 26 && slot != 35 && slot != 44 && slot != 53 && slot % 9 != 0) {
                    ++a;
                    page.setItem(slot, (ItemStack)items.get(a));
                }
            } else {
                ++slot;
                if (slot >= 9 && slot != 17 && slot != 26 && slot != 35 && slot != 44 && slot != 53 && slot % 9 != 0) {
                    ++a;
                    page.setItem(slot, (ItemStack)items.get(a));
                }
            }
        }

        this.pages.add(page);
        p.openInventory((Inventory)this.pages.get(this.currpage));
        users.put(p.getUniqueId(), this);
    }

    private Inventory getBlankPage(String name) {
        Inventory page = Bukkit.createInventory((InventoryHolder)null, 54, name);
        ItemStack nextpage = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = nextpage.getItemMeta();
        meta.setDisplayName("§aPagina " + (this.atual + 1));
        nextpage.setItemMeta(meta);
        ItemStack prevpage = new ItemStack(Material.ARROW, 1);
        meta = prevpage.getItemMeta();
        meta.setDisplayName("§aPagina " + (this.atual - 1));
        prevpage.setItemMeta(meta);
        page.setItem(26, nextpage);
        if (this.atual != 1) {
            page.setItem(18, prevpage);
        }

        return page;
    }
}