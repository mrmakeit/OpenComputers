package li.cil.oc.driver.atomicscience;

import atomicscience.api.IReactor;
import atomicscience.api.ITemperature;
import li.cil.oc.api.network.Arguments;
import li.cil.oc.api.network.Callback;
import li.cil.oc.api.network.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverTileEntity;
import li.cil.oc.driver.ManagedTileEntityEnvironment;
import net.minecraft.world.World;


public class DriverTemperature extends DriverTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return ITemperature.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z) {
        return new Environment((ITemperature) world.getBlockTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<ITemperature> {
        public Environment(final ITemperature tileEntity) {
            super(tileEntity, "temperature");
        }

        @Callback
        public Object[] getTemperature(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getTemperature()};
        }
    }
}

