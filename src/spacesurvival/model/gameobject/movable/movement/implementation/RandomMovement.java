package spacesurvival.model.gameobject.movable.movement.implementation;

import java.awt.geom.AffineTransform;
import java.util.concurrent.ThreadLocalRandom;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.utilities.Delay;
import spacesurvival.utilities.ThreadUtils;

public class RandomMovement implements MovementLogic {

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(final MovableObject movableObject) {
        if (movableObject.isMoving() && movableObject.getTarget().isPresent()) {
            final P2d target = movableObject.getTarget().get();
            final double rightRotation = Math.toDegrees(Math.atan2(movableObject.getPosition().getY() - target.getY(),
                    movableObject.getPosition().getX() - target.getX()));
            final double complementary = 180 - (rightRotation * -1);
            final double newAngle = 90 + complementary;
            final AffineTransform newTransform = new AffineTransform();

            newTransform.translate(movableObject.getTransform().getTranslateX(), movableObject.getTransform().getTranslateY());
            newTransform.rotate(Math.toRadians(newAngle), 0, 0);
            newTransform.translate(movableObject.getVelocity().getX(), movableObject.getVelocity().getY());
            movableObject.setTransform(newTransform);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startMoving(final MovableObject movableObject) {
        movableObject.setMoving(true);
        new Thread(() -> {
            while (movableObject.isMoving()) {
                changeDirectionRandomly(movableObject);
                ThreadUtils.sleep(Delay.CHANGING_DIRECTION);
            }
        }).start();
    }

    /**
     * Set a new random direction to the object velocity.
     * 
     * @param movableObject object to change direction
     */
    public void changeDirectionRandomly(final MovableObject movableObject) {
        final double directionX = ThreadLocalRandom.current().nextInt(-1, 1);
        final double directionY = ThreadLocalRandom.current().nextInt(-1, 1);
        final V2d newVelocity = new V2d(directionX, directionY);
        movableObject.setVelocity(newVelocity);
    }

    @Override
    public String toString() {
        return "DistantMovement";
    }
}