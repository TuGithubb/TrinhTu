/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Diep.Tran
 */
public class KhachHang {
    int id;
    String fullname, email, phoneNumber, birthday, address, password;

    public KhachHang() {
    }

    public KhachHang(int id, String fullname, String email, String phoneNumber, String birthday, String address, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday + ", address=" + address + ", password=" + password + '}';
    }
    
}
