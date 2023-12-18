package com.bs.hrm.entity.ids;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
@AllArgsConstructor @EqualsAndHashCode
public class MenuId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer systemId;
	private Integer subSystemId;
	private Integer functionId;
	
	
}
