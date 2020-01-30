package es.ulpgc.juan.exampemandroid.Detail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.juan.exampemandroid.app.AppMediator;
import es.ulpgc.juan.exampemandroid.master.MasterActivity;
import es.ulpgc.juan.exampemandroid.model.Usuario;

public class DetailRouter implements DetailContract.Router {

  public static String TAG = DetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public DetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(DetailState state) {
    mediator.setDetailState(state);
  }

  @Override
  public Usuario getDataFromPreviousScreen() {
    return mediator.getUsuario();
  }

  @Override
  public void navigateToMasterScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }
}
