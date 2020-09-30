
const getEtudiants = async () => {
    const response = await fetch('http://localhost:8080/etudiants');
    const etudiants = await response.json();

    console.log(etudiants) ;

    var table = document.getElementById("etudiantsTab");


    line = 1 ;
    etudiants.forEach(function (etudiant) {
        var row = table.insertRow();
        row.className = (line++ % 2 ) == 0   ? "pair" : "impair" ;
        row.insertCell(0).innerText = etudiant.nom ;
        row.insertCell(1).innerText = etudiant.prenom ;
        row.insertCell(2).innerText = "Homme" ;
        row.insertCell(3).innerText = "2000-01-01" ;
        row.insertCell(4).appendChild(createView(etudiant.id)) ;
        row.insertCell(5).appendChild(createEdit(etudiant.id)) ;
        row.insertCell(6).innerText = "Supprimer" ;
    })
}


getEtudiants() ;

function createView(id) {
    var a = document.createElement("a") ;
    a.appendChild(document.createTextNode("Visualiser"));
    a.href = "/etudiant.html?id=" + id;
    return a;
}
function createEdit(id) {
    var a = document.createElement("a") ;
    a.appendChild(document.createTextNode("Modifier"));
    a.href = "/editEtudiant.html?id=" +id;
    return a;
}