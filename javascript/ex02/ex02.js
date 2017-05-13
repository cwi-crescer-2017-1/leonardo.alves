function seriesInvalidas(series) {
    let data = new Date(),
        seriesInvalidas = [];
    for (serie of series) {
        if (serie.anoEstreia > data.getFullYear()) {
            seriesInvalidas.push(serie);
        } else {
            let propriedadeSeries = Object.getOwnPropertyDescriptors(serie);
            for (propriedade in propriedadeSeries) {
                let valorProp = propriedadeSeries[propriedade].value;
                if (valorProp === "undefined" || valorProp === null) {
                    seriesInvalidas.push(serie);
                }
            }
        }
    }
    return seriesInvalidas;
}

function filtrarSeriesPorAno(series, ano) {
    let seriesFiltradas = [];
    for (serie of series) {
        if (serie.anoEstreia >= ano) {
            seriesFiltradas.push(serie);            
        }
    }
    return seriesFiltradas;
}

function mediaDeEpisodios(series) {
    let somaEpisodios = 0,
        numeroSeries = 0;

    for (serie of series) {        
        somaEpisodios += serie.numeroEpisodios;
        numeroSeries += 1;
    }

    return somaEpisodios / numeroSeries;
}

function procurarPorNome(series, nome) {
    for (serie of series) {
        for (indice in serie.elenco)
            if (serie.elenco[indice] === nome) return true;
    }
    return false;
}

var mascadaEmSerie = (serie) =>  
    (serie.elenco.length) * 40000 + (serie.diretor.length * 100000);
    
function queroGenero(genero) {
    let seriesComOGenero = [];
    for(serie of series) {
        for(indice in serie.genero) {
            if(serie.genero[indice] === genero) 
                seriesComOGenero.push(serie.titulo);
        }
    }
    return seriesComOGenero;
}

function queroTitulo(titulo) {
    let seriesComOTituloSemelhante = [];
    for(serie of series) {
        if(serie.titulo.includes(titulo)) 
            seriesComOTituloSemelhante.push(serie.titulo);
    }
    return seriesComOTituloSemelhante;
}

 function sortUltimoNome (item1, item2) {        
    if(item1.slice(item1.lastIndexOf(" ") + 1 ) > item2.slice(item2.lastIndexOf(" ") + 1))
        return 1;    
    if(item1.slice(item1.lastIndexOf(" ") + 1 ) < item2.slice(item2.lastIndexOf(" ") + 1))
        return -1;        
    return 0;
}

function creditosIlluminatis (serie) {   
    let creditosDoCapiroto = "",
        diretores = [],
        elenco = [];
    
    creditosDoCapiroto += "TITULO: " + serie.titulo + ";";
    creditosDoCapiroto += "\nDIRETORES: ";
    
    serie.diretor.sort(sortUltimoNome);
    creditosDoCapiroto += serie.diretor.join();
    
    creditosDoCapiroto += ";\nELENCO: ";
    serie.elenco.sort(sortUltimoNome);
    creditosDoCapiroto += serie.elenco.join();

    return creditosDoCapiroto + ";";
}