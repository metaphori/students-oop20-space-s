/*
 *   V2d.java
 *
 * Copyright 2000-2001-2002  aliCE team at deis.unibo.it
 *
 * This software is the proprietary information of deis.unibo.it
 * Use is subject to license terms.
 *
 */
package spaceSurvival.model.common;

/**
 *
 * 2-dimensional vector
 * objects are completely state-less
 *
 */
public class V2d implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double x, y;
	
    public V2d() {
        this.x = 0;
        this.y = 0;
    }

    public V2d(final double x, final double y){
        this.x=x;
        this.y=y;
    }

    public V2d(final P2d to, final P2d from){
        this.x=to.x-from.x;
        this.y=to.y-from.y;
    }

    public double getX() {
		return this.x;
	}

    public double getY() {
		return this.y;
    }

    public V2d sum(final V2d v){
        return new V2d(x + v.x, y + v.y);
    }

    public double module(){
        return Math.sqrt(x*x+y*y);
    }

    public V2d getNormalized(){
        final double module = Math.sqrt(x*x + y*y);
        return new V2d(x / module, y / module);
    }

    public V2d mul(double fact){
        return new V2d(x*fact,y*fact);
    }

    @Override
    public String toString(){
        return "V2d("+x+", "+y+")";
    }
}
