package es.ulpgc.juan.exampemandroid.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.juan.exampemandroid.model.Usuario;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startAddScreen();

    void startDetailScreen(Usuario usuario);
  }

  interface Model {
    interface OnMasterItemListFetchedCallback {
      void setMasterItemList(List<Usuario> itemList);
    }

    void loadMasterItemList(OnMasterItemListFetchedCallback callback);
  }

  interface Router {
    void navigateToDetailScreen();

    void passDataToDetailScreen(Usuario usuario);

    MasterState getDataFromPreviousScreen();

    void navigateToAddScreen();
  }
}
