
import java.awt.event.*;
import javax.swing.*;

public class Main {

    private static JMenuItem due, tre;
    private static Due duepane = new Due();
    private static Tre trepane = new Tre();
    private static JPanel panel = new JPanel();
    private static JFrame frame;

    public static void main(String[] args) {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        bar.add(menu);

        panel.add(duepane);

        due = new JMenuItem("2x2");
        menu.add(due);
        due.addActionListener(new Listener());

        tre = new JMenuItem("3x3");
        menu.add(tre);
        tre.addActionListener(new Listener());

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(bar);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(500, 200, 430, 450);
        frame.setVisible(true);
    }

    private static class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (due.isArmed()) {
                panel.removeAll();
                panel.add(duepane);
                panel.updateUI();
            }
            if (tre.isArmed()) {
                panel.removeAll();
                panel.add(trepane);
                panel.updateUI();
            }
        }
    }
}
