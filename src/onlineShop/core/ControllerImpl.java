package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import javax.management.modelmbean.ModelMBeanInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Computer computer;
    private List<Computer> computerList;

    public ControllerImpl() {
        this.computerList = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer,
                              String model, double price) {

        getComputerFromTheList(id);
        doesComputerExistInCollection(computer != null, EXISTING_COMPUTER_ID);

        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);

        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);

        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);

        }

        this.computerList.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model,
                                double price, double overallPerformance, String connectionType) {

        getComputerFromTheList(computerId);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        Peripheral peripheral = this.computer.getPeripherals().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (peripheral != null) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        this.computer.addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        getComputerFromTheList(computerId);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        Peripheral existing = this.computer.removePeripheral(peripheralType);

        return String.format(REMOVED_PERIPHERAL, peripheralType, existing.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {

        getComputerFromTheList(computerId);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        Component component = this.computer.getComponents().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (component != null) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        if (componentType.equals("CentralProcessingUnit")) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);

        } else if (componentType.equals("Motherboard")) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);

        } else if (componentType.equals("PowerSupply")) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);

        } else if (componentType.equals("RandomAccessMemory")) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);

        } else if (componentType.equals("SolidStateDrive")) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);

        } else if (componentType.equals("VideoCard")) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);

        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);

        }

        this.computer.addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        getComputerFromTheList(computerId);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        Component existing = this.computer.removeComponent(componentType);

        return String.format(REMOVED_COMPONENT, componentType, existing.getId());
    }

    @Override
    public String buyComputer(int id) {
        getComputerFromTheList(id);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        this.computerList.remove(computer);

        return this.computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
//        List<Computer> comps = this.computerList.stream()
//                .filter(c -> c.getPrice() <= budget)
//                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
//                .collect(Collectors.toList());

        Computer bestComputer = this.computerList.stream()
                .filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparing(Computer::getOverallPerformance)).orElse(null);

        if (bestComputer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        return bestComputer.toString();
    }

    @Override
    public String getComputerData(int id) {

        getComputerFromTheList(id);
        doesComputerExistInCollection(computer == null, NOT_EXISTING_COMPUTER_ID);

        return this.computer.toString();
    }


    private void doesComputerExistInCollection( boolean b, String notExistingComputerId) {
        if (b) {
            throw new IllegalArgumentException(notExistingComputerId);
        }
    }

    private void getComputerFromTheList(int computerId) {
        this.computer = this.computerList.stream()
                .filter(c -> c.getId() == computerId)
                .findFirst()
                .orElse(null);
    }

}
