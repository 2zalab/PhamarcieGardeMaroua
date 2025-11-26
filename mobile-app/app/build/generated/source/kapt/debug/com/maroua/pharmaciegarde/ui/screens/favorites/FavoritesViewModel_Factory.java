package com.maroua.pharmaciegarde.ui.screens.favorites;

import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.FavoritesRepository;
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository;
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
public final class FavoritesViewModel_Factory implements Factory<FavoritesViewModel> {
  private final Provider<PharmacyRepository> pharmacyRepositoryProvider;

  private final Provider<FavoritesRepository> favoritesRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public FavoritesViewModel_Factory(Provider<PharmacyRepository> pharmacyRepositoryProvider,
      Provider<FavoritesRepository> favoritesRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.pharmacyRepositoryProvider = pharmacyRepositoryProvider;
    this.favoritesRepositoryProvider = favoritesRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public FavoritesViewModel get() {
    return newInstance(pharmacyRepositoryProvider.get(), favoritesRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static FavoritesViewModel_Factory create(
      Provider<PharmacyRepository> pharmacyRepositoryProvider,
      Provider<FavoritesRepository> favoritesRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new FavoritesViewModel_Factory(pharmacyRepositoryProvider, favoritesRepositoryProvider, authRepositoryProvider);
  }

  public static FavoritesViewModel newInstance(PharmacyRepository pharmacyRepository,
      FavoritesRepository favoritesRepository, AuthRepository authRepository) {
    return new FavoritesViewModel(pharmacyRepository, favoritesRepository, authRepository);
  }
}
