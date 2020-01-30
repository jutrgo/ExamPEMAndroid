package es.ulpgc.juan.exampemandroid.add;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.juan.exampemandroid.app.AppMediator;
import es.ulpgc.juan.exampemandroid.master.MasterActivity;

public class AddRouter implements AddContract.Router {

  public static String TAG = AddRouter.class.getSimpleName();

  private AppMediator mediator;

  public AddRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddState state) {
    mediator.setAddState(state);
  }

  @Override
  public AddState getDataFromPreviousScreen() {
    AddState state = mediator.getAddState();
    return state;
  }

  @Override
  public void navigateToMasterScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }
}
