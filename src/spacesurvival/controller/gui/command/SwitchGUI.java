package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.view.GUI;
/**
 * Switch GUI.
 */
public class SwitchGUI {
    private final CmdEngine onCmdEngine;
    private final CmdEngine offCmdEngine;

    private GUI gui;
    private EngineGUI engine;

    public SwitchGUI() {
        this.onCmdEngine = new CmdON();
        this.offCmdEngine = new CmdOFF();
    }

    public SwitchGUI(final EngineGUI engine, final GUI gui) {
        this();
        this.engine = engine;
        this.gui = gui;
    }

    /**
     * 
     * @param visibility
     */
    public void turn(final Visibility visibility) {
        switch (visibility) {
            case HIDDEN: this.offCmdEngine.execute(engine).execute(gui); break;
            case VISIBLE: this.onCmdEngine.execute(engine).execute(gui); break;
            default: break;
        }
    }

    /**
     * 
     */
    public void changeVisibility() {
        if (this.engine.isVisible()) {
            this.offCmdEngine.execute(engine).execute(gui);
        } else {
            this.onCmdEngine.execute(engine).execute(gui);
        }
    }
}
