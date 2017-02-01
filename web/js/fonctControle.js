function teste()
{
   var  ok=true;
    if(document.identification.nom.value == "")
        {
            alert("Veuillez entrer un nom");
            ok=false;
        }
      else
          if(document.identification.prenom.value == "")
            {
            alert("Veuillez entrer un prenom");
            ok=false;
        }
          else
              if(document.identification.ville.value == "")
                {
                alert("Veuillez entrer la ville");
                ok=false;
            }

return ok;
}