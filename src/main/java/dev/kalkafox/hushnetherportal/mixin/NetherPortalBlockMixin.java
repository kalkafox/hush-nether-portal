package dev.kalkafox.hushnetherportal.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin
{
	@Inject(at = @At("HEAD"), method = "animateTick", cancellable = true)
	private void animateTick(
			BlockState p_221794_, Level p_221795_, BlockPos p_221796_, RandomSource p_221797_, CallbackInfo ci)
	{
		ci.cancel();

		NetherPortalBlock that = (NetherPortalBlock) (Object) this;

		for(int i = 0; i < 4; ++i) {
			double d0 = (double)p_221796_.getX() + p_221797_.nextDouble();
			double d1 = (double)p_221796_.getY() + p_221797_.nextDouble();
			double d2 = (double)p_221796_.getZ() + p_221797_.nextDouble();
			double d3 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
			double d4 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
			double d5 = ((double)p_221797_.nextFloat() - 0.5D) * 0.5D;
			int j = p_221797_.nextInt(2) * 2 - 1;
			if (!p_221795_.getBlockState(p_221796_.west()).is(that) && !p_221795_.getBlockState(p_221796_.east()).is(
					that)) {
				d0 = (double)p_221796_.getX() + 0.5D + 0.25D * (double)j;
				d3 = p_221797_.nextFloat() * 2.0F * (float)j;
			} else {
				d2 = (double)p_221796_.getZ() + 0.5D + 0.25D * (double)j;
				d5 = p_221797_.nextFloat() * 2.0F * (float)j;
			}

			p_221795_.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
		}
	}
}
