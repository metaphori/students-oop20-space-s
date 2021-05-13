package model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.spaceShip.SpaceShipSingleton;
import model.worldEcollisioni.WorldEvent;
import model.worldEcollisioni.WorldEventListener;
import model.worldEcollisioni.physics.BoundaryCollision;
import model.worldEcollisioni.physics.boundingType.CircleBoundingBox;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import model.common.*;
//import rollball.physics.BoundaryCollision;

public class World {
	private List<AbstractGameObject> asteroids;
	private List<AbstractGameObject> perks;
	private AbstractGameObject ship;
	private RectBoundingBox mainBBox;
	private WorldEventListener evListener;
	
	public World(RectBoundingBox bbox){
		ship = SpaceShipSingleton.getSpaceShip();
		asteroids = new ArrayList<AbstractGameObject>();
		perks = new ArrayList<AbstractGameObject>();
		
		mainBBox = bbox;
	}

	public void setEventListener(WorldEventListener l){
		evListener = l;
	}
	
	public void setShip(AbstractGameObject ship){
		this.ship = ship;
	}
	
	public void addPickablePerk(AbstractGameObject obj){
		perks.add(obj);
	}

	public void removePickablePerk(AbstractGameObject obj){
		perks.remove(obj);
	}
	
	public void addAsteroid(AbstractGameObject obj){
		asteroids.add(obj);
	}

	public void removeAsteroid(AbstractGameObject obj){
		asteroids.remove(obj);
	}
	
	public void updateState(int dt){
		ship.updatePhysics(dt, this);
		asteroids.forEach(a -> a.updatePhysics(dt, this));
	}

	public Optional<BoundaryCollision> checkCollisionWithBoundaries(P2d pos, RectBoundingBox box){
		P2d ul = mainBBox.getULCorner();
		P2d br = mainBBox.getBRCorner();
		double r = box.getWidth();
		if (pos.y + r> ul.y){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.TOP, new P2d(pos.x,ul.y)));
		} else if (pos.y - r < br.y){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.BOTTOM, new P2d(pos.x,br.y)));
		} else if (pos.x + r > br.x){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.RIGHT, new P2d(br.x,pos.y)));
		} else if (pos.x - r < ul.x){
			return Optional.of(new BoundaryCollision(BoundaryCollision.CollisionEdge.LEFT, new P2d(ul.x,pos.y)));
		} else {
			return Optional.empty();
		}
	}

	public Optional<AbstractGameObject> checkCollisionWithAsteroids(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (AbstractGameObject obj: asteroids){
			if (obj.getBBox().isCollidingWith(pos,radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public Optional<AbstractGameObject> checkCollisionWithPerks(P2d pos, RectBoundingBox box){
		double radius = box.getWidth();
		for (AbstractGameObject obj: perks){
			if (obj.getBBox().isCollidingWith(pos,radius)){
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
	
	public void notifyWorldEvent(WorldEvent ev){
		evListener.notifyEvent(ev);
	}
	
	public RectBoundingBox getBBox(){
		return mainBBox;
	}
	
	public AbstractGameObject getShip(){
		return this.ship;
	}

	public List<AbstractGameObject> getPickablePerks(){
		return this.perks;
	}
	
	public List<AbstractGameObject> getAsteroids(){
		return this.asteroids;
	}

	public List<AbstractGameObject> getSceneEntities(){
		List<AbstractGameObject> entities = new ArrayList<AbstractGameObject>();
		entities.addAll(asteroids);
		entities.add(ship);
		return entities;
	}
	
}