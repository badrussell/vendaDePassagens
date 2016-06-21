/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.univates.persistencia.Dao;
import br.univates.persistencia.clauses.ClauseSQL;
import br.univates.persistencia.query.Select;
import br.univates.persistencia.query.Update;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.annotations.Where;

/**
 *
 * @author Matheus
 */
public class TestaDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

           /* Clientes p = new Clientes();
            //Voos v = new Voos();
            //Dao.setInsert(p);
            Dao.setUpdate(p);
             */

//SELECT A.nome,V.data_voo,V.valor_voo FROM voos V INNER JOIN avioes A ON V.avioes_id = A.id WHERE V.promocao != 0
        
        
        ArrayList<String[]> result = Dao.get(
                new Select("voos V INNER JOIN avioes A ON V.avioes_id = A.id ",
                    new String[]{"A.nome","V.data_voo","V.valor_voo"}, 
                        new ClauseSQL(null) {
            @Override
            public String getClause() {
                return "WHERE V.promocao != 0";
            }
        }));
                
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i)[0]);
            System.out.println(result.get(i)[1]);
        }
        
        
//        Dao.set(new Update("voos", new String[]{"promocao"}, new String[]{"1"}, "id", "1"));
        
    }
}
