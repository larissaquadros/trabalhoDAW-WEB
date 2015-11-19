package br.ifsul.edu.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Larissa
 */
public class Util {

    public static void mensagemInformacao(String strMensagem) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, strMensagem, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public static void mensagemErro(String strMensagem) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, strMensagem, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
