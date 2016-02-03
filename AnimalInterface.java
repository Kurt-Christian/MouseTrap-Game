public interface AnimalInterface
{
	/**
	 * @return
	 * true if the animal is asleep.
	 */
	public boolean isAsleep();
	/**
	 * @return
	 * a two cell array containing the grid location of the object.
	 */
	public Integer[] location();
	/**
	 * @return
	 * the distance the animal can walk in one turn
	 */
	public int walk();
	/**
	 * @return
	 * the distance the animal can run in one turn
	 */
	public int run();
	/**
	 * puts the animal in a has eaten state and then calls sleep
	 * to put the animal to sleep for a number of periods.
	 */
	public void eat();
	/**
	 * @param sleepPeriod
	 * accepts the number of periods the animal will sleep
	 */
	public void sleep(int sleepPeriod);
	/**
	 * @return
	 * the number of units to move the animal
	 */
	public int nextMove();
	/**
	 * This method kills the animal
	 * and sets an instance variable identifying that
	 * the animal is dead
	 */
	public void die();
}
