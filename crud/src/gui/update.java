package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class update extends JFrame {
    JLabel lNIP, lNama, lDivisi, lJudul, lJenisKel, lAlamat, lNo;
    JTextField tfNIP, tfNama, tfDivisi, tfJk, tfAlamat, tfNo;
    JButton btnUpdate, btnKembali;
    String DBurl = "jdbc:mysql://localhost/crudpbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    update() {
        lJudul = new JLabel("MASUKKAN NIP YANG AKAN DIUPDATE");
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

        btnUpdate = new JButton("Update");
        btnKembali = new JButton("Kembali");

        setTitle("Update Data Pegawai");
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
        add(btnUpdate);
        add(btnKembali);

        lJudul.setBounds(0, 10, 300, 25);
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
        btnUpdate.setBounds(140, 290, 100, 25);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateactionListener();
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

    private void btnUpdateactionListener() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("UPDATE pegawai SET '" + tfNama.getText() + "','" + tfDivisi.getText() + "','" + tfJk.getText() + "','" + tfAlamat.getText() + "','" + tfNo.getText() + "' WHERE nip='" + tfNIP.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal di Update!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }

    }
}