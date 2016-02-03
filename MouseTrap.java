/**
 * @author kurtkrenz
 * 
 * .:: Algorithm Summaries ::.
 * armed()
 * sets the boolean variable isArmed to true.
 * sets the boolean variable isDisabled to false.
 * creates a new MouseTrap object with the updated variables as parameters.
 * returns the newly created MouseTrap object.
 * 
 * sprung()
 * sets the boolean variable isSprung to true.
 * sets the boolean variable isArmed to false.
 * sets the boolean variable isDisabled to false.
 * creates a new MouseTrap object with the updated variables as parameters.
 * returns the newly created MouseTrap object.
 * 
 * disabled()
 * sets the boolean variable isArmed to false.
 * sets the boolean variable isDisabled to true.
 * creates a new MouseTrap object with the updated variables as parameters.
 * returns the newly created MouseTrap object.
 *
 */
public class MouseTrap implements MouseTrapInterface
{
	boolean isArmed;
	boolean isDisabled;
	int numberOfPerishedMice = 0;
	public MouseTrap()
	{
		isDisabled = true;
		numberOfPerishedMice = 0;
	}
	public MouseTrap(boolean isArmed,/* boolean isSprung,*/ boolean isDisabled, int numberOfPerishedMice)
	{
		this.isArmed = isArmed;
//		this.isSprung = isSprung;
		this.isDisabled = isDisabled;
		this.numberOfPerishedMice = numberOfPerishedMice;
	}
	public MouseTrap armed()
	{
		isArmed = true;
		isDisabled = false;

		MouseTrap newMouseTrapIsArmed = new MouseTrap(isArmed,isDisabled,/*isSprung,*/numberOfPerishedMice);
		return newMouseTrapIsArmed;
	}

	public MouseTrap sprung()
	{
		isArmed = false;
		isDisabled = false;
		MouseTrap newMouseTrapIsSprung = new MouseTrap(isArmed,isDisabled,/*isSprung,*/numberOfPerishedMice);
		return newMouseTrapIsSprung;
	}
	public MouseTrap disabled()
	{
		isDisabled = true;
		isArmed = false;
		MouseTrap newMouseTrapIsDisabled = new MouseTrap(isArmed,isDisabled,/*isSprung,*/numberOfPerishedMice);
		return newMouseTrapIsDisabled;
	}
}
