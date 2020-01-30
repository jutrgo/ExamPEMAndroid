package es.ulpgc.juan.exampemandroid.master;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.juan.exampemandroid.app.AppMediator;

public class MasterScreen {

  public static void configure(MasterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MasterState state = mediator.getMasterState();

    MasterContract.Router router = new MasterRouter(mediator);
    MasterContract.Presenter presenter = new MasterPresenter(state);
    MasterContract.Model model = new MasterModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
