package OOP.EX12_POLYMORPHISM.E04_Word_60ot100;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {

        CommandInterface commandInterface = new AdvancedCommand(text);
        commandInterface.init();
        return commandInterface;

    }

}
