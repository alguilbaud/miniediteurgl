class Buffer(txt:String, pp:PressePapier){
	var texte = txt
	var pressePapier = pp
	var debutCurseur = 0
	var longueurSelection = 0
	
	def positionnerCurseur(pos:Integer):Unit={
		if (pos>=0 && pos<texte.length){
			debutCurseur = pos
			longueurSelection = 0
		}
	}
	
	def selectionner(pos:Integer, longueur:Integer):Unit={ //sélectionne une sous chaîne qui commence à l'emplacement pos et qui a une taille égale à longueur
		if (pos>=0 && longueur>=0 && (pos+longueur)<texte.length){
			debutCurseur = pos
			longueurSelection = longueur
		}
	}
	
	def copier():Unit={ //met dans le presse papier la sélection
		if (longueurSelection > 0){
			pressePapier.ajouterTexte(texte.substring(debutCurseur, debutCurseur + longueurSelection))	
		}
	}
	
	def couper():Unit={ //copie la sélection dans le presse papier puis l'efface
		if (longueurSelection > 0){
			this.copier
			this.effacer
		}
	}
	
	def coller():Unit={ //colle dans le texte le contenu du presse papier (s'il y avait une sélection, celle-ci est remplacée)
		val part1 = texte.substring(0, debutCurseur)
		val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
		val texteAColler = pressePapier.recupererTexte
		texte = part1 + texteAColler + part2
		longueurSelection = 0
		debutCurseur = debutCurseur + texteAColler.length
	}
	
	def deplacer(pos:Integer):Unit={
		
	}
	
	def ecrire(c:Char):Unit={
		val part1 = texte.substring(0, debutCurseur)
		val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
		texte = part1 + c + part2
		longueurSelection = 0
		debutCurseur += 1
	}
	
	def effacer():Unit={
		if(longueurSelection > 0){ //si on a une sélection, on efface cette sélection
			val part1 = texte.substring(0, debutCurseur)
			val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
			texte = part1 + part2
		}
		else{ //si on n'a pas de sélection, on efface le caractère se situant juste avant la position du curseur
			if (debutCurseur>0){
				val part1 = texte.substring(0, debutCurseur-1)
				val part2 = texte.substring(debutCurseur, texte.length)
				texte = part1 + part2
			}
		}
	}
}