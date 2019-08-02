/**
 * Controller class.
 *
 * @author Daniel Hunter
 */
public final class PasswordGeneratorController1
        implements PasswordGeneratorController {

    /**
     * Model object.
     */
    private final PasswordGeneratorModel model;

    /**
     * View object.
     */
    private final PasswordGeneratorView view;

    /**
     * Updates view to display model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     */
    private static void updateViewToMatchModel(PasswordGeneratorModel model,
            PasswordGeneratorView view) {
        /*
         * Get model info
         */
        String output = model.output();
        /*
         * Update view to reflect changes in model
         */
        view.updateOutputDisplay(output.toString());
    }

    /**
     * Constructor; connects {@code this} to the model and view it coordinates.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public PasswordGeneratorController1(PasswordGeneratorModel model,
            PasswordGeneratorView view) {
        this.model = model;
        this.view = view;
        /*
         * Update view to reflect initial value of model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processGenerateEvent(String input) {
        this.model.setOutput(input);

    }

}
