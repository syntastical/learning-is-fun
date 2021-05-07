package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationException;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider  {
    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            if ( authenticationRequest.getIdentity().equals("sean") &&
                    authenticationRequest.getSecret().equals("password") ) {
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), List.of("admin")));
                emitter.onComplete();
            } else if ( authenticationRequest.getIdentity().equals("bob") &&
                    authenticationRequest.getSecret().equals("1234") ) {
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), List.of("user")));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}
