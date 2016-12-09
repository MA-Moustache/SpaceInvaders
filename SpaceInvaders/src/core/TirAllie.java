package core;

public class TirAllie extends Tir{

	public TirAllie(int i, int y)
	{
		this.posY = i;
		this.posX = y;
		forme = "|";
		moved = false;
	
	}
	
	@Override
	public void avancer() {
		
	
		Tableau.setJeu("Z", (this.posY), this.posX);
		this.posY--;	
		Tableau.setJeu(new TirAllie(posY, posX), (this.posY), this.posX);
	}
	
	public void collision()
	{
			if(Tableau.getJeu()[this.posY - 1][this.posX].equals("Z") == false)
			{
				Tableau.getJeu()[this.posY][this.posX] = "Z";
				Tableau.getJeu()[this.posY - 1][this.posX] = "Z";
			}

	}
	
	

}
