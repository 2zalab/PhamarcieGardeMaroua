package com.maroua.pharmaciegarde.ui.screens.settings;

import com.maroua.pharmaciegarde.data.local.AppLocaleManager;
import com.maroua.pharmaciegarde.data.local.UserPreferencesManager;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<UserPreferencesManager> userPreferencesManagerProvider;

  private final Provider<AppLocaleManager> appLocaleManagerProvider;

  public SettingsViewModel_Factory(Provider<UserPreferencesManager> userPreferencesManagerProvider,
      Provider<AppLocaleManager> appLocaleManagerProvider) {
    this.userPreferencesManagerProvider = userPreferencesManagerProvider;
    this.appLocaleManagerProvider = appLocaleManagerProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(userPreferencesManagerProvider.get(), appLocaleManagerProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<UserPreferencesManager> userPreferencesManagerProvider,
      Provider<AppLocaleManager> appLocaleManagerProvider) {
    return new SettingsViewModel_Factory(userPreferencesManagerProvider, appLocaleManagerProvider);
  }

  public static SettingsViewModel newInstance(UserPreferencesManager userPreferencesManager,
      AppLocaleManager appLocaleManager) {
    return new SettingsViewModel(userPreferencesManager, appLocaleManager);
  }
}
