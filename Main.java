import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JMenuBar mb;
    private JMenuItem itemSalir, itemAbout;
    private JLabel labelLogo, labelOpciones;
    private JTextArea textArea;
    private JButton btnConsultar, btnDepositar, btnRetirar;
    private String cliente = "Thiago Gomajoa";
    private String tipoCuenta = "Corriente";
    public static double saldoActual = 1500000.00;

    public Main() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Principal");
        setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
        getContentPane().setBackground(new Color(209, 242, 235));

        mb = new JMenuBar();
        mb.setBackground(new Color(144, 148, 151));
        setJMenuBar(mb);

        itemSalir = new JMenuItem("Salir");
        itemSalir.setFont(new Font("Andale Mono", 1, 14));
        itemSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemSalir.addActionListener(this);
        mb.add(itemSalir);

        itemAbout = new JMenuItem("About");
        itemAbout.setFont(new Font("Andale Mono", 1, 14));
        itemAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemAbout.addActionListener(this);
        mb.add(itemAbout);

        ImageIcon imagen = new ImageIcon("images/dinero.png");
        labelLogo = new JLabel(imagen);
        labelLogo.setBounds(25, 15, 225, 213);
        add(labelLogo);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(25, 240, 225, 150);
        textArea.setFont(new Font("Andale Mono", 1, 14));
        textArea.setBackground(new Color(174, 214, 241));
        textArea.setForeground(new Color(0, 0, 0));
        actualizarSaldo(); // Inicializa el saldo en el TextArea
        add(textArea);

        labelOpciones = new JLabel("¿QUE DESEAS HACER?");
        labelOpciones.setFont(new Font("Andale Mono", 1, 16));
        labelOpciones.setBounds(300, 50, 200, 30);
        add(labelOpciones);

        btnConsultar = new JButton("Consultar Saldo");
        btnConsultar.setBounds(330, 100, 150, 30);
        btnConsultar.setFont(new Font("Andale Mono", 1, 12));
        btnConsultar.setBackground(new Color(40, 116, 166));
        btnConsultar.setForeground(new Color(255, 255, 255));
        btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(this);
        add(btnConsultar);

        btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(330, 150, 150, 30);
        btnDepositar.setFont(new Font("Andale Mono", 1, 12));
        btnDepositar.setBackground(new Color(40, 116, 166));
        btnDepositar.setForeground(new Color(255, 255, 255));
        btnDepositar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDepositar.addActionListener(this);
        add(btnDepositar);

        btnRetirar = new JButton("Retirar");
        btnRetirar.setBounds(330, 200, 150, 30);
        btnRetirar.setFont(new Font("Andale Mono", 1, 12));
        btnRetirar.setBackground(new Color(40, 116, 166));
        btnRetirar.setForeground(new Color(255, 255, 255));
        btnRetirar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRetirar.addActionListener(this);
        add(btnRetirar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemSalir) {
            int confirmacion = JOptionPane.showConfirmDialog(
                    null, "¿Está seguro de que desea salir?", "Confirmación de salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                Login login = new Login();
                login.setBounds(0, 0, 500, 350);
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                login.setResizable(false);
                this.setVisible(false);
            }
        }

        if (e.getSource() == itemAbout) {
            JOptionPane.showMessageDialog(null, "Developed by: \nhttps://github.com/ricardoandrade1302");
        }

        if (e.getSource() == btnConsultar) {
            JOptionPane.showMessageDialog(null, "Saldo Disponible: $" + saldoActual);
        }

        if (e.getSource() == btnRetirar) {
            Retirar retirar = new Retirar(this); // Pasar referencia de Main
            retirar.setBounds(0, 0, 500, 350);
            retirar.setVisible(true);
            retirar.setLocationRelativeTo(null);
            retirar.setResizable(false);
            this.setVisible(false);
        }

        if (e.getSource() == btnDepositar) {
            Depositar depositar = new Depositar(this); // Pasar referencia de Main
            depositar.setBounds(0, 0, 500, 350);
            depositar.setVisible(true);
            depositar.setLocationRelativeTo(null);
            depositar.setResizable(false);
            this.setVisible(false);
        }
    }

    // Método para actualizar el saldo y reflejar en el JTextArea
    public void actualizarSaldo() {
        textArea.setText("\n  Cliente: " + cliente + " " +
                "\n\n  Tipo de Cuenta: " + tipoCuenta +
                "\n\n  Saldo Actual: $" + saldoActual);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setBounds(0, 0, 600, 500);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
    }
}
