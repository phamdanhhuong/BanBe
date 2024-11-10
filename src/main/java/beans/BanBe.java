package beans;

public class BanBe {
	int id;
	String hoVaTen;
	int sdt;
	String email;
	String linkSocial;
	String diaChi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkSocial() {
		return linkSocial;
	}
	public void setLinkSocial(String linkSocial) {
		this.linkSocial = linkSocial;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public BanBe(int id, String hoVaTen, int sdt, String email, String linkSocial, String diaChi) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.sdt = sdt;
		this.email = email;
		this.linkSocial = linkSocial;
		this.diaChi = diaChi;
	}
	
}
