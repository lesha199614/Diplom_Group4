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
public class Collaborator {
    private String login;
    @EqualsAndHashCode.Exclude
    private int id;
    private String type;
    @SerializedName(value = "role_name")
    private String roleName;

}
