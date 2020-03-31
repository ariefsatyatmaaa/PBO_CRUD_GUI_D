package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class create extends JFrame {
    JLabel lNIP, lNama, lDivisi, lJudul, lJenisKel, lAlamat, lNo;
    JTextField tfNIP, tfNama, tfDivisi, tfJk, tfAlamat, tfNo;
    JButton btnBuat, btnKembali;
    String DBurl = "jdbc:mysql://localhost/crudpbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    create() {
        lJudul = new JLabel("Buat Data Pegawai");
        lNIP = new JLabel("NIP ");
        lNama = new JLabel("Nama ");
        lDivisi = new JLabel("Divisi ");
        lJenisKel = new JLabel("JenKel ");
        lAlamat = new JLabel("Alamat ");
        lNo = new JLabel("No Telp");

        tfNIP = new JTextField();
        tfNama = new JTextField();
        tfDivisi = new JTextField();
        tfJk = new JTextField();
        tfAlamat = new JTextField();
        tfNo = new JTextField();

        btnBuat = new JButton("Buat");
        btnKembali = new JButton("Kembali");

        setTitle("Data Pegawai");
        setSize(300, 370);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);
        add(lJudul);
        add(lNIP);
        add(lNama);
        add(lDivisi);
        add(lJenisKel);
        add(lAlamat);
        add(lNo);
        add(tfNIP);
        add(tfNama);
        add(tfDivisi);
        add(tfJk);
        add(tfAlamat);
        add(tfNo);
        add(btnBuat);
        add(btnKembali);

        lJudul.setBounds(50, 10, 150, 25);
        lNIP.setBounds(50, 50, 100, 25);
        tfNIP.setBounds(100, 50, 100, 25);
        lNama.setBounds(50, 90, 100, 25);
        tfNama.setBounds(100, 90, 100, 25);
        lDivisi.setBounds(50, 130, 100, 25);
        tfDivisi.setBounds(100, 130, 100, 25);
        lJenisKel.setBounds(50, 170, 100, 25);
        tfJk.setBounds(100, 170, 100, 25);
        lAlamat.setBounds(50, 210, 100, 25);
        tfAlamat.setBounds(100, 210, 100, 25);
        lNo.setBounds(50, 250, 100, 25);
        tfNo.setBounds(100, 250, 100, 25);
        btnKembali.setBounds(30, 290, 100, 25);
        btnBuat.setBounds(140, 290, 100, 25);

        btnBuat.addActionListener(new ActionListener() {
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
            statement.executeUpdate("INSERT INTO pegawai VALUES ('" + tfNIP.getText() + "','" + tfNama.getText() + "','" + tfDivisi.getText() + "','" + tfJk.getText() + "','" + tfAlamat.getText() + "','" + tfNo.getText() + "')");
            JOptionPane.showMessageDialog(null, "Data berhasil di Buat!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal di Buat!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }

    }
}