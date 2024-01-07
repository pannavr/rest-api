package rest.api.main.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tb_product_information", schema = "db_rest_main", catalog = "")
public class ProductInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "product_stock")
    private Integer productStock;
    @Basic
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Basic
    @Column(name = "is_active")
    private Integer isActive;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "modified_date")
    private Date modifiedDate;
    @OneToMany(mappedBy = "tbProductInformationByProductId")
    private Collection<UserProduct> tbUserProductsByProductId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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
        ProductInformation that = (ProductInformation) o;
        return productId == that.productId && Objects.equals(productName, that.productName) && Objects.equals(productStock, that.productStock) && Objects.equals(productPrice, that.productPrice) && Objects.equals(isActive, that.isActive) && Objects.equals(createDate, that.createDate) && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productStock, productPrice, isActive, createDate, modifiedDate);
    }

    public Collection<UserProduct> getTbUserProductsByProductId() {
        return tbUserProductsByProductId;
    }

    public void setTbUserProductsByProductId(Collection<UserProduct> tbUserProductsByProductId) {
        this.tbUserProductsByProductId = tbUserProductsByProductId;
    }
}
