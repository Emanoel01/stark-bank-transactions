package com.transactions.Invoice.utils.generators;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.Optional;


@Service
public class NameGenerator {


    private final WebClient webClient;

    public NameGenerator(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://gerador-nomes.herokuapp.com").build();
    }


    public String generate() {
        String names = this.webClient.get().uri("/nome/aleatorio").retrieve().bodyToMono(String.class).block();
        Gson gson = new Gson();
        String[] namesArr = gson.fromJson(names,String[].class);
        Optional<String> name = Arrays.stream(namesArr).reduce((acumulator, current ) -> {
            acumulator = acumulator + " " + current;

            return acumulator;
        });

        if(name.get() != null){
            return name.get() + " S.A";
        }

        return "Default Company Name S.A";
    }

}
