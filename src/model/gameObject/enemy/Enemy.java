package model.gameObject.enemy;

import java.util.Optional;

import model.EngineImage;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.MainGameObject;
import model.gameObject.weapon.Weapon;
import model.movement.Movement;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class Enemy extends MainGameObject {
	
    P2d target = new P2d(0,0);

    public Enemy(EngineImage engineImage, P2d position, BoundingBox bb, PhysicsComponent phys, V2d velocity,
            Movement movement, int life, int impactDamage, Optional<Weapon> weapon, int score, P2d target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score);
        this.target = target;
    }
	
    public P2d getTarget() {
        return this.target;
    }

    public void setTarget(final P2d target) {
        this.target = target;
    }

}
