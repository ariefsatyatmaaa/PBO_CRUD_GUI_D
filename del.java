package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class del extends JFrame {
    JButton btnDel, btnKembali;
    JLabel lJudul,lNIP;
    JTextField tfNIP;
    String DBurl = "jdbc:mysql://localhost/crudpbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    del() {
        lJudul = new JLabel("Hapus Data Pegawai");
        lNIP = new JLabel("NIP ");
        btnDel = new JButton("Hapus");
        btnKembali = new JButton("Kembali");

        tfNIP = new JTextField();

        setTitle("Hapus Data Pegawai");
        setSize(300, 200);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);
        add(lJudul);
        add(lNIP);
        add(tfNIP);
        add(btnDel);
        add(btnKembali);

        lJudul.setBounds(50, 10, 150, 25);
        lNIP.setBounds(50, 50, 100, 25);
        tfNIP.setBounds(100, 50, 100, 25);
        btnKembali.setBounds(30, 90, 100, 25);
        btnDel.setBounds(140, 90, 100, 25);

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuatactionListener();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu();
            }
        });
    }

    private void btnBuatactionListener() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("DELETE FROM pegawai WHERE nip='" + tfNIP.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal di Hapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }

    }
}