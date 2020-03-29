package com.wipro.diet.app.beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Groupfiles")
public class GroupFiles {
	  @Id
	  @GeneratedValue
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "name")
	  private String name;
	    
	  @Column(name = "mimetype")
	  private String mimetype;
	  
	  @Lob
	  @Column(name="file")
	  private byte[] pic;
	  
	  @Column(name = "zone")
	  private int zone;
		public GroupFiles() {
			super();
			// TODO Auto-generated constructor stub
	}

	public GroupFiles(String name, String mimetype, byte[] pic, int group) {
			super();
			this.name = name;
			this.mimetype = mimetype;
			this.pic = pic;
			this.zone = group;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int group) {
		this.zone = group;
	}


	@Override
	public String toString() {
		return "Files [id=" + id + ", name=" + name + ", mimetype=" + mimetype + ", pic=" + Arrays.toString(pic)
				+ ", zone=" + zone + "]";
	}
	  
}
