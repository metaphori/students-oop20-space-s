package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.gameobject.VelocityUtils;
import spacesurvival.model.common.V2d;

public class UpCommand implements CommandGameObject {
    private static final double TOLLERANCE = 0.2;

    /** 
     * Accelerate the ship forward.
     * 
     * @param ship the controlled ship 
     */
    public void execute(final SpaceShipSingleton ship) {
        V2d vel = ship.getVelocity();
        if (Math.abs(vel.getY()) < TOLLERANCE) {
            vel = new V2d(vel.getX(), -VelocityUtils.SPACESHIP_STARTING_VEL);
            ship.setVelocity(vel);
        }
        ship.setAcceleration(VelocityUtils.SPACESHIP_ACCELERATION);
    }
}
