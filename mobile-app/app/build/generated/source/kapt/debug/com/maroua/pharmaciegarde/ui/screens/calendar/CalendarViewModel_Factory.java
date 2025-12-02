package com.maroua.pharmaciegarde.ui.screens.calendar;

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
public final class CalendarViewModel_Factory implements Factory<CalendarViewModel> {
  private final Provider<PharmacyRepository> repositoryProvider;

  public CalendarViewModel_Factory(Provider<PharmacyRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CalendarViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static CalendarViewModel_Factory create(Provider<PharmacyRepository> repositoryProvider) {
    return new CalendarViewModel_Factory(repositoryProvider);
  }

  public static CalendarViewModel newInstance(PharmacyRepository repository) {
    return new CalendarViewModel(repository);
  }
}
