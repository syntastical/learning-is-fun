package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationException;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider  {
    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flux.create(emitter -> {
            if (authenticationRequest.getIdentity().equals("sean") &&
                    authenticationRequest.getSecret().equals("password") ) {
                emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity(), List.of("admin")));
                emitter.complete();
            } else if (authenticationRequest.getIdentity().equals("nick") &&
                    authenticationRequest.getSecret().equals("word")) {
                emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity(), List.of("admin")));
                emitter.complete();
            } else {
                emitter.error(new AuthenticationException(new AuthenticationFailed()));
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }
}
