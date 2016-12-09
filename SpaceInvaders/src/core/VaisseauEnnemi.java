package core;

import java.util.Random;

public class VaisseauEnnemi extends Vaisseau{
	
	static boolean isAlive;
	
	private Random rand;
	public VaisseauEnnemi(int i, int y)
	{
		isAlive = true;
		this.posY = i;
		this.posX = y;
		rand = new Random();
		this.forme = "X";
	}
	
	@Override
	public void tirer()
	{
		if(posX < 40)
		{
			if(Tableau.getJeu()[this.posY + 1][this.posX].toString().equals("Z") == false)
			{
				// Rien faire
				//System.out.println("instance de vaisseau ennemi, X:" + this.posX + " Y:" + this.posY);
			}
			else
			{
				
				if(rand.nextInt(5) == 3)
				{
					//System.out.println("je tire X:" + this.posX + " Y:" + this.posY);
					Tableau.setJeu(new TirEnnemi(posY + 1, posX), (this.posY + 1), this.posX);
				}
			}
		}
	}

}
