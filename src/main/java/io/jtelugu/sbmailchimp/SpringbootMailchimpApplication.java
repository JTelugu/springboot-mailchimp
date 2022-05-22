package io.jtelugu.sbmailchimp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class SpringbootMailchimpApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootMailchimpApplication.class);

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpringbootMailchimpApplication.class, args);

		String apiKey = """
				{"key": "1q40tXmZRG6LQ3dozXjdwA"}
				""";

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://mandrillapp.com/api/1.0/users/ping"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers
						.ofString(apiKey))
				.build();

		HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers
				.ofString());

		log.info("response %s ".formatted(send.body()));
	}

}
