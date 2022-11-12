package kr.co.skeleton.bluemarble;

//import com.sk89q.worldedit.IncompleteRegionException;
//import com.sk89q.worldedit.bukkit.BukkitAdapter;
//import com.sk89q.worldedit.bukkit.BukkitPlayer;
//import com.sk89q.worldedit.bukkit.WorldEditPlugin;
//import com.sk89q.worldedit.math.BlockVector3;
//import com.sk89q.worldedit.regions.Region;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
//import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class BlueMarble extends JavaPlugin implements TabCompleter {

    @Override
    public void onEnable() {
//        itemManager.init();
//        wep = getWorldEditPlugin();
        Objects.requireNonNull(Bukkit.getPluginCommand("BlueMarble")).setTabCompleter(new tabcom());
        Objects.requireNonNull(Bukkit.getPluginCommand("bm")).setTabCompleter(new tabcom());
        System.out.println("[BlueMarble] plugin Enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("[BlueMarble] plugin Disabled");
    }


//    public WorldEditPlugin getWorldEditPlugin() {
//        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
//        if (p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
//        else return null;
//    }

//    WorldEditPlugin wep;



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        int[] num = {1, 2, 3, 4, 5, 6};
        if (label.equalsIgnoreCase("BlueMarble")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    if (p.isOp()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle( ChatColor.WHITE + "빈" + ChatColor.GOLD + "부" + ChatColor.GREEN + "격" + ChatColor.GREEN + "차", "by skeleton0126, Moonlight323, wooju0528", 0, 60, 0);
                        }
                    } else {
                        p.sendMessage("당신은 관리자가 아닙니다.");
                    }
                } else if (args[0].equalsIgnoreCase("roll")) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(num.length);
                    int randomNumber2 = r.nextInt(num.length);
                    int div = num[randomNumber] + num[randomNumber2];
                    if (randomNumber == randomNumber2) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("" + div, "" + p.getName(), 0, 40, 0);
                        }
                        Bukkit.broadcastMessage(p.getName() + " double! 한번더 굴리세요!");

                    } else {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("" + div, "" + p.getName(), 0, 40, 0);
                        }
                    }
                } else if(args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.GOLD + "---------- " + ChatColor.WHITE + "Blue Marble Help: Index (1/1)" + ChatColor.GOLD + " ---------------");
                    p.sendMessage(ChatColor.GOLD + "/bluemarble roll or /bm roll: " + ChatColor.WHITE + "Roll the dice");
                    p.sendMessage(ChatColor.GOLD + "/bluemarble help or /bm help: " + ChatColor.WHITE + "View the commands of the Blue Marble plugin.");
                    p.sendMessage(ChatColor.GOLD + "/bluemarble goldenkey or /bm goldenkey: " + ChatColor.WHITE + "Pull out the golden key.");
                    p.sendMessage(ChatColor.GOLD + "to be added");
                    p.sendMessage(ChatColor.GOLD + "---------------------------------------------------");
                } else if (args[0].equalsIgnoreCase("goldenkey")) {
                    itemManager.GoldenkeyFunction();
                    p.getInventory().addItem(itemManager.Goldenkey);
                } else if (args[0].equalsIgnoreCase("test")) {
                    p.sendMessage("1" + "2");
                } else {
                    p.sendMessage("잘못된 명령어입니다.");
                }
            }
//        } else if (label.equalsIgnoreCase("/check")) {
//
//            Region region = null;
//            BukkitPlayer bplayer = BukkitAdapter.adapt(p);
//            try {
//                region = wep.getSession(p).getSelection(bplayer.getWorld());
//            } catch (IncompleteRegionException e) {
//                e.printStackTrace();
//            }
//
//            BlockVector3 max = region.getMaximumPoint();
//            BlockVector3 min = region.getMinimumPoint();
//
//            p.sendMessage(max.toString() + ", " + min.toString());
//        } else if (label.equalsIgnoreCase("/giveitem")) {
//            p.getInventory().addItem(itemManager.wand);
        } else if (cmd.getName().equalsIgnoreCase("bm")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    p.performCommand("bluemarble start");
                } else if (args[0].equalsIgnoreCase("roll")) {
                    p.performCommand("bluemarble roll");
                } else if (args[0].equalsIgnoreCase("help")) {
                    p.performCommand("bluemarble help");
                } else if (args[0].equalsIgnoreCase("goldenkey")) {
                    p.performCommand("bluemarble goldenkey");
                } else {
                    p.sendMessage("잘못된 명령어입니다.");
                }
            }
        }
        return true;
    }
}
