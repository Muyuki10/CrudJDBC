package dao;
import model.Produto;
import connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {

    //CREATE
    public void insert(Produto produto){
        String sql = "INSERT INTO produtos(nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();

            System.out.println("Produto cadastrado com suceesso");
        }catch (Exception e){
            System.out.println("Erro ao cadastrar");
            e.printStackTrace();
        }


    }

    //READ
    public void select(){
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            System.out.println("===========Lista de produtos===========");
            while (rs.next()){
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nome") + " | " +
                        rs.getDouble("preço")
                );
            }


            System.out.println("FINAL");
        }catch (Exception e){
            System.out.println("Erro ao selecionar");
            e.printStackTrace();
        }


    }

    //UPDATE
    public void update(int id, String nome, double preco){
        String sql = "UPDATE  produtos SET nome=?, preco=?, WHERE id =?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ){

            stmt.setString(1, nome);
            stmt.setDouble(2,preco);
            stmt.setInt(3,id);

            stmt.executeUpdate();

            System.out.println("Produto atualizado");


        }catch (Exception e){
            System.out.println("Erro ao atualizar");
            e.printStackTrace();
        }


    }

    //DELETE
    public void delete(int id){
        String sql = "DELETE FROM produtos WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(3,id);

            stmt.executeUpdate();

            System.out.println("Produto Excluido");


        }catch (Exception e){
            System.out.println("Erro ao excluir");
            e.printStackTrace();
        }


    }

}
