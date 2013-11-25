class Coller(contxt:Buffer) extends Commande{
	private var contexte = contxt
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longueurSelection:Integer = _
	
	def execute():Unit={
		debutCurseur = contexte.getDebutCurseur
		longueurSelection = contexte.getLongueurSelection
		contexte.coller(this)
		contexte.sauverCommande(this)
	}
	
	def refaire():Unit={
		contexte.coller(this)
	}
	
	def getDebutCurseur():Integer = {
		return debutCurseur
	}
	
	def getLongueurSelection():Integer = {
		return longueurSelection
	}
}