import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Login extends JFrame implements ActionListener{
  private JLabel label1, label2, label3, label4;
  private JTextField textField1, textField2;
  private JButton boton1;
  private JPasswordField password;
  public static String usuario = "Thiago020813";
  public static String clave = "pedo43";


  public Login(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Login");
    setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
    getContentPane().setBackground(new Color(209, 242, 235));

    ImageIcon imagen = new ImageIcon("images/logo.png");
    label1 = new JLabel(imagen);
    label1.setBounds(25,15,225,225);
    add(label1);


    label2 = new JLabel("LOGIN");
    label2.setBounds(320,20,90,40);
    label2.setFont(new Font("Andale Mono", 1, 18)); 
    label2.setForeground(new Color(0,0,0));  
    add(label2);

    label3 = new JLabel("Usuario");
    label3.setBounds(260,50,90,30);
    label3.setFont(new Font("Andale Mono", 2, 14)); 
    label3.setForeground(new Color(0,0,0));  
    add(label3);
    
    textField1 = new JTextField();
    textField1.setBounds(260,80,160,30);
    textField1.setFont(new Font("Andale Mono", 0, 14));
    add(textField1);

    label4 = new JLabel("Contraseña");
    label4.setBounds(260,120,90,30);
    label4.setFont(new Font("Andale Mono", 2, 14)); 
    label4.setForeground(new Color(0,0,0));  
    add(label4);
    
    //textField2 = new JTextField();
    //textField2.setBounds(260,150,160,30);
    //textField2.setFont(new Font("Andale Mono", 0, 14));
    //add(textField2);
    
    password = new JPasswordField();
    password.setBounds(260,150,160,30);
    password.setFont(new Font("Andale Mono", 0, 14));   
    add(password);



    boton1 = new JButton("Login");
    boton1.setBounds(300,210,90,30);
    boton1.setFont(new Font("Andale Mono", 1, 16));
    boton1.setBackground(new Color(40, 116, 166));
    boton1.setForeground(new Color(255,255,255));
    boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton1.setBorderPainted(false);  // No pintar el borde
    boton1.setFocusPainted(false);   // Desactivar el borde al hacer foco
    boton1.setContentAreaFilled(true);  // El área de contenido debe estar llena
    getRootPane().setDefaultButton(boton1); // activar al presionar la tecla enter
    boton1.addActionListener(this);
    add(boton1);


   }
    
public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String usuarioIngresado = textField1.getText().trim();
            String claveIngresada = password.getText().trim();                

            if (usuarioIngresado.isEmpty() || claveIngresada.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                textField1.setText("");
                password.setText("");
            } else {
                if (usuarioIngresado.equals(usuario) && claveIngresada.equals(clave)) {
                    //JOptionPane.showMessageDialog(null, "Bienvenido");
                      Main main = new Main();
                      main.setBounds(0,0,600,500);
                      main.setVisible(true);
                      main.setLocationRelativeTo(null);
                      main.setResizable(false);
                      this.setVisible(false);


                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto");
                    textField1.setText("");
                    password.setText("");
                }
            }
        }
    }
    
 public static void main(String[] args) {
        Login login = new Login();
        login.setBounds(0,0,500,350);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setResizable(false);
    }

    
}



