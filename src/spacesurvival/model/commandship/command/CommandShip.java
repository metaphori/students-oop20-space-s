package spacesurvival.model.commandship.command;

import spacesurvival.model.gameobject.fireable.SpaceShipSingleton;

public interface CommandShip {

    /** 
     * Execute the specified command on the ship.
     * 
     * @param ship the controlled ship 
     */
    void execute(SpaceShipSingleton ship);
}

