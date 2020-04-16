package entity;

import javax.persistence.*;

@Entity
@Table(name = "charts", schema = "musicalbums")
public class Charts {
    private int id;
    private String name;
    private Albums albumsByFirstPlace;
    private Albums albumsBySecondPlace;
    private Albums albumsByThirdPlace;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charts that = (Charts) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "first_place", referencedColumnName = "id")
    public Albums getAlbumsByFirstPlace() {
        return albumsByFirstPlace;
    }

    public void setAlbumsByFirstPlace(Albums albumsByFirstPlace) {
        this.albumsByFirstPlace = albumsByFirstPlace;
    }

    @ManyToOne
    @JoinColumn(name = "second_place", referencedColumnName = "id")
    public Albums getAlbumsBySecondPlace() {
        return albumsBySecondPlace;
    }

    public void setAlbumsBySecondPlace(Albums albumsBySecondPlace) {
        this.albumsBySecondPlace = albumsBySecondPlace;
    }

    @ManyToOne
    @JoinColumn(name = "third_place", referencedColumnName = "id")
    public Albums getAlbumsByThirdPlace() {
        return albumsByThirdPlace;
    }

    public void setAlbumsByThirdPlace(Albums albumsByThirdPlace) {
        this.albumsByThirdPlace = albumsByThirdPlace;
    }
}
