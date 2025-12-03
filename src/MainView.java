import javax.swing.*;
import java.awt.*;

public class MainView {

    private JFrame frame;
    private JButton btnAdd;
    private JButton btnView;

    public MainView() {
        frame = new JFrame("Garage Appointment System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd = new JButton("Add Customer");
        btnView = new JButton("View Customers");

        JPanel panel = new JPanel();
        panel.add(btnAdd);
        panel.add(btnView);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JButton getAddButton() {
        return btnAdd;
    }
    public JButton getViewButton() {
        return btnView;
    }
}
