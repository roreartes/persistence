package ar.com.ada.sb.api.persistence.persistence.model.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "course")
public class Course implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "code")
    private String code;
    @NotNull
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @NotNull
    @Column(name = "description")
    private String description;

    public Course(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(name, course.name) &&
                Objects.equals(code, course.code) &&
                Objects.equals(price, course.price) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, price, description);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
