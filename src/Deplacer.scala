class Deplacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
	private var ihm : IHM = _
	//attributs de la version 2
	private var debutCurseur:Integer = _
	private var longeurSelection:Integer = _
  
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	override def execute():Unit={
		debutCurseur = contexte.getDebutCurseur
		longeurSelection = contexte.getLongueurSelection
		val pos = ihm.getPosition
		contexte.deplacer(pos)
		
	}
}