package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.ClienteDAO;
import model.bean.FilmeDAO;
import model.dao.Cliente;
import model.dao.Filme;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class JFCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFNome;
	private JTextField textFEmail;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroCliente frame = new JFCadastroCliente();
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
	public JFCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar clientes ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 11, 170, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textFNome = new JTextField();
		textFNome.setBounds(24, 84, 257, 20);
		contentPane.add(textFNome);
		textFNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(24, 121, 52, 26);
		contentPane.add(lblNewLabel_2);
		
		textFEmail = new JTextField();
		textFEmail.setBounds(24, 145, 257, 20);
		contentPane.add(textFEmail);
		textFEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(24, 176, 68, 20);
		contentPane.add(lblNewLabel_3);
		
		JSpinner idade = new JSpinner();
		idade.setBounds(24, 196, 52, 26);
		contentPane.add(idade);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(textFNome.getText());
				c.setEmail(textFEmail.getText());
				c.setIdade((Integer.parseInt(idade.getValue().toString())));
			
				dao.create(c);
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar.setBounds(30, 251, 122, 23);
		contentPane.add(btnCadastrar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setBounds(223, 252, 122, 23);
		contentPane.add(btnCancelar);
	}

}
