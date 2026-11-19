package com.github.relativobr.supreme.gear;

import com.github.relativobr.supreme.util.GearOptions;

import com.github.relativobr.supreme.Supreme;
import com.github.relativobr.supreme.machine.multiblock.MultiBlockGearFabricator;
import com.github.relativobr.supreme.util.EnchantsAndEffectsUtil;
import com.github.relativobr.supreme.util.ItemGroups;
import com.github.relativobr.supreme.util.ItemTier;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.Soulbound;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.bukkit.inventory.ItemStack;

public class AbstractWeapons extends SlimefunItem implements NotPlaceable {

  @ParametersAreNonnullByDefault
  public AbstractWeapons(@Nonnull SlimefunItemStack stack, ItemStack[] recipe) {
    super(ItemGroups.WEAPONS_CATEGORY, stack, MultiBlockGearFabricator.getMachine(), recipe);
  }

  /** Supreme weapons, soulbound or not (supreme-gear-options.soulbound in the config). */
  @ParametersAreNonnullByDefault
  private static AbstractWeapons create(@Nonnull SlimefunItemStack stack, ItemStack[] recipe) {
    return GearOptions.soulbound() ? new WithSoulbound(stack, recipe) : new AbstractWeapons(stack, recipe);
  }

  /** Supreme weapons that stay in the inventory on death. */
  private static final class WithSoulbound extends AbstractWeapons implements Soulbound {

    @ParametersAreNonnullByDefault
    private WithSoulbound(@Nonnull SlimefunItemStack stack, ItemStack[] recipe) {
      super(stack, recipe);
    }
  }

  public static void setup(Supreme sup) {

    // add Enchant
    EnchantsAndEffectsUtil.addGearBasicEnchants(WeaponsBasic.TITANIUM_SWORD, WeaponsBasic.AURUM_SWORD, WeaponsBasic.ADAMANTIUM_SWORD);

    // add Enchant
    EnchantsAndEffectsUtil.addGearThorniumEnchants(WeaponsThornium.THORNIUM_BOW, WeaponsThornium.THORNIUM_BOW_MAGIC,
        WeaponsThornium.THORNIUM_BOW_RARE, WeaponsThornium.THORNIUM_BOW_EPIC, WeaponsThornium.THORNIUM_BOW_LEGENDARY,
        WeaponsThornium.THORNIUM_BOW_SUPREME, WeaponsThornium.THORNIUM_SWORD, WeaponsThornium.THORNIUM_SWORD_MAGIC,
        WeaponsThornium.THORNIUM_SWORD_RARE, WeaponsThornium.THORNIUM_SWORD_EPIC,
        WeaponsThornium.THORNIUM_SWORD_LEGENDARY, WeaponsThornium.THORNIUM_SWORD_SUPREME,
        WeaponsThornium.THORNIUM_SHIELD, WeaponsThornium.THORNIUM_SHIELD_MAGIC, WeaponsThornium.THORNIUM_SHIELD_RARE,
        WeaponsThornium.THORNIUM_SHIELD_EPIC, WeaponsThornium.THORNIUM_SHIELD_LEGENDARY,
        WeaponsThornium.THORNIUM_SHIELD_SUPREME);

    final AbstractWeapons bow = create(WeaponsThornium.THORNIUM_BOW, WeaponsThornium.RECIPE_THORNIUM_BOW);
    bow.register(sup);
    final AbstractWeapons bowMagic = create(WeaponsThornium.THORNIUM_BOW_MAGIC,
        ItemTier.getMagicRecipe(WeaponsThornium.THORNIUM_BOW));
    bowMagic.register(sup);
    final AbstractWeapons bowRare = create(WeaponsThornium.THORNIUM_BOW_RARE,
        ItemTier.getRareRecipe(WeaponsThornium.THORNIUM_BOW_MAGIC));
    bowRare.register(sup);
    final AbstractWeapons bowEpic = create(WeaponsThornium.THORNIUM_BOW_EPIC,
        ItemTier.getEpicRecipe(WeaponsThornium.THORNIUM_BOW_RARE));
    bowEpic.register(sup);
    final AbstractWeapons bowLegendary = create(WeaponsThornium.THORNIUM_BOW_LEGENDARY,
        ItemTier.getLegendaryRecipe(WeaponsThornium.THORNIUM_BOW_EPIC));
    bowLegendary.register(sup);
    final AbstractWeapons bowSupreme = create(WeaponsThornium.THORNIUM_BOW_SUPREME,
        ItemTier.getSupremeRecipe(WeaponsThornium.THORNIUM_BOW_LEGENDARY));
    bowSupreme.register(sup);

    final AbstractWeapons titaniumSword = create(WeaponsBasic.TITANIUM_SWORD,
        WeaponsBasic.RECIPE_TITANIUM_SWORD);
    titaniumSword.register(sup);
    final AbstractWeapons aurumSword = create(WeaponsBasic.AURUM_SWORD, WeaponsBasic.RECIPE_AURUM_SWORD);
    aurumSword.register(sup);
    final AbstractWeapons adamantiumSword = create(WeaponsBasic.ADAMANTIUM_SWORD,
        WeaponsBasic.RECIPE_ADAMANTIUM_SWORD);
    adamantiumSword.register(sup);

    final AbstractWeapons sword = create(WeaponsThornium.THORNIUM_SWORD,
        WeaponsThornium.RECIPE_THORNIUM_SWORD);
    sword.register(sup);
    final AbstractWeapons swordMagic = create(WeaponsThornium.THORNIUM_SWORD_MAGIC,
        ItemTier.getMagicRecipe(WeaponsThornium.THORNIUM_SWORD));
    swordMagic.register(sup);
    final AbstractWeapons swordRare = create(WeaponsThornium.THORNIUM_SWORD_RARE,
        ItemTier.getRareRecipe(WeaponsThornium.THORNIUM_SWORD_MAGIC));
    swordRare.register(sup);
    final AbstractWeapons swordEpic = create(WeaponsThornium.THORNIUM_SWORD_EPIC,
        ItemTier.getEpicRecipe(WeaponsThornium.THORNIUM_SWORD_RARE));
    swordEpic.register(sup);
    final AbstractWeapons swordLegendary = create(WeaponsThornium.THORNIUM_SWORD_LEGENDARY,
        ItemTier.getLegendaryRecipe(WeaponsThornium.THORNIUM_SWORD_EPIC));
    swordLegendary.register(sup);
    final AbstractWeapons swordSupreme = create(WeaponsThornium.THORNIUM_SWORD_SUPREME,
        ItemTier.getSupremeRecipe(WeaponsThornium.THORNIUM_SWORD_LEGENDARY));
    swordSupreme.register(sup);

    final AbstractWeapons shield = create(WeaponsThornium.THORNIUM_SHIELD,
        WeaponsThornium.RECIPE_THORNIUM_SHIELD);
    shield.register(sup);
    final AbstractWeapons shieldMagic = create(WeaponsThornium.THORNIUM_SHIELD_MAGIC,
        ItemTier.getMagicRecipe(WeaponsThornium.THORNIUM_SHIELD));
    shieldMagic.register(sup);
    final AbstractWeapons shieldRare = create(WeaponsThornium.THORNIUM_SHIELD_RARE,
        ItemTier.getRareRecipe(WeaponsThornium.THORNIUM_SHIELD_MAGIC));
    shieldRare.register(sup);
    final AbstractWeapons shieldEpic = create(WeaponsThornium.THORNIUM_SHIELD_EPIC,
        ItemTier.getEpicRecipe(WeaponsThornium.THORNIUM_SHIELD_RARE));
    shieldEpic.register(sup);
    final AbstractWeapons shieldLegendary = create(WeaponsThornium.THORNIUM_SHIELD_LEGENDARY,
        ItemTier.getLegendaryRecipe(WeaponsThornium.THORNIUM_SHIELD_EPIC));
    shieldLegendary.register(sup);
    final AbstractWeapons shieldSupreme = create(WeaponsThornium.THORNIUM_SHIELD_SUPREME,
        ItemTier.getSupremeRecipe(WeaponsThornium.THORNIUM_SHIELD_LEGENDARY));
    shieldSupreme.register(sup);
  }
}
