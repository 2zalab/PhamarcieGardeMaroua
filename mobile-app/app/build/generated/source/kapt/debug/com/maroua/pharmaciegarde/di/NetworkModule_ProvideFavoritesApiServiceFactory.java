package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.remote.FavoritesApiService;
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
public final class NetworkModule_ProvideFavoritesApiServiceFactory implements Factory<FavoritesApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideFavoritesApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public FavoritesApiService get() {
    return provideFavoritesApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideFavoritesApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideFavoritesApiServiceFactory(retrofitProvider);
  }

  public static FavoritesApiService provideFavoritesApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideFavoritesApiService(retrofit));
  }
}
