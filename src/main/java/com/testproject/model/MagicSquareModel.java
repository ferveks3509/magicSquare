package com.testproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MAGIC_SQUARE")
public class MagicSquareModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String input;
    private int result;

    public MagicSquareModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagicSquareModel that = (MagicSquareModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MagicSquareModel{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", result=" + result +
                '}';
    }
}
