package Delete.E04_Word_80ot100;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {

        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;

    }

}
