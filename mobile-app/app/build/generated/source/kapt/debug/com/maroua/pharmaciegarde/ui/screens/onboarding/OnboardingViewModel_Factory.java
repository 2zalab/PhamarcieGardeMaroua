package com.maroua.pharmaciegarde.ui.screens.onboarding;

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
public final class OnboardingViewModel_Factory implements Factory<OnboardingViewModel> {
  private final Provider<UserPreferencesManager> userPreferencesManagerProvider;

  public OnboardingViewModel_Factory(
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    this.userPreferencesManagerProvider = userPreferencesManagerProvider;
  }

  @Override
  public OnboardingViewModel get() {
    return newInstance(userPreferencesManagerProvider.get());
  }

  public static OnboardingViewModel_Factory create(
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    return new OnboardingViewModel_Factory(userPreferencesManagerProvider);
  }

  public static OnboardingViewModel newInstance(UserPreferencesManager userPreferencesManager) {
    return new OnboardingViewModel(userPreferencesManager);
  }
}
