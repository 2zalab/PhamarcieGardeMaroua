package com.maroua.pharmaciegarde.ui.viewmodel;

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
public final class PharmacyViewModel_Factory implements Factory<PharmacyViewModel> {
  private final Provider<PharmacyRepository> repositoryProvider;

  public PharmacyViewModel_Factory(Provider<PharmacyRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PharmacyViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PharmacyViewModel_Factory create(Provider<PharmacyRepository> repositoryProvider) {
    return new PharmacyViewModel_Factory(repositoryProvider);
  }

  public static PharmacyViewModel newInstance(PharmacyRepository repository) {
    return new PharmacyViewModel(repository);
  }
}
