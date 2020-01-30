package es.ulpgc.juan.exampemandroid.Detail;

import es.ulpgc.juan.exampemandroid.model.Usuario;
import io.realm.Realm;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private Realm realm;

  public DetailModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void deletePerson(int id) {
    realm.beginTransaction();
    realm.where(Usuario.class).equalTo("id", id).findAll().deleteAllFromRealm();
    realm.commitTransaction();
  }

  @Override
  public void updatePerson(int id, String rating, String name, String surname, String age, String dni, String job, String poblacion, String fechaNacimiento) {
    realm.beginTransaction();
    Usuario usuario = realm.where(Usuario.class).equalTo("id", id).findFirst();
    usuario.setNombre(name);
    usuario.setApellidos(surname);
    usuario.setEdad(Integer.valueOf(age));
    usuario.setDni(dni);
    usuario.setProfesion(job);
    usuario.setPoblacion(poblacion);
    usuario.setValoracion(Integer.valueOf(rating));
    usuario.setFechaNacimiento(fechaNacimiento);
    realm.commitTransaction();
  }
}
