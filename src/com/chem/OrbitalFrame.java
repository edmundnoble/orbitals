
package com.chem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class OrbitalFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3556822534382670667L;

	/**
	 * Launch the application.
	 */
	private static final HashMap<String, Integer> periodicTable =
			new HashMap<String, Integer>();

	private static void initPeriodicTable() { // periodic table mapping
		periodicTable.put("H", 1);
		periodicTable.put("He", 2);
		periodicTable.put("Li", 3);
		periodicTable.put("Be", 4);
		periodicTable.put("B", 5);
		periodicTable.put("C", 6);
		periodicTable.put("N", 7);
		periodicTable.put("O", 8);
		periodicTable.put("F", 9);
		periodicTable.put("Ne", 10);
		periodicTable.put("Na", 11);
		periodicTable.put("Mg", 12);
		periodicTable.put("Al", 13);
		periodicTable.put("Si", 14);
		periodicTable.put("P", 15);
		periodicTable.put("S", 16);
		periodicTable.put("Cl", 17);
		periodicTable.put("Ar", 18);
		periodicTable.put("K", 19);
		periodicTable.put("Ca", 20);
		periodicTable.put("Sc", 21);
		periodicTable.put("Ti", 22);
		periodicTable.put("V", 23);
		periodicTable.put("Cr", 24);
		periodicTable.put("Mn", 25);
		periodicTable.put("Fe", 26);
		periodicTable.put("Co", 27);
		periodicTable.put("Ni", 28);
		periodicTable.put("Cu", 29);
		periodicTable.put("Zn", 30);
		periodicTable.put("Ga", 31);
		periodicTable.put("Ge", 32);
		periodicTable.put("As", 33);
		periodicTable.put("Se", 34);
		periodicTable.put("Br", 35);
		periodicTable.put("Kr", 36);
		periodicTable.put("Rb", 37);
		periodicTable.put("Sr", 38);
		periodicTable.put("Y", 39);
		periodicTable.put("Zr", 40);
		periodicTable.put("Nb", 41);
		periodicTable.put("Mo", 42);
		periodicTable.put("Tc", 43);
		periodicTable.put("Ru", 44);
		periodicTable.put("Rh", 45);
		periodicTable.put("Pd", 46);
		periodicTable.put("Ag", 47);
		periodicTable.put("Cd", 48);
		periodicTable.put("In", 49);
		periodicTable.put("Sn", 50);
		periodicTable.put("Sb", 51);
		periodicTable.put("Te", 52);
		periodicTable.put("I", 53);
		periodicTable.put("Xe", 54);
		periodicTable.put("Cs", 55);
		periodicTable.put("Ba", 56);
	}

	public static void main(String[] args) {
		initPeriodicTable();
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					OrbitalFrame frame = new OrbitalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;

	private JTextField textField;

	private JTextPane textPane;

	/**
	 * Create the frame.
	 */
	public OrbitalFrame() {
		setResizable(false);
		setTitle("Orbitals");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblElementNamenumber = new JLabel("Element symbol/number:");
		lblElementNamenumber.setBounds(94, 77, 165, 23);
		contentPane.add(lblElementNamenumber);

		textField = new JTextField();
		textField.setBounds(294, 78, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setEditable(false);
		textPane.setBounds(70, 123, 353, 34);
		contentPane.add(textPane);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				calculateOrbitals();
			}
		});
		btnNewButton.setBounds(131, 178, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(261, 178, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblElectronConfigurationCalculator =
				new JLabel("Electron Configuration Calculator");
		lblElectronConfigurationCalculator.setForeground(new Color(30,
				144, 255));
		lblElectronConfigurationCalculator.setFont(new Font("Tahoma",
				Font.BOLD, 18));
		lblElectronConfigurationCalculator.setBounds(90, 11, 301, 46);
		contentPane.add(lblElectronConfigurationCalculator);
	}

	protected void calculateOrbitals() {
		Integer atomicNum;
		try {
			atomicNum = Integer.parseInt(textField.getText());
		} catch (NumberFormatException e) {
			atomicNum = periodicTable.get(textField.getText());
		}
		if (atomicNum == null || atomicNum > 56) {
			JOptionPane.showMessageDialog(null,
					atomicNum == null ? "Invalid element!"
							: "Atomic number too high!");
			return;
		}
		String configuration = "";
		for (int level = 1; atomicNum > 0; level++) {
			int s = 0, p = 0, d = 0, f = 0, g = 0;
			int delta = (Math.min(2, atomicNum));
			s = delta;
			atomicNum -= s;
			if (level >= 6) {
				delta = (Math.min(14, atomicNum));
				f = delta;
				atomicNum -= delta;
			}
			if (level >= 4 || atomicNum <= 0) {
				delta = Math.min(10, atomicNum);
				if (delta == 4 || delta == 9) {
					delta++;
					s--;
				}
				d += delta;
				atomicNum -= delta;
			}
			if ((level >= 2 || atomicNum <= 0)) {
				delta = Math.min(6, atomicNum);
				p += delta;
				atomicNum -= delta;
			}

			configuration += (level + "s" + superscript(s) + "");
			if (f > 0) {
				configuration += ((level - 2) + "f" + superscript(f) + "");
			}
			if (d > 0) {
				configuration += ((level - 1) + "d" + superscript(d) + "");
			}
			if (p > 0) {
				configuration += (level + "p" + superscript(p) + "");
			}

		}

		textPane.setText(configuration);
	}

	private String superscript(int d) {
		String intstr = String.valueOf(d);
		char[] ch = new char[intstr.length()];
		for (int pos = 0; pos < intstr.length(); pos++) {

			switch (Integer.valueOf(intstr.substring(pos, pos + 1))) {
				case 1:
					ch[pos] = '\u00b9';
					break;
				case 2:
				case 3:
					ch[pos] =
							(char) ('\u00b0' + Integer.parseInt((intstr
									.substring(pos, pos + 1))));
					break;
				case 0:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					ch[pos] =
							(char) ('\u2070' + Integer.parseInt(intstr
									.substring(pos, pos + 1)));
					break;
			}
		}

		return new String(ch);
	}
}
