import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Cursor;

public class Start {

	private JFrame frame;
	private JTextField caja1;
	private JLabel etiqueta1;

	private JButton boton1, boton2, boton3, boton4, boton5, boton6,
	boton7, boton8, boton9, boton0, botonSumar, botonRestar,
	botonMulti, botonDiv, botonC, botonIgual, botonPar;

	private String signo = "";
	private String contenidoCaja1 = "";
	private float resultado = 0.0f;
	private float numero1, numero2 = 0.0f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		caja1 = new JTextField();
		caja1.setDisabledTextColor(Color.WHITE);
		caja1.setSelectionColor(Color.DARK_GRAY);
		caja1.setBackground(Color.BLACK);
		caja1.setHorizontalAlignment(SwingConstants.RIGHT);
		caja1.setToolTipText("\r\n");
		caja1.setForeground(Color.BLACK);
		caja1.setFont(new Font("Tahoma", Font.PLAIN, 55));
		caja1.setEnabled(false);
		caja1.setBounds(10, 65, 416, 104);
		frame.getContentPane().add(caja1);
		caja1.setColumns(10);
		
		boton1 = new JButton("1");
		boton1.setForeground(Color.WHITE);
		boton1.setBackground(Color.BLACK);
		boton1.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "1");
				etiqueta1.setText("" + etiqueta1.getText() + "1");
				
			}
		});
		boton1.setBounds(10, 285, 85, 61);
		frame.getContentPane().add(boton1);

		boton2 = new JButton("2");
		boton2.setForeground(Color.WHITE);
		boton2.setBackground(Color.BLACK);
		boton2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "2");
				etiqueta1.setText("" + etiqueta1.getText() + "2");

			}
		});
		boton2.setBounds(105, 285, 85, 61);
		frame.getContentPane().add(boton2);

		boton3 = new JButton("3");
		boton3.setForeground(Color.WHITE);
		boton3.setBackground(Color.BLACK);
		boton3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "3");
				etiqueta1.setText("" + etiqueta1.getText() + "3");

			}
		});
		boton3.setBounds(200, 285, 85, 61);
		frame.getContentPane().add(boton3);

		boton4 = new JButton("4");
		boton4.setForeground(Color.WHITE);
		boton4.setBackground(Color.BLACK);
		boton4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "4");
				etiqueta1.setText("" + etiqueta1.getText() + "4");

			}
		});
		boton4.setBounds(10, 356, 85, 61);
		frame.getContentPane().add(boton4);

		boton5 = new JButton("5");
		boton5.setForeground(Color.WHITE);
		boton5.setBackground(Color.BLACK);
		boton5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "5");
				etiqueta1.setText("" + etiqueta1.getText() + "5");

			}
		});
		boton5.setBounds(105, 356, 85, 61);
		frame.getContentPane().add(boton5);

		boton6 = new JButton("6");
		boton6.setForeground(Color.WHITE);
		boton6.setBackground(Color.BLACK);
		boton6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "6");
				etiqueta1.setText("" + etiqueta1.getText() + "6");

			}
		});
		boton6.setBounds(200, 356, 85, 61);
		frame.getContentPane().add(boton6);

		boton7 = new JButton("7");
		boton7.setForeground(Color.WHITE);
		boton7.setBackground(Color.BLACK);
		boton7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "7");
				etiqueta1.setText("" + etiqueta1.getText() + "7");
				

			}			
		});
		boton7.setBounds(10, 427, 85, 61);
		frame.getContentPane().add(boton7);

		boton8 = new JButton("8");
		boton8.setForeground(Color.WHITE);
		boton8.setBackground(Color.BLACK);
		boton8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "8");
				etiqueta1.setText("" + etiqueta1.getText() + "8");

			}
		});
		boton8.setBounds(105, 427, 85, 61);
		frame.getContentPane().add(boton8);

		boton9 = new JButton("9");
		boton9.setForeground(Color.WHITE);
		boton9.setBackground(Color.BLACK);
		boton9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja1.setText("" + caja1.getText() + "9");
				etiqueta1.setText("" + etiqueta1.getText() + "9");

			}
		});
		boton9.setBounds(200, 427, 85, 61);
		frame.getContentPane().add(boton9);

		boton0 = new JButton("0");
		boton0.setForeground(Color.WHITE);
		boton0.setBackground(Color.BLACK);
		boton0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).equals(boton0)) {
					caja1.setText("" + caja1.getText() + "0");
					etiqueta1.setText("" + etiqueta1.getText() + "0");

				}
			}
		});
		boton0.setBounds(10, 498, 85, 61);
		frame.getContentPane().add(boton0);

		botonSumar = new JButton("+");
		botonSumar.setForeground(Color.WHITE);
		botonSumar.setBackground(Color.DARK_GRAY);
		botonSumar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero1 = Float.parseFloat(contenidoCaja1);
					caja1.setText("");
					etiqueta1.setText(numero1 + "+");
					contenidoCaja1 = "";
					signo = "+";
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}
		});
		botonSumar.setBounds(341, 209, 85, 80);
		frame.getContentPane().add(botonSumar);

		botonRestar = new JButton("-");
		botonRestar.setForeground(Color.WHITE);
		botonRestar.setBackground(Color.DARK_GRAY);
		botonRestar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		botonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero1 = Float.parseFloat(contenidoCaja1);
					caja1.setText("");
					etiqueta1.setText(numero1 + "-");
					contenidoCaja1 = "";
					signo = "-";
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}
		});
		botonRestar.setBounds(341, 299, 85, 80);
		frame.getContentPane().add(botonRestar);

		botonDiv = new JButton("÷");
		botonDiv.setForeground(Color.WHITE);
		botonDiv.setBackground(Color.DARK_GRAY);
		botonDiv.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero1 = Float.parseFloat(contenidoCaja1);
					caja1.setText("");
					etiqueta1.setText(numero1 + "÷");
					contenidoCaja1 = "";
					signo = "÷";
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}
		});
		botonDiv.setBounds(341, 479, 85, 80);
		frame.getContentPane().add(botonDiv);

		botonMulti = new JButton("x");
		botonMulti.setForeground(Color.WHITE);
		botonMulti.setBackground(Color.DARK_GRAY);
		botonMulti.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero1 = Float.parseFloat(contenidoCaja1);
					caja1.setText("");
					etiqueta1.setText(numero1 + "x");
					contenidoCaja1 = "";
					signo = "x";
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}
		});
		botonMulti.setBounds(341, 389, 85, 80);
		frame.getContentPane().add(botonMulti);

		botonIgual = new JButton("=");
		botonIgual.setForeground(Color.WHITE);
		botonIgual.setBackground(Color.BLACK);
		botonIgual.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero2 = Integer.parseInt(contenidoCaja1);

					switch (signo) {

					case "+":
						resultado = numero1 + numero2;
						contenidoCaja1 = Float.toString(resultado);
						caja1.setText(contenidoCaja1);
						etiqueta1.setText(numero1 + "" + "+" + "" + numero2 + "=" + resultado);

						botonSumar.setEnabled(false);
						botonRestar.setEnabled(false);
						botonMulti.setEnabled(false);
						botonDiv.setEnabled(false);
						boton1.setEnabled(false);
						boton2.setEnabled(false);
						boton3.setEnabled(false);
						boton4.setEnabled(false);
						boton5.setEnabled(false);
						boton6.setEnabled(false);
						boton7.setEnabled(false);
						boton8.setEnabled(false);
						boton9.setEnabled(false);
						boton0.setEnabled(false);
						botonPar.setEnabled(false);
						botonIgual.setEnabled(false);
						botonC.setEnabled(true);

						break;

					case "-":

						resultado = numero1 - numero2;
						contenidoCaja1 = Float.toString(resultado);
						caja1.setText(contenidoCaja1);
						etiqueta1.setText(numero1 + "" + "-" + "" + numero2 + "=" + resultado);

						botonSumar.setEnabled(false);
						botonRestar.setEnabled(false);
						botonMulti.setEnabled(false);
						botonDiv.setEnabled(false);
						boton1.setEnabled(false);
						boton2.setEnabled(false);
						boton3.setEnabled(false);
						boton4.setEnabled(false);
						boton5.setEnabled(false);
						boton6.setEnabled(false);
						boton7.setEnabled(false);
						boton8.setEnabled(false);
						boton9.setEnabled(false);
						boton0.setEnabled(false);
						botonPar.setEnabled(false);
						botonIgual.setEnabled(false);
						botonC.setEnabled(true);

						break;

					case "x":
						resultado = numero1 * numero2;
						contenidoCaja1 = Float.toString(resultado);
						caja1.setText(contenidoCaja1);
						etiqueta1.setText(numero1 + "" + "x" + "" + numero2 + "=" + resultado);

						botonSumar.setEnabled(false);
						botonRestar.setEnabled(false);
						botonMulti.setEnabled(false);
						botonDiv.setEnabled(false);
						boton1.setEnabled(false);
						boton2.setEnabled(false);
						boton3.setEnabled(false);
						boton4.setEnabled(false);
						boton5.setEnabled(false);
						boton6.setEnabled(false);
						boton7.setEnabled(false);
						boton8.setEnabled(false);
						boton9.setEnabled(false);
						boton0.setEnabled(false);
						botonPar.setEnabled(false);
						botonIgual.setEnabled(false);
						botonC.setEnabled(true);

						break;

					case "÷":
						if (numero2 != 0) {
							resultado = numero1 / numero2;
							contenidoCaja1 = Float.toString(resultado);
							caja1.setText(contenidoCaja1);
							etiqueta1.setText(numero1 + "" + "÷" + "" + numero2 + "=" + resultado);
							botonSumar.setEnabled(false);
							botonRestar.setEnabled(false);
							botonMulti.setEnabled(false);
							botonDiv.setEnabled(false);
							boton1.setEnabled(false);
							boton2.setEnabled(false);
							boton3.setEnabled(false);
							boton4.setEnabled(false);
							boton5.setEnabled(false);
							boton6.setEnabled(false);
							boton7.setEnabled(false);
							boton8.setEnabled(false);
							boton9.setEnabled(false);
							boton0.setEnabled(false);
							botonPar.setEnabled(false);
							botonIgual.setEnabled(false);
							botonC.setEnabled(true);
							break;
						} else {
							botonSumar.setEnabled(false);
							botonRestar.setEnabled(false);
							botonMulti.setEnabled(false);
							botonDiv.setEnabled(false);
							boton1.setEnabled(false);
							boton2.setEnabled(false);
							boton3.setEnabled(false);
							boton4.setEnabled(false);
							boton5.setEnabled(false);
							boton6.setEnabled(false);
							boton7.setEnabled(false);
							boton8.setEnabled(false);
							boton9.setEnabled(false);
							boton0.setEnabled(false);
							botonPar.setEnabled(false);
							botonIgual.setEnabled(false);
							botonC.setEnabled(true);
							caja1.setText("Indeterminaci�n");

						}
					}
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}

		});
		botonIgual.setBounds(105, 498, 180, 61);
		frame.getContentPane().add(botonIgual);

		botonC = new JButton("C");
		botonC.setToolTipText("\r\n");
		botonC.setForeground(Color.RED);
		botonC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonC.setBackground(Color.DARK_GRAY);
		botonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				contenidoCaja1 = caja1.getText().toString();
				caja1.setText("");
				numero1 = 0;
				numero2 = 0;
				resultado = 0;
				etiqueta1.setText("");
				contenidoCaja1 = "";

				botonSumar.setEnabled(true);
				botonRestar.setEnabled(true);
				botonMulti.setEnabled(true);
				botonDiv.setEnabled(true);
				boton1.setEnabled(true);
				boton2.setEnabled(true);
				boton3.setEnabled(true);
				boton4.setEnabled(true);
				boton5.setEnabled(true);
				boton6.setEnabled(true);
				boton7.setEnabled(true);
				boton8.setEnabled(true);
				boton9.setEnabled(true);
				boton0.setEnabled(true);
				botonPar.setEnabled(true);
				botonIgual.setEnabled(true);
				botonC.setEnabled(true);

			}
		});
		botonC.setBounds(10, 214, 180, 61);
		frame.getContentPane().add(botonC);

		etiqueta1 = new JLabel("");
		etiqueta1.setBackground(Color.BLACK);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		etiqueta1.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqueta1.setBounds(147, 10, 279, 35);
		frame.getContentPane().add(etiqueta1);

		botonPar = new JButton("Par");
		botonPar.setForeground(Color.WHITE);
		botonPar.setBackground(Color.DARK_GRAY);
		botonPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contenidoCaja1 = caja1.getText().toString();
					numero1 = Integer.parseInt(contenidoCaja1);

					if (numero1 % 2 == 0) {
						botonSumar.setEnabled(false);
						botonRestar.setEnabled(false);
						botonMulti.setEnabled(false);
						botonDiv.setEnabled(false);
						boton1.setEnabled(false);
						boton2.setEnabled(false);
						boton3.setEnabled(false);
						boton4.setEnabled(false);
						boton5.setEnabled(false);
						boton6.setEnabled(false);
						boton7.setEnabled(false);
						boton8.setEnabled(false);
						boton9.setEnabled(false);
						boton0.setEnabled(false);
						botonPar.setEnabled(false);
						botonIgual.setEnabled(false);
						botonC.setEnabled(true);
						caja1.setText("Par");
						System.out.println(numero1);
					} else {
						botonSumar.setEnabled(false);
						botonRestar.setEnabled(false);
						botonMulti.setEnabled(false);
						botonDiv.setEnabled(false);
						boton1.setEnabled(false);
						boton2.setEnabled(false);
						boton3.setEnabled(false);
						boton4.setEnabled(false);
						boton5.setEnabled(false);
						boton6.setEnabled(false);
						boton7.setEnabled(false);
						boton8.setEnabled(false);
						boton9.setEnabled(false);
						boton0.setEnabled(false);
						botonPar.setEnabled(false);
						botonIgual.setEnabled(false);
						botonC.setEnabled(true);
						caja1.setText("Impar");
						System.out.println(numero1);
					}
				} catch (Exception error) {
					botonSumar.setEnabled(false);
					botonRestar.setEnabled(false);
					botonMulti.setEnabled(false);
					botonDiv.setEnabled(false);
					boton1.setEnabled(false);
					boton2.setEnabled(false);
					boton3.setEnabled(false);
					boton4.setEnabled(false);
					boton5.setEnabled(false);
					boton6.setEnabled(false);
					boton7.setEnabled(false);
					boton8.setEnabled(false);
					boton9.setEnabled(false);
					boton0.setEnabled(false);
					botonPar.setEnabled(false);
					botonIgual.setEnabled(false);
					botonC.setEnabled(true);
					caja1.setText("Error");
				}
			}
		});
		botonPar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonPar.setBounds(200, 214, 85, 61);
		frame.getContentPane().add(botonPar);

	}
}
