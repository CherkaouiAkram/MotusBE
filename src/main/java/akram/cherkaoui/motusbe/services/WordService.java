package akram.cherkaoui.motusbe.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WordService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getRandomWordByLength(int length) {
        if (length < 1 || length > 10) {
            throw new IllegalArgumentException("Length must be between 1 and 10");
        }

        String pattern = "?".repeat(length);
        String url = UriComponentsBuilder.fromHttpUrl("https://api.datamuse.com/words")
                .queryParam("sp", pattern)
                .queryParam("max", 1000)
                .toUriString();

        try {
            String json = restTemplate.getForObject(url, String.class);
            JsonNode arrayNode = objectMapper.readTree(json);
            if (arrayNode.isArray() && arrayNode.size() > 0) {
                int randomIndex = (int) (Math.random() * arrayNode.size());
                return arrayNode.get(randomIndex).get("word").asText();
            }
        } catch (Exception e) {
            System.out.println("Error fetching word: " + e.getMessage());
        }

        return null;
    }
}