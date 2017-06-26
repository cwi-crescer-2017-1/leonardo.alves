package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo.alves
 */
public class PessoaServlet extends HttpServlet {

    private List<String> nomes = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {
            out.append("Não tinha medo o tal João de Santo Cristo\n" +
"Era o que todos diziam quando ele se perdeu\n" +
"Deixou pra trás todo o marasmo da fazenda\n" +
"Só pra sentir no seu sangue o ódio que Jesus lhe deu\n" +
"\n" +
"Quando criança só pensava em ser bandido\n" +
"Ainda mais quando com um tiro de soldado o pai morreu\n" +
"Era o terror da cercania onde morava\n" +
"E na escola até o professor com ele aprendeu\n" +
"\n" +
"Ia pra igreja só pra roubar o dinheiro\n" +
"Que as velhinhas colocavam na caixinha do altar\n" +
"Sentia mesmo que era mesmo diferente\n" +
"Sentia que aquilo ali não era o seu lugar\n" +
"\n" +
"Ele queria sair para ver o mar\n" +
"E as coisas que ele via na televisão\n" +
"Juntou dinheiro para poder viajar\n" +
"De escolha própria, escolheu a solidão\n" +
"\n" +
"Comia todas as menininhas da cidade\n" +
"De tanto brincar de médico, aos doze era professor\n" +
"Aos quinze, foi mandado pro reformatório\n" +
"Onde aumentou seu ódio diante de tanto terror\n" +
"\n" +
"Não entendia como a vida funcionava\n" +
"Discriminação por causa da sua classe e sua cor\n" +
"Ficou cansado de tentar achar resposta\n" +
"E comprou uma passagem, foi direto a Salvador\n" +
"\n" +
"E lá chegando foi tomar um cafezinho\n" +
"E encontrou um boiadeiro com quem foi falar\n" +
"E o boiadeiro tinha uma passagem e ia perder a viagem\n" +
"Mas João foi lhe salvar\n" +
"\n" +
"Dizia ele: Estou indo pra Brasília\n" +
"Neste país lugar melhor não há\n" +
"Tô precisando visitar a minha filha\n" +
"Eu fico aqui e você vai no meu lugar\n" +
"\n" +
"E João aceitou sua proposta\n" +
"E num ônibus entrou no Planalto Central\n" +
"Ele ficou bestificado com a cidade\n" +
"Saindo da rodoviária, viu as luzes de Natal\n" +
"\n" +
"Meu Deus, mas que cidade linda,\n" +
"No Ano Novo eu começo a trabalhar\n" +
"Cortar madeira, aprendiz de carpinteiro\n" +
"Ganhava cem mil por mês em Taguatinga\n" +
"\n" +
"Na sexta-feira ia pra zona da cidade\n" +
"Gastar todo o seu dinheiro de rapaz trabalhador\n" +
"E conhecia muita gente interessante\n" +
"Até um neto bastardo do seu bisavô\n" +
"\n" +
"Um peruano que vivia na Bolívia\n" +
"E muitas coisas trazia de lá\n" +
"Seu nome era Pablo e ele dizia\n" +
"Que um negócio ele ia começar\n" +
"\n" +
"E Santo Cristo até a morte trabalhava\n" +
"Mas o dinheiro não dava pra ele se alimentar\n" +
"E ouvia às sete horas o noticiário\n" +
"Que sempre dizia que o seu ministro ia ajudar\n" +
"\n" +
"Mas ele não queria mais conversa\n" +
"E decidiu que, como Pablo, ele ia se virar\n" +
"Elaborou mais uma vez seu plano santo\n" +
"E sem ser crucificado, a plantação foi começar\n" +
"\n" +
"Logo logo os maluco da cidade souberam da novidade\n" +
"\"Tem bagulho bom ai!\"\n" +
"E João de Santo Cristo ficou rico\n" +
"E acabou com todos os traficantes dali\n" +
"\n" +
"Fez amigos, frequentava a Asa Norte\n" +
"E ia pra festa de rock pra se libertar\n" +
"Mas de repente\n" +
"Sob uma má influência dos boyzinho da cidade\n" +
"Começou a roubar\n" +
"\n" +
"Já no primeiro roubo ele dançou\n" +
"E pro inferno ele foi pela primeira vez\n" +
"Violência e estupro do seu corpo\n" +
"Vocês vão ver, eu vou pegar vocês\n" +
"\n" +
"Agora o Santo Cristo era bandido\n" +
"Destemido e temido no Distrito Federal\n" +
"Não tinha nenhum medo de polícia\n" +
"Capitão ou traficante, playboy ou general\n" +
"\n" +
"Foi quando conheceu uma menina\n" +
"E de todos os seus pecados ele se arrependeu\n" +
"Maria Lúcia era uma menina linda\n" +
"E o coração dele, pra ela o Santo Cristo prometeu\n" +
"\n" +
"Ele dizia que queria se casar\n" +
"E carpinteiro ele voltou a ser\n" +
"\"Maria Lúcia pra sempre vou te amar\n" +
"E um filho com você eu quero ter\"\n" +
"\n" +
"O tempo passa e um dia vem na porta\n" +
"Um senhor de alta classe com dinheiro na mão\n" +
"E ele faz uma proposta indecorosa\n" +
"E diz que espera uma resposta, uma resposta do João\n" +
"\n" +
"Não boto bomba em banca de jornal\n" +
"Nem em colégio de criança, isso eu não faço não\n" +
"E não protejo general de dez estrelas\n" +
"Que fica atrás da mesa com o cu na mão\n" +
"\n" +
"E é melhor senhor sair da minha casa\n" +
"Nunca brinques com um Peixes de ascendente Escorpião\n" +
"Mas antes de sair, com ódio no olhar, o velho disse\n" +
"Você perdeu sua vida, meu irmão\n" +
"\n" +
"Você perdeu a sua vida, meu irmão\n" +
"Você perdeu a sua vida, meu irmão\n" +
"Essas palavras vão entrar no coração\n" +
"Eu vou sofrer as consequências como um cão\n" +
"\n" +
"Não é que o Santo Cristo estava certo\n" +
"Seu futuro era incerto e ele não foi trabalhar\n" +
"Se embebedou e no meio da bebedeira\n" +
"Descobriu que tinha outro trabalhando em seu lugar\n" +
"\n" +
"Falou com Pablo que queria um parceiro\n" +
"E também tinha dinheiro e queria se armar\n" +
"Pablo trazia o contrabando da Bolívia\n" +
"E Santo Cristo revendia em Planaltina\n" +
"\n" +
"Mas acontece que um tal de Jeremias\n" +
"Traficante de renome, apareceu por lá\n" +
"Ficou sabendo dos planos de Santo Cristo\n" +
"E decidiu que com João ele ia acabar\n" +
"\n" +
"Mas Pablo trouxe uma Winchester-22\n" +
"E Santo Cristo já sabia atirar\n" +
"E decidiu usar a arma só depois\n" +
"Que Jeremias começasse a brigar\n" +
"\n" +
"Jeremias, maconheiro sem-vergonha\n" +
"Organizou a Rockonha e fez todo mundo dançar\n" +
"Desvirginava mocinhas inocentes\n" +
"Se dizia que era crente, mas não sabia rezar\n" +
"\n" +
"E Santo Cristo há muito não ia pra casa\n" +
"E a saudade começou a apertar\n" +
"Eu vou me embora, eu vou ver Maria Lúcia\n" +
"Já tá em tempo de a gente se casar\n" +
"\n" +
"Chegando em casa então ele chorou\n" +
"E pro inferno ele foi pela segunda vez\n" +
"Com Maria Lúcia Jeremias se casou\n" +
"E um filho nela ele fez\n" +
"\n" +
"Santo Cristo era só ódio por dentro\n" +
"E então o Jeremias pra um duelo ele chamou\n" +
"Amanhã às duas horas na Ceilândia\n" +
"Em frente ao lote 14, é pra lá que eu vou\n" +
"\n" +
"E você pode escolher as suas armas\n" +
"Que eu acabo mesmo com você, seu porco traidor\n" +
"E mato também Maria Lúcia\n" +
"Aquela menina falsa pra quem jurei o meu amor\n" +
"\n" +
"E o Santo Cristo não sabia o que fazer\n" +
"Quando viu o repórter da televisão\n" +
"Que deu notícia do duelo na TV\n" +
"Dizendo a hora e o local e a razão\n" +
"\n" +
"No sábado então, às duas horas\n" +
"Todo o povo sem demora foi lá só para assistir\n" +
"Um homem que atirava pelas costas\n" +
"E acertou o Santo Cristo começou a sorrir\n" +
"\n" +
"Sentindo o sangue na garganta\n" +
"João olhou pras bandeirinhas e pro povo a aplaudir\n" +
"E olhou pro sorveteiro e pras câmeras e\n" +
"A gente da TV que filmava tudo ali\n" +
"\n" +
"E se lembrou de quando era uma criança\n" +
"E de tudo o que vivera até ali\n" +
"E decidiu entrar de vez naquela dança\n" +
"Se a Via-crucis virou circo, estou aqui\n" +
"\n" +
"E nisso o sol cegou seus olhos\n" +
"E então Maria Lúcia ele reconheceu\n" +
"Ela trazia a Winchester-22\n" +
"A arma que seu primo Pablo lhe deu\n" +
"\n" +
"Jeremias, eu sou homem, coisa que você não é\n" +
"E não atiro pelas costas, não\n" +
"Olha pra cá filho da puta, sem vergonha\n" +
"Dá uma olhada no meu sangue e vem sentir o teu perdão\n" +
"\n" +
"E Santo Cristo com a Winchester-22\n" +
"Deu cinco tiros no bandido traidor\n" +
"Maria Lúcia se arrependeu depois\n" +
"E morreu junto com João, seu protetor\n" +
"\n" +
"E o povo declarava que João de Santo Cristo\n" +
"Era santo porque sabia morrer\n" +
"E a alta burguesia da cidade\n" +
"Não acreditou na história que eles viram na TV\n" +
"\n" +
"E João não conseguiu o que queria\n" +
"Quando veio pra Brasília, com o diabo ter\n" +
"Ele queria era falar pro presidente\n" +
"Pra ajudar toda essa gente que só faz\n" +
"\n" +
"Sofrer\n" +
"Add a playlist\n" +
"Tamanho\n" +
"A\n" +
"A\n" +
"Cifra\n" +
"Imprimir\n" +
"Corrigir\n" +
"");
            
            nomes.forEach(n -> out.append(n).append("<br/>"));
        }
    }
    
    @Override    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nomes.add(req.getParameter("nome"));
        
        resp.sendRedirect("pessoa");
    }

}
