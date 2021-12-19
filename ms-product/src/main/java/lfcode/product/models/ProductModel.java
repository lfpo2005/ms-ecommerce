package lfcode.product.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column( length = 4)
	private String units;
	
	@Column(nullable = false, columnDefinition = "Text")
	private String description;
	
	@Column(nullable = false, length = 10)
	private String Weight;
	
	@Column(nullable = false, length = 10)
	private String height;
	
	@Column(nullable = false, length = 10)
	private String width;
	
	@Column(nullable = false,  length = 10)
	private String depth;
	
	private BigDecimal price;
	
	private Integer stock = 0;
	
	private Boolean stockQuantityAlert = Boolean.FALSE;
	
	private Integer alertQuantityStock = 0 ;
	
	
	private String linkYoutube;
	
	private String bestSellers;
	
	private String quantitySales;
	
	private Boolean active = Boolean.FALSE;
	
	
	 @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	 private LocalDateTime creationDate;
	 
	 @Column(nullable = false)
	 @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	 private LocalDateTime lastUpdateDate;
	 
	 @OneToMany(mappedBy = "imageProduct", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<ImageModel> imagens = new ArrayList<ImageModel>();
	 
	 @ManyToOne(targetEntity = SubCategoryModel.class)
	 @JoinColumn(name = "subCategory_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "subCategory_fx"))
	 private SubCategoryModel subCategoryProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getStockQuantityAlert() {
		return stockQuantityAlert;
	}

	public void setStockQuantityAlert(Boolean stockQuantityAlert) {
		this.stockQuantityAlert = stockQuantityAlert;
	}

	public Integer getAlertQuantityStock() {
		return alertQuantityStock;
	}

	public void setAlertQuantityStock(Integer alertQuantityStock) {
		this.alertQuantityStock = alertQuantityStock;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public String getBestSellers() {
		return bestSellers;
	}

	public void setBestSellers(String bestSellers) {
		this.bestSellers = bestSellers;
	}

	public String getQuantitySales() {
		return quantitySales;
	}

	public void setQuantitySales(String quantitySales) {
		this.quantitySales = quantitySales;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<ImageModel> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImageModel> imagens) {
		this.imagens = imagens;
	}

	public SubCategoryModel getSubCategoryProduct() {
		return subCategoryProduct;
	}

	public void setSubCategoryProduct(SubCategoryModel subCategoryProduct) {
		this.subCategoryProduct = subCategoryProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductModel other = (ProductModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
