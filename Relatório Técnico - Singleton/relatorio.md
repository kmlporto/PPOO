# Singleton 
É um padrão de criação com o objetivo de garantir que exista apenas uma instância de uma classe e propõe outra classe que servirá como único ponto de acesso a classe original.
    
Em um aplicativo típico, existem muitos objetos que precisamos apenas de uma instância global. Exemplos: OkHttpClient, HttpLogginInterceptor, Retrofit, Gson, SharedPreferences, classe de repositório, etc. Se qualquer um destes exemplos de classe for instanciado mais um objeto teremos problemas com o comportamento incorreto do aplicativo, uso excessivo de recursos e outros resultados confusos.

## Implementação

```java
public class Singleton  {
 
    private static Singleton INSTANCE = null;
 
    // other instance variables can be here
     
    private Singleton() {};
 
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return(INSTANCE);
    }
     
    // other instance methods can follow 
}
```
O construtor privado garante que não seja instânciado por terceiros, só a própria classe pode se instanciar. A variável estática INSTANCE guarda a instância da classe. O método getInstante() garante que a classe seja instanciada apenas se não já tenha sido anteriormente.

## Exemplo - Criando uma única instância de Retrofit
Retrofit - é uma biblioteca para conectar um serviço web REST, traduzindo a API em interfaces Java.
Em um aplicativo Android, precisamos de uma única instância global de um objeto Retrofit para que outras partes do aplicativo, como UserProfileActivity, ou SettingsActivity, possam usá-lo e executar uma solicitação de rede sem a necessidade de criar uma instância toda vez que precisarmos. A criação de várias instâncias poluiria o aplicativo com objetos de atualização não utilizados, ocupando, desse modo, a memória do dispositivo.

```java
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
  
public class RetrofitClient {
  
    private static Retrofit retrofit = null;
  
    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
```
No momento que o cliente A chama RetrofitClient.getClient(), é verificado se já existe 
uma instância do objeto RetrofitClient, caso não existe ele irá instanciar, caso contrário ele irá retornar o objeto que já havia sido criado anteriormente, no lugar de criar um novo.

### Problema de mult-threading
No sistema Android podemos separar vários segmentos para executar tarefas diferentes. Esses encadeamentos podem acabar executando o mesmo bloco de código simultaneamente. No caso da classe Singleton acima, isso poderia levar à criação de várias instâncias de objetos, o que viola o contrato de um Singleton.

### Sincronize
Uma das maneiras de tornar uma classe Singleton segura é tornar o método getInstance() sincronizado. Assim, apenas um thread executa o método por vez, forçando todos os outros segmentos a aguardarem um estado bloqueado.

### Criar uma instância imediatamente
Outra abordagem para lidar com vários encadeamentos que acessem o singleton é criar a instância imediatamente quando a classe é carregada ou inicializada (pelo Android ClassLoader na VM). Isso torna o segmento de código seguro e a instância do objeto estará disponível antes de qualquer thread acessar a variavél. Porém, podemos está criando um objeto que nunca será usado, ocupando memória desnecessária.

### Usando Dagger 2
Uma biblioteca de injeção de dependência, Dagger, pode ajudar a conectar dependências de objetos e criar Singletons usando a anotação @Singleton, garantindo que o objeto seja inicializado apenas uma vez em todo o ciclo de vida do aplicativo.

```java
@Module
public class NetworkModule {
 
    @Provides
    @Singleton
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
 
    @Provides
    @Singleton
    public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                message -> Timber.i(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
 
    @Provides
    @Singleton
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cache
    }
 
    @Provides
    @Singleton
    public File cacheFile(@ApplicationContext Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }
 
    @Provides
    @Singleton
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
 
    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("you/base/url")
                .build();
    }
}
```