package UFJF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabalhoDAO {

    private static Connection conexao;
    private static TrabalhoDAO instancia;

    public static TrabalhoDAO getInstance() {
        if (instancia == null) {
            instancia = new TrabalhoDAO();
        }
        return instancia;
    }

    public TrabalhoDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp04", "admin1", "admin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> listaUsuarios() {
        List<String> usuarios = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT usuario from usuarios");
            while (resultado.next()) {
                
                usuarios.add(resultado.getString("usuario"));

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
   }
void pegaInfo(){
    
}
    void create(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO tarefa(titulo) VALUES('%s')", titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM tarefa WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}