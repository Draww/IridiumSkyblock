package com.peaches.epicskyblock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Permissions {
    public int scheduler;

    private transient Inventory inventory;

    public transient ItemStack Breakblocks;
    public transient ItemStack Placeblocks;
    public transient ItemStack Interact;
    public transient ItemStack Kickmembers;
    public transient ItemStack Invitemembers;
    public transient ItemStack Regen;
    public transient ItemStack Islandprivate;
    public transient ItemStack Promote;
    public transient ItemStack Demote;

    public Permissions() {
        init();
    }

    public void init() {
        this.inventory = Bukkit.createInventory(null, 27, Utils.color(EpicSkyblock.getConfiguration().PermissionsGUITitle));
        scheduler = Bukkit.getScheduler().scheduleAsyncRepeatingTask(EpicSkyblock.getInstance(), this::addContent, 0, 10);
    }

    private void addContent() {
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, Utils.makeItem(Material.STAINED_GLASS_PANE, 1, 7, " "));
        }
        this.Breakblocks = Utils.makeItem(Material.STAINED_CLAY, 1, breakBlocks ? 5 : 14, "&b&lBreak Blocks");
        this.Placeblocks = Utils.makeItem(Material.STAINED_CLAY, 1, placeBlocks ? 5 : 14, "&b&lPlace Blocks");
        this.Interact = Utils.makeItem(Material.STAINED_CLAY, 1, interact ? 5 : 14, "&b&lInteract");
        this.Kickmembers = Utils.makeItem(Material.STAINED_CLAY, 1, kickMembers ? 5 : 14, "&b&lKick Members");
        this.Invitemembers = Utils.makeItem(Material.STAINED_CLAY, 1, inviteMembers ? 5 : 14, "&b&lInvite Members");
        this.Regen = Utils.makeItem(Material.STAINED_CLAY, 1, regen ? 5 : 14, "&b&lRegen");
        this.Islandprivate = Utils.makeItem(Material.STAINED_CLAY, 1, islandprivate ? 5 : 14, "&b&lIsland Visits");
        this.Promote = Utils.makeItem(Material.STAINED_CLAY, 1, promote ? 5 : 14, "&b&lPromote");
        this.Demote = Utils.makeItem(Material.STAINED_CLAY, 1, demote ? 5 : 14, "&b&lDemote");

        inventory.setItem(9, Breakblocks);
        inventory.setItem(10, Placeblocks);
        inventory.setItem(11, Interact);
        inventory.setItem(12, Kickmembers);
        inventory.setItem(13, Invitemembers);
        inventory.setItem(14, Regen);
        inventory.setItem(15, Islandprivate);
        inventory.setItem(16, Promote);
        inventory.setItem(17, Demote);
    }

    public boolean breakBlocks = true;
    public boolean placeBlocks = true;
    public boolean interact = true;
    public boolean kickMembers = true;
    public boolean inviteMembers = true;
    public boolean regen = false;
    public boolean islandprivate = true;
    public boolean promote = true;
    public boolean demote = true;

    public Inventory getInventory() {
        return inventory;
    }
}