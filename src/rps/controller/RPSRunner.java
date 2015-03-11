package rps.controller;


public class RPSRunner 
{
	
	/**
	 * The Runner of the App. Runs the App
	 * @param args
	 */
	
	public static void main(String [] args)
	{
		RPSController appController = new RPSController();
		appController.start();
	}

}
