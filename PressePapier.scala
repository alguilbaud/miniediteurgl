class PressePapier{
	var texte = ""
	
	def ajouterTexte(txt:String):Unit={
		texte = txt
	}
	def recupererTexte():String= texte
}