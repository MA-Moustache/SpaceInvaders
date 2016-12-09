package core;

public class VaisseauAllie extends Vaisseau{

	static boolean isAlive;

	public VaisseauAllie(int i, int y)
	{
		this.posY = i;
		this.posX = y;
		isAlive = true;
		forme = "O";
	}

	@Override
	public void tirer()
	{
		//Tableau.getJeu()[this.posX][this.posY - 1] = new TirAllie(posY - 1, posX);
		Tableau.setJeu(new TirAllie(posY - 1, posX), this.posY - 1, this.posX);
		//Tableau.setJeu(new TirEnnemi(posY + 1, posX), (this.posY + 1), this.posX);
	}

	public void deplacer(String c)
	{
		c = c.toUpperCase();
		if(c.equals("Z")) // Avant
		{
			if(posY - 1 >= 0)
			{
				Tableau.setJeu("Z", this.posY, this.posX);
				this.posY = posY - 1;
				Tableau.setJeu(new VaisseauAllie(posX, posY), this.posY, this.posX);
			}
		}
		else if(c.equals("Q")) // Gauche
		{
			if(posX - 1 >= 0)
			{
				Tableau.setJeu("Z", this.posY, this.posX);
				this.posX = posX - 1;
				Tableau.setJeu(new VaisseauAllie(posX, posY), this.posY, this.posX);
			}
		}
		else if(c.equals("S")) // Arrière
		{
			if(posY + 1 < Tableau.getLigne())
			{
				Tableau.setJeu("Z", this.posY, this.posX);
				this.posY = posY + 1;
				Tableau.setJeu(new VaisseauAllie(posX, posY), this.posY, this.posX);
			}
		}
		else if(c.equals("D")) // Droite
		{
			if(posX + 1 < Tableau.getColonne())
			{
				Tableau.setJeu("Z", this.posY, this.posX);
				this.posX = posX + 1;
				Tableau.setJeu(new VaisseauAllie(posX, posY), this.posY, this.posX);
			}

		}
	}

}
