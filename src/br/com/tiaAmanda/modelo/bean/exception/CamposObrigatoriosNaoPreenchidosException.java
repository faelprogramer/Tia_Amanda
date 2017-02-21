package br.com.tiaAmanda.modelo.bean.exception;

public class CamposObrigatoriosNaoPreenchidosException extends Exception {

    public CamposObrigatoriosNaoPreenchidosException() {
        super("Existem campos obrigatórios não preenchidos!");
    }

    public CamposObrigatoriosNaoPreenchidosException(String message) {
        super(message);
    }
    
    
    
}
