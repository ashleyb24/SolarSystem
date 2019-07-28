package space;

import java.awt.Color;

/**
 * Class to store details of graphics used to paint planets
 * 
 *
 */
public class GraphicsDetails {
	
	private Color colour;
	private int size;
	
	/**Store details of graphics used to paint planets
	 * 
	 * @param colour - Colour used to paint planet/moon
	 * @param size - Display size of the planet/moon
	 */
	public GraphicsDetails(Color colour, int size){
		this.colour = colour;
		this.size = size;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
