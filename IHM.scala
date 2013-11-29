class IHM(buff:Buffer){
	private var buffer = buff
	private var position : Integer = _
	private var caractere : Char = _
	
	def getPosition():Integer= position
	
	def getCaractere():Char= caractere
	
	def afficherTexte():Unit={
		buffer.afficher
	}
	
	def positionnerCurseur(pos:Integer):Unit={
		buffer.positionnerCurseur(pos)
	}
	
	def selectionner(pos:Integer, longueur:Integer):Unit={ //sélectionne une sous chaîne qui commence à l'emplacement pos et qui a une taille égale à longueur
		buffer.selectionner(pos, longueur)
	}
	
	def copier():Unit={ //met dans le presse papier la sélection
		val cop = new Copier(buffer)
		cop.execute
	}
	
	def couper():Unit={ //copie la sélection dans le presse papier puis l'efface
		val cou = new Couper(buffer)
		cou.execute
	}
	
	def coller():Unit={ //colle dans le texte le contenu du presse papier (s'il y avait une sélection, celle-ci est remplacée)
		val col = new Coller(buffer)
		col.execute
	}
	
	def deplacer(pos:Integer):Unit={
		val dep = new Deplacer(buffer)
		dep.setIHM(this)
		position = pos
		dep.execute
	}
	
	def ecrire(c:Char):Unit={
		val ecr = new Ecrire(buffer)
		ecr.setIHM(this)
		caractere = c
		ecr.execute
	}
	
	def effacer():Unit={
		val eff = new Effacer(buffer)
		eff.execute
	}
	
	def reinititaliser():Unit={
		buffer.reinitialiser
	}
	
	def rejouer():Unit={
		buffer.rejouer
	}
}