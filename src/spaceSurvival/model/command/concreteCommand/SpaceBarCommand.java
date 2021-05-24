package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;

public class SpaceBarCommand implements CommandGameObject{
	
	public SpaceBarCommand() {}

	@Override
	public void execute(MainGameObject object) {
		if (object.getWeapon().isPresent()) {
			object.getWeapon().get().shot();
		}	
	}
	
}
