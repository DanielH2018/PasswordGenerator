/**
 * Model interface.
 *
 * The PasswordGenerator model consists of the input string.
 *
 * @author Daniel Hunter
 *
 */
public interface PasswordGeneratorModel {

    /**
     * Reports this.output.
     *
     * @return this.output
     * @ensures <pre>
     * {@code output = this.output}
     * </pre>
     */
    String output();

    /**
     * Sets this.output.
     *
     * @param output
     *            Input String
     * @ensures <pre>
     * {@code this.output = output}
     * </pre>
     */
    void setOutput(String output);

}
