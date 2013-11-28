import java.util.ArrayList

object Main {
	def main(args: Array[String]) {
		val buffer = new Buffer(new PressePapier)
		val coller = new Coller(buffer)
		val copier = new Copier(buffer)
		val couper = new Couper(buffer)
		val deplacer = new Deplacer(buffer)
		val ecrire = new Ecrire(buffer)
		val effacer = new Effacer(buffer)
		val ihm = new IHM(buffer, coller, copier, couper, deplacer, ecrire, effacer)
		
		
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
		//buffer.getHistorique
		
		ihm.reinititaliser
		ihm.afficherTexte
		
		ihm.rejouer
		ihm.afficherTexte
		
		/*ihm.selectionner(4, 3)
		ihm.deplacer(0)
		ihm.afficherTexte*/
		
	}
}