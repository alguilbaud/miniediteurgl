class Ecrire(contxt:Buffer) extends Commande{
	private var contexte = contxt
	private var ihm : IHM = _
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longueurSelection:Integer = _
	private var caractere:Char = _
	
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	def getCaractere():Char = {
		return caractere
	}
	
	def execute():Unit={
		debutCurseur = contexte.getDebutCurseur
		longueurSelection = contexte.getLongueurSelection
		caractere = ihm.getCaractere
		contexte.ecrire(this)
		contexte.sauverCommande(this)
	}
	
	def refaire():Unit={
		contexte.ecrire(this)
	}
	
	def getDebutCurseur():Integer = {
		return debutCurseur
	}
	
	def getLongueurSelection():Integer = {
		return longueurSelection
	}
}