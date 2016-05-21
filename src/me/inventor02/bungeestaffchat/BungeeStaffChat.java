package me.inventor02.bungeestaffchat;

import me.inventor02.bungeestaffchat.commands.StaffChatCommand;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeStaffChat extends Plugin {
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
    }

    @Override
    public void onDisable() {
        //
    }
}
