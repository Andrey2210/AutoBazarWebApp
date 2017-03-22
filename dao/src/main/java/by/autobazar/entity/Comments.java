package by.autobazar.entity;

/**
 * Created by Andrey on 22.03.2017.
 */
public class Comments implements Entity {

    private long id;
    private long carId;
    private String comment;
    private long userId;
    private User user;

    public Comments() {
    }

    public Comments(long id, long carId, String comment, long userId) {
        this.id = id;
        this.carId = carId;
        this.comment = comment;
        this.userId = userId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
