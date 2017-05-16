Number.prototype.arredondarNumero = function (numero) {
    numero = numero || 2;
    let string = this.toString();
    let posVirgula = string.indexOf(".");
    if(posVirgula !== -1) {
        return Number(string.substring(0, posVirgula) + "." + string.substring(posVirgula+1, posVirgula+1+numero));
    } else return null;
}

Number.prototype.arredondarNumero = function (numero) {
    numero = numero || 2;
    return Number(this.toFixed(numero));
}
