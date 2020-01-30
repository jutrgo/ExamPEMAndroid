package es.ulpgc.juan.exampemandroid.add;

import java.lang.ref.WeakReference;

interface AddContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void startMasterScreen();

    void addPerson(String name, String surname, String age, String dni, String job, String poblacion, String valoracion, String fechaNacimiento);
  }

  interface Model {
    void addPerson(String name, String surname, String age, String dni, String job, String poblacion, String valoracion, String fechaNacimiento);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddState state);

    AddState getDataFromPreviousScreen();

    void navigateToMasterScreen();
  }
}
