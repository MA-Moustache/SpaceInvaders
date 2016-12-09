package core;

public class Tableau {

	private static final int ligne = 40;
	private static final int colonne = 40;
	private static Object[][] jeu;
	static VaisseauAllie joueur;
	
	public Tableau()
	{
		joueur = new VaisseauAllie(39, 20);
	}
	
	public void Build()
	{
		jeu = new Object[ligne][colonne];
		
		// Géneration du terrain vide (Z)
		for(int i = 0; i < ligne; i++)
		{
			for(int y = 0; y < colonne; y++)
			{
				jeu[i][y] = "Z";
			}
		}
		
		// Génération des vaisseau ennemis sur les 4 premières lignes
		for(int i = 0; i < 4; i++)
		{
			for(int y = 0; y < colonne; y++)
			{
				jeu[i][y] = new VaisseauEnnemi(i, y);
			}
		}
		
		// Génération du vaisseau allié
		jeu[39][20] = joueur;	
		System.out.println("Build complété avec succes");
	}
	
	public String toString()
	{
		String s ="";
		for(int i = 0; i < ligne; i++)
		{
			for(int y = 0; y < colonne; y++)
			{
				if(jeu[i][y].equals("Z"))
				{
					s += " "; // Marquage du vide
					s += " "; // Espacement
					if(y == colonne-1)
					{
					s+= "\n";
					}
				}
				else
				{
					s += jeu[i][y].toString();
					s += " "; // Espacement
					if(y == colonne-1)
					{
					s+= "\n";
					}
				}
			}
		}
		return s;
	}
	
	public static Object[][] getJeu()
	{
		return jeu;
	}
	
	public static void setJeu(Object update, int i, int y)
	{
		jeu[i][y] = update;
	}
	
	public static int getColonne()
	{
		return colonne;
	}
	
	public static int getLigne()
	{
		return ligne;
	}
}
