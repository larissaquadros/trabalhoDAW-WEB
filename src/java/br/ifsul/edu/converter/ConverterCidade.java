package br.ifsul.edu.converter;


import br.ifsul.edu.model.Cidade;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
@FacesConverter(value = "converterCidade")
public class ConverterCidade implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Trabalho-DAW-2-Etapa-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cidade.class, Integer.parseInt(string));
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Cidade obj = (Cidade) o;
        return obj.getId().toString();
    }

}
