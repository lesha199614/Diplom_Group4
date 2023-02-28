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
    public String login;
    @EqualsAndHashCode.Exclude
    public int id;
    public String type;
    @SerializedName(value = "role_name")
    public String roleName;

}
