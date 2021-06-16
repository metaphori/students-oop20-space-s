package spacesurvival.model.worldEcollisioni.physics.components;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.MainGameObject;

import java.util.Optional;

import spacesurvival.model.World;
import spacesurvival.model.worldEcollisioni.hitEvents.HitBorderEvent;
import spacesurvival.model.worldEcollisioni.hitEvents.HitBulletEvent;
import spacesurvival.model.worldEcollisioni.physics.BoundaryCollision;
import spacesurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spacesurvival.model.gameobject.weapon.Bullet;

public class BulletPhysicsComponent implements PhysicsComponent {

    @Override
    public void update(final int dt, final GameObject abstractObj, final World w) {
        final Bullet bullet = (Bullet) abstractObj;
        final RectBoundingBox boundingBox = w.getMainBBox();
        final RectBoundingBox objectBoundingBox = (RectBoundingBox) abstractObj.getBoundingBox();
        final Optional<BoundaryCollision> borderInfo = w.checkCollisionWithBoundaries(bullet.getPosition(), boundingBox);

        if (borderInfo.isPresent()) {
            w.notifyWorldEvent(new HitBorderEvent(borderInfo.get().getWhere(), borderInfo.get().getEdge(), bullet));
        }

        final Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(objectBoundingBox);
        //collisioni con asteroidi
        if (asteroid.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, asteroid.get()));
        }
	
        final Optional<MainGameObject> chaseEnemy = w.checkCollisionWithChaseEnemies(objectBoundingBox);
        //collisioni con chaseEnemy
        if (chaseEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, chaseEnemy.get()));
        }

        final Optional<MainGameObject> fireEnemy = w.checkCollisionWithFireEnemies(objectBoundingBox);
        //collisioni con chaseEnemy
        if (fireEnemy.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, fireEnemy.get()));
        }

        final Optional<MainGameObject> boss = w.checkCollisionWithBoss(objectBoundingBox);
        //collisioni con boss
        if (boss.isPresent()) {
            w.notifyWorldEvent(new HitBulletEvent(bullet, boss.get()));
        }
    }

}
