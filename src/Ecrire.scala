class Ecrire(contxt:Buffer) extends Commande{
	var contexte = contxt
  
	var ihm : IHM = _
	
	def setIHM(i:IHM):Unit = {
	  	ihm = i
	}
	
	def execute():Unit={
		val c = ihm.getCaractere
		contexte.ecrire(c)
		
	}
}