
package br.ifsul.edu.controle;


import br.ifsul.edu.dao.IndiceDao;
import br.ifsul.edu.model.Indice;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleIndice")
@ViewScoped
public class ControleIndice implements Serializable{
    
    private IndiceDao dao;
    private Indice objeto;

    
    public ControleIndice(){
        dao = new IndiceDao();
    }
    
    public String listar(){
        return "/privado/indice/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Indice();
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persistir(objeto);
            }else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            dao.remover(id);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public IndiceDao getDao() {
        return dao;
    }

    public void setDao(IndiceDao dao) {
        this.dao = dao;
    }

    public Indice getObjeto() {
        return objeto;
    }

    public void setObjeto(Indice objeto) {
        this.objeto = objeto;
    }

}
