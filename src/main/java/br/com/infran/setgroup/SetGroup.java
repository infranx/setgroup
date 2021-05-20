package br.com.infran.setgroup;

import br.com.infran.setgroup.commands.SetGroupCommand;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import me.saiintbrisson.minecraft.command.message.MessageType;
import org.bukkit.plugin.java.JavaPlugin;

public class SetGroup extends JavaPlugin {

    @Override
    public void onEnable() {

        final BukkitFrame frame = new BukkitFrame(this);
        final MessageHolder messageHolder = frame.getMessageHolder();

        messageHolder.setMessage(MessageType.ERROR, "§cOcorreu um erro ao executar esse comando.");
        messageHolder.setMessage(MessageType.INCORRECT_TARGET,  "§cEste comando é exclusivo para jogadores.");
        messageHolder.setMessage(MessageType.INCORRECT_USAGE, "§cComando incorreto! Utilize /{usage}");
        messageHolder.setMessage(MessageType.NO_PERMISSION, "§cVocê não tem permissão para utilizar este comando.");

        frame.registerCommands(
                new SetGroupCommand()
        );

    }
}
