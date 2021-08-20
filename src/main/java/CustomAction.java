import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class CustomAction extends AbstractAction {

    public CustomAction() {
        super("Custom action");
        putValue(Action.SHORT_DESCRIPTION, "I description");
    }

    public void actionPerformed(ActionEvent actionEvent) {}
}
