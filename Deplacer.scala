class Deplacer(contxt:Buffer) extends Commande{
	var contexte = contxt
  
	var ihm : IHM = _
  
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	def execute():Unit={
		val pos = ihm.getPosition
		contexte.deplacer(pos)
		
	}
}