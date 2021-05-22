package spaceSurvival.model.GUI.settings;

import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.ImageDesign;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.utilities.*;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.utilities.ActionGUI;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EngineSettings implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final String TITLE = "SETTING";

    public static final int INDEX_INIT_SKIN = 0;
    public static final int INDEX_INTI_DIFFICULT = 0;
    public static final int STEP_INDEX_SKIN = 1;
    public static final int FIRST_DIFFICULT_ON = 0;

    private final ActionGUI id;
    private final List<NameSettingsGUI> namesButtons;
    private final ActionGUI linkBack;

    private final Map<Difficulty, DifficultActive> difficult;
    private final List<SkinSpaceShip> skinSpaceShip;
    private int chooseSkin;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineSettings(){
        this.id = ActionGUI.ID_SETTING;
        this.linkBack = ActionGUI.ID_BACK;
        this.chooseSkin = INDEX_INIT_SKIN;

        this.skinSpaceShip = Arrays.asList(SkinSpaceShip.values());
        this.namesButtons = List.of(NameSettingsGUI.values());

        this.difficult = IntStream.range(INDEX_INTI_DIFFICULT, Difficulty.values().length).boxed()
                .collect(Collectors.toMap(i -> Difficulty.values()[i], Engines.DEFAULT_DIFFICULTLY_ACTIVE::get));
    }

    @Override
    public ActionGUI getActionGUI() {
        return this.id;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<ActionGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public int getChooseSkin() {
        return this.chooseSkin;
    }

    public ActionGUI getBackLink(){
        return this.linkBack;
    }

    public String getTitleGUI() {
        return TITLE;
    }

    public List<String> getListNameUnit(){
        return this.namesButtons.stream().map(NameSettingsGUI::getTitle).collect(Collectors.toList());
    }

    public String getNameBtnBack(){
        return this.linkBack.getIdName();
    }

    public ImageDesign getSkinSpaceShip() {
        return this.skinSpaceShip.get(this.chooseSkin).getEngineImage();
    }

    public void changeSkinDx(){
        this.chooseSkin = this.chooseSkin + STEP_INDEX_SKIN < SkinSpaceShip.values().length ?
                this.chooseSkin + STEP_INDEX_SKIN : INDEX_INIT_SKIN;
    }

    public void changeSkinSx(){
        this.chooseSkin = this.chooseSkin - STEP_INDEX_SKIN >= INDEX_INIT_SKIN ?
                this.chooseSkin - STEP_INDEX_SKIN : SkinSpaceShip.values().length - STEP_INDEX_SKIN;
    }

    public Difficulty getDifficultActivate(){
        return this.difficult.entrySet().stream()
                .filter(e -> e.getValue().equals(DifficultActive.ON))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(FIRST_DIFFICULT_ON);
    }

    public void setDifficult(final Difficulty difficultyState) {
        this.resetDifficultlyOFF();
        this.difficult.entrySet().stream()
                .filter(e -> e.getKey().equals(difficultyState))
                .forEach(e -> e.setValue(DifficultActive.ON));
    }

    private void resetDifficultlyOFF(){
        this.difficult.entrySet().forEach(e -> e.setValue(DifficultActive.OFF));
    }
}
