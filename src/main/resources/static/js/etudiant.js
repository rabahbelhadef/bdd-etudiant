console.log("HELLO") ;
etudiantId = new URLSearchParams(window.location.search).get("id") ;

const getEtudiantById = async () => {
    const response = await fetch('http://localhost:8080/etudiants/' + etudiantId);
    const etudiant = await response.json();
    console.log(etudiant) ;

    document.getElementById("nom").innerText += " " + etudiant.nom;
    document.getElementById("prenom").innerText += " " + etudiant.prenom;
    document.getElementById("sexe").innerText += " " + etudiant.sexe;
    document.getElementById("dateNaissance").innerText += " " + etudiant.dateNaissance;

}


getEtudiantById() ;

