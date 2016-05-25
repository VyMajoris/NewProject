package fiap.com.br.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.fiap.api.GitHubAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProfileGithubActivity extends AppCompatActivity {


    ImageView ivUsuario;
    Button btPesquisar;
    EditText etNomeUsuario;
    TextView tvNomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_github);


        ivUsuario = (ImageView) findViewById(R.id.ivUsuario);
        btPesquisar = (Button) findViewById(R.id.btPesquisar);
        etNomeUsuario = (EditText) findViewById(R.id.etNomeUsuario);
        tvNomeUsuario = (TextView) findViewById(R.id.tvNomeUsuario);

        btPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
                GitHubAPI api = restAdapter.create(GitHubAPI.class);

                api.getUser(etNomeUsuario.getText().toString(), new Callback<Usuario>() {
                    @Override
                    public void success(Usuario usuario, Response response) {
                        tvNomeUsuario.setText(usuario.getNome());
                        Picasso.with(ProfileGithubActivity.this).load(usuario.getAvatarUrl()).placeholder(R.drawable.ic_tag_faces_black_24dp).error(R.drawable.ic_block_black_24dp).into(ivUsuario);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(ProfileGithubActivity.this, "Error",Toast.LENGTH_LONG).show();
                        System.out.println("error:::"+ error);
                    }
                });
            }
        });



    }


}
