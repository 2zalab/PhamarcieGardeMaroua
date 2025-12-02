package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.remote.SubscriptionApiService;
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
public final class NetworkModule_ProvideSubscriptionApiServiceFactory implements Factory<SubscriptionApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideSubscriptionApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SubscriptionApiService get() {
    return provideSubscriptionApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideSubscriptionApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideSubscriptionApiServiceFactory(retrofitProvider);
  }

  public static SubscriptionApiService provideSubscriptionApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideSubscriptionApiService(retrofit));
  }
}
