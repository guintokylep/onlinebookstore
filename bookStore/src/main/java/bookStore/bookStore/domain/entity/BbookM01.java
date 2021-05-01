package bookStore.bookStore.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookdetails")
public class BbookM01 {
	
	@Id
	@Column(name="name")
	private String name;

	@Column(name="outline")
	private String outline;
	
	@Column(name="author")
	private String author;
	
	@Column(name="ranking")
	private int ranking;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="invtystatus")
	private Boolean invtystatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getInvtystatus() {
		return invtystatus;
	}

	public void setInvtystatus(Boolean invtystatus) {
		this.invtystatus = invtystatus;
	}
	
	
}
