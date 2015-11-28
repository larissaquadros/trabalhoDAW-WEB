/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.CidadeDao;
import br.ifsul.edu.dao.PessoaFisicaDao;
import br.ifsul.edu.model.PessoaFisica;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable{
    
    private PessoaFisicaDao dao;
    private PessoaFisica objeto;
    private CidadeDao daoCidade;
  

    public ControlePessoaFisica() {
        dao = new PessoaFisicaDao();
        daoCidade = new CidadeDao();
    }
    
      public String listar() {
        return "/privado/pessoafisica/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new PessoaFisica();
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

    public PessoaFisicaDao getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDao dao) {
        this.dao = dao;
    }

    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }

    public CidadeDao getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDao daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    
}
