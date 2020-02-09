/**
 * 
 */
package com.atanu.spring.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This DTO class is mapped with CategoryEntity
 * 
 * @author Atanu Bhowmick
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetails implements Serializable {

	private static final long serialVersionUID = -4723499017508681913L;

	private Long categoryId;
	private String categoryName;
}