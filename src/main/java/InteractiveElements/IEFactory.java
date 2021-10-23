package InteractiveElements;

public class IEFactory {

    public static InteractiveElement getType(String IEType){
        if(IEType == null){
            return null;
        }
        if(IEType.equalsIgnoreCase("StationaryChangePoints")) {
            return new StationaryChangePoints("C");
        }

        if(IEType.equalsIgnoreCase("StationaryBlock")) {
            return new StationaryBlock("X");
        }
        if(IEType.equalsIgnoreCase("MovableChangePoints")) {
            return new MovableChangePoints("W");
        }
        if(IEType.equalsIgnoreCase("MovableBlock")) {
            return new MovableBlock("M");
        }

        return null;
    }
}
