package space;

public class Moon implements AstronomicalBody {
	private double distanceFromPlanet;
	private double angle;
	private Planet planet;
	private int[] orbitPos;
	private String name;

	/**Creates a moon to orbit another planet
	 * 
	 * @param distanceFromPlanet
	 * @param planet
	 * @param name
	 */
	public Moon(double distanceFromPlanet, Planet planet, String name) {
		this.distanceFromPlanet = distanceFromPlanet; 
		this.planet = planet;
		this.name = name;
	}
	
	/**
	 * @see AstronomicalBody.orbit()
	 */
	@Override
	public void orbit(){
		double delta = (1/this.distanceFromPlanet)*(Math.sqrt(1/this.distanceFromPlanet)); //change of angle at each step
		this.angle+=delta;
		//calculate new position of moon by using planet's position and then finding where the moon should be relative to that
		int x = (int) ((this.distanceFromPlanet*Math.cos(this.angle)) + this.planet.getOrbitPos()[0]);
		int y = (int) ((this.distanceFromPlanet*Math.sin(this.angle)) + this.planet.getOrbitPos()[1]);
		int[] pos = {x,y};
		this.orbitPos = pos;
	}
	
	/**
	 * @see AstronomicalBody.getAngle()
	 */
	@Override
	public double getAngle(){
		return this.angle;
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
	public String getName(){
		return this.name;
	}
	

}
