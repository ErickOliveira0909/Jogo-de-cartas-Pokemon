import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Pokemon {
    public String nome;
    public int nivel;
    public String tipo;

    public Pokemon(String n, int ni, String t){
        this.nome = n;
        this.nivel = ni;
        this.tipo = t;
    }

    public void apresentar(){
        String msg = "Nome: " + nome + "\nNivel: " + nivel + "\nTipo: " + tipo;
        JOptionPane.showMessageDialog(null, msg,"Informações do " + nome, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("static/"+nome.toLowerCase()+".gif"));
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String name){
        this.nome = name;
    }

    public int getNivel(){
        return this.nivel;
    }
    public void setNivel(int ni){
        this.nivel = ni;
    }

    public String getType(){
        return this.tipo;
    }
    public void setType(String type){
        this.tipo = type;
    }
    

}
