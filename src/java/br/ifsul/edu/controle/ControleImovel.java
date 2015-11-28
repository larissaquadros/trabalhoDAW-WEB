/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.CaracteristicaDao;
import br.ifsul.edu.dao.CidadeDao;
import br.ifsul.edu.dao.CondominioDao;
import br.ifsul.edu.dao.ImovelDao;
import br.ifsul.edu.dao.PessoaFisicaDao;
import br.ifsul.edu.dao.PessoaJuridicaDao;
import br.ifsul.edu.model.Caracteristica;
import br.ifsul.edu.model.Imovel;
import br.ifsul.edu.model.ImovelCaracteristica;
import br.ifsul.edu.model.Pessoa;
import br.ifsul.edu.model.PessoaFisica;
import br.ifsul.edu.model.PessoaJuridica;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleImovel")
@ViewScoped
public class ControleImovel implements Serializable{
    
    private ImovelDao dao;
    private Imovel objeto;
    private CidadeDao daoCidade;
    private CondominioDao daoCondominio;
    private PessoaFisicaDao daoPessoaFisica;
    private PessoaJuridicaDao daoPessoaJuridica;
    private ImovelCaracteristica caracteristicaImovel;
    private Boolean novaCaracteristica;
    private CaracteristicaDao daoCaracteristica;
    private Caracteristica caracteristica;
      

    public ControleImovel() {
        dao = new ImovelDao();
        daoCidade = new CidadeDao();
        daoCondominio = new CondominioDao();
        daoPessoaFisica = new PessoaFisicaDao();
        daoPessoaJuridica = new PessoaJuridicaDao();
        daoCaracteristica = new CaracteristicaDao();
    }
    
      public String listar() {
        return "/privado/imovel/listar?faces-redirect=true";
    }
      
    public void novaCaracteristica(){
        caracteristicaImovel = new ImovelCaracteristica();
        novaCaracteristica = true;   
    }
    
    public void salvarCaracteristica(){
        if(novaCaracteristica){
           objeto.adicionarCaracteristica(caracteristicaImovel);
        }
        Util.mensagemInformacao("Caracteristica adicionado com sucesso");
    }

    public void removercaracteristica(int index){
        objeto.removerCaracteristica(index);
        Util.mensagemInformacao("Item removido com sucesso");
    }

    public void novo() {
        objeto = new Imovel();
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
    
    public void definirPF(PessoaFisica obj){
        Pessoa p = (Pessoa) obj;
        objeto.setProprietario(p);
    }
    
    public void definirPJ(PessoaJuridica obj){
        Pessoa p = (Pessoa) obj;
        objeto.setProprietario(p);
    }
    
    public void remover(Integer id){
        try {
            dao.remover(id);
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public ImovelDao getDao() {
        return dao;
    }

    public void setDao(ImovelDao dao) {
        this.dao = dao;
    }

    public Imovel getObjeto() {
        return objeto;
    }

    public void setObjeto(Imovel objeto) {
        this.objeto = objeto;
    }

    public CidadeDao getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDao daoCidade) {
        this.daoCidade = daoCidade;
    }

    public CondominioDao getDaoCondominio() {
        return daoCondominio;
    }

    public void setDaoCondominio(CondominioDao daoCondominio) {
        this.daoCondominio = daoCondominio;
    }

    public PessoaFisicaDao getDaoPessoaFisica() {
        return daoPessoaFisica;
    }

    public void setDaoPessoaFisica(PessoaFisicaDao daoPessoaFisica) {
        this.daoPessoaFisica = daoPessoaFisica;
    }

    public PessoaJuridicaDao getDaoPessoaJuridica() {
        return daoPessoaJuridica;
    }

    public void setDaoPessoaJuridica(PessoaJuridicaDao daoPessoaJuridica) {
        this.daoPessoaJuridica = daoPessoaJuridica;
    }


    public CaracteristicaDao getDaoCaracteristica() {
        return daoCaracteristica;
    }

    public void setDaoCaracteristica(CaracteristicaDao daoCaracteristica) {
        this.daoCaracteristica = daoCaracteristica;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Boolean getNovaCaracteristica() {
        return novaCaracteristica;
    }

    public void setNovaCaracteristica(Boolean novaCaracteristica) {
        this.novaCaracteristica = novaCaracteristica;
    }

    public ImovelCaracteristica getCaracteristicaImovel() {
        return caracteristicaImovel;
    }

    public void setCaracteristicaImovel(ImovelCaracteristica caracteristicaImovel) {
        this.caracteristicaImovel = caracteristicaImovel;
    }

    
    
    
    
}
