package br.com.infran.setgroup.commands;

import br.com.infran.setgroup.fanciful.FancyMessage;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SetGroupCommand {

    @Command(
            name = "setgroup",
            aliases = {"setargrupo"},
            permission = "hades.gerente",
            usage = "setgroup <Jogador> <Grupo>"
    )

    public void setgroupCommand(Context<Player>context, String[] args) {
        CommandSender sender = context.getSender();

        Player p = (Player) sender;
        int var10000 = args.length;
        if (args.length != 2) {
            p.sendMessage("");
            p.sendMessage(" §e➟ Lista com grupos disponíveis:");
            (new FancyMessage(" §8 ➟ §6[Master]"))
                    .tooltip("§7Exemplo: §6[Master] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " master")
                    .send(p);
            (new FancyMessage(" §8 ➟ §4[Gerente]"))
                    .tooltip("§7Exemplo: §4[Gerente] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " gerente")
                    .send(p);
            (new FancyMessage(" §8 ➟ §c[Admin]"))
                    .tooltip("§7Exemplo: §c[Admin] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " admin")
                    .send(p);
            (new FancyMessage(" §8 ➟ §2[Moderador]"))
                    .tooltip("§7Exemplo: §2[Moderador] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " moderador")
                    .send(p);
            (new FancyMessage(" §8 ➟ §e[Ajudante]"))
                    .tooltip("§7Exemplo: §e[Ajudante] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " ajudante")
                    .send(p);
            (new FancyMessage(" §8 ➟ §b[MVP§6+§b]"))
                    .tooltip("§7Exemplo: §b[MVP§6+§b] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " mvplus")
                    .send(p);
            (new FancyMessage(" §8 ➟ §6[MVP]"))
                    .tooltip("§7Exemplo: §6[MVP] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " mvp")
                    .send(p);
            (new FancyMessage(" §8 ➟ §a[VIP]"))
                    .tooltip("§7Exemplo: §a[VIP] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " vip")
                    .send(p);
            (new FancyMessage(" §8 ➟ §7[Membro]"))
                    .tooltip("§7Exemplo: §7[Membro] " + p.getName() + " \n \n§a§l❘ §aClique para setar.!")
                    .suggest("/setgroup " + p.getName() + " membro")
                    .send(p);
            p.sendMessage("");
            return;
        }


        String grupo = args[1];
        Player player = Bukkit.getPlayer(args[0]);
        if (grupo.equalsIgnoreCase("membro")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §7[Membro]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set default")
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("vip")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §a[VIP]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("mvp")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §6[MVP]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("mvplus")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §b[MVP§6+§b]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }
        if (grupo.equalsIgnoreCase("ajudante")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §4[Ajudante]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("moderador")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §2[Moderador]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("admin")) {
            (new FancyMessage(" \n §aVocê está tem certeza que deseja setar o grupo §4[Admin]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }

        if (grupo.equalsIgnoreCase("gerente")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §4[Gerente]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }
        if (grupo.equalsIgnoreCase("master")) {
            (new FancyMessage(" \n §aVocê tem certeza que deseja setar o grupo §6[Master]§a no jogador §7" + player.getName() + "?" + "\n §a§l❘ §aClique "))
                    .then("§b§lAQUI").tooltip("§aPara confirmar está ação")
                    .command("/lp user " + player.getName()  + " parent set " + grupo)
                    .then("§a para confirmar está ação. \n ").send(p);
        }
    }
}