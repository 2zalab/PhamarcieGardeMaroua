package com.maroua.pharmaciegarde.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AppLocaleManager_Factory implements Factory<AppLocaleManager> {
  private final Provider<Context> contextProvider;

  private final Provider<UserPreferencesManager> userPreferencesManagerProvider;

  public AppLocaleManager_Factory(Provider<Context> contextProvider,
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    this.contextProvider = contextProvider;
    this.userPreferencesManagerProvider = userPreferencesManagerProvider;
  }

  @Override
  public AppLocaleManager get() {
    return newInstance(contextProvider.get(), userPreferencesManagerProvider.get());
  }

  public static AppLocaleManager_Factory create(Provider<Context> contextProvider,
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    return new AppLocaleManager_Factory(contextProvider, userPreferencesManagerProvider);
  }

  public static AppLocaleManager newInstance(Context context,
      UserPreferencesManager userPreferencesManager) {
    return new AppLocaleManager(context, userPreferencesManager);
  }
}
