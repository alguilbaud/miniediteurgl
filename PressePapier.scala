class PressePapier{
	private var texte = ""
	
	def ajouterTexte(txt:String):Unit={
		texte = txt
	}
	def recupererTexte():String= texte
	
	def afficherTexte():Unit={
		System.out.println(texte)
	}
}