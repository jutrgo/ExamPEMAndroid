package es.ulpgc.juan.exampemandroid.add;

import es.ulpgc.juan.exampemandroid.model.Usuario;
import io.realm.Realm;

public class AddModel implements AddContract.Model {

  public static String TAG = AddModel.class.getSimpleName();

  private Realm realm;

  public AddModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void addPerson(String name, String surname, String age, String dni, String job, String poblacion, String valoracion, String fechaNacimiento) {
    realm.beginTransaction();
    Usuario usuario = realm.createObject(Usuario.class);
    Number number = realm.where(Usuario.class).max("id");
    usuario.setId(number.intValue() + 1);
    usuario.setNombre(name);
    usuario.setApellidos(surname);
    usuario.setEdad(Integer.parseInt(age));
    usuario.setDni(dni);
    usuario.setProfesion(job);
    usuario.setValoracion(0);
    usuario.setPoblacion(poblacion);
    usuario.setValoracion(Integer.parseInt(valoracion));
    usuario.setFechaNacimiento(fechaNacimiento);
    realm.commitTransaction();
  }
}
