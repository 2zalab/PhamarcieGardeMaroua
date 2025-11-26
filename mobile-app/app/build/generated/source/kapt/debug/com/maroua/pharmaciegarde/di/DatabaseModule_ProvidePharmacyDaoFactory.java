package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.local.room.PharmacyDao;
import com.maroua.pharmaciegarde.data.local.room.PharmacyDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvidePharmacyDaoFactory implements Factory<PharmacyDao> {
  private final Provider<PharmacyDatabase> databaseProvider;

  public DatabaseModule_ProvidePharmacyDaoFactory(Provider<PharmacyDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PharmacyDao get() {
    return providePharmacyDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvidePharmacyDaoFactory create(
      Provider<PharmacyDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePharmacyDaoFactory(databaseProvider);
  }

  public static PharmacyDao providePharmacyDao(PharmacyDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePharmacyDao(database));
  }
}
