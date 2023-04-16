package dev.kalkafox.hushnetherportal;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
@Mod(HushNetherPortal.MODID)
public class HushNetherPortal {
    public static final String MODID = "HushNetherPortal";
    public HushNetherPortal() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
