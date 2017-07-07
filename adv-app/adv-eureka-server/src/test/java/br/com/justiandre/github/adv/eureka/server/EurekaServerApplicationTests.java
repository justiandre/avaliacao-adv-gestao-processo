
package br.com.justiandre.github.adv.eureka.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ImportAutoConfiguration(exclude = ConfigClientAutoConfiguration.class)
public class EurekaServerApplicationTests {

	private static final String PATH_SERVER = "/";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void verificaStartServidor() {
		boolean requestExecutadoSucesso = this.restTemplate.getForEntity(EurekaServerApplicationTests.PATH_SERVER, Void.class).getStatusCode().is2xxSuccessful();
		Assert.assertTrue("Servidor não subiu como esperado", requestExecutadoSucesso);
	}
}