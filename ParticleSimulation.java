import java.util.Random;
public class ParticleSimulation {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		final double particles = 1000;
		int i = 0;
		int j = 0;
		int forward = 2;
		int forwardCount = 0;
		int upCount = 3;
		int up = 3;
		int downCount = 0;
		int down = 4;
		int backwards = 1;
		int tries = 0;
		int firstMove = 0;
		int movementsOne = 0;
		int movementsTwo = 0;
		int backwardsCount = 1;
		int collisions = 0;
		double particlesEscaped = 0;
		double particlePercent = 0;
		
		for(i = 0; i < particles; i++) {   			// Outside loop that repeats 1000 times b/c there's 1000 particles.
			movementsOne = rand.nextInt(4) + 1;
			upCount = 0;                    
			downCount = 0;
			backwardsCount = 0;            // After each loop it resets these values to zero, so the loop can start over again.
			forwardCount = 0;
			collisions = 0;
			firstMove = 0;
			tries = 0;                       
			
			for(j = 0; j < 1; j++) {       // For the first move, it is always in the first position.
				movementsOne = forward;
				if(movementsOne == forward) {
					forwardCount++;
					backwardsCount++;
				}
			}
			
			while(tries != 1) {
				
				movementsTwo = rand.nextInt (4) + 1;
				
				if(firstMove > 0) {             					 // After the first move it is going to run these conditional if statements.
					if(movementsOne == forward && movementsOne != movementsTwo) {   // If it goes forward then increment forwardCount and backwardsCount.
						forwardCount++;       
						backwardsCount++; 
						collisions++;
					}
				
					else if(movementsOne == forward && movementsOne == movementsTwo) {   // If it is the same number then don't increment collisions.
							forwardCount++;
							backwardsCount++; 
					}
					else if(movementsOne == backwards && movementsOne != movementsTwo) { // If different number then increment collisions.
							forwardCount--;	
							collisions++;
					}
					else if(movementsOne == backwards && movementsOne == movementsTwo) { // If same number then increment backwards and forwards count.
							backwardsCount--;
							forwardCount--;	
					}
					else if(movementsOne == up && movementsOne != movementsTwo) {  // If it is up and different then last movement then,
							upCount++;                                             // increment up and down count.
							downCount++;
					}
					else if(movementsOne == up && movementsOne == movementsTwo) {    // If it is up and same then last movement then,
							upCount++;                                              // increment up and down count and collisions.
							downCount++;
							collisions++;
					}
					else if(movementsOne == down && movementsOne != movementsTwo) { // If it is down and different then last movement then,
							upCount++;                                              // decrement down count and up count,
							downCount--;											// and increment collisions.
							upCount--;
							collisions++;
					}
					else if(movementsOne == down && movementsOne == movementsTwo) {  // If it is down and same then last movement then,
							downCount--;											// decrement only down count and up count.
							upCount--;
					}	
				}
				
					if(movementsTwo == forward && movementsTwo != movementsOne) {	// All the above if statements for movementOne is the same for movementTwo.
						forwardCount++;
						backwardsCount++;
						collisions++;
						firstMove++;
					}
					else if(movementsTwo == forward && movementsTwo == movementsOne) {
							forwardCount++;
							backwardsCount++;
							firstMove++;
					}
					else if(movementsTwo == backwards && movementsTwo != movementsOne) {
							backwardsCount--;
							forwardCount--;
							collisions++;
							firstMove++;	
					}
					else if(movementsTwo == backwards && movementsTwo == movementsOne) {
							backwardsCount--;
							forwardCount--;
							firstMove++;
					}
					else if(movementsTwo == up && movementsTwo != movementsOne) {
							upCount++;
							downCount++;
							collisions++;
							firstMove++;
					}
					else if(movementsTwo == up && movementsTwo == movementsOne) {
							upCount++;
							downCount++;
							firstMove++;
					}
					else if(movementsTwo == down && movementsTwo != movementsOne) {
							downCount--;
							collisions++;
							firstMove++;
							upCount--;
					}	
					else if(movementsTwo == down && movementsTwo == movementsOne) {
							downCount--;
							collisions++;
							upCount--;
							firstMove++;
						
					}
				
					if(collisions >= 10 || downCount <= -1 || backwardsCount <= -1 || upCount <= -1 || forwardCount <= -1) {
						tries++;											// If any of these happen the particle is trapped and loop is restarted.
					}
					else if(forwardCount >= 6 || upCount >= 6) {   // If forward count is more or equal or up count is more or equal to six then it escapes.
							particlesEscaped++;
							tries++;							// Loop the restarts.
					}
				movementsOne = rand.nextInt(4) + 1;             // If none of the above happens then, while loop keeps going.
		}
	   }
		
		particlePercent = (particlesEscaped / particles) * 100;
		System.out.print("The percentage of particles that escape the sheilding is: ");
		System.out.printf("%.2f", particlePercent);
		System.out.print("%");
    }
}