
package spacesurvival.model.worldEcollisioni.physics.components;

import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.World;

public interface PhysicsComponent {

	public void update(int dt, GameObject abstractObj, World w);
}