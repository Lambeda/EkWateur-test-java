# Contexte

Ecriture d'un programme back-end java pour l'entretien technique d'Ekwateur. Le but est de fournir le montant à facturer à un client pour un mois calendaire.

# Tests

Pour tester le programme, il faut exécuter le Main.java avec les 3 entrées décrites ci-dessous.

## Entrées attendues 
Dans l'ordre :
- identifiant Ekwateur du client : EKW + 8 chiffres
- la date de début de facturation (au format dd-mm-yyyy)
- la date de fin de facturation (au format dd-mm-yyyy)

## Sortie

Si l'identifiant Ekwateur est erronnée ou inextante dans "les bases de données", alors le programme renvoie un message d'erreur.
Sinon on retourne le montant total (électricité + gaz) à facturer au client entre la date de début et la date de fin indiqué en entrée.

# Base de données

Les fichiers dans le répertoire src/test/resources sont une simulation des tables sql. Chaque ligne contient des séparateurs ';' qui organisent le contenu de la ligne dans des colonnes.

## ClientDB

Contient tous les clients.
Colonnes :
  - identifiant Ekwateur (juste les 8 chiffres après "EKW")
  - type de client (PARTICULIER, PROFESSIONEL, PROFESSIONEL_CA_SUPERIEUR)

## ClientPartDB

Contient tous les clients particuliers.
Colonnes :
  - identifiant Ekwateur (juste les 8 chiffres après "EKW")
  - civilité (MADAME, MONSIEUR, MADEMOISELLE)
  - nom
  - prénom

## ClientProDB

Contient tous les clients professionnels.
Colonnes :
  - identifiant Ekwateur (juste les 8 chiffres après "EKW")
  - siret
  - raison sociale
  - chiffre d'affaire

## ConsommationDB

Contient toutes les consommations des clients.
Colonnes :
  - identifiant Ekwateur (juste les 8 chiffres après "EKW")
  - type d'énergie consommée (ELECTRICITE, GAZ)
  - quantité d'énergie consommée en kWh
  - date de début du relevé de consommation
  - date de fin du relevé de consommation

## TarifDB

Contient les tarifs à appliqués aux consommations énergétiques.
Colonnes :
  - type de client (PARTICULIER, PROFESSIONEL, PROFESSIONEL_CA_SUPERIEUR)
  - type d'énergie (ELECTRICITE, GAZ)
  - prix du kWh en euros 
