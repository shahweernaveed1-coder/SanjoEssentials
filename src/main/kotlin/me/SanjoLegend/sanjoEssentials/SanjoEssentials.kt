package me.SanjoLegend.SanjoEssentials

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.hover.content.Text
import org.bukkit.Sound

class SanjoEssentials : JavaPlugin() {

    override fun onEnable() {
        logger.info("SanjoEssentials Plugin is Starting!")
    }

    override fun onDisable() {
        logger.info("§anjoEssentials Plugin is Stopping")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            when (command.name.lowercase()) {

                "youtube" -> {
                    val message = TextComponent("§aHey ${sender.name}, want to check out our §cYouTube Channel?")
                    message.clickEvent = ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.youtube.com/@SanjoOfficial1000")
                    message.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("§eClick to open Sanjo's official channel!"))
                    sender.spigot().sendMessage(message)
                    sender.playSound(sender.location, Sound.BLOCK_BEACON_ACTIVATE, 1.0f, 1.0f)
                    return true
                }

                "discord" -> {
                    val message = TextComponent("§bJoin our §9Discord Server §bnow!")
                    message.clickEvent = ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/dvUDwq9b")
                    message.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("§dClick to join our awesome community!"))
                    sender.spigot().sendMessage(message)
                    sender.playSound(sender.location, Sound.UI_BUTTON_CLICK, 1.0f, 1.0f)
                    return true
                }
            }
        } else {
            sender.sendMessage("§cOnly players can use this command!")
        }

        return false
    }
}
