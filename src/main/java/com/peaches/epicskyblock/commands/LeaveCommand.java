package com.peaches.epicskyblock.commands;

import com.peaches.epicskyblock.EpicSkyblock;
import com.peaches.epicskyblock.Roles;
import com.peaches.epicskyblock.User;
import com.peaches.epicskyblock.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaveCommand extends Command {

    public LeaveCommand() {
        super(Arrays.asList("leave"), "Leave an island", "", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        User user = User.getUser(p);
        if (user.getIsland() != null) {
            if (user.role.equals(Roles.Owner)) {
                sender.sendMessage(Utils.color(EpicSkyblock.getMessages().cantLeaveIfOwner.replace("%prefix%", EpicSkyblock.getConfiguration().prefix)));
            } else {
                user.getIsland().removeUser(user);
                sender.sendMessage(Utils.color(EpicSkyblock.getMessages().leftIsland.replace("%prefix%", EpicSkyblock.getConfiguration().prefix)));
            }
        } else {
            sender.sendMessage(Utils.color(EpicSkyblock.getMessages().noIsland.replace("%prefix%", EpicSkyblock.getConfiguration().prefix)));
        }
    }

    @Override
    public List<String> TabComplete(CommandSender cs, org.bukkit.command.Command cmd, String s, String[] args) {
        return null;
    }
}
