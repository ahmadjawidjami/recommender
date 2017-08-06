package com.tu.ziik.lms.model.library;

/**
 * Created by ahmadjawid on 8/6/17.
 */


import java.io.Serializable;

//For now couldn't manage to use this class
public class EmployeeId implements Serializable {

    //    private int idEmployee;
//    private String branchName;
    private Long user;
    private Long movie;


    public EmployeeId() {

    }

    public EmployeeId(Long user, Long movie) {
        this.user = user;
        this.movie = movie;
    }

    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    //    public EmployeeId(String branchName, int idEmployee) {
//        this.branchName = branchName;
//        this.idEmployee = idEmployee;
//    }

//    public int getIdEmployee() {
//        return idEmployee;
//    }
//
//    public String getBranchName() {
//        return branchName;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((movie == null) ? 0 : movie.hashCode());
        result = (int) (prime * result + user);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeId other = (EmployeeId) obj;
        if (movie == null) {
            if (other.movie != null)
                return false;
        } else if (!movie.equals(other.movie))
            return false;
        if (user != other.user)
            return false;
        return true;
    }


}
