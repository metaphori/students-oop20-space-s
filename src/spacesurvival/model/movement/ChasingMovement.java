package spacesurvival.model.movement;

import java.awt.geom.AffineTransform;

import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.gameobject.enemy.ChaseEnemy;

public class ChasingMovement implements Movement {

    @Override
    public void move(final MovableGameObject object) {
        if (object instanceof ChaseEnemy) {
            final ChaseEnemy chase = (ChaseEnemy) object;
            if (chase.getTarget().isPresent()) {
                final P2d target = chase.getTarget().get();

                final double rightRotation = Math.toDegrees(Math.atan2(chase.getPosition().getY() - target.getY(), chase.getPosition().getX() - target.getX()));
                final double complementary = 180 - (rightRotation * -1);
                final double newAngle = 90 + complementary;

                final AffineTransform newTransform = new AffineTransform();
                newTransform.translate(chase.getTransform().getTranslateX(), chase.getTransform().getTranslateY());
                newTransform.rotate(Math.toRadians(newAngle), 0, 0);

                newTransform.translate(chase.getVelocity().getX(), chase.getVelocity().getY());
                chase.setTransform(newTransform);
            }
        }
    }
	
    @Override
    public String toString() {
        return "Chasing Movement";
    }

}