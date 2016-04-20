/*
 * Created by JFormDesigner on Tue Apr 19 17:31:08 BST 2016
 */

package Presentation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import Presentation.teste;

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
		if(pathLabel.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Path nulo!");
		}else{
			teste.load(pathLabel.getText());
		}
	}

	private void buttonApagarActionPerformed(ActionEvent e) {
		pathLabel.setText("");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Octavio Maia
		label1 = new JLabel();
		pathLabel = new JTextField();
		buttonCarregar = new JButton();
		buttonProcurar = new JButton();
		buttonApagar = new JButton();
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
	private JFileChooser fileChooser1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
