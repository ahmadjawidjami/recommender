package com.tu.ziik.lms.model;



import com.tu.ziik.lms.model.admin.course.Course;
import com.tu.ziik.lms.model.lecturer.CourseContentPost;
import com.tu.ziik.lms.model.library.UserRating;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    private Long id;
    @Column( unique=true, nullable=false )
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;


    private String gender;
    private String profession;

    private String zipcode;
    private String genre;
    private int age;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Set<CourseContentPost> courseContentPosts;

    private Set<Course> courses;

    @Version
    private Integer version;


    private ArrayList<String> theRoles;


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<CourseContentPost> getCourseContentPosts(){
        return courseContentPosts;
    }

    public void setCourseContentPosts(Set<CourseContentPost> courseContentPosts){
        this.courseContentPosts = courseContentPosts;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Course> getCourses(){
        return courses;
    }

    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }

    @Transient
    public ArrayList<String> getTheRoles() {
        return theRoles;
    }

    public void setTheRoles(ArrayList<String> theRoles) {
        this.theRoles = theRoles;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }




    private String name;
    private Set<UserRating> userRatings;

    public User(){

    }

    public User(String name){
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(Set<UserRating> userRatings) {
        this.userRatings = userRatings;
    }
















}
