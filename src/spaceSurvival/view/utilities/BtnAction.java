package spaceSurvival.view.utilities;

import spaceSurvival.utilities.ActionGUI;

import javax.swing.*;

public class BtnAction extends JButton {
    private ActionGUI actionCurrent;
    private ActionGUI actionNext;

    public BtnAction(){
        super();
    }

    public ActionGUI getActionCurrent() {
        return this.actionCurrent;
    }

    public ActionGUI getActionNext() {
        return this.actionNext;
    }


    public void setActionCurrent(final ActionGUI currentGUIID) {
        this.actionCurrent = currentGUIID;
    }

    public void setActionNext(final ActionGUI actionGUINext) {
        this.actionNext = actionGUINext;
    }


    @Override
    public String toString() {
        return "BtnAction{" +
                "actionCurrent=" + actionCurrent +
                ", actionNext=" + actionNext +
                '}';
    }
}