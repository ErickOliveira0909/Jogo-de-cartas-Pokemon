public class CartaPokemon {
    public Pokemon pokemon;
    public int resultado;
    public CartaPokemon(Pokemon p){
        this.pokemon = p;
    }
    public void exibirCarta(){
       pokemon.apresentar();
    }
    public int batalhar(CartaPokemon carta2){
        
        if(pokemon.getNivel() > carta2.pokemon.getNivel()){
            resultado = 1;
            
        }
        else if(pokemon.getNivel() < carta2.pokemon.getNivel()){
            resultado = -1;
            
        }
        else if(pokemon.getNivel() == carta2.pokemon.getNivel()){
            resultado = 0;
            
        }
        return resultado;
        
    }
}
