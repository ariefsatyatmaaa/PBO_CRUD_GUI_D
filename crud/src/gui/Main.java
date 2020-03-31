package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new Menu();
    }
}

class Menu extends JFrame implements ActionListener {
    JLabel ljudul;
    JButton btncr;
    JButton btnud;
    JButton btndl;

    Menu() {
        ljudul = new JLabel("MENU CRUD KEPEGAWAIAN");
        btncr = new JButton("1. Create");
        btnud = new JButton("2. Update");
        btndl = new JButton("3. Delete");

        btncr.addActionListener(this);
        btnud.addActionListener(this);
        btndl.addActionListener(this);

        setLayout(null);
        add(ljudul);
        add(btncr);
        add(btnud);
        add(btndl);

        ljudul.setBounds(70, 10, 180, 25);
        btncr.setBounds(70, 40, 180, 25);
        btnud.setBounds(70, 70, 180, 25);
        btndl.setBounds(70, 100, 180, 25);

        setTitle("MENU CRUD DATA KEPEGAWAIAN");
        setSize(330, 200);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btncr) {
            setVisible(false);
            new create();
        } else if (e.getSource() == btnud) {
            setVisible(false);
            new update();
        } else if (e.getSource() == btndl) {
            setVisible(false);
            new del();
        }
    }
}