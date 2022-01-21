<html>
<head>
  <meta charset="utf-8">
</head>
<?php
session_start();
require_once("modeles/class.pdoBdvente.inc.php");
include("vues/v_layout_entete.php") ;
if(!isset($_REQUEST['controleur']))
     $controleur = 'accueil';
else
	$controleur = $_REQUEST['controleur'];
$laConnexion = PdoBdvente::getPdoBdvente();
switch($controleur)
{
	case 'accueil':
		{include("vues/v_accueil.php");break;}
	case 'gererAeroport' :
		{include("controleurs/c_controller.php");break;}

}
include("vues/v_layout_pied.php") ;

?>
</html>
