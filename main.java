import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.Random;

public class main{
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "BEM VINDO(A) AO JOGO POKEMON!","BEM VINDO(A)!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/pokeball.gif"));
        //Criando Pokemons

        Pokemon pikachu = new Pokemon("Pikachu", 25, "Elétrico");
        Pokemon charmander = new Pokemon("Charmander", 15, "Fogo");
        Pokemon bullbasaur = new Pokemon("Bullbasaur", 15, "Planta/Venenoso");
        Pokemon charizard = new Pokemon("Charizard", 35, "Fogo");
        Pokemon eevee = new Pokemon("Eevee", 5, "Normal");
        Pokemon mewtwo = new Pokemon("Mewtwo", 75, "Psíquico");

        // Criando Cartas

        CartaPokemon cartaPikachu = new CartaPokemon(pikachu);
        CartaPokemon cartaCharmander = new CartaPokemon(charmander);
        CartaPokemon cartaBullbasaur = new CartaPokemon(bullbasaur);
        CartaPokemon cartaCharizard = new CartaPokemon(charizard);
        CartaPokemon cartaEevee = new CartaPokemon(eevee);
        CartaPokemon cartaMewtwo = new CartaPokemon(mewtwo);

        // Adicionando Cartas ao vetor
        ArrayList<CartaPokemon> todasCartas;
        todasCartas = new ArrayList<>();
        todasCartas.add(cartaPikachu);
        todasCartas.add(cartaCharmander);
        todasCartas.add(cartaBullbasaur);
        todasCartas.add(cartaCharizard);
        todasCartas.add(cartaEevee);
        todasCartas.add(cartaMewtwo);


        //Criando Jogador 1
        Pacote Criar = new Pacote(1);
        String nomejogador1 = Criar.criarNomeJogador(1);
        if(nomejogador1.trim().isEmpty()){
            while(nomejogador1.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o seu nome corretamente", "ERROR",JOptionPane.ERROR_MESSAGE);
                nomejogador1 = Criar.criarNomeJogador(1);
            }
        }
        Jogador jogador1 = new Jogador(nomejogador1);

        // Criando Jogador 2
        String nomejogador2 = Criar.criarNomeJogador(2);
        if(nomejogador2.trim().isEmpty()){
            while(nomejogador2.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o seu nome corretamente", "ERROR",JOptionPane.ERROR_MESSAGE);
                nomejogador2 = Criar.criarNomeJogador(2);
            }
        }
        Jogador jogador2 = new Jogador(nomejogador2);

        // Atribuindo Cartas ao  jogador 1
        Random random = new Random();
        int numero;
        CartaPokemon carta;
        ArrayList<Integer> numerosAleatorios;
        numerosAleatorios = new ArrayList<>();

        for(int i = 0; i <= 2; i++){
            if(i == 0){
                numero = random.nextInt(6);
                numerosAleatorios.add(numero);
                carta = todasCartas.get(numero);
                jogador1.AdicionarCarta(carta);
            }
            else if(i > 0){
                while(true){
                    numero = random.nextInt(6);
                    if(numerosAleatorios.contains(numero) == false){
                        carta = todasCartas.get(numero);
                        jogador1.AdicionarCarta(carta);
                        numerosAleatorios.add(numero);
                        break;
                    }
                }
            }
        }
        // Vendo cartas do jogador 1
        //CartaPokemon cartarJogador1;
        //for(int i = 0; i < 3 ; i++){
            //cartarJogador1 = jogador1.cartas.get(i);
            //cartarJogador1.exibirCarta();
       // }
        
        //Adicionando carta ao jogador 2
        for(int i = 0; i <= 2; i++){
            if(i == 0){
                numero = random.nextInt(6);
                numerosAleatorios.add(numero);
                carta = todasCartas.get(numero);
                jogador2.AdicionarCarta(carta);
            }
            else if(i > 0){
                while(true){
                    numero = random.nextInt(6);
                    if(numerosAleatorios.contains(numero) == false){
                        carta = todasCartas.get(numero);
                        jogador2.AdicionarCarta(carta);
                        numerosAleatorios.add(numero);
                        break;
                    }
                }
            }
        }
       

        // Menu de seleção
        String mensagem = "[ 0 ] Exibir cartas\n[ 1 ] Obter numero de cartas\n[ 2 ] Adicionar carta\n[ 3 ] Apagar Carta\n[ 4 ] Realizar batalhas\n[ 5 ] Sair";
        int opcao1 = 0;
        while(opcao1 != 5){
            opcao1 = Integer.parseInt(JOptionPane.showInputDialog(null,mensagem,"Escolha uma opção", JOptionPane.INFORMATION_MESSAGE));
            switch(opcao1){
                case 0:
                    for(int i = 0; i < jogador1.cartas.size(); i++){
                        jogador1.cartas.get(i).exibirCarta();
                    }
                    break;
                case 1:
                    
                    JOptionPane.showMessageDialog(null, jogador1.obterNumeroCartas(),"Numero de cartas", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/pokeball.gif"));
                    break;
                case 2:
                    
                    String nomePokemon = JOptionPane.showInputDialog(null,"Informe o nome do Pokemon: ","Informe o nome do pokemon", JOptionPane.INFORMATION_MESSAGE);
                    int nivelPokemon = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o nivel do Pokemon: ","Informe o nivel do pokemon", JOptionPane.INFORMATION_MESSAGE));
                    String tipoPokemon = JOptionPane.showInputDialog(null,"Informe o tipo do Pokemon: ","Informe o tipo do pokemon", JOptionPane.INFORMATION_MESSAGE);

                    Pokemon novoPokemon = new Pokemon(nomePokemon, nivelPokemon,tipoPokemon);
                    CartaPokemon novaCarta = new CartaPokemon(novoPokemon);
                    if(jogador1.cartas.size() < 6){
                        jogador1.AdicionarCarta(novaCarta);
                        JOptionPane.showMessageDialog(null, "CARTA POKEMON CRIADA COM SUCESSO!","CARTA POKEMON CRIADA COM SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "IMPOSSIVEL ADICIONAR MAIS CARTAS,\nPOIS O JOGADOR JÁ POSSUI 6!","ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                case 3:
                    for(int i = 0; i < jogador1.cartas.size(); i++){
                        String msg2 = "Nome: " + jogador1.cartas.get(i).pokemon.getNome()+"\nNivel: " + jogador1.cartas.get(i).pokemon.getNivel()+"\nTipo: "+ jogador1.cartas.get(i).pokemon.getType()+"\n\nApagar carta?\n[ S ] Sim\n[ N ] Não";
                        String nomePokemon2 = jogador1.cartas.get(i).pokemon.getNome();
                        String perg = Criar.criarCaixaInput(nomePokemon2,msg2, "Apagar Carta Pokemon");
                        perg = perg.trim().toUpperCase();
                        System.out.println(perg);
                        if (perg.equals("S")){
                            CartaPokemon carta3 =  jogador1.cartas.get(i);
                            if(jogador1.cartas.size() > 1){
                                jogador1.RemoverCarta(carta3);
                                i--;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "IMPOSSIVEL APAGAR CARTA,\nPOIS O JOGADOR FICARÁ SEM CARTAS!!","ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                    break;
                case 4:
                    int vitoriasJogador1 = 0;
                    int vitoriasJogador2 = 0;
                    String opcao2 = "";
                    int indexCarta = 0;
                    while(opcao2.toUpperCase().equals("S") || opcao2.equals("")){
                        for(int i = 0; i < jogador1.cartas.size(); i++){
                            String msg2 = "Nome: " + jogador1.cartas.get(i).pokemon.getNome()+"\nNivel: " + jogador1.cartas.get(i).pokemon.getNivel()+"\nTipo: "+ jogador1.cartas.get(i).pokemon.getType()+"\n\nEscolher carta?\n[ S ] Sim\n[ N ] Não";
                            String nomePokemon2 = jogador1.cartas.get(i).pokemon.getNome();
                            String perg = Criar.criarCaixaInput(nomePokemon2,msg2, "Apagar Carta Pokemon");
                            perg = perg.trim().toUpperCase();
                            System.out.println(perg);
                            if (perg.equals("S")){
                                indexCarta = i;
                                i = jogador1.cartas.size()-1;
                            }
                        }
    
                        numero = random.nextInt(3);
                        CartaPokemon cartaInimiga = jogador2.cartas.get(numero);
                        int batalha = jogador1.realizarBatalha(cartaInimiga, indexCarta);
                        if(batalha == 1){
                            JOptionPane.showMessageDialog(null, jogador1.cartas.get(indexCarta).pokemon.getNome().toUpperCase()+" VENCEU!!\n+1 VITORIA PARA "+jogador1.getNomeJogador().toUpperCase(),"VITORIA", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/"+jogador1.cartas.get(indexCarta).pokemon.getNome().toLowerCase()+".gif"));
                            vitoriasJogador1 ++;
                        }
                        else if(batalha == -1){
                            JOptionPane.showMessageDialog(null, cartaInimiga.pokemon.getNome().toUpperCase()+" VENCEU!!\n+1 VITORIA PARA "+jogador2.getNomeJogador().toUpperCase(),"VITORIA", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/"+cartaInimiga.pokemon.getNome().toLowerCase()+".gif"));
                            vitoriasJogador2 ++;
                        }
                        else if(batalha == 0){
                            JOptionPane.showMessageDialog(null, "EMPATE!!","EMPATE", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/pokeball.gif"));
                        }
                        System.out.println(batalha);
                        opcao2 = Criar.criarCaixaInput("pokeball","Deseja continuar?\n[ S ] Sim\n[ N ] Não", "Pergunta");

                        
                    }
                    if(vitoriasJogador1 > vitoriasJogador2){
                        JOptionPane.showMessageDialog(null, jogador1.getNomeJogador().toUpperCase()+" VENCEU!!\nTotal de vitorias: "+vitoriasJogador1,"   RESULTADO: VITÓRIA DE " + jogador1.getNomeJogador().toUpperCase(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/jogador1.gif"));
                    }
                    else if(vitoriasJogador2>vitoriasJogador1){
                        JOptionPane.showMessageDialog(null, jogador2.getNomeJogador().toUpperCase()+" VENCEU!!\nTotal de vitorias: "+vitoriasJogador2,"   RESULTADO: VITÓRIA DE " + jogador2.getNomeJogador().toUpperCase(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/jogador2.gif"));
                    }
                    else if(vitoriasJogador1==vitoriasJogador2){
                        JOptionPane.showMessageDialog(null, "EMPATE!!","   RESULTADO: EMPATE!!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/pokeball.gif"));
                    }
                    break;
                case 5:
                    break;
                }
        }
        
}}