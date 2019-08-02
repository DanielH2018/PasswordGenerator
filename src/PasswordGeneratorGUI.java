/**
 * Simple GUI application creating passwords using a version of the
 * Model-View-Controller (MVC) design pattern including interfaces.
 *
 * @author Daniel Hunter
 */
public final class PasswordGeneratorGUI {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PasswordGeneratorGUI() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects, and
         * initialize them; view needs to know about controller, and controller
         * needs to know about model and view
         */
        PasswordGeneratorModel model = new PasswordGeneratorModel1();
        PasswordGeneratorView view = new PasswordGeneratorView1();
        PasswordGeneratorController controller = new PasswordGeneratorController1(
                model, view);

        view.registerObserver(controller);
    }

}
