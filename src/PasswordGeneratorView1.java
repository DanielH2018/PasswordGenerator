import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;

/**
 * View class.
 *
 * @author Daniel Hunter
 */
@SuppressWarnings("serial")
public final class PasswordGeneratorView1 extends JFrame
        implements PasswordGeneratorView {

    /**
     * Controller object.
     */
    private PasswordGeneratorController controller;

    /**
     * GUI widgets that need to be in scope in actionPerformed method, and
     * related constants.
     */
    private static final int LINES_IN_TEXT_AREAS = 1,
            LINE_LENGTHS_IN_TEXT_AREAS = 20, ROWS_IN_BUTTON_PANEL_GRID = 1,
            COLUMNS_IN_BUTTON_PANEL_GRID = 2, ROWS_IN_THIS_GRID = 3,
            COLUMNS_IN_THIS_GRID = 1, MIN_PASSWORD_LENGTH = 5,
            MAX_PASSWORD_LENGTH = 30, LOWEST_VALID_CHARACTER = 33,
            HIGHEST_VALID_CHARACTER = 126;

    /**
     * Password Length Value.
     */
    private int passwordLength = (MIN_PASSWORD_LENGTH + MAX_PASSWORD_LENGTH)
            / 2;

    /**
     * Text areas.
     */
    private final JTextArea outputText;

    /**
     * Length Slider.
     */
    private final JSlider lengthSlider;

    /**
     * Buttons.
     */
    private final JButton generateButton, copyButton;

    /**
     * No-argument constructor.
     */
    public PasswordGeneratorView1() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Password Generator GUI Demo With MVC");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */
        this.outputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);
        this.generateButton = new JButton("Generate");
        this.copyButton = new JButton("Copy");
        this.copyButton.setEnabled(false);
        this.lengthSlider = new JSlider(MIN_PASSWORD_LENGTH,
                MAX_PASSWORD_LENGTH, this.passwordLength);
        this.lengthSlider.setMajorTickSpacing(5);
        this.lengthSlider.setMinorTickSpacing(1);
        this.lengthSlider.setPaintLabels(true);
        this.lengthSlider.setPaintTicks(true);

        /*
         * Text area should wrap lines, and should be read-only
         */
        this.outputText.setEditable(false);
        this.outputText.setLineWrap(true);
        this.outputText.setWrapStyleWord(true);
        /*
         * Create a button panel organized using grid layout
         */
        JPanel buttonPanel = new JPanel(new GridLayout(
                ROWS_IN_BUTTON_PANEL_GRID, COLUMNS_IN_BUTTON_PANEL_GRID));
        /*
         * Add the buttons to the button panel, from left to right and top to
         * bottom
         */
        buttonPanel.add(this.generateButton);
        buttonPanel.add(this.copyButton);
        /*
         * Organize main window using grid layout
         */
        this.setLayout(new GridLayout(ROWS_IN_THIS_GRID, COLUMNS_IN_THIS_GRID));
        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(this.outputText);
        this.add(this.lengthSlider);
        this.add(buttonPanel);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */
        this.generateButton.addActionListener(this);
        this.copyButton.addActionListener(this);
        this.lengthSlider.addChangeListener(this);

        // Start the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized for the widgets in
         * it, that it exits this program when closed, and that it becomes
         * visible to the user now
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    @Override
    public void registerObserver(PasswordGeneratorController controller) {
        this.controller = controller;
    }

    /**
     * Updates input display based on String provided as argument.
     *
     * @param input
     *            new value of input display
     */

    /**
     * Updates output display based on String provided as argument.
     *
     * @param output
     *            new value of output display
     */
    @Override
    public void updateOutputDisplay(String output) {
        this.outputText.setText(output);
    }

    @Override
    public void updateCopyAllowed(boolean allowed) {
        this.copyButton.setEnabled(allowed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = e.getSource();
        if (source == this.generateButton) {
            //Update Copy
            this.updateCopyAllowed(true);
            //Generate the password within the bounds we specified on the ASCII table.
            Random r = new Random();
            String password = "";
            while (password.length() < this.passwordLength) {
                int nextChar = r.nextInt(HIGHEST_VALID_CHARACTER + 1);
                if (nextChar >= LOWEST_VALID_CHARACTER
                        && nextChar <= HIGHEST_VALID_CHARACTER) {
                    password += (char) nextChar;
                }
            }
            this.updateOutputDisplay(password);
            this.controller.processGenerateEvent(password);
        } else if (source == this.copyButton) {
            //Copy to Clipboard
            StringSelection stringSelection = new StringSelection(
                    this.outputText.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit()
                    .getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if (!slider.getValueIsAdjusting()) {
            //Set Password Length to adjusted value
            this.passwordLength = slider.getValue();
            System.out.println("Here");
        }
    }
}
