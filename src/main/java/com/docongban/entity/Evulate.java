package com.docongban.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evulate")
@Data
public class Evulate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private Instant time;
	private int orderAccountId;
	private int foodRate;
	private int serviceRate;
}
