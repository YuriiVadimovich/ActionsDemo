import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ActionsDemo extends JFrame {

    public ActionsDemo() {
        super("ActionsDemo");
        setSize(600, 400);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        ButtonsContainer buttonsContainer = new ButtonsContainer();

        final CustomAction customAction = new CustomAction();
        JMenu changeColorMenu = new JMenu("Actions");

        JMenuItem enableAction = new JMenuItem("Enable", KeyEvent.VK_E);
        enableAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        ActionListener enableActionListener = actionEvent -> customAction.setEnabled(true);
        enableAction.addActionListener(enableActionListener);

        JMenuItem textAction = new JMenuItem("Change text", KeyEvent.VK_T);
        textAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        ActionListener changeTexActionListener = e -> customAction.putValue(Action.NAME, "CHANGED");
        textAction.addActionListener(changeTexActionListener);

        JMenuItem disableAction = new JMenuItem("Disable", KeyEvent.VK_D);
        disableAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        ActionListener disableActionListener = e -> customAction.setEnabled(false);
        disableAction.addActionListener(disableActionListener);

        JMenuItem iconAction = new JMenuItem("Set icon", KeyEvent.VK_I);
        iconAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        ActionListener iconActionListener = e -> customAction.putValue(Action.SMALL_ICON,
                MetalIconFactory.getFileChooserHomeFolderIcon());
        iconAction.addActionListener(iconActionListener);

        changeColorMenu.add(enableAction);
        changeColorMenu.add(disableAction);
        changeColorMenu.add(textAction);
        changeColorMenu.add(iconAction);
        menuBar.add(changeColorMenu);

        for (JButton button : buttonsContainer.getButtonList()) {
            button.setAction(customAction);
        }

        setJMenuBar(menuBar);
        add(buttonsContainer, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ActionsDemo();
    }
}
