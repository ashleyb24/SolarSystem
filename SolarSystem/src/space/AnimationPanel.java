package space;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.*;

/**
 * Animation of the first four planets of the solar system
 * with start and stop buttons.
 */
public class AnimationPanel extends JPanel implements ActionListener {    
	private final int delay = 15; // delay in ms between steps   

	private Timer animationTimer; // timer controlling frame rate
	private boolean isInitialised = false;
	
	private int size; //size of the sun
	private Planet earth, mars, mercury, venus;
	private Moon moon;
	private GraphicsDetails earthGraphicsDetails, marsGraphicsDetails, mercuryGraphicsDetails, venusGraphicsDetails, moonGraphicsDetails;
	LinkedHashMap<AstronomicalBody, GraphicsDetails> solarBodies;

	/**Create animation window
	 * 
	 * @param width width of the animation window
	 * @param height height of the animation window
	 */
	public AnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));		
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	
	
	/** Paint sun and planets at positions defined by their orbits. */
	protected void paintComponent(Graphics g) {
		//details needed for background
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		this.size = height/10;  //define the size of the sun
		int centre = 0 - (size/2);  //define the centre point of the sun
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		
		//draw sun
		g.setColor(Color.YELLOW);
		g.fillOval(centre, centre, size, size);
		
		//check if planets have already been created
		if(!this.isInitialised)
			initialisePlanets();
		
		//move each planet along in its orbit and paint
		for(AstronomicalBody body : this.solarBodies.keySet()){
			body.orbit();
			setPlanetGraphics(g, this.solarBodies.get(body), body);
		}

		
		//draw clock using lambda expression
		g.setColor(Color.yellow);
		Clock clock = (Planet planet, int daysInYear) -> {
			int days = (int) ((planet.getAngle()*daysInYear)/(2*Math.PI)); //days that have passed based on angle of orbit
			
			if (days > daysInYear){
				return days/daysInYear + " " + planet.getName() +" years have passed";
			}
			else{
				return days + " " + planet.getName() +" days have passed";
			}
		};
		g.drawString(clock.daysPassedMessage(this.earth, 365), -70, 150);
		
	}

	//Create planets and moon and insert into linked hash map so they don't have to be created each frame
	private void initialisePlanets() {
		this.earth = new Planet(3*this.size, "Earth");
		this.earthGraphicsDetails = new GraphicsDetails(Color.BLUE, this.size/3);
		this.moon = new Moon(0.60*this.size, this.earth, "Moon");
		this.moonGraphicsDetails = new GraphicsDetails(Color.GRAY, this.size/4);
		this.mars = new Planet(4.5*this.size, "Mars");
		this.marsGraphicsDetails = new GraphicsDetails(Color.RED, this.size/3);
		this.mercury = new Planet(1.2*this.size, "Mercury");
		this.mercuryGraphicsDetails = new GraphicsDetails(Color.GRAY, this.size/3);
		this.venus = new Planet(2.2*this.size, "Venus");
		this.venusGraphicsDetails = new GraphicsDetails(Color.ORANGE, this.size/3);
		
		//Using LinkedHashMap so planets are printed in the order they are inserted.
		//This is because moons have dependency on the planet they are orbiting
		this.solarBodies = new LinkedHashMap<AstronomicalBody, GraphicsDetails>();
		this.solarBodies.put(this.earth, this.earthGraphicsDetails);
		this.solarBodies.put(this.moon, this.moonGraphicsDetails);
		this.solarBodies.put(this.mars, this.marsGraphicsDetails);
		this.solarBodies.put(this.mercury, this.mercuryGraphicsDetails);
		this.solarBodies.put(this.venus, this.venusGraphicsDetails);
		
		this.isInitialised = true;
	}
	
	//method that paints the planet/moon in the panel
	private void setPlanetGraphics(Graphics g, GraphicsDetails details, AstronomicalBody body){
		g.setColor(details.getColour());
		g.fillOval(body.getOrbitPos()[0], body.getOrbitPos()[1], details.getSize(), details.getSize());
	}


	/**
	 * This is called by the animation Timer object
	 * at regular intervals to repaint each planet
	 * in its new position
	 */
	public void actionPerformed(ActionEvent event) {
		repaint();
	}

	/** Start the animation */
	public void start() {animationTimer.start();}

	/** Stop the animation */
	public void stop() {animationTimer.stop();}
	
}

