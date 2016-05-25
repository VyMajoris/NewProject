package fiap.com.br.newproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rm49812 on 24/05/2016.
 */
public class Usuario {

    @SerializedName("name")
    private String nome;

    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;




    public Usuario(String nome, String login, String avatarUrl) {
        this.nome = nome;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
