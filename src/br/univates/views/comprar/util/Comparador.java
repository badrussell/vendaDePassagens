package br.univates.views.comprar.util;

import br.univates.entity.Passagem;
import java.util.Comparator;


public class Comparador implements Comparator<Passagem>{

    @Override
    public int compare(Passagem o1, Passagem o2) {
                
        return (o1.getPoltronas()+ "").compareTo(o2.getPoltronas() + "");
    
    }
    
}
