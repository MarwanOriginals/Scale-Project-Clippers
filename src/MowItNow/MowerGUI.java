package MowItNow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MowerGUI {
    private JButton mowerStart;
    private JPanel panel1;

    public MowerGUI() {
        mowerStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(null);
                mowerStart.setText("Done !");
                mowerStart.setEnabled(false);
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Mow It Now");
        frame.setContentPane((new MowerGUI().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }
}
