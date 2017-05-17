var url = "http://pokeapi.co/api/v2/pokemon/",
    meshBtn = document.getElementById("meshBtn"),
    colorPicker = document.getElementById("colorPicker"),   
    pokemash = document.getElementById("pokemash"),
    body = document.getElementsByTagName("body")[0],
    colorRGB = [];

var noHex = (color) => color.substring(1, color.length);

var hexToRGB = (color, start, end) =>
    parseInt(color.substring(start, end), 16);

colorPicker.addEventListener("change", selectedColor, false);


function selectedColor() {
    let color = noHex(colorPicker.value);
    colorRGB = [
         hexToRGB(color, 0, 2),
         hexToRGB(color, 2, 4),
         hexToRGB(color, 4, 6)
    ]    
}

var invokePokemon = (colors) => {  
    colors.forEach(color =>{
        fetch(url + color)
        .then(response => response.json())
        .then(json => {
            console.log(json);
            let imagem = document.createElement("img");           
            imagem.setAttribute("src", json.sprites.front_default); 
            imagem.className = "poke-mesh-img";            
            pokemash.append(imagem);
        })
    });
}

meshBtn.onclick = function () {
   invokePokemon(colorRGB);
    body.style.background = `rgb(${colorRGB[0]}, ${colorRGB[1]}, ${colorRGB[2]})`;
}
