package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.common.V2d;

public class RightCommand implements CommandGameObject{
	
	public RightCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
		
		if (vel.getX() <= 15) {
			object.setVelocity(vel.sum(new V2d(1, 0)));
		}
		//System.out.println("Right " + object.toString());

	}

}
