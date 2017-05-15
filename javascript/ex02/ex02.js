function seriesInvalidas(series) {
    let data = new Date(),
        seriesInvalidas = [];
    for (serie of series) {
        if (serie.anoEstreia > data.getFullYear()) {
            seriesInvalidas.push(serie.titulo);
        } else {
            let propriedadeSeries = Object.getOwnPropertyDescriptors(serie);
            for (propriedade in propriedadeSeries) {
                let valorProp = propriedadeSeries[propriedade].value;
                if (valorProp === "undefined" || valorProp === null) {
                    seriesInvalidas.push(serie.titulo);
                }
            }
        }
    }
    return "Séries Inválidas: " + seriesInvalidas.join(" - ");
}

var filtrarSeriesPorAno = (series, ano) =>
    series.filter(serie => serie.anoEstreia >= ano);

function mediaDeEpisodios(series) {
    let somaEpisodios = 0;

    for (serie of series)
        somaEpisodios += serie.numeroEpisodios;

    return somaEpisodios / series.length;
}

var procurarPorNome = (series, nome) =>
    series.some(
        serie => serie.elenco.some(
            elenco  => elenco.includes(nome)));

var mascadaEmSerie = (serie) =>
    (serie.elenco.length * 40000) + (serie.diretor.length * 100000);

var queroGenero = (genero) =>
    series.filter(
        s => s.genero.some(
            g => g === genero));

var queroTitulo = (titulo) =>
    series.filter(s => s.titulo.includes(titulo));

 function sortUltimoNome (item1, item2) {
    if(item1.slice(item1.lastIndexOf(" ") + 1 ) > item2.slice(item2.lastIndexOf(" ") + 1))
        return 1;
    if(item1.slice(item1.lastIndexOf(" ") + 1 ) < item2.slice(item2.lastIndexOf(" ") + 1))
        return -1;
    return 0;
}

function creditosIlluminatis (serie) {
    let creditosDoCapiroto = "";
    serie.diretor.sort(sortUltimoNome);
    serie.elenco.sort(sortUltimoNome);

    creditosDoCapiroto += "TITULO: "      + serie.titulo         + ";";
    creditosDoCapiroto += "\nDIRETORES: " + serie.diretor.join() + ";";
    creditosDoCapiroto += "\nELENCO: "    + serie.elenco.join()  + ";";

    return creditosDoCapiroto + ";";
}


var todosPossuemNomeAbreviado = (nomes) =>
    nomes.every(n => n.indexOf(".") !== -1);

var nomesAbreviados = function (nomes){
    let palavraMagica = "#";

    nomes.forEach(e =>
        palavraMagica += e.substring(e.indexOf(".") - 1, e.indexOf("."))
    );

    return palavraMagica;
};

function serieIlluminati (series) {
    let serieDoCramunhao;

    for(serie of series)
        if(todosPossuemNomeAbreviado(serie.elenco))
            serieDoCramunhao = serie;
    
    return nomesAbreviados(serieDoCramunhao.elenco);
}
