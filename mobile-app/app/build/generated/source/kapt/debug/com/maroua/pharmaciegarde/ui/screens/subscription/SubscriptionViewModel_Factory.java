package com.maroua.pharmaciegarde.ui.screens.subscription;

import com.maroua.pharmaciegarde.data.repository.AuthRepository;
import com.maroua.pharmaciegarde.data.repository.SubscriptionRepository;
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
public final class SubscriptionViewModel_Factory implements Factory<SubscriptionViewModel> {
  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public SubscriptionViewModel_Factory(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public SubscriptionViewModel get() {
    return newInstance(subscriptionRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static SubscriptionViewModel_Factory create(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new SubscriptionViewModel_Factory(subscriptionRepositoryProvider, authRepositoryProvider);
  }

  public static SubscriptionViewModel newInstance(SubscriptionRepository subscriptionRepository,
      AuthRepository authRepository) {
    return new SubscriptionViewModel(subscriptionRepository, authRepository);
  }
}
