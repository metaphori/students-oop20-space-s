package model.gameObject.asteroid;


import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;

public class Asteroid extends AbstractGameObject {
	
	public Asteroid(EngineImage engineImage, Integer life,Integer damage, Dimension dim,
					P2d point, Movement movement, V2d vel, AffineTransform transform, Optional<Weapon> weapon) {
		super(engineImage, life, damage, point, movement, vel, transform, weapon);
	}


	@Override
	public String toString() {
		return "Asteroid { " + super.toString() + " }";
	}
}
