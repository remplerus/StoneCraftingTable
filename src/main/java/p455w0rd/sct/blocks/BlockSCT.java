package p455w0rd.sct.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.sct.StoneCraftingTable;
import p455w0rd.sct.blocks.tiles.TileSCT;
import p455w0rd.sct.init.ModGlobals;

/**
 * @author p455w0rd
 *
 */
public class BlockSCT extends Block implements ITileEntityProvider {

	protected static final String NAME = "stone_crafting_table";

	public BlockSCT() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setUnlocalizedName(NAME);
		setRegistryName(ModGlobals.MODID + ":" + NAME);
		setHarvestLevel("pickaxe", 1);
		setHardness(5.0F);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		}
		else {
			player.openGui(StoneCraftingTable.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
			player.addStat(StatList.CRAFTING_TABLE_INTERACTION);
			return true;
		}
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
		player.addStat(StatList.getBlockStats(this));
		player.addExhaustion(0.025F);
		stack = getItemBlockWithNBT(te);
		spawnAsEntity(world, pos, stack);
	}

	private ItemStack getItemBlockWithNBT(TileEntity te) {
		ItemStack stack = getSilkTouchDrop(te.getWorld().getBlockState(te.getPos()));
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		if (te != null && te instanceof TileSCT && !((TileSCT) te).isEmpty()) {
			te.writeToNBT(nbttagcompound);
			stack.setTagInfo("BlockEntityTag", nbttagcompound);
		}
		return stack;
	}

	@SideOnly(Side.CLIENT)
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileSCT();
	}

}
