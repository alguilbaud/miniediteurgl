class Coller(contxt:Buffer) extends Commande{
	private var contexte = contxt
  
	override def execute():Unit={
		contexte.coller
	}
}