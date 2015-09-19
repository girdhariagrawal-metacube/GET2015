package assignment1;

public class Member {
	
	private enum category {Faculty,Student,Others};
	private int memberId;
	private String memberName;
	private String addressLine1;
	private String addressLine2;
	private category memberCategory;
	
	public category getMemberCategory() {
		return memberCategory;
	}
	public void setMemberCategory(category memberCategory) {
		this.memberCategory = memberCategory;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	};
	
	
}
