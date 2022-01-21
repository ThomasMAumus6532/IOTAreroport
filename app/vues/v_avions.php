<div id="image">
<img src="images/logo.png" width="100px" height="75px"	alt="logo" title="logo Pic du midi"/>
</div>
<ul id="categories">
<br/>
<table >
	<tr><th>ID</th><th>Type</th></tr>
		<td id="id">
<?php
foreach($lesAvions as $leAvion)
{
    $idAvion = $leAvion->idPlane;
    $model = $leAvion->model;
    $brand = $leAvion->brand;
    echo $idAvion ?></td><td id="type"><?php echo $brand?>-<?php  echo $model?></td>
<?php
}
?>
</table>

</ul>
