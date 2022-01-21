<?php
/**
 * Classe d'accès aux données.

 * Utilise les services de la classe PDO
 * pour l'application
 * $monPdo de type PDO
 *
 */
class PdoBdvente
{
   		private static $monPdo;
		private static $monPdoBdvente = null;
/**
 * Constructeur privé, crée l'instance de PDO qui sera sollicitée
 * pour toutes les méthodes de la classe
 * Utilisation du design Pattern Singleton
 */
	private function __construct()
	{
    		self::$monPdo = new PDO('mysql:host=localhost;dbname=bdmvcboutique','root','root');
			self::$monPdo->query("SET CHARACTER SET utf8");
	}
	public function _destruct(){
		self::$monPdo = null;
	}
/**
 * Fonction statique qui crée l'unique instance de la classe
 *
 * Appel : $instancePdobdvente = PdoBdvente::getPdoBdvente();
 * @return l'unique objet de la classe PdoBdvente
 */
	public  static function getPdoBdvente()
	{
		if(self::$monPdoBdvente == null)
		{
			self::$monPdoBdvente= new PdoBdvente();
		}
		return self::$monPdoBdvente;
	}
/**
 * Retourne toutes les catégories sous forme d'un tableau associatif
 *
 * @return le tableau associatif des catégories
*/
public static function getLesCategories()
	{
		$req = "select * from categorie";
		$res = self::$monPdo->query($req);
		$lesLignes = $res->fetchAll();
		return $lesLignes;
	}

/**
 * Retourne sous forme d'un tableau associatif tous les produits de la
 * catégorie passée en argument
 *
 * @param $idCategorie
 * @return un tableau associatif
*/

	public static function getLesProduitsDeCategorie($idCategorie)
	{
	    $req="select * from article where categorie = '$idCategorie'";
		$res = self::$monPdo->query($req);
		$lesLignes = $res->fetchAll();
		return $lesLignes;
	}
public static function getLeProduit($idProduit)
	{
	    $req="select * from article where idArticle = '".$idProduit."'";
		$res = self::$monPdo->query($req);
		$leProduit= $res->fetch(PDO::FETCH_ASSOC);
		return $leProduit;
	}

	public static function modifierProduit($id,$des,$prix,$categ){
		$req = "update article set designationArticle='".$des."', prixTTC=".$prix." , categorie=".$categ." where idArticle='".$id."'" ;
		$res = self::$monPdo->exec($req);
	}


	public static function insererProduit($id,$des,$prix,$categ){
		$req = "INSERT into article VALUES ('".$id."','". $des."',".$prix.",".$categ.")";
	     $res=self::$monPdo->exec($req);
		return $res;
	}

	public static function detruireProduit($id){
		$req = "delete from article where idArticle='".$id."'";
		$res = self::$monPdo->exec($req);
		return $res;
	}
	public static function ajouter_categorie($libelle){
            $req = "INSERT into categorie(libelleCateg) VALUES ('".$libelle."')";
            $res = self::$monPdo->exec($req);
		return $res;
        }
        public static function supprimer_categorie($id){
            $req = "delete from categorie where idCateg='".$id."'";
		$res = self::$monPdo->exec($req);
		return $res;
        }
        public static function modifiertaux($modiftaux){
            $req = "update param set tauxRéductionPass='".$modiftaux."'" ;
		$res = self::$monPdo->exec($req);
                return $res;

        }
        public static function viderbase() {
            $req =" truncate table vente " ;
            $res = self::$monPdo->exec($req);
            $req =" truncate table detailvente " ;
            $res = self::$monPdo->exec($req);
                return $res;

        }

        public static function afficheVente(){
          $req="select count(idVente) as nbVente,dateVente from vente where 1 group by dateVente";
          $res = self::$monPdo->query($req);
          $lesLignes = $res->fetchAll();
          return $lesLignes;
        }


}
?>
