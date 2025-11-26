package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.remote.PharmacyApiService;
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
public final class PharmacyRepository_Factory implements Factory<PharmacyRepository> {
  private final Provider<PharmacyApiService> apiServiceProvider;

  public PharmacyRepository_Factory(Provider<PharmacyApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public PharmacyRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static PharmacyRepository_Factory create(Provider<PharmacyApiService> apiServiceProvider) {
    return new PharmacyRepository_Factory(apiServiceProvider);
  }

  public static PharmacyRepository newInstance(PharmacyApiService apiService) {
    return new PharmacyRepository(apiService);
  }
}
