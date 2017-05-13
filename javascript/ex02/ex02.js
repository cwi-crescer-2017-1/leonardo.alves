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
            console.log(serie.anoEstreia);
        }
    }
    return seriesFiltradas;
}

function mediaDeEpisodios(series) {
    let somaEpisodios = 0,
        numeroSeries = 0;

    for (serie of series) {
        console.log(serie.titulo, serie.numeroEpisodios);
        somaEpisodios += serie.numeroEpisodios;
        numeroSeries += 1;
    }

    return somaEpisodios / numeroSeries;
}
