package assignment1;

public class Book {

	private int accessionNumber;
	private int titleId;
	private String purchaseDate;
	private int price;
	private String status;
	
	public int getAccessionNumber() {
		return accessionNumber;
	}
	public void setAccessionNumber(int accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
