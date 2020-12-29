window.onload = () => {
    // document.getElementById("loginForm").addEventListener("submit", login);
}


function login(e) {
    e.preventDefault();
    
    let username = document.getElementById("username");
    let password = document.getElementById("password");

    postLogin(username, password);
}





function postLogin(username, password) {
    // let planetInput = document.getElementById("pokemonId");
    // let planetId = planetInput.value;

    // let planetURL = `http://localhost:8080/PlanetApi/api/Planet`;
	// console.log(planetURL);

    // let xhttp = new XMLHttpRequest();

    // xhttp.onreadystatechange = () => {
    //     if (xhttp.readyState == 4 && xhttp.status == 200) {
    //         let pokeDetails = JSON.parse(xhttp.response);
    //         if (pokeDetails) {
    //             handlePokemon(pokeDetails);
    //         }
    //     } else if  (xhttp.readyState == 4 && xhttp.status != 200) {
    //         console.log("Failed http request");
    //     }
    // }

    // xhttp.open("GET", planetURL);

    // xhttp.send()

    // planetInput.value = "";
}

function handlePokemon(planet) {
	console.log(planet);
    //document.getElementById("pokemonName").innerHTML = pokemon.name;
    //let pokeImg = document.getElementById("pokemonImg");
    //pokeImg.src = pokemon.sprites.front_default;
    //pokeImg.alt = pokemon.name;
    //pokeImg.title = pokemon.name;
}