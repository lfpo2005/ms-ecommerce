package lfcode.product.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_IMAGES")
public class ImageModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "Text")
	private String ImgOriginal;	
	
	 @ManyToOne(targetEntity = ProductModel.class)
	 @JoinColumn(name = "imageProduct_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "imageProduct_fx"))
	 private ProductModel imageProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgOriginal() {
		return ImgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		ImgOriginal = imgOriginal;
	}

	public ProductModel getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(ProductModel imageProduct) {
		this.imageProduct = imageProduct;
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
		ImageModel other = (ImageModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
