package com.maroua.pharmaciegarde.ui.screens.details;

import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class PharmacyDetailsViewModel_Factory implements Factory<PharmacyDetailsViewModel> {
  private final Provider<FavoritesRepository> favoritesRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public PharmacyDetailsViewModel_Factory(Provider<FavoritesRepository> favoritesRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.favoritesRepositoryProvider = favoritesRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public PharmacyDetailsViewModel get() {
    return newInstance(favoritesRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static PharmacyDetailsViewModel_Factory create(
      Provider<FavoritesRepository> favoritesRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new PharmacyDetailsViewModel_Factory(favoritesRepositoryProvider, authRepositoryProvider);
  }

  public static PharmacyDetailsViewModel newInstance(FavoritesRepository favoritesRepository,
      AuthRepository authRepository) {
    return new PharmacyDetailsViewModel(favoritesRepository, authRepository);
  }
}
