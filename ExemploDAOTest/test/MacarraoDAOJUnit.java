import dao.MacarraoDAO;
import bean.Macarrao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Crispim Paiano dos Santos
 */
public class MacarraoDAOJUnit {
    
    @Test
    public void testarCadastro(){
        Macarrao nissin = new Macarrao();
        nissin.setMarca("Nissin");
        nissin.setPeso(100);
        nissin.setAldente(false);
        nissin.setTipo("Na Hora");
    
        int identificador = new MacarraoDAO().cadastrar(nissin);
        
        assertNotSame(nissin, -1);
        
        Macarrao macarraoBuscado = new MacarraoDAO().obterPeloId(identificador);
        
        // Verifica se o que foi guardado em um objeto java
        // foi o que realmente foi armazenado no banco, ou seja
        // consistir se as informações são iguais
        
        assertEquals(nissin.getMarca(), macarraoBuscado.getMarca());
        assertEquals(nissin.getPeso(), macarraoBuscado.getPeso(), 0);
        assertEquals(nissin.isAldente(), macarraoBuscado.isAldente());
        assertEquals(nissin.getTipo(), macarraoBuscado.getTipo());
        
        
    }
    
    @Test
    public void testarEdicao(){
        Macarrao magali = new Macarrao();
        magali.setMarca("Magali");
        magali.setPeso(80);
        magali.setAldente(true);
        magali.setTipo("Da Hora");
    
        int identificador = new MacarraoDAO().cadastrar(magali);
        magali.setId(identificador);
        
        magali.setMarca("Monica");
        magali.setPeso(8001);
        magali.setAldente(false);
        magali.setTipo("Na Hora");
        boolean alterado = new MacarraoDAO().alterar(magali);
        assertTrue(alterado);
        
        Macarrao macarraoBuscado = new MacarraoDAO().obterPeloId(identificador);        
        assertNotNull(macarraoBuscado);
        assertEquals(magali.getMarca() ,macarraoBuscado.getMarca());
        assertEquals(magali.getPeso()  ,macarraoBuscado.getPeso(), 0);
        assertEquals(magali.isAldente(),macarraoBuscado.isAldente());
        assertEquals(magali.getTipo()  ,macarraoBuscado.getTipo());
        
        
    }
    
    @Test
    public void testarApagar(){
        Macarrao magali = new Macarrao();
        magali.setMarca("Magali");
        magali.setPeso(80);
        magali.setAldente(true);
        magali.setTipo("Da Hora");
    
        int identificador = new MacarraoDAO().cadastrar(magali);
        boolean excluido = new MacarraoDAO().apagar(identificador);
        assertTrue(excluido);
        Macarrao macarraoBuscado = new MacarraoDAO().obterPeloId(identificador);        
        assertNull(macarraoBuscado);
    }
    
}
