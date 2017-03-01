package br.com.tiaAmanda.modelo.exception;

public class CamposObrigatoriosNaoPreenchidosException extends Exception {

    public CamposObrigatoriosNaoPreenchidosException() {
        super("Existem campos obrigatórios não preenchidos!");
    }

    public CamposObrigatoriosNaoPreenchidosException(String message) {
        super(message);
    }
    
    
    
}
