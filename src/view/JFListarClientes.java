package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setTitle("Listar clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 113, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 603, 265);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Email", "Idade"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(63, 342, 113, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(216, 342, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(364, 342, 89, 23);
		contentPane.add(btnAlterar);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[]{
				c.getId_cliente(),
				c.getNome(),
				c.getEmail(),
				c.getIdade()				
			});
				
		}
		
	}
}
