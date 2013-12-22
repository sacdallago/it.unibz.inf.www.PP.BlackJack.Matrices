
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Due extends JPanel {

    private static JTextField[] list = {new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0")};
    private static JButton computedue;
    private static JPanel duepane;
    private static JLabel instdue;

    public Due() {
        duepane = new JPanel();
        duepane.setLayout(new GridLayout(2, 2));

        instdue = new JLabel("Write four integers in the following four spaces:");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(instdue);

        for (JTextField f : list) {
            f.setHorizontalAlignment(JTextField.CENTER);
            f.setBorder(BorderFactory.createEtchedBorder());
            duepane.add(f);
        }

        add(duepane);

        computedue = new JButton("Compute");
        computedue.addActionListener(new Listener());

        add(computedue);
    }

    private static class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int result;
            try {
                int main = Integer.parseInt(list[0].getText()) * Integer.parseInt(list[3].getText());
                int nonma = Integer.parseInt(list[1].getText()) * Integer.parseInt(list[2].getText());
                result = main - nonma;
                JOptionPane.showMessageDialog(null, result + "\nThis matrix is " + (result != 0 ? "" : "NOT ") + "invertible.");
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "You did not write integers!");
            }
        }
    }
}
