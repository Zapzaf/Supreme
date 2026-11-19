package com.github.relativobr.supreme.util;

import com.github.relativobr.supreme.Supreme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import javax.annotation.Nonnull;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * {@code supreme-gear-options} in the config: potion effects, soulbound and attributes of the Supreme gear.
 */
public final class GearOptions {

  private static final String PATH = "supreme-gear-options.";

  private GearOptions() {
  }

  /** Whether Supreme armor gives potion effects. */
  public static boolean armorPotionEffects() {
    return Supreme.inst().getConfig().getBoolean(PATH + "armor-potion-effects", false);
  }

  /** Whether Supreme armor, weapons and tools stay in the inventory on death. */
  public static boolean soulbound() {
    return Supreme.inst().getConfig().getBoolean(PATH + "soulbound", false);
  }

  /** Whether Supreme armor keeps the armor, toughness and knockback resistance of its base item. */
  public static boolean armorAttributes() {
    return Supreme.inst().getConfig().getBoolean(PATH + "armor-attributes", true);
  }

  /**
   * Takes away the attributes the armor gets from its base item (armor, toughness, knockback resistance).
   * <p>
   * An item without its own attribute modifiers uses its material's, so clearing them would change nothing:
   * the item gets one modifier of +0 armor instead, which replaces the material's, and the tooltip is hidden.
   */
  public static void removeArmorAttributes(@Nonnull SlimefunItemStack item) {
    ItemMeta meta = item.getItemMeta();
    meta.setAttributeModifiers(null);
    meta.addAttributeModifier(Attribute.ARMOR, new AttributeModifier(
        new NamespacedKey(Supreme.inst(), "no_armor"), 0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.ARMOR));
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    item.setItemMeta(meta);
  }
}
