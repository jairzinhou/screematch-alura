package br.com.alura.screematch;

import br.com.alura.screematch.model.DadosSerie;
import br.com.alura.screematch.service.ConsumoApi;
import br.com.alura.screematch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreematchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie.avaliacao());
	}
}
