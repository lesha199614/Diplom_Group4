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
    public String login;
    public String password;
    @EqualsAndHashCode.Exclude
    public int id;
    public String type;
    public String name;
    public String company;
    public String location;
    public String email;
    public String bio;
    @SerializedName(value = "public_repos")
    @EqualsAndHashCode.Exclude
    public int publicRepos;
}
