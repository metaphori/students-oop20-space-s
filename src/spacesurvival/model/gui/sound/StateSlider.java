package spacesurvival.model.gui.sound;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.path.Icon;

public enum StateSlider {
    ON(true, new EngineImage(ScaleOf.ICON_MEDIUM, EngineSound.RECTANGLE.width, Icon.SOUND_ON)),
    OFF(false, new EngineImage(ScaleOf.ICON_MEDIUM,  EngineSound.RECTANGLE.width, Icon.SOUND_OFF));

    private final boolean state;
    private final EngineImage engineImage;

    private StateSlider(final boolean state, final EngineImage engineImage){
        this.state = state;
        this.engineImage = engineImage;
    }

    public boolean isActive() {
        return this.state;
    }

    public EngineImage getEngineImage(){
        return this.engineImage;
    }

    @Override
    public String toString() {
        return "StateSlider{" +
                "state=" + state +
                ", engineImage=" + engineImage + '}';
    }
}