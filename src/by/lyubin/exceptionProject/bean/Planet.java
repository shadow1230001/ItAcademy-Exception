package by.lyubin.exceptionProject.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Planet {
    private List<Continent> continents;

    private List<Island> islands;

    private List<Ocean> oceans;

    public Planet(){
        continents = new LinkedList<>();
        islands = new LinkedList<>();
        oceans = new LinkedList<>();
    }

    private List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) throws NullPointerException{
        if (continents != null) {
            this.continents = continents;
        } else {
            throw new NullPointerException("Continents are null");
        }
    }

    private List<Island> getIslands() {
        return islands;
    }

    public void setIslands(List<Island> islands) throws NullPointerException{
        if (islands != null) {
            this.islands = islands;
        } else {
            throw new NullPointerException("Islands are null");
        }
    }

    private List<Ocean> getOceans() {
        return oceans;
    }

    public void setOceans(List<Ocean> oceans) throws NullPointerException{
        if (oceans != null) {
            this.oceans = oceans;
        } else {
            throw new NullPointerException("Oceans are null");
        }
    }

    public void addContinent(Continent input) throws IllegalArgumentException{
        if (input != null) {
            continents.add(input);
        } else {
            throw new IllegalArgumentException("Input continent is null");
        }
    }

    public void removeContinent(int index) {
        try {
            continents.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Something goes wrong with removing continent! " + e);
        }
    }

    public void addIsland(Island input) throws IllegalArgumentException{
        if (input != null) {
            islands.add(input);
        } else {
            throw new IllegalArgumentException("Input island is null");
        }
    }

    public void removeIsland(int index) {
        try {
            islands.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Something goes wrong with removing island! " + e);
        }
    }

    public void addOcean(Ocean input) throws IllegalArgumentException{
        if (input != null) {
            oceans.add(input);
        } else {
            throw new IllegalArgumentException("Input ocean is null");
        }
    }

    public void removeOcean(int index) throws IndexOutOfBoundsException {
        oceans.remove(index);
    }

    private double landSquare() {
        double square = 0;
        for (Continent c : continents) {
            square += c.getSquare();
        }
        for (Island i : islands) {
            square += i.getSquare();
        }
        return square;
    }

    private double waterSquare() {
        double square = 0;
        for (Ocean o : oceans) {
            square += o.getSquare();
        }
        return square;
    }

    public double planetSquare() {
        return landSquare() + waterSquare();
    }

    @Override
    public String toString() {
        return "Planet{" +
                "continents=" + continents +
                ", islands=" + islands +
                ", oceans=" + oceans +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Planet)) return false;
        Planet planet = (Planet) object;
        return Objects.equals(getContinents(), planet.getContinents()) &&
                Objects.equals(getIslands(), planet.getIslands()) &&
                Objects.equals(getOceans(), planet.getOceans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContinents(), getIslands(), getOceans());
    }
}
