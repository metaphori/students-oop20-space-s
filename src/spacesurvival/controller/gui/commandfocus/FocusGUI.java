package spacesurvival.controller.gui.commandfocus;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import spacesurvival.controller.gui.CtrlGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.StateLevelGUI;
import spacesurvival.view.GUI;

public class FocusGUI implements MouseListener {
    private final CtrlGUI control;

    public FocusGUI(final CtrlGUI controll) {
        this.control = controll;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(final MouseEvent e) {
        final LinkActionGUI id = control.getControllerGUIFromGUI((GUI) e.getSource()).get().getMainLink();
        final int indexDifferent = 1;

        if (id.getStateLevel() != StateLevelGUI.OVERLAY 
                && this.control.getChronology().lastElementOfList().get().getStateLevel().equals(StateLevelGUI.OVERLAY)) {

            int sizeList =  this.control.getChronology().size() - indexDifferent;
            while (this.control.getChronology().get(sizeList).getStateLevel().equals(StateLevelGUI.OVERLAY)) {
                this.control.getManagerGui().get(this.control.getChronology().get(sizeList)).turn(Visibility.HIDDEN);
                this.control.getChronology().remove(sizeList--);
            }
            
            this.control.getChronology().lastElementOfList().ifPresent(link -> this.control.getCtrlSound().checkChangeSoundLoop(link));
            System.out.println("list" + this.control.getChronology());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
