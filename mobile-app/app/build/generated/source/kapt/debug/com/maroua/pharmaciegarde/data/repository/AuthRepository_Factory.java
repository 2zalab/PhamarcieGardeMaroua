package com.maroua.pharmaciegarde.data.repository;

import android.content.Context;
import com.maroua.pharmaciegarde.data.local.TokenManager;
import com.maroua.pharmaciegarde.data.remote.AuthApiService;
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<AuthApiService> authApiServiceProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public AuthRepository_Factory(Provider<Context> contextProvider,
      Provider<AuthApiService> authApiServiceProvider,
      Provider<TokenManager> tokenManagerProvider) {
    this.contextProvider = contextProvider;
    this.authApiServiceProvider = authApiServiceProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(contextProvider.get(), authApiServiceProvider.get(), tokenManagerProvider.get());
  }

  public static AuthRepository_Factory create(Provider<Context> contextProvider,
      Provider<AuthApiService> authApiServiceProvider,
      Provider<TokenManager> tokenManagerProvider) {
    return new AuthRepository_Factory(contextProvider, authApiServiceProvider, tokenManagerProvider);
  }

  public static AuthRepository newInstance(Context context, AuthApiService authApiService,
      TokenManager tokenManager) {
    return new AuthRepository(context, authApiService, tokenManager);
  }
}
