package mod.milkeyyy.pecodurabilityview.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.Entity;

import mod.milkeyyy.pecodurabilityview.PecodurabilityviewModVariables;
import mod.milkeyyy.pecodurabilityview.PecodurabilityviewMod;

import java.util.Map;
import java.util.HashMap;

public class UpdateDurabilityViewProcedure {
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
				PecodurabilityviewMod.LOGGER.warn("Failed to load dependency entity for procedure UpdateDurabilityView!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIMHToolDurabilityMaxValue) != 0)) {
			{
				String _setval = (String) (("[") + "" + ((new TranslationTextComponent("text.overlay.main_hand_durability_title").getString())) + ""
						+ ("]"));
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIMHToolDurabilityOverlayTitleText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (String) (((new java.text.DecimalFormat("#")
						.format(((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIMHToolDurabilityValue))))
						+ "" + (" / ") + ""
						+ ((new java.text.DecimalFormat("#")
								.format(((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIMHToolDurabilityMaxValue)))));
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIMHToolDurabilityOverlayText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = (String) "";
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIMHToolDurabilityOverlayTitleText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (String) "";
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIMHToolDurabilityOverlayText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIOHToolDurabilityMaxValue) != 0)) {
			{
				String _setval = (String) (("[") + "" + ((new TranslationTextComponent("text.overlay.off_hand_durability_title").getString())) + ""
						+ ("]"));
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIOHToolDurabilityOverlayTitleText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (String) (((new java.text.DecimalFormat("#")
						.format(((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIOHToolDurabilityValue))))
						+ "" + (" / ") + ""
						+ ((new java.text.DecimalFormat("#")
								.format(((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIOHToolDurabilityMaxValue)))));
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIOHToolDurabilityOverlayText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = (String) "";
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIOHToolDurabilityOverlayTitleText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (String) "";
				entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HIOHToolDurabilityOverlayText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
