package br.ifsul.edu.converter;

import br.ifsul.edu.model.Estado;
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
@FacesConverter(value = "converterEstado")
public class ConverterEstado implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("DAW-2015-2-5N1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Estado.class, Integer.parseInt(string));
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
        Estado obj = (Estado) o;
        return obj.getId().toString();
    }

}
