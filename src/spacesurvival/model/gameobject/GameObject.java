package spacesurvival.model.gameobject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.List;
import spacesurvival.model.common.P2d;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.Animation;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundingBox;
import spacesurvival.model.collision.eventgenerator.EventComponent;


public abstract class GameObject implements Collideable {
    private AffineTransform transform;
    private BoundingBox boundingBox;
    private EventComponent evComponent;

    private final Animation body;
    private final Animation effect;

//    private List<SoundPath> effectSounds;

    public GameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final EventComponent eventComponent) {
        this.body = new Animation(engineImage);
        this.effect = new Animation(EngineImage.getTransparentEngineImage(engineImage));


        initializeThread();

        this.boundingBox = bb;
        this.evComponent = eventComponent;
        this.setTransform(position);
//        this.setEffectSounds(new LinkedList<>());
    }

    private void initializeThread() {
        this.body.start();
        this.effect.start();
    }

    public void setPause(final boolean isPause) {
        this.body.setPause(isPause);
        this.effect.setPause(isPause);
    }

    public void stopAnimation() {
        this.body.setAnimating(false);
        this.effect.setAnimating(false);
    }

    public Image getImgBody() {
        return this.body.getImage();
    }

    public Image getImgEffect() {
        return this.effect.getImage();
    }

    public void setAnimation(final List<String> animation) {
        this.body.setListPath(animation);
    }

    public void setAnimationEffect(final List<String> animation) {
        this.effect.setListPath(animation);
    }

//    public List<SoundPath> getEffectSounds() {
//        return this.effectSounds;
//    }
//
//    public void setEffectSounds(final List<SoundPath> effectSounds) {
//        this.effectSounds = effectSounds;
//    }

//    public void pushEffect(final SoundPath soundEffect) {
//        this.effectSounds.add(soundEffect);
//    }
//
//    public final Optional<SoundPath> popEffect() {
//        if (!this.effectSounds.isEmpty()) {
//            final Optional<SoundPath> first = Optional.of(this.effectSounds.get(0));
//            this.effectSounds.remove(0);
//            return first;
//        }
//        return Optional.empty();
//    }

    public final AffineTransform getTransform() {
        return this.transform;
    }

    public void setTransform(final P2d position) {
        this.transform = new AffineTransform();
        this.transform.translate(position.getX(), position.getY());
        this.boundingBox.setTransform(this.transform);
    }

    public void setTransform(final AffineTransform transform) {
        this.transform.setTransform(transform);
        this.boundingBox.setTransform(transform);
    }

    public final EngineImage getEngineImage() {
        return this.body.getBody();
    }

    public final EngineImage getEngineEffect() {
        return this.effect.getBody();
    }

    public final P2d getPosition() {
        return new P2d(this.transform.getTranslateX(), this.getTransform().getTranslateY());
    }

    public void setPosition(final P2d position) {
        final AffineTransform newTransform = new AffineTransform();
        newTransform.translate(position.getX(), position.getY());
        this.transform.setTransform(newTransform);
        this.boundingBox.setTransform(newTransform);
    }

    public final BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(final BoundingBox boundingBox) {
          this.boundingBox = boundingBox;
    }

    public void setEngineImage(final EngineImage engineImage) {
        this.body.setBody(engineImage);
    }

    public final EventComponent getPhys() {
        return evComponent;
    }

    public void setPhys(final EventComponent phys) {
        this.evComponent = phys;
    }

    public void updateEvents(final World w) {
        evComponent.update(this, w);
    }

    public final Dimension getSize() {
        return this.body.getBody().getSize();
    }

    public final double getWidth() {
        return this.getEngineImage().getSize().getWidth();
    }

    public final double getHeight() {
        return this.getEngineImage().getSize().getHeight();
    }

    public final List<String> getAnimation() {
        return this.body.getListPath();
    }

    @Override
    public abstract void collided(World world, WorldEvent worldEvent);

    @Override
    public String toString() {
        return "GameObject [transform=" + transform + ", boundingBox=" + boundingBox
                + ", phys=" + evComponent + ", body=" + body + ", effect=" + effect + "]";
    }

}
