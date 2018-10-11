import dao.FilmeDAO;
import bean.filmeBean;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Crispim Paiano dos Santos
 */
public class FilmeJUnitTeste {
    
    FilmeDAO dao = new FilmeDAO();
    
    @Test
    public void adicionarFilme(){
        filmeBean filmezinho = new filmeBean();
        filmezinho.setNome("Kid Begala, a foda do futuro");
        filmezinho.setDiretor("Aquele cara");
        filmezinho.setCategoria("Sacanagem e Putaria");
        filmezinho.setAno((short)2011);
        filmezinho.setAtorPrincipal("Kid Bengala");
        filmezinho.setTempoFilme((short)135);
        filmezinho.setOrcamento(246999.9);
        filmezinho.setFaturamento(1124246969.9);
        filmezinho.setFaixaEtaria("Adulto");
        filmezinho.setLegenda(true);
        filmezinho.setDublado(true);
        filmezinho.setIdiomaOriginal("Português - Anal");
        
        int id = dao.cadastrar(filmezinho);
        assertNotSame(id, -1);
        
        filmezinho.setId(id);
        
        filmeBean filmaco = dao.retornarPorId(id);
        
        assertEquals(filmezinho.getId(), filmaco.getId());
        assertEquals(filmezinho.getNome(), filmaco.getNome());
        assertEquals(filmezinho.getDiretor(), filmaco.getDiretor());
        assertEquals(filmezinho.getCategoria(), filmaco.getCategoria());
        assertEquals(filmezinho.getAno(), filmaco.getAno());
        assertEquals(filmezinho.getAtorPrincipal(), filmaco.getAtorPrincipal());
        assertEquals(filmezinho.getTempoFilme(), filmaco.getTempoFilme());
        assertEquals(filmezinho.getOrcamento(), filmaco.getOrcamento(),0);
        assertEquals(filmezinho.getFaturamento(), filmaco.getFaturamento(),0);
        assertEquals(filmezinho.getFaixaEtaria(), filmaco.getFaixaEtaria());
        assertEquals(filmezinho.isLegenda(), filmaco.isLegenda());
        assertEquals(filmezinho.isDublado(), filmaco.isDublado());
        assertEquals(filmezinho.getIdiomaOriginal(), filmaco.getIdiomaOriginal());
        
    }
    
    @Test
    public void apagarFilme(){
        filmeBean filmezinho = new filmeBean();
        filmezinho.setNome("Mia Khalifa, e as mil picas");
        filmezinho.setDiretor("Arabe ");
        filmezinho.setCategoria("Gang Bang");
        filmezinho.setAno((short)2017);
        filmezinho.setAtorPrincipal("Mia Khalifa");
        filmezinho.setTempoFilme((short)69);
        filmezinho.setOrcamento(246999.9);
        filmezinho.setFaturamento(1124246969.9);
        filmezinho.setFaixaEtaria("Adulto");
        filmezinho.setLegenda(true);
        filmezinho.setDublado(true);
        filmezinho.setIdiomaOriginal("Arabe - Alahu Akbar");
        
        int id = dao.cadastrar(filmezinho);
        assertNotSame(id, -1);
        
        boolean deletado = dao.deletar(id);
        assertTrue(deletado);
        
    }
    
    @Test
    public void alterarFilme(){
        filmeBean filmezinho = new filmeBean();
        filmezinho.setNome("Alexis Texas, a gemidora do ZapZap");
        filmezinho.setDiretor("Texas Ranger");
        filmezinho.setCategoria("Hardcore");
        filmezinho.setAno((short)2015);
        filmezinho.setAtorPrincipal("Alexis Texas");
        filmezinho.setTempoFilme((short)246);
        filmezinho.setOrcamento(246999.9);
        filmezinho.setFaturamento(1124246969.9);
        filmezinho.setFaixaEtaria("Livre para Criancas");
        filmezinho.setLegenda(true);
        filmezinho.setDublado(true);
        filmezinho.setIdiomaOriginal("USA motherfucka");
        
        int id = dao.cadastrar(filmezinho);
        assertNotSame(id, -1);
        filmezinho.setId(id);
        
        filmezinho.setNome("Alexis Texas e Mia Khalifa, duelo prazeroso");
        filmezinho.setDiretor("Insanity");
        filmezinho.setCategoria("Tudo que tem direito");
        filmezinho.setAno((short)2018);
        filmezinho.setAtorPrincipal("Mia Khalifa/Alexis Texas");
        filmezinho.setTempoFilme((short)69);
        filmezinho.setOrcamento(246999.9);
        filmezinho.setFaturamento(1124246969.9);
        filmezinho.setFaixaEtaria("Adulto");
        filmezinho.setLegenda(true);
        filmezinho.setDublado(true);
        filmezinho.setIdiomaOriginal("Arabe - Alahu Akbar");
        
        boolean alterado = dao.alterar(filmezinho);
        assertTrue(alterado);
        
        filmeBean filmaco = dao.retornarPorId(id);
        assertEquals(filmezinho.getId(), filmaco.getId());
        assertEquals(filmezinho.getNome(), filmaco.getNome());
        assertEquals(filmezinho.getDiretor(), filmaco.getDiretor());
        assertEquals(filmezinho.getCategoria(), filmaco.getCategoria());
        assertEquals(filmezinho.getAno(), filmaco.getAno());
        assertEquals(filmezinho.getAtorPrincipal(), filmaco.getAtorPrincipal());
        assertEquals(filmezinho.getTempoFilme(), filmaco.getTempoFilme());
        assertEquals(filmezinho.getOrcamento(), filmaco.getOrcamento(),0);
        assertEquals(filmezinho.getFaturamento(), filmaco.getFaturamento(),0);
        assertEquals(filmezinho.getFaixaEtaria(), filmaco.getFaixaEtaria());
        assertEquals(filmezinho.isLegenda(), filmaco.isLegenda());
        assertEquals(filmezinho.isDublado(), filmaco.isDublado());
        assertEquals(filmezinho.getIdiomaOriginal(), filmaco.getIdiomaOriginal());
        
        
    }
    
}
