package com.mycompany.cursovideoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBancoDadosDAO {
        
        public static Connection conexaoBD(){
            Connection conexao = null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //url para conectar com o banco
                String url = "jdbc:mysql://localhost:3306/cadastro?user=root&password=@Rodrig0";
                //conectar com o banco
                conexao = DriverManager.getConnection(url);
                
                
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro na ConexãoDAO" + erro);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoBancoDadosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return conexao;
        }
    
    }
