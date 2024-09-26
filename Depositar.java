import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Depositar extends JFrame implements ActionListener, KeyListener {
    private JLabel labelHead, labelLogo, labelIngresar;
    private JTextField texto;
    private JButton btnConfirmar, btnCancelar;
    private JTextArea txtInfo;
    private Main ventanaMain;

    public Depositar(Main main) {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Depositar");
        setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
        getContentPane().setBackground(new Color(209, 242, 235));

        // Almacenar la referencia a Main
        this.ventanaMain = main;

        labelHead = new JLabel("ZONA TRANSACCIONAL: DEPÓSITO");
        labelHead.setBounds(90, 5, 350, 40);
        labelHead.setFont(new Font("Andale Mono", 3, 18));
        add(labelHead);

        ImageIcon imagen = new ImageIcon("images/depositar.png");
        labelLogo = new JLabel(imagen);
        labelLogo.setBounds(25, 15, 210, 213);
        add(labelLogo);

        labelIngresar = new JLabel("Ingrese Monto a Depositar $");
        labelIngresar.setBounds(250, 85, 200, 30);
        labelIngresar.setFont(new Font("Andale Mono", 1, 14));
        add(labelIngresar);

        texto = new JTextField();
        texto.setBounds(250, 130, 180, 30);
        texto.setFont(new Font("Andale Mono", 1, 14));
        texto.addKeyListener(this);
        add(texto);

        btnCancelar = new JButton("<< Cancelar");
        btnCancelar.setBounds(200, 190, 120, 30);
        btnCancelar.setFont(new Font("Andale Mono", 1, 12));
        btnCancelar.setBackground(new Color(40, 116, 166));
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(this);
        add(btnCancelar);

        btnConfirmar = new JButton("Confirmar >>");
        btnConfirmar.setBounds(340, 190, 120, 30);
        btnConfirmar.setFont(new Font("Andale Mono", 1, 12));
        btnConfirmar.setBackground(new Color(40, 116, 166));
        btnConfirmar.setForeground(new Color(255, 255, 255));
        btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmar.addActionListener(this);
        add(btnConfirmar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            ventanaMain.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == btnConfirmar) {
            String monto = texto.getText();

            if (monto.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un monto.");
            } else {
                double deposito = Double.parseDouble(monto);
                Main.saldoActual += deposito;
                JOptionPane.showMessageDialog(null, "Depósito exitoso. Nuevo saldo: $" + Main.saldoActual);
                ventanaMain.actualizarSaldo(); // Actualizar el saldo en la ventana principal
                ventanaMain.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}

