package project;
import java.awt.*;
import javax.swing.*;

import java.util.Random; //per il random number generator

class RandomPasswordGenerator extends JFrame{
	
	public RandomPasswordGenerator() {
		setTitle("Random Password Generator");
		setSize(500, 400);
		setLocation(700, 300);
		setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().setBackground(new Color(123, 50, 250)); //setta il colore dello sfondo
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(7, 0, 0, 5));
		pan1.setBackground(new Color(123, 50, 250));
		this.add(pan1, BorderLayout.CENTER);
		
		
		JCheckBox spunta1 = new JCheckBox(" Lettere Maiuscole"); 	//creazione oggetto di tipo JCheckBox
		spunta1.setFont(new Font("Comic Sans ms", Font.BOLD, 17));	//modifica il font
		spunta1.setForeground(Color.WHITE);  						//modifica colore scritta
		spunta1.setBackground(new Color(123, 50, 250));				//modifica colore sfondo
		pan1.add(spunta1);
		
		JCheckBox spunta4 = new JCheckBox(" Lettere Minuscole");
		spunta4.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta4.setForeground(Color.WHITE); 						
		spunta4.setBackground(new Color(123, 50, 250));
		pan1.add(spunta4);
		
		JCheckBox spunta2 = new JCheckBox(" Lettere Speciali");
		spunta2.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta2.setForeground(Color.WHITE); 						
		spunta2.setBackground(new Color(123, 50, 250));
		pan1.add(spunta2);
		
		JCheckBox spunta3 = new JCheckBox(" Numeri");
		spunta3.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta3.setForeground(Color.WHITE); 						
		spunta3.setBackground(new Color(123, 50, 250));
		pan1.add(spunta3);
		
		
		JLabel text1 = new JLabel("Quantità Caratteri: ", JLabel.CENTER);
		text1.setFont(new Font("Arial", Font.BOLD, 20));
		text1.setForeground(Color.WHITE);
		pan1.add(text1);
		
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
		slider.setBackground(new Color(123, 50, 250));
		pan1.add(slider);
		
	}
}
