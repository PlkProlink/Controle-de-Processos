/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */

/**
 *
 * @author User
 */
public class TesteInterface{
    
    static String usuario;
    static String senha;
    
    TesteInterface(TesteBean b) {
        this.usuario = (b.getUsuario());
        this.senha=(b.getSenha());
        execute();
    }
    void execute(){
        System.out.println(usuario);
        System.out.println(senha);
    }
}
