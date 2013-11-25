
class Buffer(pp:PressePapier){
	private var texte = ""
	private var pressePapier = pp
	private var debutCurseur = 0
	private var longueurSelection = 0
	//attribut de la version 2
	private var historique = List()
	
	def afficher():Unit={
		System.out.println(texte)
	}
	
	def getDebutCurseur():Integer = {
		return debutCurseur
	}
	
	def getLongueurSelection():Integer = {
		return longueurSelection
	}
	
	def positionnerCurseur(pos:Integer):Unit={
		if (pos>=0 && pos<texte.length){ //on ne change la position du curseur que si c'est une position valide
			debutCurseur = pos
			longueurSelection = 0
		}
	}
	
	def selectionner(pos:Integer, longueur:Integer):Unit={ //sélectionne une sous chaîne qui commence à l'emplacement pos et qui a une taille égale à longueur
		if (pos>=0 && longueur>=0 && (pos+longueur)<=texte.length){
			debutCurseur = pos
			longueurSelection = longueur
		}
	}
	
	def copier(c:Copier):Unit={ //met dans le presse papier la sélection
		debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		if (longueurSelection > 0){
			pressePapier.ajouterTexte(texte.substring(debutCurseur, debutCurseur + longueurSelection))
		}
	}
	
	def couper(c:Couper):Unit={ //copie la sélection dans le presse papier puis l'efface
		debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		if (longueurSelection > 0){
			pressePapier.ajouterTexte(texte.substring(debutCurseur, debutCurseur + longueurSelection))
			val part1 = texte.substring(0, debutCurseur)
			val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
			texte = part1 + part2
			longueurSelection = 0
		}
	}
	
	def coller(c:Coller):Unit={ //colle dans le texte le contenu du presse papier (s'il y avait une sélection, celle-ci est remplacée)
	  	debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		val texteAColler = pressePapier.recupererTexte
	  	if (texteAColler.length > 0){ //on ne colle que si le presse papier ne contenait pas la chaine vide
	  		val part1 = texte.substring(0, debutCurseur)
	  		val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
	  		texte = part1 + texteAColler + part2
	  		longueurSelection = 0
	  		debutCurseur = debutCurseur + texteAColler.length
	  	}
	}
	
	def deplacer(c:Deplacer):Unit={ //déplace la sélection débutant à débutCurseur pour la mettre à la position pos
		debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		val pos = c.getPosition
		if (pos >= debutCurseur){
			val part1 = texte.substring(0, debutCurseur)
			val texteADeplacer = texte.substring(debutCurseur, debutCurseur + longueurSelection)
			val part2 = texte.substring(debutCurseur + longueurSelection, pos)
			val part3 = texte.substring(pos,texte.length)
			texte = part1 + part2 + texteADeplacer + part3
			debutCurseur = pos - longueurSelection //pos - longueurSelection car le curseur se met au début de la sélection et on a supprimé la sélection à l'ancienne position
		}
		else{
			val part1 = texte.substring(0, pos)
			val part2 = texte.substring(pos, debutCurseur)
			val texteADeplacer = texte.substring(debutCurseur, debutCurseur + longueurSelection)
			val part3 = texte.substring(debutCurseur + longueurSelection, texte.length)
			texte = part1 + texteADeplacer + part2 + part3
			debutCurseur = pos
		}
	}
	
	def ecrire(c:Ecrire):Unit={ //écrit un caractère à l'endroit du curseur si pas de sélection, et à la place de la sélection s'il y en a
		debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		val car = c.getCaractere 
		val part1 = texte.substring(0, debutCurseur)
		val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
		texte = part1 + car + part2
		longueurSelection = 0
		debutCurseur += 1
	}
	
	def effacer(c:Effacer):Unit={
		debutCurseur = c.getDebutCurseur
		longueurSelection = c.getLongueurSelection
		if(longueurSelection > 0){ //si on a une sélection, on efface cette sélection
			val part1 = texte.substring(0, debutCurseur)
			val part2 = texte.substring(debutCurseur+longueurSelection, texte.length)
			texte = part1 + part2
			longueurSelection = 0
		}
		else{ //si on n'a pas de sélection, on efface le caractère se situant juste avant la position du curseur
			if (debutCurseur>0){
				val part1 = texte.substring(0, debutCurseur-1)
				val part2 = texte.substring(debutCurseur, texte.length)
				texte = part1 + part2
				debutCurseur -= 1
			}
		}
	}
	
	def sauverCommande(c:Commande):Unit={
		c::historique
	}
	
	def reinitialiser():Unit={
		texte=""
	    debutCurseur=0
	    longueurSelection=0
	}
	
	def rejouer():Unit={ //méthode pour demander au buffer de rejouer son historique de commandes
		rejouer(historique)
	}
	
	def rejouer(l:List[Commande]):Unit={ //méthode récursive qui va refaire toutes les commandes depuis le début
		if (!l.isEmpty){
			l.last.refaire()
			rejouer(l.init)
		}
	}
}