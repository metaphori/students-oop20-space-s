package spacesurvival.model.collisioni.physics.component;

import java.util.Optional;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;

import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.model.World;
import spacesurvival.model.collisioni.hitevent.HitBorderEvent;
import spacesurvival.model.collisioni.hitevent.HitMainGameObject;
import spacesurvival.model.collisioni.hitevent.HitTakeableGameObject;
import spacesurvival.model.collisioni.physics.BoundaryCollision;
import spacesurvival.model.collisioni.physics.bounding.RectBoundingBox;


public class ShipPhysicsComponent implements PhysicsComponent {

    /**
     * Update the physics of the ship, check also the collision between ship and other game object.
     * 
     * @param abstractObj the ship
     * @param w represent the current world
     */
    public void update(final GameObject abstractObj, final World w) {
        final SpaceShipSingleton ship = (SpaceShipSingleton) abstractObj;

        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox shipBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();

        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(ship.getPosition(), boundingBox);
        if (borderInfo.isPresent()) {
            final BoundaryCollision info = borderInfo.get();
            w.notifyWorldEvent(new HitBorderEvent(info.getWhere(), info.getEdge(), ship));
        }

        final Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(shipBoundingBox);
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, asteroid.get()));
        }

        final Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(shipBoundingBox);
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, chaseEnemy.get()));
        }

        final Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(shipBoundingBox);
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, fireEnemy.get()));
        }

        final Optional<FireableObject> boss = w.checkCollisionWithBoss(shipBoundingBox);
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitMainGameObject(ship, boss.get()));
        }

        final Optional<TakeableGameObject> ammo = w.checkCollisionWithAmmo(shipBoundingBox);
        if (ammo.isPresent()) {
            w.notifyWorldEvent(new HitTakeableGameObject(ammo.get()));
        }

        final Optional<TakeableGameObject> heart = w.checkCollisionWithHearts(shipBoundingBox);
        if (heart.isPresent()) {
            w.notifyWorldEvent(new HitTakeableGameObject(heart.get()));
        }
    }
}