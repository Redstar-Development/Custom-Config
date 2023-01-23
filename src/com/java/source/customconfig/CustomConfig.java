/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.source.customconfig;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomConfig extends JavaPlugin {
    private CustomConfig plugin;
    public File Configuration = new File("plugins/NAME/", "config.yml");
    public FileConfiguration Config = YamlConfiguration.loadConfiguration(Configuration);
    
    public File Playerinformation = new File("plugins/NAME/", "playerdata.yml");
    public FileConfiguration Playerdata = YamlConfiguration.loadConfiguration(Playerinformation);

    public static final Logger logger = Logger.getLogger("Minecraft-Server");

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        com.java.source.customconfig.CustomConfig.logger.log(Level.INFO, "{0} Version{1} Has Been Enabled", new Object[]{pdfFile.getName(), pdfFile.getVersion()});
        PluginManager pm = this.getServer().getPluginManager();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    @Override
    public void onDisable() {
        com.java.source.customconfig.CustomConfig.logger.info("Blank Plugin Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (commandLabel.equalsIgnoreCase("test")) {
            Playerdata.get("test");
            Config.get("test1");
        }
        return false;
    }
    
}