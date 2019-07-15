package livros_database_class;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import aed3.*;
import aed3.ArquivoIndexado;

public class ControleDeLivros {
    
    private static Scanner console = new Scanner(System.in);
    private static ArquivoIndexado<Livro> arqLivros;

    public static void main(String[] args) {

        try {
           arqLivros = new ArquivoIndexado<>(Livro.class, "Livros.db", "Livros1.idx", "Livros2.idx");
           
            // menu
            int opcao;
            do {
               System.out.println("\n\nCONTROLE DE LivroS");
               System.out.println("----------------------\n");
               System.out.println("1 - Listar");
               System.out.println("2 - Incluir");
               System.out.println("3 - Alterar");
               System.out.println("4 - Excluir");
               System.out.println("5 - Buscar por código de Livro");
               System.out.println("6 - Buscar por Nome de Livro");
               System.out.println("9 - Reorganizar arquivo");
               System.out.println("0 - Sair");
               System.out.print("\nOpcao: ");
               opcao = Integer.valueOf(console.nextLine());
               
               switch(opcao) {
                   case 1: listarLivros(); break;
                   case 2: incluirLivros(); break;
                   case 3: alterarLivros(); break;
                   case 4: excluirLivro(); break;
                   case 5: buscarLivroCodigo(); break;
                   case 6: buscarLivroTitulo(); break;
                   case 9: reorganizar(); break;
                   case 0: break;
                   default: System.out.println("Opção inválida");
               }
               
           } while(opcao != 0);
       } catch(Exception e) {
           e.printStackTrace();
       }
       
   }
   
   // PROJETOS
   
   public static void listarLivros() throws Exception {
       
       Object[] obj = arqLivros.listar();
       
       System.out.println("\nLISTA DE LivroS");
       for(int i=0; i<obj.length; i++) {
           System.out.println((Livro)obj[i]);
       }
       pausa();
       
   }
   
    public static void incluirLivros() throws Exception {
       
        int    codigo;
        String titulo;
        String autor ;           
        String publicacao;
        String sinopse;
       
        System.out.println("\nINCLUSAO DE LIVRO NA BASE DE DADOS");
        System.out.print("Nome: ");
        titulo = console.nextLine();


        System.out.println("Autor do Livro: ");
        autor = console.nextLine();

        System.out.print("publicacao do Livro: ");
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        publicacao =  formatter.format(date);
        System.out.print("A data de publicacao colocada sera: " + publicacao +"\n");

        System.out.print("Sinopse do livro(fale um pouco do conteudo do livro): ");
        sinopse = console.nextLine();
    

        System.out.print("\nConfirma inclusão? digite s ou S ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Livro obj = new Livro(-1, titulo, autor, publicacao, sinopse);
            int cod = arqLivros.incluir(obj);
            System.out.println("Livro incluído com código: " + cod);
        }

        pausa();
    }

   
   public static void alterarLivros() throws Exception {
       
       System.out.println("\nALTERACAO DE Livro");

       int codigo;
       System.out.print("Código: ");
       codigo = Integer.valueOf(console.nextLine());
       if(codigo <=0) 
           return;
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscarCodigo(codigo))!=null ) {
            System.out.println(obj);
            
            String titulo;
            String autor;
            String  publicacao;
            String sinopse;
           
            System.out.println("\nALTERACAO DE LIVRO");
            System.out.print("Novo Nome para Livro: ");
            titulo = console.nextLine();
    

             System.out.println("Novo autor do Livro: ");
             autor = console.nextLine();


             System.out.print("Nova publicacao do Livro: ");
             Date date = new Date();  
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             publicacao =  formatter.format(date);
             System.out.print("A data  nova de publicacao colocada sera: " + publicacao);
             

             System.out.print("Nova sinopse do livro(fale um pouco do conteudo do livro): ");
             sinopse = console.nextLine();


            if(titulo.length()>0 || autor.length() > 0 || sinopse.length() > 0) {
                System.out.print("\nConfirma alteração? digite s ou S ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='s' || confirma=='S') {

                obj.titulo  = (titulo.length()>0 ? titulo : obj.titulo);
                obj.autor = (autor.length()>0 ? autor : obj.autor);
                obj.sinopse   = (sinopse.length()>=0 ? sinopse:obj.sinopse);

                if( arqLivros.alterar(obj) ) 
                        System.out.println("Livro alterado.");
                    else
                        System.out.println("Livro não pode ser alterado.");
                }
            }
       }
       else
           System.out.println("ERROR: Product NOT FOUND/Livro NAO ENCONTRADO");
       pausa();
       
   }
  
   
   public static void excluirLivro() throws Exception {
       
       System.out.println("\nEXCLUSÃO DE Livro");

       int codigo;
       System.out.print("Código: ");
       codigo = Integer.valueOf(console.nextLine());

       if(codigo <=0) 
           return;
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscarCodigo(codigo))!=null ) {
            System.out.println(obj);
            
            System.out.print("\nConfirma exclusão? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                if( arqLivros.excluir(codigo) ) {
                    System.out.println("Product deleted from database/Livro excluído da database.");
                }
            }
       }
       else
           System.out.println("Error Class not found/Livro não encontrado");
       pausa();  
   }
   
   
   public static void buscarLivroCodigo() throws Exception {
       
       System.out.println("\nBUSCA DE LIVRO POR CÓDIGO");
       
       int codigo;
       System.out.print("Código: ");
       codigo = Integer.valueOf(console.nextLine());
       if(codigo <=0) 
           return; 
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscarCodigo(codigo))!=null )
           System.out.println(obj);
       else
           System.out.println("Error Class not found/Livro não encontrado");
       pausa();
   }

   public static void buscarLivroTitulo() throws Exception {
       
       System.out.println("\nBUSCA DE Livro POR Nome");
       
       String titulo;
       System.out.print("Nome: ");
       titulo = console.nextLine();
       if(titulo.compareTo("")==0) 
           return;
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscarString(titulo))!=null )
           System.out.println(obj);
       else
           System.out.println("Livro não encontrado");
       pausa();
   }

   
    public static void reorganizar() throws Exception {

        System.out.println("\nREORGANIZAÇÃO");
        arqLivros.reorganizar();
        System.out.println("\nArquivo reorganizado");
        pausa();
    
    }
   
    public static void pausa() throws Exception {
        System.out.println("\nPressione ENTER para continuar ...");
        console.nextLine();
    }
}
