package utils;

public class Endpoints {
    public static final String GET_USER = "/user";
    public static final String GET_EXACT_USER = "/users/{username}";
    public static final String CREATE_REPOSITORY = "/user/repos";
    public static final String GET_REPOSITORY = "/repos/{owner}/{repo}";
    public static final String UPDATE_REPOSITORY = "/repos/{owner}/{repo}";
    public static final String DELETE_REPOSITORY = "/repos/{owner}/{repo}";
    public static final String GET_COLLABORATORS = "/repos/{owner}/{repo}/collaborators";
}