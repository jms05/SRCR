/*
 * Created by JFormDesigner on Tue Apr 19 17:31:08 BST 2016
 */

package Presentation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import src.Main;
/**
 * @author Octavio Maia
 */
public class MainInterface extends JFrame {
	public MainInterface() {
		initComponents();
	}

	private void buttonProcurarActionPerformed(ActionEvent e) {
		fileChooser1.setVisible(true);
		int result = fileChooser1.showOpenDialog(fileChooser1);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser1.getSelectedFile();
		    pathLabel.setText(selectedFile.getAbsolutePath());
		    fileChooser1.setVisible(false);
		}else
			fileChooser1.setVisible(false);
	}

	private void buttonCarregarActionPerformed(ActionEvent e) {
		int flag=0;
		
		if(pathLabel.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Path nulo!");
		}else{
			flag = Main.load(pathLabel.getText());
			if(flag==1){
				addConhecimentoImpreciso.setEnabled(true);
				addConhecimentoIncerto.setEnabled(true);
				addConhecimentoInterdito.setEnabled(true);
				addConhecimentoPerfeito.setEnabled(true);
			}
		}
	}

	private void buttonApagarActionPerformed(ActionEvent e) {
		pathLabel.setText("");
	}

	private void addConhecimentoPerfeitoActionPerformed(ActionEvent e) {
		ConhecimentoPerfeito cp = new ConhecimentoPerfeito();
		cp.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Octavio Maia
		label1 = new JLabel();
		pathLabel = new JTextField();
		buttonCarregar = new JButton();
		buttonProcurar = new JButton();
		buttonApagar = new JButton();
		separator1 = new JSeparator();
		addConhecimentoPerfeito = new JButton();
		label2 = new JLabel();
		addConhecimentoImpreciso = new JButton();
		addConhecimentoIncerto = new JButton();
		addConhecimentoInterdito = new JButton();
		fileChooser1 = new JFileChooser();

		//======== this ========
		setTitle("Leitura");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Path do ficheiro");
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(label1);
		label1.setBounds(10, 25, 130, 25);

		//---- pathLabel ----
		pathLabel.setEditable(false);
		contentPane.add(pathLabel);
		pathLabel.setBounds(155, 25, 400, 25);

		//---- buttonCarregar ----
		buttonCarregar.setText("Carregar ficheiro");
		buttonCarregar.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonCarregar.addActionListener(e -> buttonCarregarActionPerformed(e));
		contentPane.add(buttonCarregar);
		buttonCarregar.setBounds(155, 60, 200, buttonCarregar.getPreferredSize().height);

		//---- buttonProcurar ----
		buttonProcurar.setText("Procurar");
		buttonProcurar.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonProcurar.addActionListener(e -> buttonProcurarActionPerformed(e));
		contentPane.add(buttonProcurar);
		buttonProcurar.setBounds(570, 25, 90, 25);

		//---- buttonApagar ----
		buttonApagar.setText("Apagar path");
		buttonApagar.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonApagar.addActionListener(e -> buttonApagarActionPerformed(e));
		contentPane.add(buttonApagar);
		buttonApagar.setBounds(370, 60, 185, buttonApagar.getPreferredSize().height);
		contentPane.add(separator1);
		separator1.setBounds(10, 95, 665, 5);

		//---- addConhecimentoPerfeito ----
		addConhecimentoPerfeito.setText("Conhecimento Perfeito (Positivo / Negativo)");
		addConhecimentoPerfeito.setFont(new Font("Arial", Font.PLAIN, 14));
		addConhecimentoPerfeito.setEnabled(false);
		addConhecimentoPerfeito.addActionListener(e -> addConhecimentoPerfeitoActionPerformed(e));
		contentPane.add(addConhecimentoPerfeito);
		addConhecimentoPerfeito.setBounds(10, 135, 640, 25);

		//---- label2 ----
		label2.setText("Evolu\u00e7\u00e3o da base de conhecimento");
		label2.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(label2);
		label2.setBounds(10, 105, 310, 25);

		//---- addConhecimentoImpreciso ----
		addConhecimentoImpreciso.setText("Conhecimento Impreciso");
		addConhecimentoImpreciso.setFont(new Font("Arial", Font.PLAIN, 14));
		addConhecimentoImpreciso.setEnabled(false);
		contentPane.add(addConhecimentoImpreciso);
		addConhecimentoImpreciso.setBounds(200, 170, 205, 25);

		//---- addConhecimentoIncerto ----
		addConhecimentoIncerto.setText("Conhecimento Incerto");
		addConhecimentoIncerto.setFont(new Font("Arial", Font.PLAIN, 14));
		addConhecimentoIncerto.setEnabled(false);
		contentPane.add(addConhecimentoIncerto);
		addConhecimentoIncerto.setBounds(10, 170, 177, 25);

		//---- addConhecimentoInterdito ----
		addConhecimentoInterdito.setText("Conhecimento Interdito");
		addConhecimentoInterdito.setFont(new Font("Arial", Font.PLAIN, 14));
		addConhecimentoInterdito.setEnabled(false);
		contentPane.add(addConhecimentoInterdito);
		addConhecimentoInterdito.setBounds(430, 170, 220, addConhecimentoInterdito.getPreferredSize().height);

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
		setSize(700, 420);
		setLocationRelativeTo(null);

		//---- fileChooser1 ----
		fileChooser1.setFont(new Font("Arial", Font.PLAIN, 11));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Octavio Maia
	private JLabel label1;
	private JTextField pathLabel;
	private JButton buttonCarregar;
	private JButton buttonProcurar;
	private JButton buttonApagar;
	private JSeparator separator1;
	private JButton addConhecimentoPerfeito;
	private JLabel label2;
	private JButton addConhecimentoImpreciso;
	private JButton addConhecimentoIncerto;
	private JButton addConhecimentoInterdito;
	private JFileChooser fileChooser1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
