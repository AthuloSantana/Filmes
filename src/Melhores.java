import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Melhores {
    public static void main(String[] args) throws Exception {
        // ====Fazer a conexão HTTP=====
        //Armazenar a URL em uma string
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //Cria um cliente
        URI endereco = URI.create(url);        
        HttpClient client = HttpClient.newHttpClient();
        // GET() que é a maneira de buscar dados do http
        HttpRequest request  = HttpRequest.newBuilder(endereco).GET().build();
        // para ler uma String
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();   

       
    
        //========Extrair dados(titulo, poster e classificação)======
        // uma espécie de dicionário em java(Map<chave, valor>)
        JParser parser = new JParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        

        //==== exibir e Manipular os dados ======
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("\n");
        }

    }
}
