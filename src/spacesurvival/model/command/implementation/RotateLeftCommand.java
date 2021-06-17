package spacesurvival.model.command.implementation;

import java.awt.geom.AffineTransform;
import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public class RotateLeftCommand implements CommandGameObject {

    /** 
     * Rotate left the ship.
     * 
     * @param ship the controlled ship 
     */
    public void execute(final SpaceShipSingleton ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(-GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }
}