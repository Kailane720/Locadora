package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFNome;
	private JTextField textFEmail;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param i 
	 */
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar clientes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 11, 170, 26);
		contentPane.add(lblNewLabel);
		
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNewLabel_7 = new JLabel("ID do cliente");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(166, 38, 89, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(240, 38, 46, 14);
		contentPane.add(lblId);
		
		
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
		
		
		lblId.setText(String.valueOf(c.getId_cliente()));
		textFNome.setText(c.getNome());
		textFEmail.setText(c.getEmail());
		idade.setValue(c.getIdade());
		
	    JButton btnAlterar = new JButton("Alterar");
	    btnAlterar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {		
	    				Cliente c = new Cliente();
	    				ClienteDAO dao = new ClienteDAO();
	    			
	    				c.setId_cliente(Integer.parseInt(lblId.getText()));
	    			    c.setNome(textFNome.getText());
	    			    c.setEmail(textFEmail.getText());
	    				c.setIdade(Integer.parseInt(idade.getValue().toString()));
	    				
	    				dao.update(c);
	    				dispose();
	    			}
	    		});
	    		btnAlterar.setBounds(10, 400, 89, 23);
	    		contentPane.add(btnAlterar);

		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(21, 252, 101, 24);
		contentPane.add(btnAlterar);
		
		
	
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFNome.setText(null);
				textFEmail.setText(null);
                idade.setValue(0);
									
					}		
		});
		btnNewButton.setBounds(134, 254, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(260, 254, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
	
	}
}