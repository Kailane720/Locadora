package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JFCadastroFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroFilme frame = new JFCadastroFilme();
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
	public JFCadastroFilme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastro = new JLabel("Cadastrar Filmes");
		cadastro.setFont(new Font("Arial", Font.BOLD, 17));
		cadastro.setBounds(24, 11, 149, 28);
		contentPane.add(cadastro);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 66, 267, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel tituloum = new JLabel("T\u00EDtulo");
		tituloum.setFont(new Font("Arial", Font.BOLD, 14));
		tituloum.setBounds(10, 50, 46, 14);
		contentPane.add(tituloum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 473, 97);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel titulosinopse = new JLabel("Sinopse");
		titulosinopse.setFont(new Font("Arial", Font.BOLD, 14));
		titulosinopse.setBounds(10, 97, 79, 14);
		contentPane.add(titulosinopse);
		
		JLabel categoria = new JLabel("Categoria");
		categoria.setFont(new Font("Arial", Font.BOLD, 14));
		categoria.setBounds(10, 226, 79, 14);
		contentPane.add(categoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(10, 251, 267, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel tempo = new JLabel("Tempo");
		tempo.setFont(new Font("Arial", Font.BOLD, 14));
		tempo.setBounds(10, 282, 79, 14);
		contentPane.add(tempo);
		
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setBounds(197, 283, 69, 14);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_6 = new JLabel("Audio");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setBounds(361, 283, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(20, 307, 69, 20);
		contentPane.add(spTempo);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setBounds(176, 306, 46, 23);
		contentPane.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setBounds(224, 304, 53, 23);
		contentPane.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(318, 306, 89, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(403, 306, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtn2D.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				}
				if(rdbtnDublado.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
				dispose();
				
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(23, 372, 97, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText(null);
				txtSinopse.setText(null);
				txtCategoria.setText(null);
				spTempo.setValue(0);
				imagem.clearSelection();
				audio.clearSelection();
							
					
				}		
		
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpar.setBounds(177, 373, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar.setBounds(318, 373, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}
