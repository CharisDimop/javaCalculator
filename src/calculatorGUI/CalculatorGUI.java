package calculatorGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaCalculator.Calculator;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;

public class CalculatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField textDisplay;
	private JPanel panel_1;
	private JButton btn5;
	private JButton btn9;
	private JButton btn8;
	private JButton btnDivide;
	private JButton btnMultiply;
	private JButton btnAdd;
	private JButton btn6;
	private JButton btn4;
	private JButton btn1;
	private JButton btnSubtract;
	private JButton btn3;
	private JButton btnSquared;
	private JButton btnSqrt;
	private JButton btn0;
	private JButton btn7;
	private JButton btn2;
	private JButton btnComma;
	private JButton btnEquals;
	
	// i 'll add new variables i ll need for the operation methods
	
	private double num1;
	private double num2;
	private String operator = "";
	private boolean isNewNumber = true; // it will track if we should start a new number input or append digits
										// it helps also to reset the display
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
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
	public CalculatorGUI() {
		setTitle("Calculator by CHARILAOS_DIMOPOULOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 701);
		
		
		// i ll change the icon of my calculator
		try {	       
	        Image icon = new ImageIcon(getClass().getResource("/calculatorGUI/icons/calculator_icon_2.png")).getImage();
	        this.setIconImage(icon); // 'this' refers to the JFrame itself
	    } catch (Exception e) {
	        // This block will catch an error if the image can't be found or loaded.
	        System.err.println("Error loading icon: " + e.getMessage());
	        // e.printStackTrace(); // Uncomment this line temporarily for more detailed error info if needed
	    }
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textDisplay = new JTextField();
		textDisplay.setBackground(new Color(202, 252, 177));
		textDisplay.setPreferredSize(new Dimension(0, 180));
		textDisplay.setEditable(false);
		textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisplay.setText("0");
		textDisplay.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel.add(textDisplay, BorderLayout.NORTH);
		textDisplay.setColumns(10);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 4, 0, 0));
		
		JButton btnClear = new JButton("C");
		btnClear.setBackground(Color.RED);
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText("0");
				num1 = 0;
				operator = "";
				isNewNumber = true;
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btnClear);
		
		btnDivide = new JButton("/");
		btnDivide.setBackground(Color.LIGHT_GRAY);
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDisplay.getText().isEmpty()) { //so it can't be used on an empty display
				    num1 = Double.parseDouble(textDisplay.getText());
				    operator = "/"; 
				    isNewNumber = true; // Prepare for the next number to be typed
				}
			}
		});
		panel_1.add(btnDivide);
		
		btnMultiply = new JButton("*");
		btnMultiply.setBackground(Color.LIGHT_GRAY);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDisplay.getText().isEmpty()) {
				    num1 = Double.parseDouble(textDisplay.getText());
				    operator = "*"; 
				    isNewNumber = true; // Prepare for the next number to be typed
				}
			}
		});
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btnMultiply);
		
		btnSubtract = new JButton("-");
		btnSubtract.setBackground(Color.LIGHT_GRAY);
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If a new number is expected (at the start, or after an operator)
				if (isNewNumber) {
				    // Instead of setting an operator, we'll start a negative number.
				    textDisplay.setText("-");
				    isNewNumber = false; // Allow digits to be appended to the "-"
				} else {
				    // Otherwise, treat it as a standard subtraction operation.
				    // Make sure the display isn't empty or just a "-".
				    String currentText = textDisplay.getText();
				    if (!currentText.isEmpty() && !currentText.equals("-")) {
				        num1 = Double.parseDouble(currentText);
				        operator = "-";
				        isNewNumber = true; // Prepare for the next number to be typed
				    }
				}
			}
		});
		btnSubtract.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_1.add(btnSubtract);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("7");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "7");
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("8");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "8");
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("9");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "9");
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn9);
		
		btnAdd = new JButton("+");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDisplay.getText().isEmpty()) {
				    num1 = Double.parseDouble(textDisplay.getText());
				    operator = "+"; 
				    isNewNumber = true; // Prepare for the next number to be typed
				}
			}
		});
		panel_1.add(btnAdd);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("4");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "4");
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("5");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "5");
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("6");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "6");
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn6);
		
		btnSquared = new JButton("x^2");
		btnSquared.setBackground(Color.LIGHT_GRAY);
		btnSquared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDisplay.getText().isEmpty()) {
				    double number = Double.parseDouble(textDisplay.getText());
				    double result = Calculator.squared(number); // Call your logic class
				    textDisplay.setText(String.valueOf(result));
				    isNewNumber = true;
				}
			}
		});
		btnSquared.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btnSquared);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("1");
				    isNewNumber = false; // we started a new number
				} else {
				    textDisplay.setText(currentText + "1");
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("2");
				    isNewNumber = false; // we started a new number
				} else {
				    textDisplay.setText(currentText + "2");
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = textDisplay.getText();
				if (isNewNumber) {
				    textDisplay.setText("3");
				    isNewNumber = false; // We started a new number
				} else {
				    textDisplay.setText(currentText + "3");
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn3);
		
		btnSqrt = new JButton("sqrt");
		btnSqrt.setBackground(Color.LIGHT_GRAY);
		btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDisplay.getText().isEmpty()) {
				    double number = Double.parseDouble(textDisplay.getText());
				    if (number >= 0) {
				        double result = Calculator.squareRoot(number);
				        textDisplay.setText(String.valueOf(result));
				    } else {
				        textDisplay.setText("Error"); // Handle negative root
				    }
				    isNewNumber = true;
				}
				
			}
		});
		panel_1.add(btnSqrt);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the current text from the display.
				String currentText = textDisplay.getText();

				// If the display is NOT just "0" OR if it's a new number entry,
				// then we can add a zero. I want to prevent "00" from appearing.
				if (!currentText.equals("0") || isNewNumber) {
				    if (isNewNumber) {
				        textDisplay.setText("0");
				        isNewNumber = false;
				    } else {
				        textDisplay.setText(currentText + "0");
				    }
				}
				// If the text is already "0" and it's not a new number, do nothing.
				

			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btn0);
		
		btnComma = new JButton(",");
		btnComma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNewNumber) {
				    textDisplay.setText("0."); // Start with "0." if it's a new number
				    isNewNumber = false;
				} else {
				    // Only add a comma if one doesn't already exist
				    if (!textDisplay.getText().contains(".")) {
				        textDisplay.setText(textDisplay.getText() + ".");
				    }
				}
			}
		});
		btnComma.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(btnComma);
		
		btnEquals = new JButton("=");
		btnEquals.setBackground(Color.ORANGE);
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator.isEmpty() || isNewNumber) {
				    // Do nothing if no operator was chosen or if we just chose one
				    return;
				}

				double num2 = Double.parseDouble(textDisplay.getText());
				double result = 0;

				switch (operator) {
				    case "+":
				        result = Calculator.add(num1, num2);
				        break;
				    case "-":
				        result = Calculator.subtract(num1, num2);
				        break;
				    case "*":
				        result = Calculator.multiply(num1, num2);
				        break;
				    case "/":
				        if (num2 != 0) {
				            result = Calculator.divide(num1, num2);
				        } else {
				            textDisplay.setText("Error");
				            operator = "";
				            isNewNumber = true;
				            return; // Exit
				        }
				        break;
				}

				// i formated the result nicely to avoid ".0" for whole numbers
				if (result == (long) result) {
				    textDisplay.setText(String.format("%d", (long) result));
				} else {
				    textDisplay.setText(String.format("%s", result));
				}

				operator = ""; // Reset operator
				isNewNumber = true; // Prepare for a new calculation
			}
		});
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_1.add(btnEquals);

	}

}
