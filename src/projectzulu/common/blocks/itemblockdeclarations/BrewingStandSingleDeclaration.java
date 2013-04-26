package projectzulu.common.blocks.itemblockdeclarations;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import projectzulu.common.api.BlockList;
import projectzulu.common.core.ProjectZuluLog;
import projectzulu.common.core.itemblockdeclaration.BlockDeclaration;
import projectzulu.common.potion.brewingstands.BlockBrewingStandSingle;
import projectzulu.common.potion.brewingstands.RenderBrewingStandSingle;
import projectzulu.common.potion.brewingstands.TileEntityBrewingTriple;

import com.google.common.base.Optional;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BrewingStandSingleDeclaration extends BlockDeclaration {

    private int renderID = -1;

    public BrewingStandSingleDeclaration() {
        super("BrewingStandSingle");
    }

    @Override
    protected void preCreateLoadConfig(Configuration config) {
        renderID = config.get("Do Not Touch", "Brewing Stand Single Render ID", renderID).getInt(renderID);
        renderID = renderID == -1 ? RenderingRegistry.getNextAvailableRenderId() : renderID;
    }

    @Override
    protected boolean createBlock(int iD) {
        BlockList.brewingStandSingle = Optional.of(new BlockBrewingStandSingle(iD, renderID)
                .setUnlocalizedName("brewingSingle"));
        return true;
    }

    @Override
    protected void registerBlock() {
        Block block = BlockList.brewingStandSingle.get();
        GameRegistry.registerBlock(block, name.toLowerCase());
        LanguageRegistry.addName(block, "Brewing Stand Single");
        GameRegistry.registerTileEntity(TileEntityBrewingTriple.class, "TileEntityBrewingSingle");
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void clientRegisterBlock() {
        RenderingRegistry.registerBlockHandler(renderID, new RenderBrewingStandSingle(1));
        ProjectZuluLog.info("Brewing Stand Single Render ID Registed to %s", renderID);
        // ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrewingSingle.class,
        // new RenderBrewingStandSingle());
    }
}