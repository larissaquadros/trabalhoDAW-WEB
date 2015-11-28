/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.CidadeDao;
import br.ifsul.edu.dao.CondominioDao;
import br.ifsul.edu.model.Condominio;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleCondominio")
@ViewScoped
public class ControleCondominio implements Serializable{
    
    private CondominioDao dao;
    private Condominio objeto;
    private CidadeDao daoCidade;
  

    public ControleCondominio() {
        dao = new CondominioDao();
        daoCidade = new CidadeDao();
    }
    
      public String listar() {
        return "/privado/condominio/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Condominio();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persistir(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e) {
            e.getStackTrace();
            Util.mensagemErro(e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            dao.remove(id);
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public CondominioDao getDao() {
        return dao;
    }

    public void setDao(CondominioDao dao) {
        this.dao = dao;
    }

    public Condominio getObjeto() {
        return objeto;
    }

    public void setObjeto(Condominio objeto) {
        this.objeto = objeto;
    }

    public CidadeDao getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDao daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    
}
