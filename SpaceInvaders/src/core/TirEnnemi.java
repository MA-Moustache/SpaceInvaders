package core;

public class TirEnnemi extends Tir {
	
	public TirEnnemi(int i, int y)
	{
		this.posY = i;
		this.posX = y;
		forme = "I";
		moved = false;
	}

	@Override
	public void avancer() {
		
		Tableau.setJeu("Z", (this.posY), this.posX);
		this.posY++;	
		Tableau.setJeu(new TirEnnemi(posY, posX), (this.posY), this.posX);	
	}
	
	public void collision()
	{
		if(Tableau.getJeu()[this.posY + 1][this.posX] instanceof VaisseauAllie)
		{
			System.out.println("Collision vaisseau allie");
			Tableau.setJeu("Z", this.posY, this.posX);
			Tableau.setJeu("Z", (this.posY + 1), this.posX);
			Tableau.joueur.isAlive = false;
		}
		else if(Tableau.getJeu()[this.posY + 1][this.posX].equals("Z") == false)
		{
			System.out.println("Collision !Z");
			Tableau.setJeu("Z", this.posY, this.posX);
			Tableau.setJeu("Z", (this.posY + 1), this.posX);
		}


	}
}
