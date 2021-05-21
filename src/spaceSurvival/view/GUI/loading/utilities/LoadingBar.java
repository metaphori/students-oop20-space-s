package spaceSurvival.view.GUI.loading.utilities;

import spaceSurvival.model.EngineImage;
import spaceSurvival.utilities.dimension.Screen;
import spaceSurvival.view.utilities.JImage;

import javax.swing.*;
import java.awt.*;

public class LoadingBar extends JProgressBar {

    public LoadingBar(){
        super(JProgressBar.HORIZONTAL, 0, 100);;
    }

    public void paintComponent(final Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        int i = Screen.scaleRespectTo(30, super.getWidth());
        Image img = getImageFromEngine(new EngineImage("loading.png", i, i));

        for (int j = 0; j < (super.getWidth() * super.getValue() / (100 * i)) + 1; j++){
            g2d.drawImage(img, j * i,0, null);
        }
    }

    private Image getImageFromEngine(final EngineImage image){
        JImage icon = new JImage(image.getPath(), image.getSize());
        return icon.getImage();
    }
}
