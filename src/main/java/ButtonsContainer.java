import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class ButtonsContainer extends JPanel {

    private final List<JButton> buttonList = new ArrayList<>();

    public ButtonsContainer() {

        for (int i = 0; i < 5; i++) {
            JButton button = new JButton(Integer.toString(i));
            buttonList.add(button);
            add(button);
        }
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }
}
