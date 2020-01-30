package es.ulpgc.juan.exampemandroid.master;

import es.ulpgc.juan.exampemandroid.model.Usuario;
import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private Realm realm;

  public MasterModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void loadMasterItemList(final OnMasterItemListFetchedCallback callback) {
    final RealmResults<Usuario> people = realm.where(Usuario.class).findAllAsync();
    people.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Usuario>>() {
      @Override
      public void onChange(RealmResults<Usuario> people, OrderedCollectionChangeSet changeSet) {
        changeSet.getInsertions();
        // Once we get the list, it is passed to presenter
        callback.setMasterItemList(people);
      }
    });
  }
}
