
package br.ifsul.edu.controle;


import br.ifsul.edu.dao.EstadoDao;
import br.ifsul.edu.model.Estado;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleEstado")
@ViewScoped
public class ControleEstado implements Serializable{
    
    private EstadoDao dao;
    private Estado objeto;
    
    public ControleEstado(){
        dao = new EstadoDao();
    }
    
    public String listar(){
        return "/privado/estado/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Estado();
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

    public EstadoDao getDao() {
        return dao;
    }

    public void setDao(EstadoDao dao) {
        this.dao = dao;
    }

    public Estado getObjeto() {
        return objeto;
    }

    public void setObjeto(Estado objeto) {
        this.objeto = objeto;
    }
}
