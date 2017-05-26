using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios
                .OrderBy(funcionario => funcionario.Cargo.Titulo)
                .ThenBy(funcionario => funcionario.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            
            return Funcionarios
                    .Where(funcionario => funcionario.Nome.IndexOf(nome, Comparar) != -1)
                    .ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            if (turnos.Length <= 0) return Funcionarios;

            return funcionariosPorTurnos(turnos);
        }

        private List<Funcionario> funcionariosPorTurnos(TurnoTrabalho[] turnos)
        {
            var totalFuncionarios = new List<Funcionario>();

            foreach (var turno in turnos)
            {
                var funcionariosDoTurnoEspecifico =
                     Funcionarios
                         .Where(f => f.TurnoTrabalho.Equals(turno));

                foreach (var funcionario in funcionariosDoTurnoEspecifico)
                    totalFuncionarios.Add(funcionario);

            }

            return totalFuncionarios;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return Funcionarios
                    .Where(f => CalcularIdade(f.DataNascimento) < idade + 5
                           && CalcularIdade(f.DataNascimento) > idade - 5)
                    .ToList();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            return DateTime.Now.Year - dataNascimento.Year;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if (!turno.HasValue)
                return CalcularSalarioMedio(Funcionarios);

            var funcionariosDoTurno =
                  Funcionarios
                    .Where(f => f.TurnoTrabalho.Equals(turno))
                    .ToList();

            return CalcularSalarioMedio(funcionariosDoTurno);
        }

        private double CalcularSalarioMedio(List<Funcionario> funcionarios)
        {
            return funcionarios.Sum(f => f.Cargo.Salario) / funcionarios.Count;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var mesAtual = DateTime.Now.Month;

            return Funcionarios
                .Where(f => f.DataNascimento.Month == mesAtual).ToList();
        }



        public IList<dynamic> BuscaRapida()
        {
            var funcionariosSimples = new List<dynamic>();

            foreach (var funcionario in Funcionarios)
            {
                funcionariosSimples
                    .Add(new
                        { NomeFuncionario = funcionario.Nome,
                          TituloCargo = funcionario.Cargo.Titulo });               
            }

            return funcionariosSimples;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {            
            var funcionariosPorTurno  = Funcionarios.GroupBy(f => f.TurnoTrabalho);
                 
            return GerarQtdFuncionariosTurno(funcionariosPorTurno);
        }       

        private List<dynamic> GerarQtdFuncionariosTurno (IEnumerable<IGrouping<TurnoTrabalho, Funcionario>> lista)
        {
            var listaAux = new List<dynamic>();
            foreach (var turno in lista)
            {
                listaAux.Add(new { Turno = turno.Key, Quantidade = turno.Count() });
            }
            return listaAux;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var funcionariosPreSelecionados = Funcionarios
                .Where(f => FuncionarioEhElegivel(f.Cargo.Titulo, f.TurnoTrabalho));

            var nomeComMaisConsoantes = MaiorNumDeConsoantes(funcionariosPreSelecionados);

            var funcionarioComMaisConsoantes = 
                funcionariosPreSelecionados
                  .First(f => ContarConsoantes(f.Nome) == nomeComMaisConsoantes);

            var funcionariosMesmoTurno = 
                FuncionariosMesmoTurno(funcionariosPreSelecionados, funcionarioComMaisConsoantes);


            return GerarMaisComplexo(funcionarioComMaisConsoantes, funcionariosMesmoTurno);
        }    

        private string FormatarDataNascimento (DateTime dataNascimento)
        {
            return $"{dataNascimento.Day}/{dataNascimento.Month}/{dataNascimento.Year}";
        }

        private dynamic GerarMaisComplexo (Funcionario complexo, int mesmoCargo)
        {
            return new
            {
                Nome = complexo.Nome,
                DataNascimento = FormatarDataNascimento(complexo.DataNascimento),
                SalarioRS = TrocarSalarioDePais(complexo.Cargo.Salario, "pt-BR"),
                SalarioUS = TrocarSalarioDePais(complexo.Cargo.Salario, "en-US"),
                QuantidadeMesmoCargo = mesmoCargo
            };
        }
        
        private int FuncionariosMesmoTurno (IEnumerable<Funcionario> funcionarios, Funcionario complexo)
        {
            return funcionarios
                .Where(f => f.TurnoTrabalho == complexo.TurnoTrabalho && f.Nome != complexo.Nome)
                .ToList().Count;
        }

        private int MaiorNumDeConsoantes(IEnumerable<Funcionario> funcionarios)
        {
            return funcionarios.Max(f => ContarConsoantes(f.Nome));
        }

        private bool FuncionarioEhElegivel (string titulo, TurnoTrabalho turnoDeTrabalho)
        {
            return titulo != "Desenvolvedor Júnior" && turnoDeTrabalho != TurnoTrabalho.Tarde;
        }

        private int ContarConsoantes (string valor)
        {
            const string vogais = "aeiou";
            return valor.Count(Char => vogais.Contains(char.ToLowerInvariant(Char)));
        }
        private static StringComparison Comparar = StringComparison.OrdinalIgnoreCase;

        private string TrocarSalarioDePais (double salario, string cultura)
        {
            return salario.ToString("C", CultureInfo.CreateSpecificCulture(cultura));
        }
    }
}
