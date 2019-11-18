package dev.jbond.quizpop.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jbond.quizpop.BuildConfig;
import dev.jbond.quizpop.model.pojo.QuestionResponse;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Quiz pop service.
 */
public interface QuizPopService {

  /**
   * Gets instance.
   *
   * @return the instance
   */
  static QuizPopService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Random question single.
   *
   * @param count the count
   * @return the single
   */
  @GET("api.php")
  Single<QuestionResponse> randomQuestion(@Query("amount") int count);

  /**
   * The type Instance holder.
   */
  class InstanceHolder {

    private static final QuizPopService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gson))
          .baseUrl(BuildConfig.Base_URL)
          .client(client)
          .build();
      INSTANCE = retrofit.create(QuizPopService.class);

    }
  }
}
