package spacesurvival.view.settings.concrete;

import spacesurvival.model.EngineImage;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.settings.utilities.PanelSkin;
import spacesurvival.view.utilities.ButtonLink;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GUISettingsConcrete extends AbstractGUI implements GUISettings {
    private static final long serialVersionUID = 1L;

    private final JLabel lbTitle;
    private final PanelSkin panelSkin;
    private final ButtonLink btnBack;

    public GUISettingsConcrete() {
        super();
        this.lbTitle = new JLabel();
        this.panelSkin = new PanelSkin();
        this.btnBack = new ButtonLink();
    }

    @Override
    public final List<ButtonLink> getBtnActionLinks() {
        return List.of(this.btnBack);
    }


    @Override
    public final List<JButton> getBtnUnitSkin() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }


    @Override
    public final void setUnitsTitle(final List<String> listName) {
        int i = 0;
        this.panelSkin.setLabelTitle(listName.get(i++));
    }

    @Override
    public final void setTextBtnBack(final String nameBtnBack) {
        this.btnBack.setText(nameBtnBack);
    }

    @Override
    public final void setSkinSpaceShip(final EngineImage imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPath());
        this.panelSkin.setRateImg(imageEngine.getScaleOf(), imageEngine.getRespectTo());
    }

    @Override
    public final void setBtnBackID(final LinkActionGUI mainAction, final LinkActionGUI action) {
        this.btnBack.setCurrentLink(mainAction);
        this.btnBack.setNextLink(action);
    }


    @Override
    public final void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.panelSkin.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    @Override
    public final void setFontTitleGUI(final Font font) {
        this.lbTitle.setFont(font);
    }

    @Override
    public final void setFontTitleUnit(final Font font) {
        this.panelSkin.setFontLabelTitle(font);
        this.btnBack.setFont(font);
    }

    @Override
    public final void setFontGUI(final Font font) {
        this.panelSkin.setFontButtons(font);
    }

    @Override
    public final void setTitleGUI(final String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public final void setTransparentComponent() {
        this.panelSkin.setTransparentButton();
        FactoryGUIs.setTransparentJButton(this.btnBack);
    }


    public final JLabel getLbTitle() {
        return this.lbTitle;
    }

    public final ButtonLink getBtnBack() {
        return this.btnBack;
    }

    public final PanelSkin getPanelSkin() {
        return this.panelSkin;
    }

}
