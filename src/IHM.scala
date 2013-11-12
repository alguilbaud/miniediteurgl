class IHM(buff:Buffer, copi:Copier, coll:Coller, coup:Couper, depl:Deplacer, ecri:Ecrire, effa:Effacer){
	var buffer = buff
	var cop = copi
	var col = coll
	var cou = coup
	var dep = depl
	var ecr = ecri
	var eff = effa
	var position : Integer = _
	var caractere : Char = _
	
	def getPosition():Integer= position
	
	def getCaractere():Char= caractere
	
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
}