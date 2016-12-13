package core;

import java.util.Scanner;

public class Start extends Thread {

	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
		String dir;
		boolean gagne = false;
		int time = 0;

		Tableau grille = new Tableau();
		grille.Build();

		while(Tableau.joueur.isAlive && gagne == false)
		{

			System.out.println(grille.toString());

			dir = scan.nextLine();
			grille.joueur.deplacer(dir);

			// Tout les vaisseau en front line doivent tirer avec un delai 5x plus grand  ==> THIS IS A THREAD (1)
			if(time == 0)
			{
				Tableau.joueur.tirer();
				for(int i = 0; i < 5; i++)
				{
					for(int j = 0; j < 40; j++)
					{
						if(grille.getJeu()[i][j] instanceof VaisseauEnnemi)
						{
							((VaisseauEnnemi) grille.getJeu()[i][j]).tirer();
						}
						else if(grille.getJeu()[i][j] instanceof VaisseauAllie)
						{
							// pas moyen de tirer en static avec vaisseau ennemi ?
						}
					}	
				}
			}
			else if(time == 3)
			{
				Tableau.joueur.tirer();
			}
			else if(time == 5)
			{
				time = -1;
			}

			// Les tirs avancent et se définissent comme "bougé"  ==> THREAD TOO (2)	
			for(int i = 1; i < 39; i++)
			{
				for(int j = 0; j < 40; j++)
				{
					if(grille.getJeu()[i][j] instanceof Tir)
					{
						((Tir) grille.getJeu()[i][j]).collision();
					}

					if(grille.getJeu()[i][j] instanceof TirEnnemi)
					{
						if(((TirEnnemi) grille.getJeu()[i][j]).getMoved() == false)
						{

							((TirEnnemi) grille.getJeu()[i][j]).avancer();

							((TirEnnemi) grille.getJeu()[i + 1][j]).setMoved(true);

						}
					}
					else if(grille.getJeu()[i][j] instanceof TirAllie)
					{
						if(((TirAllie) grille.getJeu()[i][j]).getMoved() == false)
						{

							((TirAllie) grille.getJeu()[i][j]).avancer();

							((TirAllie) grille.getJeu()[i - 1][j]).setMoved(true);

						}
					}
				}

			}

			// Les tirs se redéfinissent comme non bougé 
			for(int i = 0; i < 39; i++)
			{
				for(int j = 0; j < 40; j++)
				{
					if(grille.getJeu()[i][j] instanceof Tir)
					{
						((Tir) grille.getJeu()[i][j]).setMoved(false);
					}
				}
			}


			for(int j = 0; j < 40; j++)
			{
				if(grille.getJeu()[39][j] instanceof TirEnnemi)
				{
					grille.getJeu()[39][j] = "Z";
				}
			}
			for(int j = 0; j < 40; j++)
			{
				if(grille.getJeu()[0][j] instanceof TirAllie)
				{
					grille.getJeu()[0][j] = "Z";
				}
			}
			
			gagne = true;
			for(int i = 0; i < 4; i++)
			{
				for(int y = 0; y < 40; y++)
				{
					if(grille.getJeu()[i][y] instanceof VaisseauEnnemi)
					{
						gagne = false;
					}
				}
			}
			
			
			
			

			time++;
		}

		if(!Tableau.joueur.isAlive)
		{
			System.out.println("Vous avez perdu!");
		}
		else
		{
			System.out.println("Félicitation vous avez gagné!");
		}






	}
}
