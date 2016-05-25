package br.com.fiap.api;

import java.util.List;

import fiap.com.br.newproject.Usuario;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by rm49812 on 24/05/2016.
 */
public interface GitHubAPI {

    @GET("/users/{user}")
    public void getUser(@Path("user") String user, Callback<Usuario> usuario);

    @GET("")
    public void getUsers(@Path("user") String user, Callback<List<Usuario>> listUsuario);
}
