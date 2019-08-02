import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.event.ChangeListener;

/**
 * View interface.
 *
 * @author Daniel Hunter
 */
public interface PasswordGeneratorView
        extends ActionListener, ChangeListener, ComponentListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(PasswordGeneratorController controller);

    /**
     * Updates output display based on String provided as argument.
     *
     * @param output
     *            new value of output display
     */
    void updateOutputDisplay(String output);

    /**
     * Updates display of whether copy operation is allowed.
     *
     * @param allowed
     *            true iff undo is allowed
     */
    void updateCopyAllowed(boolean allowed);

}
