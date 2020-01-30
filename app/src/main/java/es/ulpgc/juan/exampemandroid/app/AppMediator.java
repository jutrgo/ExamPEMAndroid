package es.ulpgc.juan.exampemandroid.app;

import android.app.Application;

import es.ulpgc.juan.exampemandroid.Detail.DetailState;
import es.ulpgc.juan.exampemandroid.add.AddState;
import es.ulpgc.juan.exampemandroid.master.MasterState;
import es.ulpgc.juan.exampemandroid.model.Usuario;
import io.realm.Realm;

public class AppMediator extends Application {

  private MasterState masterState;
  private AddState addState;
  private DetailState detailState;

  private Usuario usuario;

  @Override
  public void onCreate() {
    super.onCreate();

    // initializing Realm Database
    Realm.init(this);

    // : FOR DELETING THE DATABASE
    /*Realm realm;
    try {
      realm = Realm.getDefaultInstance();
    } catch (Exception e) { // Get a Realm instance for this thread
      RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
      realm = Realm.getInstance(config);
    }*/

    // initializing states
    masterState = new MasterState();
    addState = new AddState();
    detailState = new DetailState();

    // initializing objects
    usuario = new Usuario();
  }

  // getters and setters

  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }

  public AddState getAddState() {
    return addState;
  }

  public void setAddState(AddState addState) {
    this.addState = addState;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState detailState) {
    this.detailState = detailState;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
