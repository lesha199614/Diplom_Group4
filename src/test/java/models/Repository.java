package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Builder
@Data
@ToString
@EqualsAndHashCode
@Setter
public class Repository {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String description;
    @SerializedName(value = "private")
    private boolean IsPrivate;
}
