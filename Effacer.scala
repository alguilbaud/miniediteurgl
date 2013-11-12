class Effacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
  
	override def execute():Unit={
		contexte.effacer
	}
}