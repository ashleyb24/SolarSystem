package space;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Animation of the first four planets of the solar system
 * with start, stop and exit buttons.
 */
public class AnimationGuiPanel extends JPanel implements ActionListener {
	private AnimationPanel animPanel; //panel containing animation
	private JButton startButton;
	private JButton stopButton;
	
	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(350,400));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		//create solar system panel
		animPanel = new AnimationPanel(300,300);  
		
		//create and name buttons
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);

		//places buttons neatly 
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		
		//adds solar system and buttons 
		add(animPanel);
		add(buttonPanel);
	}

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) 
			start();
		else if (e.getSource()==stopButton) 
			stop();
	}

	/** Start animation when applet is started */
	public void start() {animPanel.start();}

	/** Stop animation when applet is stopped */
	public void stop() {animPanel.stop();} 
	

	}
