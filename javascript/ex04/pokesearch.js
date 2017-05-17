var btnSearch = document.getElementById("btnSearch");
var content = document.getElementById("content");
var pokeCounter = 0;
btnSearch.onclick = function () {

    let pokemonId = document.getElementById("search").value;
    if (pokemonId !== 0) {
        let url = "http://pokeapi.co/api/v2/pokemon/" + pokemonId;

        fetch(url)
            .then(response => response.json())
            .then(json => {                
                content.append(
                    renderPoke(json)
                );
            });
    }
}

var renderPoke = function (json) {
    let desc = () => json.types.map(t => t.type.name);
    let everyStatus = () => json.stats.map(s => {
       return {name: s.stat.name, base_stat: s.base_stat}
    });
    
    let descVal = desc();
    let everyStatusVal = everyStatus();
    
    let div = document.createElement("div");
    div.className = "pokemon " + json.name;
    div.id = json.name + json.id + "-" + ++pokeCounter;

    let name = document.createElement("h2");
    name.className = "poke-name";
    name.innerHTML = json.name;

    let id = document.createElement("h3");
    id.className = "poke-id";
    id.innerHTML = json.id;

    let sprite = document.createElement("img");
    sprite.className = "poke-sprite";
    sprite.setAttribute("src", json.sprites.front_default);

    let description = document.createElement("ul");
    description.className = "poke-desc";

    descVal.forEach(d => {
        let li = document.createElement("li");
        li.innerHTML = d;
        li.className = "poke-desc-li";
        description.append(li);
    });
    
    let stats = document.createElement("ul");
    stats.className = "poke-stats";
    
    everyStatusVal.forEach(s =>{
        let li = document.createElement("li");
        li.className = "poke-stats-li";
        let progress = document.createElement("progress");
        progress.value = s.base_stat;
        progress.max = 100;
        li.innerHTML = `<p>${ s.name }: ${ s.base_stat }% </p>`;
        li.append(progress);
           
        stats.append(li);
    });
    

    div.append(name);
    div.append(id);
    div.append(sprite);
    div.append(sprite);
    div.append(description);
    div.append(stats);

    return div;
}
