package by.autobazar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 2:31
 */
@Entity
@Table(name="T_IMAGE")
@Data
@ToString(exclude="car")
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="F_IMAGE_PATH")
    private String imagePath;

    @Column
    private String  status;

    @ManyToOne
    @JoinColumn(name="F_CAR_ID")
    private Car car;

    public Image(String imagePath, String status) {
        this.imagePath = imagePath;
        this.status = status;
    }
}