package br.com.gilvanmuniz.model;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person") // quando o nome da entidade é igual a tabela não precisa colocar nada fica @Table

public class Person implements Serializable {
    // está linha a baixo é padrão
  private static final Long serialVersionUid = 1L;
  // temos agora de mapiar os atributos dela
   @Id
 // temos que dizer qual é a forma do ID que vamos adotar
  // ele vai ser IDENTITY == auto incremental

@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "first_name", nullable = false, length = 80)
    private String firtsName;
   @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;
   @Column(nullable = false, length = 100)
    private String address; // se nome = na entidade e no banco
   @Column(nullable = false, length = 6)
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

    public Person orElseThrow(Object o) {
        return null;
    }
}
