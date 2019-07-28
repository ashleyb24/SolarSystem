package space;

/**Creates a planet object to be displayed in animation*/
public class Planet implements AstronomicalBody {
	
	private double distance;
	private double angle=0;
	private int[] orbitPos;
	private String name;
	
	/**Creates a planet object to be displayed in animation
	 * 
	 * @param distance - Distance from sun
	 * @param name - Name of planet
	 */
	public Planet(double distance, String name){
		this.distance = distance;
		this.name = name;
	}
	
	/**
	 * @see AstronomicalBody.getAngle()
	 */
	@Override
	public double getAngle(){
		return angle;
	}
	
	/**
	 * @see AstronomicalBody.orbit()
	 */
	@Override
	public void orbit(){
		double delta = (1/this.distance)*(Math.sqrt(1/this.distance)); //change of angle at each step
		this.angle+=delta;
		//calculate new position relative to sun
		int x = (int) (this.distance*Math.cos(this.angle));
		int y = (int) (this.distance*Math.sin(this.angle));
		int[] pos = {x,y};
		this.orbitPos = pos;
	}
	
	/**
	 * @see AstronomicalBody.getOrbitPos()
	 */
	@Override
	public int[] getOrbitPos(){
		return this.orbitPos;
	}

	/**
	 * @see AstronomicalBody.getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

}
