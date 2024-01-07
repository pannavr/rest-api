package rest.api.main.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tb_user_information", schema = "db_rest_main", catalog = "")
public class UserInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "is_active")
    private Integer isActive;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "modified_date")
    private Date modifiedDate;
    @OneToMany(mappedBy = "tbUserInformationByUserId")
    private Collection<UserProduct> tbUserProductsByUserId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return userId == that.userId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(gender, that.gender) && Objects.equals(isActive, that.isActive) && Objects.equals(createDate, that.createDate) && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, birthDate, gender, isActive, createDate, modifiedDate);
    }

    public Collection<UserProduct> getTbUserProductsByUserId() {
        return tbUserProductsByUserId;
    }

    public void setTbUserProductsByUserId(Collection<UserProduct> tbUserProductsByUserId) {
        this.tbUserProductsByUserId = tbUserProductsByUserId;
    }
}
