package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.AbstractGameObject;
import model.common.V2d;

public class LeftReleaseCommand implements CommandMovement {

	@Override
	public void execute(AbstractGameObject ship) {
		System.out.println("Release Left");
		V2d vel = ship.getVelocity();
		ship.setVelocity(ship.getVelocity().mul(0.5));	
		
//		V2d vel = ship.getCurrentVel();
////
//		ship.setVel(vel.sum(new V2d(30,0)));
		//ship.setVel(new V2d(0,0));

	}

}
