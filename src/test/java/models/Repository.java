package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Builder
@Data
@ToString
@EqualsAndHashCode
public class Repository {
    @EqualsAndHashCode.Exclude
    public int id;
    public String name;
    public String description;
    @SerializedName(value = "private")
    public boolean IsPrivate;
}
