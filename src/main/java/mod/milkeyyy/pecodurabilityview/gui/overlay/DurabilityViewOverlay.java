
package mod.milkeyyy.pecodurabilityview.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import mod.milkeyyy.pecodurabilityview.PecodurabilityviewModVariables;

@Mod.EventBusSubscriber
public class DurabilityViewOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIMHToolDurabilityOverlayTitleText) + "",
						posX + -207, posY + 77, -5921371);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIOHToolDurabilityOverlayTitleText) + "",
						posX + -207, posY + 95, -5921371);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIMHToolDurabilityOverlayText) + "",
						posX + -207, posY + 86, -1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(PecodurabilityviewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new PecodurabilityviewModVariables.PlayerVariables())).HIOHToolDurabilityOverlayText) + "",
						posX + -207, posY + 104, -1);
			}
		}
	}
}
