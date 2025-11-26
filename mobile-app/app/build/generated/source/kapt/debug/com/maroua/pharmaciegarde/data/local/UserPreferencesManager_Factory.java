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
public final class UserPreferencesManager_Factory implements Factory<UserPreferencesManager> {
  private final Provider<Context> contextProvider;

  public UserPreferencesManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UserPreferencesManager get() {
    return newInstance(contextProvider.get());
  }

  public static UserPreferencesManager_Factory create(Provider<Context> contextProvider) {
    return new UserPreferencesManager_Factory(contextProvider);
  }

  public static UserPreferencesManager newInstance(Context context) {
    return new UserPreferencesManager(context);
  }
}
