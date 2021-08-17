package mod.milkeyyy.pecodurabilityview.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.pecodurabilityview.PecodurabilityviewModVariables;
import mod.milkeyyy.pecodurabilityview.PecodurabilityviewMod;

import java.util.Map;
import java.util.HashMap;

public class UpdateDurabilityValueProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PecodurabilityviewMod.LOGGER.warn("Failed to load dependency entity for procedure UpdateDurabilityValue!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.getMaxDamage())
					- ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage()));
			entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HIMHToolDurabilityValue = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.getMaxDamage())
					- ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getDamage()));
			entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HIOHToolDurabilityValue = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.getMaxDamage());
			entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HIMHToolDurabilityMaxValue = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.getMaxDamage());
			entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HIOHToolDurabilityMaxValue = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
