public class CarEnginFacade {
  private static int DEFAULT_COOLING_TEMP = 90;
  private static int MAX_ALLOWED_TEMP = 50;
  private FuelInjector fuelInjector = new FuelInjector();
  private AirFlowController airFlowController = new AirFlowController();
  private Starter starter = new Starter();
  private CoolingController coolingController = new CoolingController();
  private CatalycticConverter catalyticConverter = new CatalycticConverter ();

  public void startEngine() {
    fuelInjector.on();
    airFlowController.takeAir();
    fuelInjector.on();
    fuelInjector.inject();
    starter.start();
    coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
    coolingController.run();
    catalyticConverter.on();
    System.out.println("Tableau de Bord :\n  La voiture a démarée...");

  }

  private void takeAir() {
  }

  public void stopEngine() {
    fuelInjector.off();
    catalyticConverter.off();
    coolingController.cool(MAX_ALLOWED_TEMP);
    coolingController.stop();
    airFlowController.off();
  }

  private void off() {
  }

}
