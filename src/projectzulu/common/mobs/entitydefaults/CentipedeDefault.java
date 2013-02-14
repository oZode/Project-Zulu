package projectzulu.common.mobs.entitydefaults;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import projectzulu.common.api.CustomEntityList;
import projectzulu.common.api.CustomMobData;
import projectzulu.common.api.ItemList;
import projectzulu.common.core.DefaultSpawnable;
import projectzulu.common.core.ItemGenerics;
import projectzulu.common.mobs.entity.EntityCentipede;
import projectzulu.common.mobs.models.ModelCentipede;

import com.google.common.base.Optional;

public class CentipedeDefault extends DefaultSpawnable{
	
	public CentipedeDefault(){
		super("Centipede", EntityCentipede.class);		
		setSpawnProperties(EnumCreatureType.monster, 1, 35, 1, 1);
		setRegistrationProperties(128, 3, true);
		setModelAndRender(ModelCentipede.class, "projectzulu.common.mobs.renders.RenderGenericLiving");

		eggColor1 = (77 << 16) + (22 << 8) + 17;						eggColor2 = (212 << 16) + (97 << 8) + 38;
		defaultBiomesToSpawn.add(BiomeGenBase.plains.biomeName); 		defaultBiomesToSpawn.add(BiomeGenBase.extremeHills.biomeName);
		defaultBiomesToSpawn.add(BiomeGenBase.forest.biomeName); 		defaultBiomesToSpawn.add(BiomeGenBase.taiga.biomeName);
		defaultBiomesToSpawn.add(BiomeGenBase.swampland.biomeName); 	defaultBiomesToSpawn.add(BiomeGenBase.forestHills.biomeName);
		defaultBiomesToSpawn.add("Autumn Woods");						defaultBiomesToSpawn.add("Birch Forest");
		defaultBiomesToSpawn.add("Forested Hills");						defaultBiomesToSpawn.add("Forested Island");
		defaultBiomesToSpawn.add("Green Hills");						defaultBiomesToSpawn.add("Redwood Forest");
		defaultBiomesToSpawn.add("Lush Redwoods");						defaultBiomesToSpawn.add("Temperate Rainforest");
		defaultBiomesToSpawn.add("Woodlands");
	}
	
	@Override
	public void outputDataToList() {
		if(shouldExist){
			CustomMobData customMobData = new CustomMobData(mobName, secondarySpawnRate, reportSpawningInLog);
			if(ItemList.scrapMeat.isPresent()){ customMobData.addLootToMob(new ItemStack(ItemList.scrapMeat.get()), 15); }
			if(ItemList.genericCraftingItems1.isPresent()){
				customMobData.addLootToMob(new ItemStack(ItemList.genericCraftingItems1.get().itemID, 1, ItemGenerics.Properties.Antennae.meta()), 1);
			}
			CustomEntityList.centipede = Optional.of(customMobData);	
		}
	}
}