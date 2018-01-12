package by.lyubin.exceptionProject.bean;

import java.util.Objects;

public class Continent {
    private String name;

    private double square;

    public Continent() {
    }

    public Continent(String name) {
        setName(name);
    }

    public Continent(double square) {
        setSquare(square);
    }

    public Continent(String name, double square) {
        setName(name);
        setSquare(square);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Continent name is null");
        }
    }

    double getSquare() {
        return square;
    }

    private void setSquare(double square) {
        if (square > 0) {
            this.square = square;
        } else {
            throw new IllegalArgumentException("Continent square is " + square);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " # name " + name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Continent)) return false;
        Continent continent = (Continent) object;
        return Double.compare(continent.getSquare(), getSquare()) == 0 &&
                Objects.equals(getName(), continent.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSquare());
    }
}
