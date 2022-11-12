package kr.co.skeleton.bluemarble;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class itemManager {
//    public static ItemStack wand;
    public static ItemStack Goldenkey;



//    public static void init() {
//        createWand();
//    }

//    private static void createWand() {
//        ItemStack item = new ItemStack(Material.STICK, 1);
//        ItemMeta meta = item.getItemMeta();
//        meta.setDisplayName("wow");
//        List<String> lore = new ArrayList<>();
//        lore.add("This is test");
//        meta.setLore(lore);
//        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, false);
//        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//        item.setItemMeta(meta);
//        wand = item;
//    }
    public static void GoldenkeyFunction() {
        Random r = new Random();
        String[] title = {"이사", "재난", "벌금", "이사", "고속도로", "이사", "우대권"},
                description = {"뒤로 한칸가기", "앞으로 세칸가기", "과속운전을 해서 적발됨 10만원을 은행에 내시오", "무인도로 가시오", "출발로 가시오", "레드스톤실험실로 가시오", "우대권"};
        int randomStoring = r.nextInt(title.length);
        String itemTitle = title[randomStoring],
                itemDescription = description[randomStoring];

        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(itemTitle);
        List<String> lore = new ArrayList<>();
        lore.add(itemDescription);
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Goldenkey = item;
    }
}
