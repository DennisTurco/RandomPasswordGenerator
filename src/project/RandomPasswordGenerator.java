package project;
import java.awt.*;
import javax.swing.*;
import java.util.Random; //per il random number generator

class RandomPasswordGenerator extends JFrame{
	
	private JLabel textComment;
	private JLabel textPassword;
	private JCheckBox spunta1, spunta2, spunta3, spunta4;
	private JSlider slider;
	
	public RandomPasswordGenerator() {
		setTitle("Random Password Generator");
		setSize(550, 600);
		setLocation(700, 250);
		setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().setBackground(new Color(18, 15, 37)); //setta il colore dello sfondo
		
		
		//creazione oggetto actionlistener
		RandomPasswordGeneratorListener g = new RandomPasswordGeneratorListener(this);
		
		
		//ELEMENTI CENTRALI
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(10, 0, 0, 7));
		pan1.setBackground(new Color(18, 15, 37));
		this.add(pan1, BorderLayout.CENTER);	;
		
		
		//BORDI LATERALI
		JPanel panEast = new JPanel();
		panEast.setLayout(new FlowLayout(1, 50, 50));
		panEast.setBackground(new Color(18, 15, 37));
		this.add(panEast, BorderLayout.EAST);
		
		JPanel panWest = new JPanel();
		panWest.setLayout(new FlowLayout(1, 50, 50));
		panWest.setBackground(new Color(18, 15, 37));
		this.add(panWest, BorderLayout.WEST);
		
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout(1, 20, 20));
		panNorth.setBackground(new Color(18, 15, 37));
		this.add(panNorth, BorderLayout.NORTH);
		
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		panSouth.setBackground(new Color(10, 10, 30));
		this.add(panSouth, BorderLayout.SOUTH);
		
		
		JLabel author = new JLabel("Authors: © DennisTurco & Adrian Tunea");
		author.setFont(new Font("Arial", Font.BOLD, 15));
		author.setForeground(new Color(163, 24, 21));
		author.setHorizontalTextPosition(0);
		panNorth.add(author);
		
		//spunta 1
		spunta1 = new JCheckBox(" Lettere Maiuscole", false); 	//creazione oggetto di tipo JCheckBox
		spunta1.setFont(new Font("Comic Sans ms", Font.BOLD, 17));	//modifica il font
		spunta1.setForeground(Color.GREEN);  						//modifica colore scritta
		spunta1.setBackground(new Color(18, 15, 37));				//modifica colore sfondo
		pan1.add(spunta1);
		
		//spunta 2
		spunta4 = new JCheckBox(" Lettere Minuscole", false);
		spunta4.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta4.setForeground(Color.GREEN); 						
		spunta4.setBackground(new Color(18, 15, 37));
		pan1.add(spunta4);
		
		//spunta 3
		spunta2 = new JCheckBox(" Lettere Speciali", false);
		spunta2.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta2.setForeground(Color.GREEN); 						
		spunta2.setBackground(new Color(18, 15, 37));
		pan1.add(spunta2);
		
		//spunta 4
		spunta3 = new JCheckBox(" Numeri", false);
		spunta3.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta3.setForeground(Color.GREEN); 						
		spunta3.setBackground(new Color(18, 15, 37));
		pan1.add(spunta3);
		
		
		JLabel text1 = new JLabel("Quantità Caratteri: ", JLabel.CENTER);
		text1.setFont(new Font("Arial", Font.BOLD, 20));
		text1.setForeground(Color.GREEN);
		pan1.add(text1);
		
		
		slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true); 
		slider.setBackground(new Color(18, 15, 37));
		slider.setForeground(Color.WHITE);
		pan1.add(slider);
		
		
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnGenerate.setSize(2, 0);
		pan1.add(btnGenerate);
		btnGenerate.addActionListener(g);
		
		
		textPassword = new JLabel("Password Generata", JLabel.CENTER);
		textPassword.setFont(new Font("Arial", Font.BOLD, 20));
		textPassword.setForeground(Color.GREEN);
		pan1.add(textPassword);
		
		
		textComment = new JLabel("Comment", JLabel.CENTER);
		textComment.setFont(new Font("Arial", Font.BOLD, 10));
		textComment.setForeground(Color.GREEN);
		pan1.add(textComment);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnClear.setSize(40, 30);
		panSouth.add(btnClear);
		btnClear.addActionListener(g);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnExit.setSize(40, 30);
		panSouth.add(btnExit);
		btnExit.addActionListener(g);
		
	}
	
	
	void Clear() {
		System.out.println("Event ----> Clear");
		spunta1.setSelected(false);
		spunta2.setSelected(false);
		spunta3.setSelected(false);
		spunta4.setSelected(false);
		slider.setValue(10);
		textPassword.setText("");
		textComment.setText("");
		return;
	}
	
	public void Exit() {
		System.out.println("Event ----> Exit");
		System.exit(EXIT_ON_CLOSE);
		return;
	}
	
	public void Generate() {
		return;
	}


	
}
