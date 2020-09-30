console.log("HELLO") ;
etudiantId = new URLSearchParams(window.location.search).get("id") ;

const getEtudiantById = async () => {
    const response = await fetch('http://localhost:8080/etudiants/' + etudiantId);
    const etudiant = await response.json();
    console.log(etudiant) ;

    document.getElementById("nom").setAttribute("value" , etudiant.nom) ;
    document.getElementById("prenom").setAttribute("value" , etudiant.prenom);
    document.getElementById("sexe").setAttribute("value" , etudiant.sexe);
    document.getElementById("dateNaissance").setAttribute("value" , etudiant.dateNaissance);

}


getEtudiantById() ;

function saveEtudiant(){
    document.getElementById("nom").innerText += " " + etudiant.nom;
    document.getElementById("prenom").innerText += " " + etudiant.prenom;
    document.getElementById("sexe").innerText += " " + etudiant.sexe;
    document.getElementById("dateNaissance").innerText += " " + etudiant.dateNaissance;

}

