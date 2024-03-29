/*
 * Created by JFormDesigner on Wed Apr 20 14:40:06 BST 2016
 */

package Presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.conheci_impreciso;
import src.conheci_incerto;
import src.conhecimento;
import src.Main;

/**
 * @author Octavio Maia
 */
public class ConhecimentoImpreciso extends JFrame {
	public ConhecimentoImpreciso() {
		initComponents();
	}

	private void button1ActionPerformed(ActionEvent e) {
		conhecimento c;
		
		if(buttonUtente.isSelected()){
			//String idUtente, String nomeUtente, String idadeUtente, String moradaUtente
			String id = textArg1.getText();
			String nome = textArg2.getText();
			String idade = textArg3.getText();
			String morada = textArg4.getText();
			String ops = null;
			
			if(id.contains("-") || id.contains(",")){
				ops=id;
				id=null;
			}else if(nome.contains("-") || nome.contains(",")){
				ops=nome;
				nome=null;
			}else if(idade.contains("-") || idade.contains(",")){
				ops=idade;
				idade=null;
			}else if(morada.contains("-") || morada.contains(",")){
				ops=morada;
				morada=null;
			}
			
			/*System.out.println("ID:"+id);
			System.out.println("NOME:"+nome);
			System.out.println("Ida:"+idade);
			System.out.println("Mor:"+morada);
			System.out.println("OPs:"+ops);*/
			c = new conheci_impreciso("", id, nome, idade, morada, ops);
			Main.evolucao(c.getProlog());
		}
		if(buttonConsulta.isSelected()){
			//String diaConslta, String mesConslta, String anoConslta, String utenteConslta, String serveConslta, String custoConslta,String ops
			String diaConsulta = textArg1.getText();
			String mesConsulta = textArg2.getText();
			String anoConsulta = textArg3.getText();
			String utenteConsulta = textArg4.getText();
			String serveConsulta = textArg5.getText();
			String custoConsulta = textArg6.getText();
			String ops = null;
			
			if(diaConsulta.contains("-") || diaConsulta.contains(",")){
				ops=diaConsulta;
				diaConsulta=null;
			}else if(mesConsulta.contains("-") || mesConsulta.contains(",")){
				ops=mesConsulta;
				mesConsulta=null;
			}else if(anoConsulta.contains("-") || anoConsulta.contains(",")){
				ops=anoConsulta;
				anoConsulta=null;
			}else if(utenteConsulta.contains("-") || utenteConsulta.contains(",")){
				ops=utenteConsulta;
				utenteConsulta=null;
			}else if(serveConsulta.contains("-") || serveConsulta.contains(",")){
				ops=serveConsulta;
				serveConsulta=null;
			}else if(custoConsulta.contains("-") || custoConsulta.contains(",")){
				ops=custoConsulta;
				custoConsulta=null;
			}/*
			System.out.println(diaConsulta);
			System.out.println(mesConsulta);
			System.out.println(anoConsulta);
			System.out.println(utenteConsulta);
			System.out.println(serveConsulta);
			System.out.println(custoConsulta);
			System.out.println(ops);*/
			c = new conheci_impreciso(diaConsulta,mesConsulta,anoConsulta,utenteConsulta,serveConsulta,custoConsulta,ops);
			Main.evolucao(c.getProlog());
		}
		if(buttonServico.isSelected()){
			//String idServico, String nomeServico, String instServico, String cidadeServico,String ops
			String idServico = textArg1.getText();
			String nomeServico = textArg2.getText();
			String instServico = textArg3.getText();
			String cidadeServico = textArg4.getText();
			String ops = null;
			
			if(idServico.contains("-") || idServico.contains(",")){
				ops=idServico;
				idServico=null;
			}else if(nomeServico.contains("-") || nomeServico.contains(",")){
				ops=nomeServico;
				nomeServico=null;
			}else if(instServico.contains("-") || instServico.contains(",")){
				ops=instServico;
				instServico=null;
			}else if(cidadeServico.contains("-") || cidadeServico.contains(",")){
				ops=cidadeServico;
				cidadeServico=null;
			}
			/*System.out.println(idServico);
			System.out.println(nomeServico);
			System.out.println(instServico);
			System.out.println(cidadeServico);
			System.out.println(ops);*/
			c = new conheci_impreciso(idServico,nomeServico,instServico,cidadeServico,ops);
			Main.evolucao(c.getProlog());
		}
		
		//agr falta adicionar o conhecimento_incerto c à base de conhecimento
	}

	private void buttonServicoActionPerformed(ActionEvent e) {
		arg1.setText("Argumento 1 (idServico)");
		arg2.setText("Argumento 2 (nomeServico)");
		arg3.setText("Argumento 3 (institServico)");
		arg4.setText("Argumento 4 (cidadeServico)");
		arg5.setVisible(false);
		arg6.setVisible(false);
		textArg5.setVisible(false);
		textArg6.setVisible(false);
	}

	private void buttonConsultaActionPerformed(ActionEvent e) {
		arg1.setText("Argumento 1 (diaConsulta)");
		arg2.setText("Argumento 2 (mesConsulta)");
		arg3.setText("Argumento 3 (anoConsulta)");
		arg4.setText("Argumento 4 (utenteConsulta)");
		arg5.setText("Argumento 5 (servicoConsulta)");
		arg6.setText("Argumento 6 (custoConsulta)");
		arg5.setVisible(true);
		arg6.setVisible(true);
		textArg5.setVisible(true);
		textArg6.setVisible(true);
	}

	private void buttonUtenteActionPerformed(ActionEvent e) {
		arg1.setText("Argumento 1 (idUtente)");
		arg2.setText("Argumento 2 (nomeUtente)");
		arg3.setText("Argumento 3 (idadeUtente)");
		arg4.setText("Argumento 4 (moradaUtente)");
		arg5.setVisible(false);
		arg6.setVisible(false);
		textArg5.setVisible(false);
		textArg6.setVisible(false);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Octavio Maia
		label1 = new JLabel();
		buttonUtente = new JRadioButton();
		buttonServico = new JRadioButton();
		buttonConsulta = new JRadioButton();
		separator1 = new JSeparator();
		label2 = new JLabel();
		arg1 = new JLabel();
		textArg1 = new JTextField();
		arg2 = new JLabel();
		arg3 = new JLabel();
		arg4 = new JLabel();
		arg5 = new JLabel();
		arg6 = new JLabel();
		textArg2 = new JTextField();
		textArg3 = new JTextField();
		textArg4 = new JTextField();
		textArg5 = new JTextField();
		textArg6 = new JTextField();
		separator2 = new JSeparator();
		buttonConhecimentoPositivo = new JButton();
		separator3 = new JSeparator();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		textPane1 = new JTextPane();

		//======== this ========
		setTitle("Conhecimento Impreciso");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setFont(new Font("Arial", Font.PLAIN, 12));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Predicados");
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(label1);
		label1.setBounds(10, 5, 130, 25);

		//---- buttonUtente ----
		buttonUtente.setText("Utente");
		buttonUtente.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonUtente.setSelected(true);
		buttonUtente.addActionListener(e -> buttonUtenteActionPerformed(e));
		contentPane.add(buttonUtente);
		buttonUtente.setBounds(110, 40, 95, buttonUtente.getPreferredSize().height);

		//---- buttonServico ----
		buttonServico.setText("Servi\u00e7o");
		buttonServico.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonServico.addActionListener(e -> buttonServicoActionPerformed(e));
		contentPane.add(buttonServico);
		buttonServico.setBounds(230, 40, 100, buttonServico.getPreferredSize().height);

		//---- buttonConsulta ----
		buttonConsulta.setText("Consulta");
		buttonConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonConsulta.addActionListener(e -> buttonConsultaActionPerformed(e));
		contentPane.add(buttonConsulta);
		buttonConsulta.setBounds(355, 40, 105, buttonConsulta.getPreferredSize().height);
		contentPane.add(separator1);
		separator1.setBounds(10, 68, 540, 7);

		//---- label2 ----
		label2.setText("Construtor");
		label2.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(10, 85), label2.getPreferredSize()));

		//---- arg1 ----
		arg1.setText("Argumento 1 (idUtente)");
		arg1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(arg1);
		arg1.setBounds(15, 115, 190, 20);
		contentPane.add(textArg1);
		textArg1.setBounds(240, 115, 295, textArg1.getPreferredSize().height);

		//---- arg2 ----
		arg2.setText("Argumento 2 (NomeUtente)");
		arg2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(arg2);
		arg2.setBounds(15, 145, 190, 20);

		//---- arg3 ----
		arg3.setText("Argumento 3 (idadeUtente)");
		arg3.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(arg3);
		arg3.setBounds(15, 175, 190, 20);

		//---- arg4 ----
		arg4.setText("Argumento 4 (MoradaUtente)");
		arg4.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(arg4);
		arg4.setBounds(15, 205, 215, 20);

		//---- arg5 ----
		arg5.setText("Argumento 5");
		arg5.setFont(new Font("Arial", Font.PLAIN, 12));
		arg5.setVisible(false);
		contentPane.add(arg5);
		arg5.setBounds(15, 235, 180, 20);

		//---- arg6 ----
		arg6.setText("Argumento 6");
		arg6.setFont(new Font("Arial", Font.PLAIN, 12));
		arg6.setVisible(false);
		contentPane.add(arg6);
		arg6.setBounds(15, 265, 180, 20);
		contentPane.add(textArg2);
		textArg2.setBounds(240, 145, 295, 20);
		contentPane.add(textArg3);
		textArg3.setBounds(240, 175, 295, 20);
		contentPane.add(textArg4);
		textArg4.setBounds(240, 205, 295, 20);

		//---- textArg5 ----
		textArg5.setVisible(false);
		contentPane.add(textArg5);
		textArg5.setBounds(240, 235, 295, 20);

		//---- textArg6 ----
		textArg6.setVisible(false);
		contentPane.add(textArg6);
		textArg6.setBounds(240, 265, 295, 20);
		contentPane.add(separator2);
		separator2.setBounds(10, 300, 540, 7);

		//---- buttonConhecimentoPositivo ----
		buttonConhecimentoPositivo.setText("Adicionar conhecimento impreciso");
		buttonConhecimentoPositivo.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonConhecimentoPositivo.addActionListener(e -> button1ActionPerformed(e));
		contentPane.add(buttonConhecimentoPositivo);
		buttonConhecimentoPositivo.setBounds(10, 515, 540, 25);
		contentPane.add(separator3);
		separator3.setBounds(10, 505, 540, 7);

		//---- label3 ----
		label3.setText("Regras de utiliza\u00e7\u00e3o");
		label3.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(label3);
		label3.setBounds(10, 310, 175, label3.getPreferredSize().height);

		//======== scrollPane1 ========
		{

			//---- textPane1 ----
			textPane1.setText("-> De modo a representar v\u00e1rios possiveis valores \u00e9 necess\u00e1rio utilizar uma v\u00edrgula de modo a separar as diversas opc\u00f5es.\n-Exemplo: O utente n\u00e3o sabe se o seu nome \u00e9 Joao, Manuel ou Rui, logo os valores ir\u00e3o ser representados da seguinte forma: \"Joao,Manuel,Rui\"\n\n-> De forma a representar um intervalo de valores utilizamos um h\u00edfen.\n-Exemplo: O utente sabe que tem entre 50 e 60 anos, logo os valores ir\u00e3o ser representados da seguinte forma: \"50-60\"");
			textPane1.setFont(new Font("Arial", Font.PLAIN, 12));
			textPane1.setEditable(false);
			scrollPane1.setViewportView(textPane1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(10, 340, 540, 145);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		setSize(580, 585);
		setLocationRelativeTo(null);

		//---- buttonGroup1 ----
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(buttonUtente);
		buttonGroup1.add(buttonServico);
		buttonGroup1.add(buttonConsulta);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Octavio Maia
	private JLabel label1;
	private JRadioButton buttonUtente;
	private JRadioButton buttonServico;
	private JRadioButton buttonConsulta;
	private JSeparator separator1;
	private JLabel label2;
	private JLabel arg1;
	private JTextField textArg1;
	private JLabel arg2;
	private JLabel arg3;
	private JLabel arg4;
	private JLabel arg5;
	private JLabel arg6;
	private JTextField textArg2;
	private JTextField textArg3;
	private JTextField textArg4;
	private JTextField textArg5;
	private JTextField textArg6;
	private JSeparator separator2;
	private JButton buttonConhecimentoPositivo;
	private JSeparator separator3;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JTextPane textPane1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
