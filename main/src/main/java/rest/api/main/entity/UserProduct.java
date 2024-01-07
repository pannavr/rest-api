package rest.api.main.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_user_product", schema = "db_rest_main", catalog = "")
public class UserProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_product_id")
    private int userProductId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "is_active")
    private Integer isActive;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "modified_date")
    private Date modifiedDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserInformation tbUserInformationByUserId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductInformation tbProductInformationByProductId;

    public int getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(int userProductId) {
        this.userProductId = userProductId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        UserProduct that = (UserProduct) o;
        return userProductId == that.userProductId && Objects.equals(userId, that.userId) && Objects.equals(productId, that.productId) && Objects.equals(isActive, that.isActive) && Objects.equals(createDate, that.createDate) && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProductId, userId, productId, isActive, createDate, modifiedDate);
    }

    public UserInformation getTbUserInformationByUserId() {
        return tbUserInformationByUserId;
    }

    public void setTbUserInformationByUserId(UserInformation tbUserInformationByUserId) {
        this.tbUserInformationByUserId = tbUserInformationByUserId;
    }

    public ProductInformation getTbProductInformationByProductId() {
        return tbProductInformationByProductId;
    }

    public void setTbProductInformationByProductId(ProductInformation tbProductInformationByProductId) {
        this.tbProductInformationByProductId = tbProductInformationByProductId;
    }
}
