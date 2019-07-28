package space;

public interface AstronomicalBody {
	
	/**Progresses the body along its orbital path. The position [x,y] and the angle of the body relative to the body it is orbiting are updated.
	 * 
	 */
	public void orbit();
	
	/**Gets the x and y position of the body.
	 * 
	 * @return position[x,y]
	 */
	public int[] getOrbitPos();
	
	/**Gets the angle of the body relative to the body it is orbiting.
	 * 
	 * @return angle
	 */
	public double getAngle();
	
	/**Gets the name of body.
	 * 
	 * @return name
	 */
	public String getName();

}
