class Effacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longeurSelection:Integer = _
	
	override def execute():Unit={
		debutCurseur = contexte.getDebutCurseur
		longeurSelection = contexte.getLongueurSelection
		contexte.effacer
	}
}