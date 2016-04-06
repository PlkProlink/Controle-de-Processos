/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */

/**
 *
 * @author User
 */
public class TesteLogin {
    
    public static void main(String[] args){
        TesteBean b = new TesteBean();
        b.setSenha("12345");
        b.setUsuario("Mario");
        Menu menu = new Menu();
        //Menu(b);
        menu.setVisible(true);
    }
    public TesteLogin(){
        
    }
}
