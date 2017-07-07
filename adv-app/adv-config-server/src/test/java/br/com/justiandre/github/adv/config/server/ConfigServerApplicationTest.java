
package br.com.justiandre.github.adv.config.server;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ConfigServerApplicationTest {

	private static final String PATH_GET_PROPERTIES = "/adv-eureka-server-default.properties";
	private static final String NOME_PROPERTIES = "eureka.client.fetchRegistry";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void verificaSeConfigServerEstaRecuperandoAsPropriedadesCorretamente() {
		String conteudo = this.restTemplate.getForEntity(ConfigServerApplicationTest.PATH_GET_PROPERTIES, String.class).getBody();
		Assert.assertTrue(String.format("O retorno deveria possuir o conteudo %s", ConfigServerApplicationTest.NOME_PROPERTIES), StringUtils.containsIgnoreCase(conteudo, ConfigServerApplicationTest.NOME_PROPERTIES));
	}
}