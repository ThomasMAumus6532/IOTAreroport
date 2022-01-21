<div id="image">
<img src="images/logo.png" width="100px" height="75px"	alt="logo" title="logo Pic du midi"/>
</div>
<ul id="categories">
<br/>
<table >
	<tr><th>ID</th><th>Départ</th><th>Arrivée</th></tr>
		<td id="id">

<?php
foreach($lesVols as $leVol)
{
    $idVol = $leVol->idFlight;
    $dc = $leVol->departureCity;
    $ac = $leVol->arrivalCity;
   echo $idVol ?></td><td id="type"><?php echo $dc?></td><td id="arriv"><?php echo $ac?></td>
<?php
}
?>
</table>

</ul>
