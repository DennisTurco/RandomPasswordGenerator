package project;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.Random; //per il random number generator

@SuppressWarnings("serial")
class RandomPasswordGenerator extends JFrame{
	private JLabel textComment;
	private JTextField textPassword;
	private JCheckBox spunta1, spunta2, spunta3, spunta4;
	private JSlider slider;
	private JButton btnCopy, btnGenerate, btnSave;
	
	public RandomPasswordGenerator() {
		setTitle("Random Password Generator");
		setSize(550, 600);
		setLocation(700, 250);
		setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().setBackground(new Color(18, 15, 37)); //setta il colore dello sfondo
		
		ImageIcon image = new ImageIcon(".//res//logo.png"); //crea un'icona
		setIconImage(image.getImage());	//cambia l'icona del frame
		
		//creazione oggetto actionlistener
		RandomPasswordGeneratorListener g = new RandomPasswordGeneratorListener(this);
		
		
		//ELEMENTI CENTRALI
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(10, 0, 0, 7));
		pan1.setBackground(new Color(18, 15, 37));
		this.add(pan1, BorderLayout.CENTER);	
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout(1, 10, 0));
		pan2.setBackground(new Color(18, 15, 37));
		
		JPanel pan3 = new JPanel();
		pan2.setLayout(new GridLayout());
		pan2.setBackground(new Color(18, 15, 37));

		
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
		spunta1 = new JCheckBox(" Lowercase letters", false); 	//creazione oggetto di tipo JCheckBox
		spunta1.setFont(new Font("Comic Sans ms", Font.BOLD, 17));	//modifica il font
		spunta1.setForeground(Color.GREEN);  						//modifica colore scritta
		spunta1.setBackground(new Color(18, 15, 37));				//modifica colore sfondo
		pan1.add(spunta1);
		
		//spunta 2
		spunta2 = new JCheckBox(" Uppercase letters", false);
		spunta2.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta2.setForeground(Color.GREEN); 						
		spunta2.setBackground(new Color(18, 15, 37));
		pan1.add(spunta2);
		
		//spunta 3
		spunta3 = new JCheckBox(" Special letters", false);
		spunta3.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta3.setForeground(Color.GREEN); 						
		spunta3.setBackground(new Color(18, 15, 37));
		pan1.add(spunta3);
		
		//spunta 4
		spunta4 = new JCheckBox(" Numbers", false);
		spunta4.setFont(new Font("Comic Sans ms", Font.BOLD, 17));
		spunta4.setForeground(Color.GREEN); 						
		spunta4.setBackground(new Color(18, 15, 37));
		pan1.add(spunta4);
		
		
		JLabel text1 = new JLabel("Quantity of characters: ", JLabel.CENTER);
		text1.setFont(new Font("Arial", Font.BOLD, 20));
		text1.setForeground(Color.GREEN);
		pan1.add(text1);
		
		
		//slider
		slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true); 
		slider.setBackground(new Color(18, 15, 37));
		slider.setForeground(Color.WHITE);
		pan1.add(slider);
		
		//pan3 serve par dare spazio fra gli elementi
		pan1.add(pan3, BorderLayout.CENTER);
		pan3.setBackground(new Color(18, 15, 37));
		
		pan1.add(pan2, BorderLayout.CENTER);
		
		//bottone Generate
		btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnGenerate.setSize(2, 0);
		pan2.add(btnGenerate);
		btnGenerate.addActionListener(g);
		
		//bottone copy
		btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnCopy.setSize(10, 15);
		btnCopy.setEnabled(false);  //inizialmente non c'è nulla da copiare quindi è disattivato
		btnCopy.setToolTipText("Copy the password");
		pan2.add(btnCopy);
		btnCopy.addActionListener(g);
		
		//bottone save
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Comic Sans ms", Font.BOLD, 20));
		btnSave.setSize(20, 15);
		btnSave.setEnabled(false);  //inizialmente non c'è nulla da salvare quindi è disattivato
		btnSave.setToolTipText("Save the password");
		pan2.add(btnSave);
		btnSave.addActionListener(g);
		
				
		//Stringa Password
		textPassword = new JTextField("", JTextField.CENTER);
		textPassword.setFont(new Font("Arial", Font.BOLD, 20));
		textPassword.setForeground(Color.GREEN);
		textPassword.setSize(20, 10);
		textPassword.setVisible(false); //inizilamente non deve essere visibile poichè non generata
		textPassword.setHorizontalAlignment(0);
		textPassword.setBackground(new Color(18, 15, 37));
		pan1.add(textPassword);
		

		//Stringa Commento
		textComment = new JLabel("", JLabel.CENTER);
		textComment.setFont(new Font("Arial", Font.BOLD, 10));
		textComment.setForeground(Color.GREEN);
		textComment.setVisible(false); //inizilamente non deve essere visibile poichè non generata
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
	
		JButton btnHistory = new JButton("Password List");
		btnHistory.setFont(new Font ("Comic Sans ms", Font.BOLD, 20));
		btnHistory.setSize(40, 30);
		panSouth.add(btnHistory);
		btnHistory.addActionListener(g);
		
	}
	
	
	void Clear() {
		System.out.println("Event ----> Clear");
		spunta1.setSelected(false);
		spunta2.setSelected(false);
		spunta3.setSelected(false);
		spunta4.setSelected(false);
		slider.setValue(10);
		textPassword.setText("");
		textPassword.setVisible(false);
		btnCopy.setEnabled(false);
		btnSave.setEnabled(false);
		textComment.setText("");
		textComment.setVisible(false);
		return;
	}
	
	void Exit() {
		System.out.println("Event ----> Exit");
		System.exit(EXIT_ON_CLOSE);
		return;
	}
	
	void PasswordList() throws Exception {
		System.out.println("Event --> Password List");
		
		Runtime runtime = Runtime.getRuntime();
		
		@SuppressWarnings("unused")  //per togliere il warning
		Process process = runtime.exec("notepad.exe res//PasswordList");
	}
	
	void Generate() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("Event ----> Generate");
		
		
		//se tutti i checkbox sono false(non atttivati) allora si termina la funzione 
		if(spunta1.isSelected()==false && spunta2.isSelected()==false && spunta3.isSelected()==false && spunta4.isSelected()==false) {
			textPassword.setText("Error! Argument Missing!");
			textPassword.setForeground(Color.RED);
			textPassword.setVisible(true);
			Comment();
			return;
		}
		
		// -------- Apertura Sound ----------
		File file = new File(".//res//Spin.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
		Random random = new Random();  //oggetto della classe Random
		int value;
		
		String letters = "abcdefghilmnopqrstuvzxykjw";
		String numbers = "1234567890";
		String specialChars = ",._-*?!";
		String password = "";		
		

		//costruzione stringa password
		for(int i=0; i<slider.getValue(); i++) {
			
			value = random.nextInt(4 - 1 + 1) + 1;  //questa funzione ci da un numero randomico compreso tra 1 e 4
			
			if(spunta1.isSelected()==true &&  value == 1) {
				//lettera minuscola
				value = random.nextInt(25 - 0 + 1) + 0;
				password = password + letters.substring(value, value+1);	
			}
			else if(spunta2.isSelected()==true &&  value == 2) {
				//lettera maiuscola
				value = random.nextInt(25 - 0 + 1) + 0;
				password = password + letters.toUpperCase().substring(value, value+1);
			}
			else if(spunta3.isSelected()==true &&  value == 3){
				//carattere speciale
				value = random.nextInt(6 - 0 + 1) + 0;
				password = password + specialChars.substring(value, value+1);
			}
			else if(spunta4.isSelected()==true &&  value == 4) {
				//numero
				value = random.nextInt(9 - 0 + 1) + 0;
				password = password+ numbers.substring(value, value+1);
			}
			
			else {  //a volte capita che non entra in nessun if quindi resetto il ciclo con i--
				i--;
			}
			
		}
		
		//stampa a schermo
		textPassword.setText(password);
		textPassword.setForeground(Color.GREEN);
		textPassword.setVisible(true);
		
		
		//attivazione del tasto copy
		btnCopy.setEnabled(true);
		
		//attivazione del tasto save
		btnSave.setEnabled(true);
		
		//chiamata alla funzione commento
		Comment();
		
		return;
			
		
	}
	
	void Comment() {
		
		String letters = "abcdefghilmnopqrstuvzxykjw";
		String numbers = "1234567890";
		String specialChars = ",._-*?!";
		String password = textPassword.getText();
		int n = 0;
		
		//caso della stringa vuota
		if (textPassword.getText() == "Error! Argument Missing!") {
			textComment.setVisible(true);
			textComment.setForeground(Color.RED);
			textComment.setText("Password Too Short!");
		}
		
		
		//lettere minuscole e maiuscole
		for (int i=0; i<password.length(); i++){
			for (int j=0; j<letters.length(); j++) {
				if ( (password.charAt(i) == letters.charAt(j)) || (password.charAt(i) == letters.toUpperCase().charAt(j)) ) {
					n = n + 3;
				}
			}
		}
		//numeri
		for (int i=0; i<password.length(); i++){
			for (int j=0; j<numbers.length(); j++) {
				if (password.charAt(i) == numbers.charAt(j)) {
					n = n + 8;
				}
			}
		}
		//caratteri speciali
		for (int i=0; i<password.length(); i++){
			for (int j=0; j<specialChars.length(); j++) {
				if (password.charAt(i) == specialChars.charAt(j)) {
					n = n + 10;
				}
			}
		}
		
		if (n == 0) {
			textComment.setVisible(true);
			textComment.setForeground(Color.RED);
			textComment.setText("Password Too Short!");
		}
		if (n > 0 && n < 20) {
			textComment.setVisible(true);
			textComment.setForeground(Color.RED);
			textComment.setText("Password Very Weak!");
		}
		if (n >= 20 && n < 40) {
			textComment.setVisible(true);
			textComment.setForeground(Color.RED);
			textComment.setText("Password Weak!");
		}
		if (n >= 40 && n < 60) {
			textComment.setVisible(true);
			textComment.setForeground(Color.YELLOW);
			textComment.setText("Password Good!");	
		}
		if (n >= 60 && n < 80) {
			textComment.setVisible(true);
			textComment.setForeground(Color.GREEN);
			textComment.setText("Password Strong!");
		}
		if (n >= 80) {
			textComment.setVisible(true);
			textComment.setForeground(Color.GREEN);
			textComment.setText("Password Very Strong!");
		}
	}
		
	
	void Copy(){
		//copia il testo
		StringSelection stringSelection = new StringSelection(textPassword.getText());
		Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
		clpbrd.setContents (stringSelection, null);
		
		//messaggio popup
		JOptionPane.showMessageDialog(null, "Password has been Copied!", "Confermed", 1);
		
	}
	
	void Save() {
		//messaggio popup
		String response;
		response = JOptionPane.showInputDialog("Insert name for the current Password: ");
		
		String response2;
		response2 = JOptionPane.showInputDialog("Insert email associated at the currunt Password: ");
		
		//caso d'errore
		if (response == null || response2 == null) return;
		
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("res//PasswordList", true));  //modalita' append
            System.out.println("Event ----> Save");
            bw.write("\n• " + response + ":\n\tEmail: " + response2 + "\n\tPassword: " + textPassword.getText() + "\n");
            bw.close();
            
        } catch (IOException e) {
            System.out.println("Exception --> " + e);
            return;
        }
		
	}

	
}
