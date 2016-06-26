package br.univates.views.comprar.util;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;

public class AssentosUtil {
    
    private Map<Integer, JCheckBox> assentos = new HashMap<>();
    private Map<Integer, Integer> categorias = new HashMap<>();

    public Map<Integer, JCheckBox> getAssentos() {
        return assentos;
    }

    public void setAssentos(Map<Integer, JCheckBox> assentos) {
        this.assentos = assentos;
    }

    public Map<Integer, Integer> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<Integer, Integer> categorias) {
        this.categorias = categorias;
    }
    
    public void add(Integer id, JCheckBox assento, Integer categoria){
        assentos.put(id, assento);
        categorias.put(id, categoria);
    }
    
    public void remove(Integer id){
        assentos.remove(id);
        categorias.remove(id);
    }
    
    public int getCetegoriasId(Integer id){
        return categorias.get(id);
    }
    
    public JCheckBox getAssentoAt(Integer id){
        return assentos.get(id);
    }
}
