package spacesurvival.model.gameobject.weapon.shootinglogic.implementation;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.takeable.AmmoType;
import spacesurvival.model.gameobject.weapon.shootinglogic.FiringLogic;
import spacesurvival.utilities.ThreadUtils;

public class BossFiringImpl implements FiringLogic {

    /**
     * Start the boss firing every 3 seconds.
     * 
     * @param fireableObject object which which will fire
     */
    public void startFiring(final FireableObject fireableObject) {
        new Thread(() -> {
            while (fireableObject.isAlive()) {
                ThreadUtils.sleep(GameObjectUtils.BOSS_FIRING_DELAY);
                fireableObject.fire();
            }
        }).start();
    }

    /**
     * Start the boss changing ammo every 20 seconds.
     * 
     * @param fireableObject object which which will fire
     */
    public void startChangingAmmo(final FireableObject fireableObject) {
        new Thread(() -> {
            while (fireableObject.isAlive()) {
                ThreadUtils.sleep(GameObjectUtils.BOSS_CHANGING_AMMO_DELAY);
                fireableObject.getWeapon().setAmmoType(AmmoType.random());
            }
        }).start();
    }

}