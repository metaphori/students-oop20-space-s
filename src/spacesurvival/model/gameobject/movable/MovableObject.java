package spacesurvival.model.gameobject.movable;

import java.util.Optional;

import spacesurvival.controller.CallerCommand;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;


public abstract class MovableObject extends GameObject {

    private V2d velocity;
    private double acceleration;
    private Optional<P2d> target;
    private MovementLogic movementLogic;
    private CallerCommand caller;
    private boolean isMoving;

    public MovableObject() {
        super(new EngineImage(), new P2d(), null, null);
        this.velocity = new V2d();
        this.movementLogic = null;
    }

    public MovableObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic,
            final Optional<P2d> target) {
        super(engineImage, position, bb, phys);
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.target = target;
        this.movementLogic = movementLogic;
    }

    public void move() {
        this.movementLogic.move(this);
    }

    public V2d getVelocity() {
        return velocity;
    }

    public void setVelocity(final V2d velocity) {
        this.velocity = velocity;
    }

    /**
     * @return the object acceleration
     */
    public double getAcceleration() {
        return this.acceleration;
    }

    /**
     * Sets a new acceleration to the object.
     *
     * @param acceleration the acceleration to set
     */
    public void setAcceleration(final double acceleration) {
        this.acceleration = acceleration;
    }

    public MovementLogic getMovement() {
        return movementLogic;
    }

    public void setMovement(final MovementLogic movementLogic) {
        this.movementLogic = movementLogic;
    }

    public void startMoving() {
        this.movementLogic.startMoving(this);
    }

    public void stopMoving() {
        this.movementLogic.stopMoving(this);
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(final boolean isMoving) {
        this.isMoving = isMoving;
    }

    /**
     * Return the target position of Enemy.
     *
     * @return the target position of Enemy
     */
    public Optional<P2d> getTarget() {
        return target;
    }

    /**
     * Sets the target position of Enemy.
     *
     * @param target the new target position
     */
    public void setTarget(final Optional<P2d> target) {
        this.target = target;
    }

    public CallerCommand getCaller() {
        return caller;
    }

    public void setCaller(final CallerCommand caller) {
        this.caller = caller;
    }

    @Override
    public String toString() {
        return "MovableGameObject [velocity=" + velocity + ", movement=" + movementLogic + ", "
                + "transform=" + super.getTransform() + ", " + super.toString() +  "]";
    }

}
