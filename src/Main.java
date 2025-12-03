import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        MainView view = new MainView();

        view.getAddButton().addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter name:");
            String phone = JOptionPane.showInputDialog("Enter phone:");

            if (controller.addCustomer(name, phone)) {
                JOptionPane.showMessageDialog(null, "Customer added.");
            } else {
                JOptionPane.showMessageDialog(null, "Error adding customer.");
            }
        });

        view.getViewButton().addActionListener(e -> {
            var list = controller.loadCustomers();
            StringBuilder sb = new StringBuilder();

            for (Customer c : list) {
                sb.append(c.getId()).append(" - ").append(c.getName())
                        .append(" | ").append(c.getPhone()).append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        });
    }
}

