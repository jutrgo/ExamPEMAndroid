package es.ulpgc.juan.exampemandroid.Detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.juan.exampemandroid.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;

  // buttons
  private Button cancelButton, updateButton, deleteButton;

  // text views
  private TextView ratingText, nameText, surnameText, ageText, dniText, jobText, poblacionText, fechaNacimientoText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    // initializing buttons and edit texts
    cancelButton = findViewById(R.id.cancelButton);
    updateButton = findViewById(R.id.updateButton);
    deleteButton = findViewById(R.id.deleteButton);

    ratingText = findViewById(R.id.ratingText);
    nameText = findViewById(R.id.nameText);
    surnameText = findViewById(R.id.surnameText);
    ageText = findViewById(R.id.ageText);
    dniText = findViewById(R.id.dniText);
    jobText = findViewById(R.id.jobText);
    poblacionText = findViewById(R.id.poblacionText);
    fechaNacimientoText = findViewById(R.id.fechaNacimientoText);

    // listeners
    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMasterScreen();
      }
    });

    updateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String rating = ratingText.getText().toString();
        String name = nameText.getText().toString();
        String surname = surnameText.getText().toString();
        String age = ageText.getText().toString();
        String dni = dniText.getText().toString();
        String job = jobText.getText().toString();
        String poblacion = poblacionText.getText().toString();
        String fechaNacimiento = fechaNacimientoText.getText().toString();
        if (
            !rating.equals("") &&
            !name.equals("") &&
                !surname.equals("") &&
                !age.equals("") &&
                !dni.equals("") &&
                !job.equals("") &&
                !poblacion.equals("") &&
                !fechaNacimiento.equals("") &&
                Integer.valueOf(rating) >= 0 &&
                Integer.valueOf(rating) <= 10
        ) {
          presenter.updatePerson(rating, name, surname, age, dni, job, poblacion, fechaNacimiento);
          presenter.startMasterScreen();
        } else {
          Toast.makeText(DetailActivity.this, "Hay algún campo vacío o el campo valoración es mayor que 10", Toast.LENGTH_SHORT).show();
        }
      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.deleteUser();
        presenter.startMasterScreen();
      }
    });

    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    //((EditText) findViewById(R.id.ratingText)).setText(viewModel.usuario.getValoracion());
    ((EditText) findViewById(R.id.nameText)).setText(viewModel.usuario.getNombre());
    ((EditText) findViewById(R.id.surnameText)).setText(viewModel.usuario.getApellidos());
    ((EditText) findViewById(R.id.ageText)).setText(String.valueOf(viewModel.usuario.getEdad()));
    ((EditText) findViewById(R.id.dniText)).setText(viewModel.usuario.getDni());
    ((EditText) findViewById(R.id.jobText)).setText(viewModel.usuario.getProfesion());
    ((EditText) findViewById(R.id.poblacionText)).setText(viewModel.usuario.getPoblacion());
    ((EditText) findViewById(R.id.fechaNacimientoText)).setText(String.valueOf(viewModel.usuario.getFechaNacimiento()));
  }
}
