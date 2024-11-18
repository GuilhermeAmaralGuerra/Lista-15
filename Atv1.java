import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Atv1{
    public static void main(String[] args) {
        try {
            String nome = "Guilherme Guerra";
            String curso = "Engenharia de Software";
            String expectativas = "Conseguir um trabalho descente!";
    
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); 
            SecretKey chave = keyGen.generateKey();
    
            Cipher cipher = Cipher.getInstance("AES");
    
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            byte[] nomeCriptografado = cipher.doFinal(nome.getBytes());
            String nomeCriptografadoString = Base64.getEncoder().encodeToString(nomeCriptografado);
    
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            byte[] cursoCriptografado = cipher.doFinal(curso.getBytes());
            String cursoCriptografadoString = Base64.getEncoder().encodeToString(cursoCriptografado);
    
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            byte[] expectativasCriptografado = cipher.doFinal(expectativas.getBytes());
            String expectativasCriptografadoString = Base64.getEncoder().encodeToString(expectativasCriptografado);
    
            System.out.println("Texto Original: " + nome);
            System.out.println("Texto Criptografado: " + nomeCriptografadoString);
            System.out.println("______________________");
    
            System.out.println("Texto Original: " + curso);
            System.out.println("Texto Criptografado: " + cursoCriptografadoString);
            System.out.println("______________________");
    
            System.out.println("Texto Original: " + expectativas);
            System.out.println("Texto Criptografado: " + expectativasCriptografadoString);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}