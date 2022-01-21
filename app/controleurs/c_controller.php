<?php
$action = $_REQUEST['action'];
switch($action)
{
    case 'consulterVols':
        {
            $lesVols = file_get_contents("http://localhost:8080/rest/api/flights");
            $lesVols = json_decode($lesVols);
          include("vues/v_vols.php");
          break;
        }
    case 'consulterAvions' :
        {
            $lesAvions = file_get_contents("http://localhost:8080/rest/api/plane/all");
            $lesAvions = json_decode($lesAvions);
        include("vues/v_avions.php");
        break;
        }
    case 'reserver':
        {
        include ("vues/v_reservation.php");
        break;
        }
    case 'accueil':
    {
      $lesAvionsF = file_get_contents("http://localhost:8080/rest/api/plane");
      $lesAvionsF = json_decode($lesAvionsF);
        include("vues/v_accueil.php");
        break;

    }
}
?>
