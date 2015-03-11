package rps.controller;

import java.util.Scanner;

public class RPSController
{

	private final int ROCK = 1;
	private final int PAPER = 2;
	private final int SCISSORS = 3;
	
	private int userMove;
	private int compMove;
	private int score;
	private String userDid;
	private String compDid;
	
	private Scanner sysIn;
	
	private boolean gaveInput;
	
	public RPSController(){
		gaveInput = false;
		score = 0;
		sysIn = new Scanner(System.in);
		
	}
	public void start()
	{
		System.out.println("Welcome to Rock Paper Scissors! \n Press R for rock, P for Paper, and S for Scissors. \n Begin!");
		processTurn();
	}
	
	public void processTurn(){
		getUserMove();
		if(gaveInput){
		getComputerMove();
		System.out.println("You did: " + userDid);
		System.out.println("The Computer did: " + compDid);
		System.out.println("Score: " + score);
		
		if(compMove == ROCK && userMove == SCISSORS){
			endGame();
			processTurn();
		}
		else if(compMove == PAPER && userMove == ROCK){
			endGame();
			processTurn();
		}
		else if(compMove == SCISSORS && userMove == PAPER){
			endGame();
			processTurn();
		}
		else if(compMove == userMove){
			System.out.println("Tie!");
			processTurn();
		}
		else{
			score++;
			processTurn();
		}
		}
		
		
	}
	
	private int getUserMove(){
		System.out.println("Take your turn!");
		userMove = 0;
		String input = sysIn.nextLine();
		if(input.toLowerCase().startsWith("r")){
			userMove = ROCK;
			userDid = "Rock";
			gaveInput = true;
		}
		else if(input.toLowerCase().startsWith("p")){
			userMove = PAPER;
			userDid = "Paper";
			gaveInput = true;
		}
		else if(input.toLowerCase().startsWith("s")){
			userMove = SCISSORS;
			userDid = "Scissors";
			gaveInput = true;
		}
		else{
			System.out.println("Please enter just r, p, or s!");
			getUserMove();
		}
		
		return userMove;
	}
	
	private int getComputerMove(){
		compMove = (int) Math.random() * 3;
		if(compMove == ROCK){
			compDid = "Rock";
		}
		else if(compMove == PAPER){
			compDid = "Paper";
		}
		else{
			compDid = "Scissors";
		}
		return compMove;	
	}
	
	public void endGame(){
		score = 0;
		System.out.println("You Lose!");
	}
	

}
