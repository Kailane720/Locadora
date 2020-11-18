package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class jFLogin extends JFrame {

	private JPanel contentPane;
	private JLabel usuario;
	private JTextField informeusuario;
	private JPasswordField informesenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFLogin frame = new jFLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jFLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bemvindo = new JLabel("Boas Vindas");
		bemvindo.setBounds(5, 5, 424, 21);
		bemvindo.setHorizontalAlignment(SwingConstants.CENTER);
		bemvindo.setFont(new Font("Arial Black", Font.BOLD, 16));
		contentPane.add(bemvindo);
		
		usuario = new JLabel("Usu\u00E1rio");
		usuario.setFont(new Font("Arial", Font.PLAIN, 16));
		usuario.setBounds(15, 38, 148, 34);
		contentPane.add(usuario);
		
		informeusuario = new JTextField();
		informeusuario.setBounds(5, 71, 158, 20);
		contentPane.add(informeusuario);
		informeusuario.setColumns(10);
		
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Arial", Font.PLAIN, 16));
		senha.setBounds(15, 118, 46, 14);
		contentPane.add(senha);
		
		informesenha = new JPasswordField();
		informesenha.setBounds(5, 143, 158, 20);
		contentPane.add(informesenha);
		
		JButton entrar = new JButton("Entrar");
		entrar.setFont(new Font("Arial Black", Font.BOLD, 13));
		entrar.setHorizontalAlignment(SwingConstants.RIGHT);
		entrar.setBounds(100, 206, 89, 23);
		contentPane.add(entrar);
		
		JButton limpar = new JButton("Limpar dados");
		limpar.setFont(new Font("Arial Black", Font.BOLD, 13));
		limpar.setBounds(208, 206, 184, 23);
		contentPane.add(limpar);
	}
}
