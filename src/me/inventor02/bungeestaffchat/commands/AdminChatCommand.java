package me.inventor02.bungeestaffchat.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AdminChatCommand extends Command {

    public AdminChatCommand() {
        super("a");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {
            ComponentBuilder message = new ComponentBuilder("You must be a ProxiedPlayer to do this!").color(ChatColor.RED);

            sender.sendMessage(message.create());

            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if(!(player.hasPermission("staffchat.admin"))) {
            ComponentBuilder message = new ComponentBuilder("Insufficient permission. If you believe this is an error, contact inventor02.").color(ChatColor.RED);

            player.sendMessage(message.create());

            return;
        }

        if(args.length < 2) {
            ComponentBuilder message = new ComponentBuilder("/a [message]").color(ChatColor.DARK_PURPLE);

            player.sendMessage(message.create());

            return;
        }

        StringBuilder builder = new StringBuilder();

        for(String argument : args) {
            builder.append(argument + " ");
        }

        for(ProxiedPlayer proxiedPlayer : ProxyServer.getInstance().getPlayers()) {
            if(proxiedPlayer.hasPermission("staffchat.admin")) {
                TextComponent text1 = new TextComponent("[" + player.getServer().getInfo().getName() + "] " + player.getName() + ": " + builder.toString().trim());
                text1.setColor(ChatColor.RED);

                proxiedPlayer.sendMessage(text1);
            }
        }
    }
}