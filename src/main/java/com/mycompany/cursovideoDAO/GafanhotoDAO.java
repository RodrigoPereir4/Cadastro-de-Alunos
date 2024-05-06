package com.mycompany.cursovideoDAO;

import com.mycompany.cursovideoDTO.GafanhotoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GafanhotoDAO {

    Connection conexao;
    PreparedStatement pstm;

    public ResultSet listarNacionalidade() {

        conexao = ConexaoBancoDadosDAO.conexaoBD();
        String sql = "select nacionalidade from gafanhotos group by nacionalidade";

        try {

            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ListarNacionalidade  " + ex);

            return null;
        }

    }
    
    public ResultSet listarSexo() {

        conexao = ConexaoBancoDadosDAO.conexaoBD();
        String sql = "select sexo from gafanhotos group by sexo";

        try {

            pstm = conexao.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ListarSexo  " + ex);

            return null;
        }

    }
    
    public void CadastrarGafanhoto(GafanhotoDTO objGafanhotoDTO){
        
        String sql = "insert into gafanhotos (nome,profissao,peso,altura,sexo,nacionalidade) values (?,?,?,?,?,?)";
        conexao = ConexaoBancoDadosDAO.conexaoBD();
        
        try {
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objGafanhotoDTO.getNome());
            pstm.setString(2, objGafanhotoDTO.getProfissao());
            pstm.setDouble(3, objGafanhotoDTO.getPeso());
            pstm.setDouble(4, objGafanhotoDTO.getAltura());
            pstm.setString(5, objGafanhotoDTO.getSexo());
            pstm.setString(6, objGafanhotoDTO.getNacionalidade());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "CadastroGafanhotoDAO " + ex);
        }
    }
}
