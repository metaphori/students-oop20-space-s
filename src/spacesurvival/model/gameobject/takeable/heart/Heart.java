package spacesurvival.model.gameobject.takeable.heart;

import spacesurvival.model.EngineImage;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;

public class Heart extends TakeableGameObject {

    private HeartType type;

    public Heart(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final HeartType type) {
        super(engineImage, position, bb, phys, type.getAnimation());
        this.type = type;
    }

    public HeartType getType() {
        return type;
    }

    public void setType(final HeartType type) {
        this.type = type;
    }

}
