package spacesurvival.view.menu.factorymethod;

import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.utilities.DesignJComponent;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.view.menu.FactoryGUIMenu;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.menu.concrete.GUIMenuConcrete;
import spacesurvival.view.menu.utilities.IconsButton;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.*;
import java.util.List;

public class GUIMenuCompact implements FactoryGUIMenu {

    @Override
    public GUIMenu createGUI() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();

        menuConcrete.setFontGUI(DesignGraphics.FONT_MEDIUM_STANDARD);
        menuConcrete.setForegroundGUI(DesignGraphics.COLOR_4);
        menuConcrete.setFontTitleGUI(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setLayout(new GridBagLayout());
        int nBtnUsed = 0;

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLbTitle(), lim);

        FactoryGUIs.resetGridBagConstraints(lim);
        lim.gridy++;

        menu.getBtnActionLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getBtnActionLinks().get(nBtnUsed++))), lim);

        while(nBtnUsed < EngineGame.N_BUTTONS){
            lim.gridy++;
            menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getBtnActionLinks().get(nBtnUsed++),
                    nBtnUsed + 1 < EngineGame.N_BUTTONS ? menu.getBtnActionLinks().get(nBtnUsed++) : FactoryGUIs.getJComponentEmpty())), lim);
        }

        nBtnUsed = 0;
        while(nBtnUsed < EngineGame.N_BUTTONS){
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), 25, menu.getWidth());
        }
    }
}