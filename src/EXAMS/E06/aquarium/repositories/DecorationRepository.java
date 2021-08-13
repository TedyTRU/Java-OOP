package EXAMS.E06.aquarium.repositories;

import EXAMS.E06.aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecorationRepository implements Repository {
    private List<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    public List<Decoration> getDecorations() {
        return Collections.unmodifiableList(this.decorations);
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        if (decorations.contains(decoration)) {
            decorations.remove(decoration);
            return true;

        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        return this.decorations.stream()
                .filter(d -> d.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
