
package br.ifsul.edu.controle;



import br.ifsul.edu.dao.CidadeDao;
import br.ifsul.edu.dao.EstadoDao;
import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleCidade")
@ViewScoped
public class ControleCidade implements Serializable{
    
    private CidadeDao dao;
    private Cidade objeto;
    private EstadoDao daoEstado;
    
    public ControleCidade(){
        dao = new CidadeDao();
        daoEstado = new EstadoDao();
    }
    
    public String listar(){
        return "/privado/cidade/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Cidade();
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

    public CidadeDao getDao() {
        return dao;
    }

    public void setDao(CidadeDao dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }

    public EstadoDao getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(EstadoDao daoEstado) {
        this.daoEstado = daoEstado;
    }

    
}
