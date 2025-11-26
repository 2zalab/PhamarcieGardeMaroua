package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.local.FavoritesManager;
import com.maroua.pharmaciegarde.data.local.TokenManager;
import com.maroua.pharmaciegarde.data.remote.FavoritesApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class FavoritesRepository_Factory implements Factory<FavoritesRepository> {
  private final Provider<FavoritesApiService> favoritesApiServiceProvider;

  private final Provider<FavoritesManager> localFavoritesManagerProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public FavoritesRepository_Factory(Provider<FavoritesApiService> favoritesApiServiceProvider,
      Provider<FavoritesManager> localFavoritesManagerProvider,
      Provider<TokenManager> tokenManagerProvider) {
    this.favoritesApiServiceProvider = favoritesApiServiceProvider;
    this.localFavoritesManagerProvider = localFavoritesManagerProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public FavoritesRepository get() {
    return newInstance(favoritesApiServiceProvider.get(), localFavoritesManagerProvider.get(), tokenManagerProvider.get());
  }

  public static FavoritesRepository_Factory create(
      Provider<FavoritesApiService> favoritesApiServiceProvider,
      Provider<FavoritesManager> localFavoritesManagerProvider,
      Provider<TokenManager> tokenManagerProvider) {
    return new FavoritesRepository_Factory(favoritesApiServiceProvider, localFavoritesManagerProvider, tokenManagerProvider);
  }

  public static FavoritesRepository newInstance(FavoritesApiService favoritesApiService,
      FavoritesManager localFavoritesManager, TokenManager tokenManager) {
    return new FavoritesRepository(favoritesApiService, localFavoritesManager, tokenManager);
  }
}
