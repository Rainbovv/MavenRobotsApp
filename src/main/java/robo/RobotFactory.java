package robo;

public class RobotFactory {

    private RobotFactory(){}

    public AbstractRobot getRobot(String model, String name){

        switch (model.toUpperCase()){

            case "ALPHA":
                return new AlphaRobot(name, model);

            case "BETA":
                return new BetaRobot(name, model);

            case "CHARLIE":
                return new CharlieRobot(name,model);

            default:
                System.err.println("Unfortunately we don't have such a model!\n" +
                                   "Please, use one of these: Alpha, Beta, Charlie!");
                return null;
        }
    }

    private static class SingletonHolder {
        private final static RobotFactory INSTANCE = new RobotFactory();
    }

    public static RobotFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
