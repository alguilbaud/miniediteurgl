class Couper(contxt:Buffer) extends Commande{
	private var contexte = contxt
  
	override def execute():Unit={
		contexte.couper
	}
}