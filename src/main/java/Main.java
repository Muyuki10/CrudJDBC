import dao.ProdutoDAO;
import  model.Produto;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        int opcao;

        do{
            System.out.println("\n==========================");
            System.out.println("CRUD de produtos");
            System.out.println("\n==========================");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Excluir Produto");
            System.out.println("4- Excluir produto");
            System.out.println("5- sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Nome : ");
                    String nome = sc.nextLine();

                    System.out.println("preço : ");
                    double preco = sc.nextDouble();

                    Produto produto = new Produto(nome, preco);
                    dao.insert(produto);
                    break;
                case 2:

                    dao.select();
                    break;
                case 3:
                    System.out.println("ID : ");
                    int id = sc.nextInt();

                    System.out.println("Nome : ");
                     nome = sc.nextLine();

                    System.out.println("preço : ");
                     preco = sc.nextDouble();


                    dao.update(id,nome,preco);
                    break;
                case 4:
                    System.out.println("ID : ");
                     id = sc.nextInt();

                    dao.delete(id);
                    break;
                case 5:
                    System.out.println("ENCERRADO");

                    break;
                default:
                    System.out.println("OPCAO invalida");

            }

        }while (opcao!=5);
            sc.close();


    }
}
