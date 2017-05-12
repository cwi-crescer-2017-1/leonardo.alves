//Daisy Game 1
function daisyGame(numero) {
	if(numero % 2 == 0) {
		return "Love me not";
	} else {
		return "Love me";
	}
}

//Maior texto 2
function maiorTexto(strings) {
	let maiorNumero = 0;
	let maiorTexto;
	for(let texto of strings) {
		if(texto.length > maiorNumero) {
			maiorNumero = texto.length;
			maiorTexto = texto;
		}
	}
	return maiorTexto;
}

//Instrutor querido 3
function olaInstrutor(instrutores){
	for(let instrutor of instrutores) {
		console.log("olá querido instrutor:", instrutor);
	}
}

function imprime(instrutores, olaInstrutor){
	if(typeof olaInstrutor === "function") {
		return olaInstrutor(instrutores);
	}	
}

//Soma diferentona 4
function adicionar (a){
	return function (b){
		return a + b;
	}
}

//Fibona 5
var fiboSum = function (n) {	
	let fib = [], soma = 0;
	fib[0] = 0;
	fib[1] = 1;
	
	for(i = 2; i <= n; i++){
		fib[i] = fib[i-2] + fib[i-1];		
	}
	
	for(let index of fib){
		soma += index;
	}
	
	return soma;
}

//QUERO CAFEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE 6
function queroCafe (mascada, precos) {
	precos.sort();
	let precosQueOPovoGosta = [];
	for (let preco of precos) {
		if(preco <= mascada){
			precosQueOPovoGosta.push(preco);
		}
	}
	return precosQueOPovoGosta.toString();
}













