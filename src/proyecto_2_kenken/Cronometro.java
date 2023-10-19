package proyecto_2_kenken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cronometro extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel cronometro_lbl;
    private JTextField horasEntry, minutosEntry, segundosEntry;
    private JButton btn, btn_pause, btn_reset;
    private Timer timer;
    private int temp;

    public Cronometro() {
        setLayout(new FlowLayout());

        cronometro_lbl = new JLabel("Cronometro");
        cronometro_lbl.setFont(new Font("Calibri", Font.BOLD, 14));
        cronometro_lbl.setForeground(Color.WHITE);
        add(cronometro_lbl);

        horasEntry = new JTextField("00", 3);
        horasEntry.setFont(new Font("Calibri", Font.PLAIN, 14));
        add(horasEntry);

        minutosEntry = new JTextField("00", 3);
        minutosEntry.setFont(new Font("Calibri", Font.PLAIN, 14));
        add(minutosEntry);

        segundosEntry = new JTextField("00", 3);
        segundosEntry.setFont(new Font("Calibri", Font.PLAIN, 14));
        add(segundosEntry);

        btn = new JButton("INICIAR");
        btn.addActionListener(this);
        add(btn);

        btn_pause = new JButton("PAUSA");
        btn_pause.addActionListener(this);
        btn_pause.setEnabled(false);
        add(btn_pause);

        btn_reset = new JButton("REINICIAR");
        btn_reset.addActionListener(this);
        btn_reset.setEnabled(false);
        add(btn_reset);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            try {
                temp = Integer.parseInt(horasEntry.getText()) * 3600 + Integer.parseInt(minutosEntry.getText()) * 60 + Integer.parseInt(segundosEntry.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor digite un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            btn.setEnabled(false);
            btn_pause.setEnabled(true);
            btn_reset.setEnabled(true);
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (temp == 0) {
                        JOptionPane.showMessageDialog(Cronometro.this, "Se acabó el tiempo", "Cuenta Regresiva", JOptionPane.INFORMATION_MESSAGE);
                        btn_pause.setEnabled(false);
                        btn_reset.setEnabled(false);
                        timer.stop();
                    } else {
                        temp--;
                        int hours = temp / 3600;
                        int minutes = (temp % 3600) / 60;
                        int seconds = temp % 60;
                        horasEntry.setText(String.format("%02d", hours));
                        minutosEntry.setText(String.format("%02d", minutes));
                        segundosEntry.setText(String.format("%02d", seconds));
                    }
                }
            });
            timer.start();
        } else if (e.getSource() == btn_pause) {
            btn_pause.setEnabled(false);
            btn_reset.setEnabled(true);
            timer.stop();
        } else if (e.getSource() == btn_reset) {
            btn.setEnabled(true);
            btn_pause.setEnabled(false);
            btn_reset.setEnabled(false);
            timer.stop();
            horasEntry.setText("00");
            minutosEntry.setText("00");
            segundosEntry.setText("00");
        }
    }

    /*public static void main(String[] args) {
        new Cronometro();
    }*/
}