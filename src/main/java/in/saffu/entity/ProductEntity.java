package in.saffu.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TAB_PRODUCT")
@Setter
@Getter
@ToString
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	@Column(name = "PRODUCT_NAME")
	private String  productName;
	
	@Column(name = "DESCRIPTION")
	private String  productDescription;
	
	@Column(name = "PRODUCT_PRICE")
	private Double  produPrice;
	
	@Column(name="PRODUCT_AVAILABLE")
	private Boolean productAvilable;
	
	@Column(name="PRODUCT_IN_STOCK")
	private Integer productInStock;
	
	@Column(name = "DATE_CREATED")
	@CreationTimestamp
	private LocalDateTime craeteDate;
	
	@Column(name = "LAST_UPDATE")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	
	

}
