package it.unibo.oop.lab09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Example class loading an image with {@link Class#getResource(String)}.
 * 
 * @author Danilo Pianini
 *
 */
public final class UseGetResource {
	
	private UseGetResource() {
	}

	/**
	 * @param args Ignored
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException {
		final URL imgURL = UseGetResource.class.getResource("/images/gandalf.jpg");
		
		final ImageIcon icon = new ImageIcon(imgURL);
		final InputStream in = UseGetResource.class.getResourceAsStream("/settings/settings");
		final BufferedReader br = new BufferedReader(new InputStreamReader(in));
		final String line = br.readLine();
		in.close();
		final JLabel lab1 = new JLabel(icon);
		final JLabel lab2 = new JLabel(line);
		
		final JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		pan.add(lab1);
		pan.add(lab2);
		
		final JFrame f = new JFrame("Image loader");
		f.getContentPane().add(pan);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationByPlatform(true);
		f.setVisible(true);
	}

}
