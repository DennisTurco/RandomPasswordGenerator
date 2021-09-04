package project;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class RandomPasswordGeneratorListener implements ActionListener{
	private RandomPasswordGenerator rp;
	
	public RandomPasswordGeneratorListener() {}
	
	public RandomPasswordGeneratorListener(RandomPasswordGenerator v) {
		this.rp = v;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("Clear")) {
			rp.Clear(); //chiamata funzione
		}
		else if(b.getText().equals("Generate")) {
			rp.Generate(); //chiamata funzione
		}
		else {
			rp.Exit(); //chiamata funzione
		}
	}
}
