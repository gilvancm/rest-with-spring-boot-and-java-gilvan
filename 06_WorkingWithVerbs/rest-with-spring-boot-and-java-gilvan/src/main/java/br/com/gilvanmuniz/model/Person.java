package br.com.gilvanmuniz.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    // está linha a baixo é padrão
  private static final Long serialVersionUid = 1L;

   // primeiro atributo
    private Long id;
    // prof por vc não está usando classe record? neste caso
    // precisamos manipular o id, precisamos ler e escrever no objeto
    private String firtsName;
    private String lastName;
    private String address;
    private String gender;


    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirtsName(), person.getFirtsName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirtsName(), getLastName(), getAddress(), getGender());
    }
}
