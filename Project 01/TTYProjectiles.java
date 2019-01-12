package ttyProjectiles;
/*
 * Name: Zhaozhou Lyu
 * NetID: zlyu2
 * Assignment number: Project01
 * Lab: TR6:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 */
/**
 * This program is a TTY Projectile game in which the user can input 
 * the speed and angle of the projectile. The program will examine if the projectile can cross the wall.
 * @author georgelyu
 *
 */
import java.util.Scanner;
import java.util.Random;
public class TTYProjectiles {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);

		int distance, height;
		double flyDistance;
		int score=0; 
		Random randomGenerator=new Random();
		
		//Generate random height and distance of the wall
		distance=1+randomGenerator.nextInt(49);
		height=1+randomGenerator.nextInt(29);
		
		//Beginning Page and Instruction for the User
		System.out.println(">>>>>>>>>>Hi! Welcome to the TTY Projectile Game!<<<<<<<<<<\n\n\n\n");
		System.out.println("The Game is About to Begin! But Please Read the Instruction First!\n\n\n\n");
		System.out.println(">>>>>>>>>>Instruction! Please Read Them Carefully!<<<<<<<<<<");
		System.out.println("1. In this program, you have a projectile we create for you. What you need to do is try to shot the projectile cross the wall.");
		System.out.println("2. The program will show you the distance and height of the wall in front of you.");
		System.out.println("3. Try and Estimate the speed and angle of your projectiles!");
		System.out.println("4. Your Beginning Score is 0. Each launch will cost you 1 credit. The net score will be shown after each ground :) Scroll Down and Begin!!\n\n\n");


		//The outer loop to count the number of rounds
		for(int round=1;round>=0;round++) {
			
			System.out.println(">>>>>>The Round "+round+"<<<<<<");
			System.out.println("The distance between you and the wall is: "+distance+" meters");
			System.out.println("The height of the wall is: "+height+" meters");
			
			//User input part for the angle and speed of the projectile
			System.out.print("Please enter the angle (in Degree) of the projectile:");
			double angle=scan.nextDouble();
		    angle=Math.toRadians(angle);
			System.out.print("Please enter the speed (in meters/second) of the projectile:");
			double speed=scan.nextDouble();
			System.out.println("");
			
			//Score after each launch
			System.out.println("LAUNCH!!");
			score--;
			System.out.println("Your score now is (after launch \"-1\"): "+score);
			System.out.println("");
			
			//Calculate the flying distance of the projectile
			flyDistance=distance*Math.tan(angle)-((9.8*distance*distance))/(2*(speed*Math.cos(angle))*(speed*Math.cos(angle)));
			double difference=flyDistance-height;

			//Conditional statement to check the distance between the ball and the wall. Score for the player.
			if(flyDistance<height) {
				if(difference>=-10&&difference<0) {
					
					//I use the random number to make the computer generate responses randomly
					int r1= 1+ randomGenerator.nextInt(2);
					if(r1==1) {System.out.println("Hey bro, you are so close to it. Try it again!");}
					if(r1==2) {System.out.println("Oops! Not Quiet Over!");}
					if(r1==3) {System.out.println("Just a miss! I'm sure you can make it closer, bro!");}
					
				}
				else {
					score-=2;
					int r2=1+randomGenerator.nextInt(2);
					if(r2==1) {System.out.println("Oh man, you miss a lot... You do not cross the wall. Why not try again!");}
					if(r2==2) {System.out.println("So far away from crossing the wall. It's not a good shoot.");}
					if(r2==3) {System.out.println("emmm.. Not even close to get cross the wall. Maybe try to adjust the angle and speed of the projectile");}
				
					}	
			}
			
           if(flyDistance>height) {
        	   if(difference>8) {
        		   score+=3;
				   int r3=1+randomGenerator.nextInt(2);
				   if(r3==1) {System.out.println("Plenty of Room. Adjust a little bit. You can make it! But, you do get 3 points.");}
				   if(r3==2) {System.out.println("It's so far away from the wall... But You Cross the Wall. The good news is that you get 3 points");}
				   if(r3==3) {System.out.println("A nice shot and you cross the wall but you need to adjust a little bit. Anyway, you get 3 points!");}

        	   }
        	   
        	   else {
        		   score+=5;
        		   int r4=1+randomGenerator.nextInt(2);
        		   if(r4==1) {System.out.println("Congratulations! You Made It! 5 points are in your pocket.");}
        		   if(r4==2) {System.out.println("You are so good at playing this game!! You got 5 points!!");}
        		   if(r4==3) {System.out.println("Wow! Unbelieveable! You made it! You got 5 points!");}
        		   
        			   
        		   
        		   
        	   }
           }
           
           //Just make sure someone accidently crush the edge of the wall
           if(flyDistance==height) {
        	   score+=11;
        	   System.out.println("This is incredible. Even \"I\" cannot do this");
           }
           
           //Show the distance between ball and wall
           System.out.println("\"Hint: The distance difference between the ball and the wall for your previous round is: "+difference+" meters\"");
           System.out.println("(\"-\" means your projectile is below the wall; \"No sign\" means your projectile is above the wall)\n");
           
           //Score at the end of each round
           System.out.println("The score of round "+round+ " now"+" is: "+score);

           //User input for start or end each round
           System.out.println("Now, you can choose to give up this round (start another round) or to stop playing this game :(");
           System.out.println("(Enter \"again + Enter\" to skip this round (start another round) or enter \"quit + Enter\" to stop playing this game)");
           System.out.println("");
           System.out.print("Your choice is: ");
       
           String a=scan.next();
           
           //User can choose continue or stop the game
           if(a.equals("again")) {
        	   continue;
           }
           else if(a.equals("quit")){
        	   System.out.println("The Game Ends. Thanks for your participation. \nYour final score is: "+score);

        	   break;  
           }

		}
		
		
	}

}
