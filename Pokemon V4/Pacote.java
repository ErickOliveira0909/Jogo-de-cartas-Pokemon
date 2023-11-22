import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Pacote {
    public int numJogador;
    
    public Pacote(int numJogador){
        this.numJogador = numJogador;
    }
    public String criarNomeJogador(int numJogador){
        ImageIcon icon = new ImageIcon("static/jogador"+numJogador+".gif");
        return (String) JOptionPane.showInputDialog(null,"Informe o seu nome, "+numJogador+"° Jogador: " ,"Informe o seu nome",JOptionPane.INFORMATION_MESSAGE,icon,null,"");
    }
    public String criarCaixaInput(String nome_arquivo, String message,String titulo){
        ImageIcon icon = new ImageIcon("static/"+nome_arquivo.toLowerCase()+".gif");
        return (String) JOptionPane.showInputDialog(null,message,titulo, JOptionPane.INFORMATION_MESSAGE,icon,null,"");
    }
}
