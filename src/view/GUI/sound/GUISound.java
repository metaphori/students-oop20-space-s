package view.GUI.sound;

import utilities.IdGUI;
import view.GUI.GUI;

import javax.swing.*;
import java.util.List;

public interface GUISound extends GUI, GraphicsGUISound {
    public void setNameComponents(final List<String> listName);

    public void setNameTypeSlider(final List<String> listName);

    public List<JSlider> getSlidersSound();

    public void setDefaultValueSlidersSound(final int value);

    public void setBtnBackID(final IdGUI idGUI);

    public List<JButton> getBtnSwitchs();
}
