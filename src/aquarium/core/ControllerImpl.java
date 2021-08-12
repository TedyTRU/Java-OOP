package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    private Aquarium aquarium;
    private Decoration decoration;
    private Fish fish;

    public ControllerImpl() {
        this.aquariums = new ArrayList<>();
        this.decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        switch (aquariumType) {
            case "FreshwaterAquarium":
                this.aquarium = new FreshwaterAquarium(aquariumName);
                break;

            case "SaltwaterAquarium":
                this.aquarium = new SaltwaterAquarium(aquariumName);
                break;

            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(this.aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        switch (type) {
            case "Ornament":
                this.decoration = new Ornament();
                break;
            case "Plant":
                this.decoration = new Plant();
                break;

            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);

        }

        this.decorations.add(this.decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        this.decoration = this.decorations.findByType(decorationType);

        if (this.decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));

        }

        giveAquarium(aquariumName);

        if (this.aquarium != null) {
            this.aquarium.addDecoration(this.decoration);
            this.decorations.remove(decoration);
        }

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        String type;

        switch (fishType) {
            case "FreshwaterFish":
                this.fish = new FreshwaterFish(fishName, fishSpecies, price);
                type = "FreshwaterAquarium";
                break;
            case "SaltwaterFish":
                this.fish = new SaltwaterFish(fishName, fishSpecies, price);
                type = "SaltwaterAquarium";
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        giveAquarium(aquariumName);

        if (this.aquarium != null) {
            if (!this.aquarium.getClass().getSimpleName().equals(type)) {
                //throw new IllegalArgumentException(WATER_NOT_SUITABLE);
                return WATER_NOT_SUITABLE;
            }
            this.aquarium.addFish(this.fish);
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int fedCount = 0;

        giveAquarium(aquariumName);

        if (this.aquarium != null) {
            this.aquarium.feed();
            fedCount = this.aquarium.getFish().size();
        }

        return String.format(FISH_FED, fedCount);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double price = 0;

        giveAquarium(aquariumName);

        if (this.aquarium != null) {
            double fishPrice = this.aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
            double decorationPrice = this.aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
            price = fishPrice + decorationPrice;
        }

        return String.format(VALUE_AQUARIUM, aquariumName, price);
    }

    @Override
    public String report() {
        //StringBuilder sb = new StringBuilder();

        //this.aquariums.forEach(a -> sb.append(a.getInfo()).append(System.lineSeparator()));
        return this.aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));

        //return sb.toString().trim();
    }

    private void giveAquarium(String aquariumName) {
        this.aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName))
                .findFirst().orElse(null);
    }
}
