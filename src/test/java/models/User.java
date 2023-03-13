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
public class User {
    private String login;
    private String password;
    @EqualsAndHashCode.Exclude
    private int id;
    private String type;
    private String name;
    private String company;
    private String location;
    private String email;
    private String bio;
    @SerializedName(value = "public_repos")
    @EqualsAndHashCode.Exclude
    private int publicRepos;
}
