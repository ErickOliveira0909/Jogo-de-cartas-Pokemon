import javax.swing.JOptionPane;

public class test {
    public void main(String [] args){
        while(true){
            for(int i = 0; i <3; i++){
                if(i == 0){
                    String message = "messagem";
                    int opcao = Integer.parseint(JOptionPane.showInputDialog(null, message, message,JOptionPane.INFORMATION_MESSAGE));
                    switch(opcao){
                        case 0:
                            break
                    }
                }
            }
        }
    }
}
