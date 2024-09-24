import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrapingService {

    private static final String URL = "https://webscraper.io/test-sites/e-commerce/static/computers/laptops";

    public List<Notebook> scrapeLenovoNotebooks() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Erro ao acessar a página: " + response);

            String html = response.body().string();
            Document doc = Jsoup.parse(html);

            Elements products = doc.select(".thumbnail"); // Seleciona todos os elementos de produtos

            List<Notebook> notebooks = new ArrayList<>();

            for (Element product : products) {
                // Verifica se o título do produto contém 'Lenovo'
                String title = product.select(".title").text();
                if (title.toLowerCase().contains("lenovo")) {

                    String description = product.select(".description").text();
                    String priceText = product.select(".price").text().replace("$", ""); // Remove o símbolo de dólar
                    double price = Double.parseDouble(priceText);

                    // Pega informações adicionais, se disponíveis
                    String link = product.select(".title").attr("href"); // Link do produto
                    String reviewsText = product.select(".ratings p").text(); // Reviews
                    String ratingText = product.select(".ratings .rating").attr("data-rating"); // Avaliação (se presente)

                    Notebook notebook = new Notebook(title, description, price, link, reviewsText, ratingText);
                    notebooks.add(notebook);
                }
            }

            // Ordenar os notebooks pelo preço, do mais barato para o mais caro
            return notebooks.stream()
                    .sorted((n1, n2) -> Double.compare(n1.getPrice(), n2.getPrice()))
                    .collect(Collectors.toList());
        }
    }
}
