package org.akshay.hibernatex.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;


@Builder
@Getter
@Setter
@ToString
@Entity  
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class UserDetails3 {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	// Had to include @Tolerate as Lombok builder doesnt work with no arg constructor
	@Tolerate
	UserDetails3(){super();}

}
