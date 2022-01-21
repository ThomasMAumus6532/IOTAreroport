<div id="image">
<img src="images/logo.png" width="100px" height="75px"	alt="logo" title="logo Pic du midi"/>
</div>
<div id="produits">
<form method="POST" action="index.php?controleur=gererProduits&action=sauvegarderPassager">
   <fieldset>
     <p>
            <label for="nomPersonne">Nom :</label>
            <input id="nomPersonne" type="text" name="nomPersonne" size="30" maxlength="45"/>
        </p>
        <p>
            <label for="prenomPersonne">Prenom : </label>
            <input id="prenomPersonne" type="text" name="prenomPersonne" size="30" maxlength="45"/>
        </p>
        <p>
            <label for="idVol">Id Vol :</label>
             <input id="idVol" type="text" name="idVol"  size="30" maxlength="45"/>
        </p>
    <p>
      <input type="submit" value="Valider" name="valider"/>
      <input type="reset" value="Annuler" name="annuler"/>
   </p>
</form>

</div>
