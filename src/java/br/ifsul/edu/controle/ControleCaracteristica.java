
package br.ifsul.edu.controle;


import br.ifsul.edu.dao.CaracteristicaDao;
import br.ifsul.edu.model.Caracteristica;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleCaracteristica")
@ViewScoped
public class ControleCaracteristica implements Serializable{
    
    private CaracteristicaDao dao;
    private Caracteristica objeto;
    
    public ControleCaracteristica(){
        dao = new CaracteristicaDao();
    }
    
    public String listar(){
        return "/privado/caracteristica/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Caracteristica();
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

    public CaracteristicaDao getDao() {
        return dao;
    }

    public void setDao(CaracteristicaDao dao) {
        this.dao = dao;
    }

    public Caracteristica getObjeto() {
        return objeto;
    }

    public void setObjeto(Caracteristica objeto) {
        this.objeto = objeto;
    }
}
