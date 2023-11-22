import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class Jogador {
    private String nome;
    public ArrayList<CartaPokemon> cartas;
    
    public Jogador(String nome){
        this.nome = nome;
        this.cartas = new ArrayList<>();

    }
    public void AdicionarCarta(CartaPokemon carta){
        cartas.add(carta);
    }

    public void RemoverCarta(CartaPokemon carta){
        cartas.remove(carta);
    }

    public int realizarBatalha(CartaPokemon cartaInimiga, int indexCarta){
        CartaPokemon cartaJogador = cartas.get(indexCarta);
        return cartaJogador.batalhar(cartaInimiga);
    }
    public int obterNumeroCartas(){
        return cartas.size();
    }
    public String getNomeJogador(){
        return nome;
    }

}
