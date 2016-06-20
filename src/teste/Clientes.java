package teste;

import br.univates.persistencia.Bd;

/**
 *
 * @author Matheus
 */
public class Clientes extends Object{

    static final String TABLE = "clientes";
    static final String PRIMARYKEY = "id";
    
    private int id = 2;
    private String nome = "Carlos";
    private int idade = 20;
    private char sexo = 'M';
    private String usuario = "teste";
    private String senha = "123456";

    @Bd
    public static String getTABLE() {
        return TABLE;
    }
    
    @Bd
    public static String getPRIMARYKEY() {
        return PRIMARYKEY;
    }
    
    @Bd
    public int getId() {
        return id;
    }

    @Bd
    public String getNome() {
        return nome;
    }

    @Bd
    public int getIdade() {
        return idade;
    }

    @Bd
    public char getSexo() {
        return sexo;
    }

    @Bd
    public String getUsuario() {
        return usuario;
    }

    @Bd
    public String getSenha() {
        return senha;
    }
    
    

    

}
