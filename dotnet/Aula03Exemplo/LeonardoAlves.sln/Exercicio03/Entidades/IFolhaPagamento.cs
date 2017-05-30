
namespace Exercicio03.Entidades
{
    public interface IFolhaPagamento
    {
        Demonstrativo GerarDemonstrativo(
            int horasCategoria,
            double salarioBase,
            double horasExtras,
            double horasDescontadas);
    }
}
