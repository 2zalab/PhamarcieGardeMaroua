package com.maroua.pharmaciegarde.data.repository;

import com.maroua.pharmaciegarde.data.remote.RatingApiService;
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
public final class RatingRepository_Factory implements Factory<RatingRepository> {
  private final Provider<RatingApiService> ratingApiServiceProvider;

  public RatingRepository_Factory(Provider<RatingApiService> ratingApiServiceProvider) {
    this.ratingApiServiceProvider = ratingApiServiceProvider;
  }

  @Override
  public RatingRepository get() {
    return newInstance(ratingApiServiceProvider.get());
  }

  public static RatingRepository_Factory create(
      Provider<RatingApiService> ratingApiServiceProvider) {
    return new RatingRepository_Factory(ratingApiServiceProvider);
  }

  public static RatingRepository newInstance(RatingApiService ratingApiService) {
    return new RatingRepository(ratingApiService);
  }
}
