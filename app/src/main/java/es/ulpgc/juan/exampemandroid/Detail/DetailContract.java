package es.ulpgc.juan.exampemandroid.Detail;

import android.widget.DatePicker;

import java.lang.ref.WeakReference;

import es.ulpgc.juan.exampemandroid.model.Usuario;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMasterScreen();

    void deleteUser();

    void updatePerson(String rating, String name, String surname, String age, String dni, String job, String poblacion, String fechaNacimiento);
  }

  interface Model {
    void deletePerson(int id);

    void updatePerson(int id, String rating, String name, String surname, String age, String dni, String job, String poblacion, String fechaNacimiento);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    //DetailState getDataFromPreviousScreen();
    Usuario getDataFromPreviousScreen();

    void navigateToMasterScreen();
  }
  void onDateSet(DatePicker view, int year, int monthOfYear,
                 int dayOfMonth);
  void actualizarInput();
}
