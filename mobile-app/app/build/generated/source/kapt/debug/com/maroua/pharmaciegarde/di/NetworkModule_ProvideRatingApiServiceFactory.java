package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.remote.RatingApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideRatingApiServiceFactory implements Factory<RatingApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideRatingApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public RatingApiService get() {
    return provideRatingApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideRatingApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideRatingApiServiceFactory(retrofitProvider);
  }

  public static RatingApiService provideRatingApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRatingApiService(retrofit));
  }
}
