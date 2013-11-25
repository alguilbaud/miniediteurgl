class Deplacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
	private var ihm : IHM = _
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longueurSelection:Integer = _
	private var position:Integer = _
  
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	def getPosition():Integer = {
		return position
	}
	
	def execute():Unit={
		debutCurseur = contexte.getDebutCurseur
		longueurSelection = contexte.getLongueurSelection
		position = ihm.getPosition
		contexte.deplacer(this)
		contexte.sauverCommande(this)
	}
	
	def refaire():Unit={
		contexte.deplacer(this)
	}
	
	def getDebutCurseur():Integer = {
		return debutCurseur
	}
	
	def getLongueurSelection():Integer = {
		return longueurSelection
	}
}