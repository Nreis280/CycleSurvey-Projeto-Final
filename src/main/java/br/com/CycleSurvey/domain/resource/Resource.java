package br.com.CycleSurvey.domain.resource;

import jakarta.ws.rs.core.Response;

public interface Resource<T, U> {

    public Response findAll();

    public Response findById(U id);

    public Response persiste(T t);

}