package dev.anhuar.antiDebuff;

import dev.anhuar.antiDebuff.handler.CommandHandler;
import dev.anhuar.antiDebuff.handler.ListenerHandler;
import dev.anhuar.antiDebuff.handler.ManagerHandler;
import dev.anhuar.antiDebuff.handler.MongoHandler;
import dev.anhuar.antiDebuff.util.ConfigUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class AntiDebuff extends JavaPlugin {

    @Getter
    private static AntiDebuff instance;

    private ConfigUtil setting, message;

    private CommandHandler commandHandler;
    private ListenerHandler listenerHandler;
    private ManagerHandler managerHandler;
    private MongoHandler mongoHandler;

    @Override
    public void onEnable() {

        instance = this;

        setting = new ConfigUtil(this, "settings.yml");
        message = new ConfigUtil(this, "messages.yml");

        commandHandler = new CommandHandler(this);
        listenerHandler = new ListenerHandler(this);
        managerHandler = new ManagerHandler(this);
        mongoHandler = new MongoHandler(this);

    }

    @Override
    public void onDisable() {

        if (mongoHandler != null) {
            mongoHandler.close();
        }

    }
}
