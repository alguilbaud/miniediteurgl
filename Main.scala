import java.util.ArrayList

object Main {
	def main(args: Array[String]) {
		val buffer = new Buffer(new PressePapier)
		val ihm = new IHM(buffer)
		
		
		ihm.ecrire('a')
		ihm.ecrire('b')
		ihm.ecrire('c')
		ihm.ecrire('d')
		ihm.ecrire('e')
		ihm.ecrire('f')
		ihm.ecrire('g')
		ihm.ecrire('h')
		ihm.ecrire('i')
		
		ihm.afficherTexte
		
		ihm.selectionner(0,3)
		ihm.copier
		ihm.positionnerCurseur(9)
		ihm.coller
		
		ihm.afficherTexte
		
		ihm.selectionner(3,3)
		ihm.copier
		ihm.selectionner(9,3)
		ihm.coller
		
		ihm.afficherTexte
		
		ihm.effacer
		
		ihm.afficherTexte
		
		ihm.selectionner(0,9)
		ihm.couper
		
		ihm.afficherTexte
		
		ihm.positionnerCurseur(2)
		ihm.coller
		
		ihm.afficherTexte
		
		ihm.selectionner(0,2)
		ihm.deplacer(11)
		
		ihm.afficherTexte
		
		ihm.selectionner(9,2)
		ihm.effacer
		
		ihm.afficherTexte
		
		ihm.reinititaliser
		ihm.afficherTexte
		
		ihm.rejouer
		ihm.afficherTexte
		
		
	}
}