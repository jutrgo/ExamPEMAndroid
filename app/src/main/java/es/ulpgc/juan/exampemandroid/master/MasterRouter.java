package es.ulpgc.juan.exampemandroid.master;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.juan.exampemandroid.Detail.DetailActivity;
import es.ulpgc.juan.exampemandroid.add.AddActivity;
import es.ulpgc.juan.exampemandroid.app.AppMediator;
import es.ulpgc.juan.exampemandroid.model.Usuario;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToDetailScreen(Usuario usuario) {
    mediator.setUsuario(usuario);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }

  @Override
  public void navigateToAddScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddActivity.class);
    context.startActivity(intent);
  }
}
