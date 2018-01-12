package by.lyubin.exceptionProject.bean;

import java.util.Objects;

public class Ocean {
    private String name;

    private double square;

    public Ocean() {
    }

    public Ocean(String name) {
        setName(name);
    }

    public Ocean(double square) {
        setSquare(square);
    }

    public Ocean(String name, double square) {
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
            throw new NullPointerException("Ocean name is null");
        }
    }

    double getSquare() {
        return square;
    }

    private void setSquare(double square) {
        if (square > 0) {
            this.square = square;
        } else {
            throw new IllegalArgumentException("Ocean square is " + square);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " # name " + name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ocean)) return false;
        Ocean ocean = (Ocean) object;
        return Double.compare(ocean.getSquare(), getSquare()) == 0 &&
                Objects.equals(getName(), ocean.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSquare());
    }
}
