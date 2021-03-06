/**
 * 
 */
package dev.atanu.ecom.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This entity class is mapped with the table BRAND_DETAILS in database.
 * 
 * @see ProductEntity
 * @see CategoryEntity
 * @see ColourEntity
 * @see AvailableProductEntity
 * 
 * @author Atanu Bhowmick
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "BRAND_DETAILS", uniqueConstraints = {
		@UniqueConstraint(name = "UNIQUE_BRAND_NAME", columnNames = "BRAND_NAME") })
public class BrandEntity extends BaseEntity {

	private static final long serialVersionUID = -9042637631956138898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "BRAND_NAME")
	private String brandName;

	@Column(name = "BRAND_DESC")
	private String brandDesc;
}
