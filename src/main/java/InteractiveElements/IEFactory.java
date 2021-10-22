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

        return null;
    }
}
