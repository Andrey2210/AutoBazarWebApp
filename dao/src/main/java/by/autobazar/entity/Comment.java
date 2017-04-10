package by.autobazar.entity;

import by.autobazar.util.LocalDateTimeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 2:31
 */
@Entity
@Table(name="T_COMMENT")
@Data
@ToString(exclude={"user", "car"})
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Lob
    private String comment;

    @Column(name="F_CREATIONS_DATE")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime creationsDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="F_USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="F_CAR_ID")
    private Car car;

    public Comment(String comment, LocalDateTime creationsDate) {
        this.comment = comment;
        this.creationsDate = creationsDate;
    }
}