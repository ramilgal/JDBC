package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    @Column(name="city_name")
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;
    public City(
//            int city_id,
            String city_name) {
//        this.city_id = city_id;
        this.city_name = city_name;
    }

    public City(int city_id) {
        this.city_id = city_id;
    }

    public City() {

    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return city_id == city.city_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id);
    }
}
