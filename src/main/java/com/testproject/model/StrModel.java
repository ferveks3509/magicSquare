package com.testproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "str_model")
public class StrModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "input_str")
    private String inputStr;
    @Column(name = "compare_str")
    private String compareStr;
    @Column(name = "result_str")
    private String result;

    public StrModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getCompareStr() {
        return compareStr;
    }

    public void setCompareStr(String compareStr) {
        this.compareStr = compareStr;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrModel that = (StrModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArrayModel{" +
                "id=" + id +
                ", inputStr='" + inputStr + '\'' +
                ", compareStr='" + compareStr + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
