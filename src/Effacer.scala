class Effacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longueurSelection:Integer = _
	
	def execute():Unit = {
		debutCurseur = contexte.getDebutCurseur
		longueurSelection = contexte.getLongueurSelection
		contexte.effacer(this)
		contexte.sauverCommande(this)
	}
	
	def refaire():Unit = {
		contexte.effacer(this)
	}
	
	def getDebutCurseur():Integer = {
		return debutCurseur
	}
	
	def getLongueurSelection():Integer = {
		return longueurSelection
	}
}