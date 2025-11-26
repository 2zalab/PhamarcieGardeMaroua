package com.maroua.pharmaciegarde.di;

import android.content.Context;
import com.maroua.pharmaciegarde.data.local.room.PharmacyDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvidePharmacyDatabaseFactory implements Factory<PharmacyDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvidePharmacyDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PharmacyDatabase get() {
    return providePharmacyDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvidePharmacyDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvidePharmacyDatabaseFactory(contextProvider);
  }

  public static PharmacyDatabase providePharmacyDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePharmacyDatabase(context));
  }
}
