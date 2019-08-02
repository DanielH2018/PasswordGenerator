/**
 * Controller interface.
 *
 * @author Daniel Hunter
 *
 * @mathmodel <pre>
 * {@code type PasswordGeneratorController is modeled by
 *   (model: PasswordGeneratorModel,
 *    view: PasswordGeneratorView)}
 * </pre>
 * @initially <pre>
 * {@code (PasswordGeneratorModel model, PasswordGeneratorView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view}
 * </pre>
 */
public interface PasswordGeneratorController {

    /**
     * Processes event to Generate password.
     *
     * @updates {@code this.model, this.view}
     * @ensures this.model.output = <output>
     * @param output
     *            Generated Password
     */
    void processGenerateEvent(String output);
}
