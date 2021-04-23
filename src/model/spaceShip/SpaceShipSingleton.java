package model.spaceShip;

import java.awt.Dimension;

import model.GUI.settings.SkinSpaceShip;
import model.MyJImage.JImageRateEngine;
import model.MyJImage.MyJImageEngine;
import model.environment.Point2D;
import utilities.DesignSpace;

public class SpaceShipSingleton {
    
    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
    		DesignSpace.CENTER_ENVIRONMENT,
            SkinSpaceShip.GNEGNE.getPath());
    
    private Point2D position;
    private MyJImageEngine imageEngine;
    
    /** 
    * Invisible class constructor specifying space ship initial position and image path
    */
    private SpaceShipSingleton(final Point2D position, final String imagePath) {
        this.position = position;
        this.imageEngine = new MyJImageEngine(imagePath);
        this.imageEngine.setDimensionImage(new Dimension(250, 140));
    }
    
    /**
     * @return space ship static istance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }
    
    /**
     * @return the current space ship position
     */
    public Point2D getPosition() {
        return this.position;
    }
    
    /**
     * @return the current space ship image model
     */
    public MyJImageEngine getSpaceImageEngine() {
        return this.imageEngine;
    }

    /**
     * @return the current space ship dimension
     */
    public Dimension getDimension() {
        return this.imageEngine.getDimensionImage();
    }
    
    /**
     * @param newPosition
     *            the new space ship position
     */
    public void setPosition(final Point2D newPosition) {
        this.position = newPosition;
    }
    
    /**
     * @param newDimension
     *            the new space ship position
     */
    public void setDimension(final Dimension newDimension) {
        this.imageEngine.setDimensionImage(newDimension);
    }
}

