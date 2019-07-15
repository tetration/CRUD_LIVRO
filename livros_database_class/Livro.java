package livros_database_class;
import aed3.Registro;
import java.io.*;

public class Livro implements Registro {// codigo, titulo, preco, autor, publicacao, sinopse, fabricante
    protected int    codigo;
    protected String titulo;
    protected String autor;
    protected String  publicacao;// Na realidade dateformat que será convertido para string apos pegar o horario exato
    protected String sinopse;

    
    public Livro(int id, String t, String description, String date,
                 String d) {
        codigo = id;
        titulo = t;
        autor = description;
        publicacao = date;
        sinopse = d;
    }

    public Livro() {
        titulo = "";
        autor = "";
        publicacao = "";
        sinopse = "";       
    }
    
    public String getString() {
        return titulo;
    }
    
    public String toString() {
        return "\nCódigo: " + codigo +
               "\nTítulo: " + titulo +
               "\nAutor: " + autor +
               "\nData de publicacao: " + publicacao + // nao usei acento para evitar problemas com o UNICODE
               "\nsinopse: " + sinopse;
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream(dados);
        saida.writeInt(codigo);
        saida.writeUTF(titulo);
        saida.writeUTF(autor);
        saida.writeUTF(publicacao);
        saida.writeUTF(sinopse);
        return dados.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        codigo = entrada.readInt();
        titulo = entrada.readUTF();
        autor = entrada.readUTF();
        publicacao = entrada.readUTF();
        sinopse = entrada.readUTF();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int compareTo( Object b ) {
        return codigo - ((Livro)b).codigo;
    }
    public void setCodigo(int c) {
            codigo = c;
    }
        
    public int getCodigo() {
            return codigo;
    }
}
