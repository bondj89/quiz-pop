package dev.jbond.quizpop.service;

// TODO  See BlackjackV2 commits oct 21-22

import dev.jbond.quizpop.BuildConfig;
import dev.jbond.quizpop.model.entity.Question;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuizPopService {

  @GET("api.php?amount=1")
  Single<Question> randomQuestion(@Query("amount") int count);


  static QuizPopService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final QuizPopService INSTANCE;


    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.Base_URL)
          .client(client)
          .build();
      INSTANCE = retrofit.create(QuizPopService.class);

    }
  }
}
