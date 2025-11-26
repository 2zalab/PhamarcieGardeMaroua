package com.maroua.pharmaciegarde.di;

import com.maroua.pharmaciegarde.data.local.room.PharmacyDatabase;
import com.maroua.pharmaciegarde.data.local.room.ScheduleDao;
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
public final class DatabaseModule_ProvideScheduleDaoFactory implements Factory<ScheduleDao> {
  private final Provider<PharmacyDatabase> databaseProvider;

  public DatabaseModule_ProvideScheduleDaoFactory(Provider<PharmacyDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ScheduleDao get() {
    return provideScheduleDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideScheduleDaoFactory create(
      Provider<PharmacyDatabase> databaseProvider) {
    return new DatabaseModule_ProvideScheduleDaoFactory(databaseProvider);
  }

  public static ScheduleDao provideScheduleDao(PharmacyDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideScheduleDao(database));
  }
}
