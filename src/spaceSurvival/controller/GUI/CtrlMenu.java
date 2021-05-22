package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.menu.EngineMenu;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.menu.GUIMenu;

public class CtrlMenu implements ControllerGUI {
    private GUIMenu gui;
    private EngineMenu engine;

    private final SwitchGUI switchGUI;

    public CtrlMenu(final EngineMenu menuEngine, final GUIMenu menuGUI){
        this.gui = menuGUI;
        this.engine = menuEngine;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignId();
        this.assignStrings();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    private void assignId(){
        this.gui.setMainAction(this.engine.getActionGUI());
        this.gui.setBtnActions(this.engine.getLinks());
    }

    private void assignStrings(){
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListName());
    }

    @Override
    public ActionGUI getIdGUI() {
        return this.engine.getActionGUI();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility){
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
