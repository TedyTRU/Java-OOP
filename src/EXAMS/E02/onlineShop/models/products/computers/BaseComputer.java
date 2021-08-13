package EXAMS.E02.onlineShop.models.products.computers;

import EXAMS.E02.onlineShop.models.products.BaseProduct;
import EXAMS.E02.onlineShop.models.products.Product;
import EXAMS.E02.onlineShop.models.products.components.Component;
import EXAMS.E02.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static EXAMS.E02.onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {

        return super.getOverallPerformance() +
                this.components.stream()
                        .mapToDouble(Component::getOverallPerformance)
                        .average()
                        .orElse(0);
    }

    @Override
    public double getPrice() {

        double priceOfComponents = this.components.stream().mapToDouble(Component::getPrice).sum();
        double priceOfPeripherals = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

        return super.getPrice() + priceOfComponents + priceOfPeripherals;

    }

    @Override
    public List<Component> getComponents() {
        return Collections.unmodifiableList(this.components);
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return Collections.unmodifiableList(this.peripherals);
    }

    @Override
    public void addComponent(Component component) {

        if (this.components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        Component existing = this.components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findAny()
                .orElse(null);

        if (existing == null || this.components.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }

        this.components.remove(existing);
        return existing;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        if (this.peripherals.stream().anyMatch(p -> p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {

        Peripheral existing = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);

        if (existing == null || this.peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.remove(existing);
        return existing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", this.components.size())).append(System.lineSeparator());

        this.components.forEach(c -> sb.append("  ").append(c.toString()).append(System.lineSeparator()));

        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
                this.peripherals.size(), getAveragePeripheralOverallPerformance()));
        sb.append(System.lineSeparator());

        this.peripherals.forEach(p -> sb.append("  ").append(p.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private double getAveragePeripheralOverallPerformance() {
        //return this.peripherals.stream().map(Peripheral::getOverallPerformance)
               // .mapToDouble(Double::doubleValue).average().orElse(0.00);

        return this.peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.00);
    }
}
