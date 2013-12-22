
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Tre extends JPanel {

    private static JTextField[] list = {new JTextField("0"), new JTextField("0"), new JTextField("0"),
        new JTextField("0"), new JTextField("0"), new JTextField("0"),
        new JTextField("0"), new JTextField("0"), new JTextField("0")};
    private static JButton computetre;
    private static JPanel trepane;
    private static JLabel instre;

    public Tre() {
        trepane = new JPanel();
        trepane.setLayout(new GridLayout(3, 3));

        instre = new JLabel("Write nine integers in the following nine spaces:");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(instre);

        for (JTextField f : list) {
            f.setHorizontalAlignment(JTextField.CENTER);
            f.setBorder(BorderFactory.createEtchedBorder());
            trepane.add(f);
        }

        add(trepane);

        computetre = new JButton("Compute");
        computetre.addActionListener(new Listener());

        add(computetre);
    }

    private static class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int result;
            try {
                int one, two, three, four, five, six;
                one = Integer.parseInt(list[0].getText()) * Integer.parseInt(list[4].getText()) * Integer.parseInt(list[8].getText());
                two = Integer.parseInt(list[1].getText()) * Integer.parseInt(list[5].getText()) * Integer.parseInt(list[6].getText());
                three = Integer.parseInt(list[2].getText()) * Integer.parseInt(list[3].getText()) * Integer.parseInt(list[7].getText());
                four = Integer.parseInt(list[6].getText()) * Integer.parseInt(list[4].getText()) * Integer.parseInt(list[2].getText());
                five = Integer.parseInt(list[7].getText()) * Integer.parseInt(list[5].getText()) * Integer.parseInt(list[0].getText());
                six = Integer.parseInt(list[8].getText()) * Integer.parseInt(list[3].getText()) * Integer.parseInt(list[1].getText());

                result = one + two + three - four - five - six;
                JOptionPane.showMessageDialog(null, result + "\nThis matrix is " + (result != 0 ? "" : "NOT ") + "invertible.");
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "You did not write integers!");
            }
        }
    }
}
