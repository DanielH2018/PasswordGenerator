/**
 * Model class.
 *
 * @author Daniel Hunter
 */
public final class PasswordGeneratorModel1 implements PasswordGeneratorModel {

    /**
     * Model variable.
     */
    private String output;

    /**
     * Default constructor.
     */
    public PasswordGeneratorModel1() {
        /*
         * Initialize model; variable starts as empty string
         */
        this.output = "";
    }

    @Override
    public String output() {
        return this.output;
    }

    @Override
    public void setOutput(String input) {
        this.output = input;

    }

}
