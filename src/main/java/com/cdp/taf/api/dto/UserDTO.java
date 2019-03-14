package com.cdp.taf.api.dto;


import java.util.Objects;

public class UserDTO {

    private String website;

    private Address address;

    private String phone;

    private String name;

    private Company company;

    private String id;

    private String email;

    private String username;

    public static UserDTO getDefaultUserDTO(int id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("newemail.@gmail.com");
        userDTO.setName("newName");
        userDTO.setUsername("newUsername");
        userDTO.setId(String.valueOf(id));
        return userDTO;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [website = " + website + ", address = " + address + ", phone = " + phone + ", name = " + name + ", company = " + company + ", id = " + id + ", email = " + email + ", username = " + username + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(website, userDTO.website) &&
                Objects.equals(address, userDTO.address) &&
                Objects.equals(phone, userDTO.phone) &&
                Objects.equals(name, userDTO.name) &&
                Objects.equals(company, userDTO.company) &&
                Objects.equals(id, userDTO.id) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, address, phone, name, company, id, email, username);
    }
}
