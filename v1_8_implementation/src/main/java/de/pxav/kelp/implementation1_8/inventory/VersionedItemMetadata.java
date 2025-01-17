package de.pxav.kelp.implementation1_8.inventory;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.pxav.kelp.core.inventory.metadata.*;
import de.pxav.kelp.core.version.Versioned;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

@Versioned
public class VersionedItemMetadata extends ItemMetadataVersionTemplate {

  @Override
  public ItemStack applyMetadata(ItemStack itemStack, ItemMetadata metadata) {

    if (metadata instanceof LeatherArmorMetadata) {
      LeatherArmorMetadata kelpMeta = (LeatherArmorMetadata) metadata;
      LeatherArmorMeta armorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
      armorMeta.setColor(kelpMeta.getColor().getBukkitColor());
      itemStack.setItemMeta(armorMeta);
      return itemStack;
    }

    if (metadata instanceof SkullMetadata) {
      SkullMetadata kelpMeta = (SkullMetadata) metadata;
      SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();

      if (kelpMeta.getTextureURL() != null) {
        try {

          GameProfile profile = new GameProfile(UUID.randomUUID(), null);
          profile.getProperties().put("textures", new Property("textures", kelpMeta.getTextureURL()));

          Field profileField = skullMeta.getClass().getDeclaredField("profile");
          profileField.setAccessible(true);
          profileField.set(skullMeta, profile);

        } catch (Exception ex) {
          ex.printStackTrace();
        }

        itemStack.setItemMeta(skullMeta);
      } else if (kelpMeta.getSkullOwner() != null) {
        skullMeta.setOwner(kelpMeta.getSkullOwner());
        itemStack.setItemMeta(skullMeta);
      }

      return itemStack;
    }

    return itemStack;
  }

  @Override
  public ItemMetadata getMetadata(ItemStack itemStack) {
    ItemMeta itemMeta = itemStack.getItemMeta();

    if (itemMeta instanceof LeatherArmorMeta) {
      LeatherArmorMeta armorMeta = (LeatherArmorMeta) itemMeta;
      LeatherArmorMetadata kelpMeta = LeatherArmorMetadata.create();
      kelpMeta.setColor(Color.fromBukkit(armorMeta.getColor()));
      return kelpMeta;
    }

    if (itemMeta instanceof SkullMeta) {
      SkullMeta skullMeta = (SkullMeta) itemMeta;
      SkullMetadata kelpMeta = SkullMetadata.create();



      kelpMeta.setSkullOwner(skullMeta.getOwner());
      return kelpMeta;
    }

    return null;
  }

}
