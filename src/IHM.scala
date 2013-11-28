class IHM(buff:Buffer, coll:Coller, copi:Copier, coup:Couper, depl:Deplacer, ecri:Ecrire, effa:Effacer){
	private var buffer = buff
	private var col = coll
	private var cop = copi
	private var cou = coup
	private var dep = depl
	private var ecr = ecri
	private var eff = effa
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
		cop.execute
	}
	
	def couper():Unit={ //copie la sélection dans le presse papier puis l'efface
		cou.execute
	}
	
	def coller():Unit={ //colle dans le texte le contenu du presse papier (s'il y avait une sélection, celle-ci est remplacée)
		col.execute
	}
	
	def deplacer(pos:Integer):Unit={
		dep.setIHM(this)
		position = pos
		dep.execute
	}
	
	def ecrire(c:Char):Unit={
		ecr.setIHM(this)
		caractere = c
		ecr.execute
	}
	
	def effacer():Unit={
		eff.execute
	}
	
	def reinititaliser():Unit={
		buffer.reinitialiser
	}
	
	def rejouer():Unit={
		buffer.rejouer
	}
}