class Deplacer(contxt:Buffer) extends Commande{
	private var contexte = contxt
  
	private var ihm : IHM = _
  
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	override def execute():Unit={
		val pos = ihm.getPosition
		contexte.deplacer(pos)
		
	}
}