package ma.fstm.ilisi.routage.shorthpath.model.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class EventObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;
    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "image_path")
    @JsonProperty("imagePath")
    private String imagePath;

    @Column(name = "start_date")
    @JsonProperty("startDate")
    private LocalDate startDate;

    @Column(name = "start_time")
    @JsonProperty("startTime")
    private String startTime;

    @Column(name = "end_time")
    @JsonProperty("endTime")
    private String endTime;

    @Column(name = "longitude")
    @JsonProperty("longt")
    private double longitude;

    @Column(name = "latitude")
    @JsonProperty("lapt")
    private double latitude;

    @Override
    public String toString() {
        return "EventObj{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", startDate=" + startDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
