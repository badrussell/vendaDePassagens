package br.univates.views.comprar.util;

import br.univates.entity.Passagem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassagensUtil {
    
    Map<Integer, Passagem> passagens = new HashMap<>();

    public Map<Integer, Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(Map<Integer, Passagem> passagens) {
        this.passagens = passagens;
    }
    
    public void add(Integer id, Passagem passagem){
        this.passagens.put(id, passagem);
    }
    
    public void remove(Integer id){
        this.passagens.remove(id);
    }
    
    public void limpa(){
        this.passagens = new HashMap<>();
    }
    
    public List<Passagem> listaDePassagens(){
        List<Passagem> lista = new ArrayList<>();
        for(Integer id : passagens.keySet()){
            lista.add(passagens.get(id));
        }
        
        Collections.sort(lista, new Comparador());
        
        return lista;
    }
    
}
