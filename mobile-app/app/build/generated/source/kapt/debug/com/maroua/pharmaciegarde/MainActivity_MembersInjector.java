package com.maroua.pharmaciegarde;

import com.maroua.pharmaciegarde.data.local.UserPreferencesManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<UserPreferencesManager> userPreferencesManagerProvider;

  public MainActivity_MembersInjector(
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    this.userPreferencesManagerProvider = userPreferencesManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<UserPreferencesManager> userPreferencesManagerProvider) {
    return new MainActivity_MembersInjector(userPreferencesManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectUserPreferencesManager(instance, userPreferencesManagerProvider.get());
  }

  @InjectedFieldSignature("com.maroua.pharmaciegarde.MainActivity.userPreferencesManager")
  public static void injectUserPreferencesManager(MainActivity instance,
      UserPreferencesManager userPreferencesManager) {
    instance.userPreferencesManager = userPreferencesManager;
  }
}
