class Effacer(contxt:Buffer) extends Commande{
	var contexte = contxt
  
	def execute():Unit={
		contexte.effacer
	}
}