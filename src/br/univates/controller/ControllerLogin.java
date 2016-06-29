/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.controller;

import br.univates.entity.Cliente;
import br.univates.entity.Session;
import br.univates.persistencia.Dao;
import br.univates.persistencia.clauses.Where;
import br.univates.persistencia.query.Insert;
import br.univates.persistencia.query.Select;
import br.univates.views.Login;
import java.util.ArrayList;

/**
 *
 * @author carlos.smolareck
 */
public class ControllerLogin {

    /**
     * @param login
     * @return um int com o valor da operação 1,2,3 ou 4
     */
    public int salvar(Login login) {
        
        Cliente cliente = new Cliente();
        cliente.setIdade(Integer.parseInt(login.getTxtIdade().getText()));
        cliente.setNome(login.getTxtNome().getText());
        
        String usuario = login.getTxtUsuario().getText();
        
        if (validarUsuario(usuario)) {
            cliente.setUsuario(usuario);
        } else {
            return 3;
        }
        
        String senha = new String(login.getTxtSenha().getPassword());
        String confirmaSenha = new String(login.getTxtConfirma().getPassword());
        
        if (this.validarSenha(senha, confirmaSenha)) {
            cliente.setSenha(senha);
        } else {
            return 4;
        }
        
        char sexo = this.validarCombo(login.getSelecSexo().getSelectedItem().toString());
        cliente.setSexo(sexo);
        
        if (!Dao.set(new Insert(cliente))) {
            return 1;
        } else {
            return 2;
        }
        
    }

    /**
     * @param login
     * @return um int com o valor da operação 1,2,3 ou 4
     */
    public int validarLogin(Login login) {
        
        Cliente cliente = new Cliente();
        
        String usuario = login.getTxtUsuarioLogin().getText();
        String senha = new String(login.getTxtSenhaLogin().getPassword());
        
        ArrayList<String[]> usuarioRet = this.validarUsuarioSenha(usuario, senha);
        
        int totalRegistros = usuarioRet.size();
        
        if (totalRegistros >= 1) {
            
            this.starSession(usuarioRet);
            
            return 1;
            
        } else {
            return 0;
        }
        
    }
    
    public void starSession(ArrayList<String[]> usuarioRet) {
        
        Cliente cli = new Cliente();
        cli.setId(Integer.parseInt(usuarioRet.get(0)[0]));
        cli.setIdade(Integer.parseInt(usuarioRet.get(0)[2]));
        cli.setNome(usuarioRet.get(0)[1].toString());
        cli.setSenha(usuarioRet.get(0)[5].toString());
        cli.setSexo(usuarioRet.get(0)[3].charAt(0));
        cli.setUsuario(usuarioRet.get(0)[4].toString());
        
        Session.setCliente(cli);
        
    }

    /**
     * @param tipo
     * @return retorna formatado o M ou F
     */
    public char validarCombo(String tipo) {
        
        if (tipo.equals("Masculino")) {
            return 'M';
        } else {
            return 'F';
        }
    }

    /**
     * @param senha
     * @param confirmaSenha
     * @return valida se as senhas conferem e retorna um boolean sucesso 1 ou
     * erro 0
     */
    public boolean validarSenha(String senha, String confirmaSenha) {
        
        if (senha.equals(confirmaSenha)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param usuario
     * @return busca se existe usuarios cliente, retorna um boolean true se nao
     * existe, false se existe usuarios reptidos
     */
    public boolean validarUsuario(String usuario) {
        
        ArrayList<String[]> usuarios = Dao.get(new Select("clientes", new String[]{"usuario"}, new Where("usuario = '" + usuario + "'")));
        
        int totalRegistros = usuarios.size();
        
        if (totalRegistros == 0) {
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * @param usuario
     * @param senha
     * @return busca se existe usuarios e senha do cliente, retorna um boolean
     * true se existe, false se não existe usuarios reptidos
     */
    public ArrayList<String[]> validarUsuarioSenha(String usuario, String senha) {
        
        ArrayList<String[]> usuarios = Dao.get(new Select("clientes", new String[]{"id", "nome", "idade", "sexo", "usuario", "senha"}, new Where("usuario = '" + usuario + "' AND senha = '" + senha + "'")));
        
        return usuarios;
    }   
}